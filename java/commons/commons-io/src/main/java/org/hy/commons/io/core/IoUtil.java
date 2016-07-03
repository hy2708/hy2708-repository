package org.hy.commons.io.core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.LinkedList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import jodd.io.StreamUtil;

import org.apache.commons.io.FileUtils;
import org.hy.commons.lang.ByteUtil;
import org.hy.commons.lang.character.FullCharConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * http://blog.csdn.net/leon_ice/article/details/7537517
 * 
 * <ul>
 * <li>开发作者：花宏宇</li>
 * <li>设计日期：2013-3-16；时间：下午3:04:12</li>
 * <li>类型名称：IoUtil</li>
 * <li>设计目的：<br/>复制，不用缓冲刘
 * </li>
 * </ul>
 * <ul>
 * <b>修订编号：</b>
 * <li>修订日期：</li>
 * <li>修订作者：</li>
 * <li>修订原因：</li>
 * <li>修订内容：</li>
 * </ul>
 */
public class IoUtil extends StreamUtil{

	private static Logger logger = LoggerFactory.getLogger(IoUtil.class);
	// 虚拟机，默认字符集
	// public static String DEFAULT_CHARSET = Charset.defaultCharset().name();
	public static String DEFAULT_CHARSET = System.getProperty("file.encoding");

	public static void main(String[] args) {
		// System.err.println(getProjectPath(MyLoggerUtil.class,
		// "commons-log-slf4j-logback"));
		String string =readText00(ProjectPathUtil.getProjectResourcesDirPath()+"/Xx.java", "utf8");
		System.err.println(string);
	}
	
	
	
	
	public static void copyInputStreamToFile(InputStream in,File destFile) {
		try {
			FileUtils.copyInputStreamToFile(in, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	




	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2013-5-15；时间：下午3:59:33</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * 
	 * @param dir
	 * @param fileName
	 * @return
	 * @return
	 */
	public static List<File> findFiles(String dir, String fileName) {
		List<File> targetFiles = new LinkedList<File>();
		FileUtil.findFiles(dir, fileName, targetFiles);
		logger.debug("查找文件【" + fileName + "】，查找目录是【" + dir + "】，查找到【"
				+ targetFiles.size() + "】个文件");
		return targetFiles;
	}

	public static File findFile(String dir, String fileName) {
		List<File> targetFiles = findFiles(dir, fileName);
		if (targetFiles == null || targetFiles.size() == 0) {
			throw new RuntimeException("查找的文件不存");
		} else if (targetFiles == null || targetFiles.size() != 1) {
			logger.warn("查找的文件,大于1个，返回第一个文件");
		}
		for (File file : targetFiles) {
			System.err.println(file);
		}
		return targetFiles.get(0);
	}
	



	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：给定一个路径,创建BufferedReader，并需要设定字符集,默认字符集是gbk<br>
	 * </li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2012-6-8；时间：下午06:25:19</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * 
	 * @param filePath
	 * @param charsetName
	 * @return
	 * @throws FileNotFoundException
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static BufferedReader getBufferedReader(String filePath,
			String charsetName) {
		String replace = FileUtil.filterFilePath(filePath);
		InputStream in;
		try {
			in = new FileInputStream(replace);
			InputStreamReader reader = new InputStreamReader(in, charsetName);
			BufferedReader br = new BufferedReader(reader);
			return br;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @see #getBufferedReader(String, String)
	 */
	public static BufferedReader getBufferedReader2(File file,
			String charsetName) throws FileNotFoundException,
			UnsupportedEncodingException {
		return getBufferedReader(file.toString(), charsetName);
	}

	/**
	 * @see #getBufferedReader(String, String)
	 */
	public static BufferedReader getBufferedReader(String filePath)
			throws FileNotFoundException, UnsupportedEncodingException {
		return getBufferedReader(filePath, "gbk");
	}

	/**
	 * @see #getBufferedReader(String)
	 */
	public static BufferedReader getBufferedReader(File filePath) {
		InputStream in = null;
		try {
			File replace = FileUtil.filterFilePath(filePath);
			in = new FileInputStream(replace);
		} catch (FileNotFoundException e) {
			//
			e.printStackTrace();
		} catch (IOException e) {
			//
			e.printStackTrace();
		}
		InputStreamReader reader = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(reader);
		return br;
	}

	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：给定一个路径,创建BufferedWriter，并设置字符集，默认字符集是gbk</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2012-6-8；时间：下午06:25:56</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * 
	 * @param filePath
	 * @param charsetName
	 * @return
	 * @throws FileNotFoundException
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static BufferedWriter getBufferedWriter(String filePath,
			String charsetName)  {
		OutputStream os = null;
		BufferedWriter bw = null;
		try {
			String replace = FileUtil.filterFilePath(filePath);

			os = new FileOutputStream(replace);
			OutputStreamWriter osw = new OutputStreamWriter(os, charsetName);
			bw = new BufferedWriter(osw);
		} catch (FileNotFoundException e) {
			//
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return bw;

	}

		
	public static BufferedWriter getBufferedWriter(String filePath)
			 {
		return getBufferedWriter(filePath, "gbk");
	}

	/**
	 * @see #getBufferedWriter(String)
	 */
	public static BufferedWriter getBufferedWriter(File filePath) {

		return getBufferedWriter(filePath, false, "gbk");

	}

	public static BufferedWriter getBufferedWriter(String filePath, Boolean flag)
			throws UnsupportedEncodingException {
		return getBufferedWriter(filePath, flag, "gbk");
	}

	public static BufferedWriter getBufferedWriter(String filePath,
			Boolean append, String charsetName) {
		return getBufferedWriter(new File(filePath), append, charsetName);
	}

	public static BufferedWriter getBufferedWriter(File filePath,
			Boolean append, String charsetName) {
		OutputStream os = null;
		BufferedWriter bw = null;
		try {
			File replace = FileUtil.filterFilePath(filePath);

			if (!replace.exists()) {
				replace.createNewFile();
			}
			os = new FileOutputStream(replace, append);
			OutputStreamWriter osw = new OutputStreamWriter(os, charsetName);
			bw = new BufferedWriter(osw);
		} catch (FileNotFoundException e) {
			//
			e.printStackTrace();
		} catch (IOException e) {
			//
			e.printStackTrace();
		}

		return bw;

	}
	
	public static FileOutputStream getFileOutputStream(String filePath,
			Boolean append) {
		FileOutputStream os = null;
		try {
			File replace = FileUtil.filterFilePath(new File(filePath));

			if (!replace.exists()) {
				replace.createNewFile();
			}
			os = new FileOutputStream(replace, append);		
			
		} catch (FileNotFoundException e) {
			//
			e.printStackTrace();
		} catch (IOException e) {
			//
			e.printStackTrace();
		}

		return os;

	}

	
	public static ObjectOutputStream getObjectOutputStream(String filePath,
			Boolean append) {
		ObjectOutputStream os = null;
		try {
			os =new ObjectOutputStream(getFileOutputStream(filePath, append));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return os;

	}

	
	public static PrintWriter getPrintWriter(String filePath,
			Boolean append, String charsetName) {
		BufferedWriter bw = getBufferedWriter(filePath, append, charsetName);
		PrintWriter printWriter = new PrintWriter(bw);

		return printWriter;

	}

	public static InputStream getResourceFromJarFile(Class clazz,String resourcePath) {
		String path = ProjectPathUtil.getJarFileLocation(clazz);
		JarFile file = null;
		try {
			file = new JarFile(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (FileUtil.isBeginWithDirSeparator(resourcePath)) {
			resourcePath = resourcePath.substring(1);
		}
		JarEntry entry = file.getJarEntry(resourcePath);
		try {
			return file.getInputStream(entry);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	


	public static void printBytesLength(String str) {
		printBytesLength(str, "utf-8");
	}

	public static void printBytesLength(String str, String charsetName) {
		logger.debug("打印信息：");

		int length = 0;
		try {
			length = str.getBytes(charsetName).length;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int showStringLength = 100;
		if (length > showStringLength) {

			logger.info("字符串【" + str.substring(0, showStringLength)
					+ ".......】，在字符集【" + charsetName + "】解码下的Byte数组长度是【"
					+ length + "】");

		} else {

			logger.info("字符串【" + str + "】，在字符集【" + charsetName
					+ "】解码下的Byte数组长度是【" + length + "】");
		}
	}





	public static byte[] readToBytes(String filePath) throws IOException {
		return readBytes(filePath);
	}

	public static byte[] readBytes(String filePath)  {
		

		// Create stream to read from the from file
		FileInputStream in=null;

		try {
			in = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Create stream to compress data and write it to the to file.
		// GZIPOutputStream out = new GZIPOutputStream(new
		// FileOutputStream(to));
		// Copy bytes from one stream to the other
		byte[] buffer = new byte[4096];
		List<byte[]> list = new LinkedList<byte[]>();
		int bytes_read;
		int size =4096;
		try {
			while ((bytes_read = in.read(buffer)) != -1) {
				if (bytes_read <size) {
					byte[] temp = ByteUtil.subBytes(buffer, 0, bytes_read);				
					list.add(temp);
				} else {
					list.add(buffer);
				}

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			// And close the streams
			
			if (in!=null) {					
			try {
					in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			}
		}

		return  ByteUtil.combineBytes(list);

	}
	

	public static String readText(Reader reader) {
		StringBuilder stringBuilder = new StringBuilder();

		try {
			
			char[] cbuf = new char[2048];
			int len = 0;
			while ((len= reader.read(cbuf)) != -1) {
					stringBuilder.append(cbuf, 0, len);			
			}									

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if (reader!=null) {					
			try {
					reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			}
			
		}
		return stringBuilder.toString();
	}
	
	/*
	 * 全角变成半角
	 */
	@Deprecated
	public static String readText00(String filePath, String charsetName) {
		String string =readText(filePath, charsetName);
		String string2 = FullCharConverter.ToDBC(string);
		return string2;
	}

	
	public static String readText(String filePath, String charsetName) {
		BufferedReader bufferedReader = null;
		bufferedReader = IoUtil.getBufferedReader(filePath, charsetName);
		return readText(bufferedReader);
		
	}
	

	@Deprecated
	public static String readText2(String filePath, String charsetName) {
		BufferedReader bufferedReader = null;
		StringBuffer stringBuffer = new StringBuffer();
		try {
			bufferedReader = IoUtil.getBufferedReader(filePath, charsetName);

			String line = bufferedReader.readLine();
			if (line != null) {
				stringBuffer.append(line);
			}

			while (line != null) {
				line = bufferedReader.readLine();
				if (line != null) {
					stringBuffer.append("\n"+line);
				}
			}
			


		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (bufferedReader!=null) {
			
			try {
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
				
		return stringBuffer.toString();
	}
	
	public static byte[] readTextToBytes(String sourceFilePath,String sourceCharsetName) {
		sourceFilePath = FileUtil.filterFilePath(sourceFilePath);
		InputStream in = null;
		OutputStreamWriter writer = null;
		InputStreamReader reader = null;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			in = new FileInputStream(sourceFilePath);
			reader = new InputStreamReader(in, sourceCharsetName);
			
			writer =new OutputStreamWriter(out);
			
			char[] buf = new char[1024];
			int len = 0;
			
			while ((len = reader.read(buf)) > 0) {
				writer.write(buf, 0, len);
			}
			
			writer.flush();

			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			
			if (reader!=null) {				
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (writer!=null) {
				
				try {
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return out.toByteArray();
		
	}

	public static void writeBytes(String filePath, byte... bytes) throws IOException{
			// Create stream to read from the from file
			//FileInputStream in = new FileInputStream(from);
			// Create stream to compress data and write it to the to file.
			FileOutputStream out = new FileOutputStream(filePath);
			// Copy bytes from one stream to the other
			//byte[] buffer = new byte[4096];
			int length = bytes.length;
			int BLOCK_SIZE = 256;
			int blocks = length/BLOCK_SIZE;
			//int bytes_read;
			for (int i = 0; i < blocks; i++) {
				//System.err.println(i+" "+i*BLOCK_SIZE+" "+(i*BLOCK_SIZE+BLOCK_SIZE));				
				out.write(bytes, i*BLOCK_SIZE, i*BLOCK_SIZE+BLOCK_SIZE);
			}
			if (length>(blocks*BLOCK_SIZE)) {				
				out.write(bytes, blocks*BLOCK_SIZE, length-blocks*BLOCK_SIZE);
			}
			
			out.close();
	}
	
	
	
	

	public static void writeText(Writer writer, String content) {
		
			//IOUtils.write(content, writer);
			logger.info("写入文本【" +
					content.substring(0,10)+
					"...】，长度为【" +
					content.length()+
					"】");
		
		Writer bufferedWriter = null;
		try {
			bufferedWriter = writer;

			int offset = 0;
			int length = content.length();
			while (0 < length) {
				if (length - 200 < 0) {
					bufferedWriter.write(content.substring(offset, offset
							+ length));
					length = 0;
				} else {
					bufferedWriter.write(content
							.substring(offset, offset + 200));
					length = length - 200;
				}
				offset = offset + 200;
			}
			
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}finally{
			if (bufferedWriter!=null) {
				
				try {
					bufferedWriter.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static void writeText(String filePath, String content) {
		writeText(filePath, "gbk", false, content);
	}

	public static void writeText(String filePath, Boolean flag, String content) {
		writeText(filePath, "gbk", flag, content);
	}

	public static void writeText(String filePath, String charsetName,
			String content) {
		writeText(filePath, charsetName, false, content);
	}



	public static void writeText(String filePath, String charsetName,
			Boolean append, String content) {

		BufferedWriter bufferedWriter = null;
		try {
			bufferedWriter = getBufferedWriter(filePath, append, charsetName);

			int offset = 0;
			int length = content.length();
			int SIZE = 1024;
			while (0 < length) {
				if (length - SIZE < 0) {

					bufferedWriter.write(content.substring(offset, offset
							+ length));
					length = 0;
				} else {
					bufferedWriter.write(content.substring(offset, offset
							+ SIZE));
					length = length - SIZE;
				}
				offset = offset + SIZE;
			}
			bufferedWriter.flush();
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}finally{
			if (bufferedWriter!=null) {
				
				try {
					bufferedWriter.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}

	}
}
