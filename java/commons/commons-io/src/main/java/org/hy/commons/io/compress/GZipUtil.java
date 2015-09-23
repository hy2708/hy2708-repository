package org.hy.commons.io.compress;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import jodd.io.ZipUtil;

import org.hy.commons.io.core.FileUtil;
import org.hy.commons.io.core.IoUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class defines two static methods for gzipping files and zipping
 * directories. It also defines a demonstration program as a nested class.
 **/
public class GZipUtil extends ZipUtil{
	private static Logger logger = LoggerFactory.getLogger(GZipUtil.class);

	public static void main(String[] args) throws UnsupportedEncodingException,
			IOException {

		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 80000; i++) {
			builder.append("abcd");
		}
		String data = builder.toString();
		FileUtil.createFile("e:/1.txt");
		BufferedWriter writer = IoUtil.getBufferedWriter("e:/1.txt");
		writer.write(data);
		writer.close();
		String filePath = "e:/1.txt";
		// IoUtil.getBufferedReader(filePath).r;
		GZIPOutputStream out = new GZIPOutputStream(new FileOutputStream(
				filePath));

		out.write(data.getBytes("utf8"));
		out.finish();

		out.close();

	}
	
	public static  byte[] gzipBytes(byte[] bytes) {
		/*
		 * ByteArrayOutputStream不需要，输入File的地址或者filepath
		 */
		//确定压缩的位置
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		//压缩  gzip
		GZIPOutputStream gzip =null;
		try {
			gzip = new GZIPOutputStream(baos);
			//压缩数据
			gzip.write(bytes);
			//压缩结束
			gzip.close();
		} catch (IOException e) {
			e.printStackTrace();
		}  //压缩的位置		
		
		/**
		 * 获取，GZIPOutputStream压缩后的，输出流数据
		 */
		//获得压缩后的字节数组
		byte[] finalData = baos.toByteArray();
		float f = (float)finalData.length/(float)bytes.length;
		String yasuolv = null;
		yasuolv = String.valueOf(f);
		if (yasuolv.length()>4) {
			yasuolv=yasuolv.substring(0,4);
		}
		logger.debug("执行【 gzipBytes(byte[])】方法，压缩后，数组【byte[]】的长度是【" +
				bytes.length+
				"】，压缩后，数组【byte[]】的长度是【" +
				finalData+
				"】，压缩率是【" +
				yasuolv+
				"】");

		return finalData;
	}
	
	@Deprecated
	public static  String gzipText(String text,String charsetName) {
		try {
			byte[] bytes = gzipBytes(text.getBytes(charsetName));
			System.err.println("压"+bytes.length);
			String string = new String(bytes);
			return string;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		throw new RuntimeException("8888888888888888888");
	}

	

	/** Gzip the contents of the from file and save in the to file. */
	public static void gzipFile(String from, String to) throws IOException {
		// Create stream to read from the from file
		FileInputStream in = new FileInputStream(from);
		// Create stream to compress data and write it to the to file.
		GZIPOutputStream out = new GZIPOutputStream(new FileOutputStream(to));
		// Copy bytes from one stream to the other
		byte[] buffer = new byte[1024];
		int bytes_read;
		while ((bytes_read = in.read(buffer)) != -1) {
			out.write(buffer, 0, bytes_read);
		}
		// And close the streams
		out.finish();
		in.close();
		out.close();
	}
	
	public static void gzipFile(byte[] bytes, String to) throws IOException {
		FileOutputStream out = IoUtil.getFileOutputStream(to, false);
		out.write(bytes);
		out.flush();
		out.close();
	}
	
	public static  byte[] unzipBytes(byte[] bytes) {
		
		ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
		
		return unzipInputStream(bais);
	}
	
	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2013-7-4；时间：下午1:53:57</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param text
	 * @param charsetName
	 * @return
	 * @return
	 */
	@Deprecated
	public static  String unzipText(String text,String charsetName) {
		
//		ByteArrayInputStream bais=null;
//		try {
//			bais = new ByteArrayInputStream(text.getBytes(charsetName));
//			byte[] unzipBytes =  unzipInputStream(bais);
//			String returnString = new String(unzipBytes);
//			return returnString;
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		try {
			byte[] unzipBytes =   unzipBytes(text.getBytes(charsetName));
			String returnString = new String(unzipBytes);
			return returnString;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static byte[] unzipFile(String from) throws IOException {

		FileInputStream in = new FileInputStream(from);
		GZIPInputStream gin = new GZIPInputStream(in);

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte[] buf = new byte[1024];
		int len;
		while ((len = gin.read(buf)) > 0) {
			out.write(buf, 0, len);
		}

		gin.close();
		out.close();
		return out.toByteArray();
	}

	public static Boolean unzipFile(String from, String to) throws IOException {

		FileInputStream in = new FileInputStream(from);
		GZIPInputStream gin = new GZIPInputStream(in);

		FileOutputStream out = new FileOutputStream(to);
		byte[] buf = new byte[1024];
		int len;
		while ((len = gin.read(buf)) > 0) {
			out.write(buf, 0, len);
		}

		gin.close();
		out.close();
		return true;
	}

	public static byte[] unzipInputStream(InputStream in)  {
		GZIPInputStream gin = null;
		try {
			gin = new GZIPInputStream(in);
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			int len;
			while ((len = gin.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
			
			gin.close();
			out.close();
			return out.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		throw new RuntimeException("888888888888888888");
	}

	/** Zip the contents of the directory, and save it in the zipfile */
	public static void zipDirectory(String dir, String zipfile)
			throws IOException, IllegalArgumentException {
		// Check that the directory is a directory, and get its contents
		File d = new File(dir);
		if (!d.isDirectory())
			throw new IllegalArgumentException("Compress: not a directory:  "
					+ dir);
		String[] entries = d.list();
		byte[] buffer = new byte[4096]; // Create a buffer for copying
		int bytes_read;

		// Create a stream to compress data and write it to the zipfile
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipfile));

		// Loop through all entries in the directory
		for (int i = 0; i < entries.length; i++) {
			File f = new File(d, entries[i]);
			if (f.isDirectory())
				continue; // Don't zip sub-directories
			FileInputStream in = new FileInputStream(f); // Stream to read file
			ZipEntry entry = new ZipEntry(f.getPath()); // Make a ZipEntry
			out.putNextEntry(entry); // Store entry
			while ((bytes_read = in.read(buffer)) != -1)
				// Copy bytes
				out.write(buffer, 0, bytes_read);
			in.close(); // Close input stream
		}
		// When we're done with the whole loop, close the output stream
		out.close();
	}

	/**
	 * This nested class is a test program that demonstrates the use of the
	 * static methods defined above.
	 **/
	public static class Test {
		/**
		 * Compress a specified file or directory. If no destination name is
		 * specified, append .gz to a file name or .zip to a directory name
		 **/
		public static void main(String args[]) throws IOException {
			if ((args.length != 1) && (args.length != 2)) { // check arguments
				System.err.println("Usage: java Compress$Test <from> [<to>]");
				System.exit(0);
			}
			String from = args[0], to;
			File f = new File(from);
			boolean directory = f.isDirectory(); // Is it a file or directory?
			if (args.length == 2)
				to = args[1];
			else { // If destination not specified
				if (directory)
					to = from + ".zip"; // use a .zip suffix
				else
					to = from + ".gz"; // or a .gz suffix
			}

			if ((new File(to)).exists()) { // Make sure not to overwrite
				System.err.println("Compress: won't overwrite existing file: "
						+ to);
				System.exit(0);
			}

			// Finally, call one of the methods defined above to do the work.
			if (directory)
				GZipUtil.zipDirectory(from, to);
			else
				GZipUtil.gzipFile(from, to);

			FileInputStream input = new FileInputStream(new File(args[1]));
			byte[] rstr = GZipUtil.unzipInputStream(input);
			System.out.println(new String(rstr));
		}
	}
}