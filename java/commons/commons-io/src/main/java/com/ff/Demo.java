package com.ff;

import java.io.*;
import java.util.RandomAccess;

public class Demo{
 public static void main(String[] args) throws Exception{
  File srcFile=new File("源文件路径");
  File orgFile=new File("目标文件路径");
  //orgFile.createNewFile();
  Demo demo=new Demo();
  demo.analysisFile(srcFile,orgFile,4);//4为线程数，你也可以修改为其他数值
 }
 
 public void analysisFile(File srcFile,File orgFile,int threadNum){
  int length=(int)srcFile.length();
  int splitNum=length%threadNum==0?length/threadNum:length/threadNum+1;
  int skipPostion=-1;
  int readNum=0;
  for(int i=1;i<=threadNum;i++){
   if(i!=threadNum){
    readNum=i*splitNum;
   }
   else{
    readNum=length-readNum;
   }
   new SplitFile(srcFile,orgFile,skipPostion+1,readNum).start();
   
   skipPostion=i*splitNum;
  }
 }
 
 class SplitFile extends Thread{
  private int minPosition;
  private int maxPosition;
  private File srcFile;
  private File orgFile;
  
  public SplitFile(File srcFile,File orgFile,int minPosition,int maxPosition){
   this.maxPosition=maxPosition;
   this.minPosition=minPosition;
   this.srcFile=srcFile;
   this.orgFile=orgFile;
  }
  
  public void run(){
   try{
    RandomAccessFile raf_r=new RandomAccessFile(srcFile,"rw");
    RandomAccessFile raf_w=new RandomAccessFile(orgFile,"rw");
    
    raf_r.skipBytes(minPosition);
    raf_w.seek(minPosition);
    
    byte[] buf=new byte[1];
    int alreadyRec=0;
    for(int size=0;alreadyRec<=maxPosition&&size!=-1;size=raf_r.read(buf)){
     alreadyRec+=size;
     raf_w.write(buf,0,size);
    }
    
    raf_w.close();
    raf_r.close();
    
    System.out.println("总共:"+srcFile.length()+" 文件"+srcFile.getName()+"从:"+minPosition+"开始---复制大小:"+maxPosition+"结束!此刻接收文件大小为:"+orgFile.length());
   }
   catch(Exception ex){
    ex.printStackTrace();
   }
  }
  
 }



}