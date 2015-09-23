package org.hy.commons.io;

import java.io.File;

public class ThreadCopyDemo {

    /**
     * @param args
     */
    //源文件
    private static String sourceFile;
    //目标文件
    private static String targetFile;
    //分块数
    private static int blockCount;
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //
    	
        sourceFile="F:\\temp-test\\a.txt";
        targetFile="F:\\temp-test\\ca.txt";
        
        File file = new File(targetFile);
        blockCount=Integer.parseInt("3");
        //记录开始时间
        long beginTime=System.currentTimeMillis();
        //依次分块复制
        for(int i=0;i<blockCount;i++)
        {
            //实例化文件复制对象
            SplitCopyFile copyFile=new SplitCopyFile(sourceFile,targetFile,blockCount,i);
            //实例化线程
            Thread thread=new Thread(copyFile);
            
            thread.start();
            try
            {
                //合并
                thread.join();
            }
            catch (Exception e) {
                
                e.printStackTrace();
            }
        }
        
        long endTime=System.currentTimeMillis();
        //耗时
        System.out.println("共用时:"+(endTime-beginTime)+"ms");

    }
}