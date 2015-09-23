package com.hy.commons.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Terminal {

    public static void main(String[] args) throws IOException, InterruptedException {
        final Process proc = Runtime.getRuntime().exec("java Main");

        // Normal input thread
        new Thread() {
            public void run() {
                InputStream in = proc.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                try {
                    int ch = 0;
                    while ((ch = reader.read()) != -1) { // 不用readLine是为了防止print没有回车的输出
                        System.out.print((char) (ch));
                    }

                    System.out.println("Process end.");
                    // 当读取到-1时，说明proc已经结束，所以本程序也应该结束了(或者结束输出线程)
                    System.exit(0); 
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        // Error input thread
        new Thread() {
            public void run() {
                InputStream in = proc.getErrorStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String line = null;

                try {
                    while ((line = reader.readLine()) != null) {
                        System.err.println(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        // System.out.println("Sleep...");
        // Thread.sleep(3000); // 程序在这里等待时，在Eclipse的控制台也能进行输入
        // 当proc代表的程序结束后，Eclipse才强制在控制台不能进行输入

        // Output thread.
        // 在输入中按下回车后取得当前行字符(去掉传进来的，只取输入的部分)，然后转对方.
        new Thread() {
            public void run() {
                OutputStream out = proc.getOutputStream();
                PrintWriter writer = new PrintWriter(out);
                Scanner scanner = new Scanner(System.in);
                String str = null;
                while ((str = scanner.nextLine()) != null) {
                    writer.println(str);
                    writer.flush();
                }
            }
        }.start();
    }
}