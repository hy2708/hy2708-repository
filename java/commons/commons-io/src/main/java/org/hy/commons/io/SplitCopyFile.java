package org.hy.commons.io;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;


public class SplitCopyFile extends Thread {
	/*
	 * 属性各自独立，无线程安全问题
	 */
    //源文件
    private String sourceFileName;
    //目标文件
    private String targetFileName;
    //分块总数
    private int blockCount;
    //分块的序号
    private int blockNo;
    //缓存大小
    private int maxBuffSize=1024*1024;
    
    
    /**
     * 将sourceFileName文件分blockCount块后的第blockNo块复制至sourceFileName
     * @param sourceFileName
     * @param targetFileName
     * @param blockCount
     * @param blockNo
     */
    public SplitCopyFile(String sourceFileName,String targetFileName,int blockCount,int blockNo)
    {
        this.sourceFileName=sourceFileName;
        this.targetFileName=targetFileName;
        this.blockCount=blockCount;
        this.blockNo=blockNo;
    }
    public void run() {
    	
    	splitCopy();
    }
    
    public void splitCopy() {
    	//得到来源文件
        File file=new File(sourceFileName);
        //得到源文件的大小
        long size=file.length();
        //根据文件大小及分块总数算出单个块的大小
        long blockLenth=size/blockCount;
        //算出当前开始COPY的位置
        long startPosition=blockLenth*blockNo;
        //实例化缓存
        byte[] buff=new byte[maxBuffSize];
        RandomAccessFile randomAccessFile=null;
        InputStream inputStream= null;
        try{
            //得到输入流
            inputStream=new FileInputStream(sourceFileName);
            //得到目标文件的随机访问对象
            randomAccessFile = new RandomAccessFile(targetFileName,"rw");
            //将目标文件的指针偏移至开始位置
            randomAccessFile.seek(startPosition);
            
            //当前读取的字节数
            int tempReadLength;
            //累计读取字节数的和
            int totalReadLength=0;
            //将来源文件的指针偏移至开始位置
            inputStream.skip(startPosition);
            //依次分块读取文件
            while((tempReadLength=inputStream.read(buff))>0 && totalReadLength<blockLenth)
            {
                //将缓存中的字节写入目标文件中
                randomAccessFile.write(buff, 0, tempReadLength);
                //累计读取的字节数
                totalReadLength+=tempReadLength;
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
			// 关闭相关资源

			try {
				if (randomAccessFile != null) {
					randomAccessFile.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					if (inputStream != null) {
						inputStream.close();
					}
				} catch (IOException e2) {
					e2.printStackTrace();
				}

			}

			
        }

	}

}
 
