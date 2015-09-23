package org.hy.commons.web.servlet.compression;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import javax.servlet.http.HttpServletResponse;

public class GZipServletUtil {
	
	public static HttpServletResponse gzipWrite(HttpServletResponse response,StringBuffer content,String charsetName) throws IOException {
		return gzipWrite(response, content.toString(), charsetName);
	}
	
	
	public static HttpServletResponse gzipWrite(HttpServletResponse response,String content,String charsetName) throws IOException {
		response.setContentType("text/html;charset=" +
				charsetName +
				"");
		byte[] bytes = content.getBytes(charsetName);
		return gzipWrite(response, bytes);
	}

		
	
	public static HttpServletResponse gzipWrite(HttpServletResponse response,byte[] bytes) throws IOException {
		//通知浏览器，服务器发送的数据时压缩的，并且指定压缩的格式
		response.setHeader("content-encoding", "gzip");
						
		/*
		 * ByteArrayOutputStream不需要，输入File的地址或者filepath
		 */
		//确定压缩的位置
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		//压缩  gzip
		GZIPOutputStream gzip = new GZIPOutputStream(baos);  //压缩的位置
		//压缩数据
		gzip.write(bytes);
		gzip.close();
		
		/**
		 * 获取，GZIPOutputStream压缩后的，输出流数据
		 */
		//获得压缩后的字节数组
		byte[] endData = baos.toByteArray();
		
		response.setContentLength( endData.length);

		//将压缩的数据发送给浏览器  -- 
		response.getOutputStream().write(endData);
		
		return response;
	}

}
