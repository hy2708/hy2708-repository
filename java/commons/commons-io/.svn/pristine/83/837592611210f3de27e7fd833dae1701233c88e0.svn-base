package org.hy.commons.io.compress;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.hy.commons.io.core.IoUtil;

public class T {

	public static void main(String[] args) throws IOException {
		// 准备大数据
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 80000; i++) {
			builder.append("abcd");
		}
		String data = builder.toString();
		IoUtil.printBytesLength(data);

		// 确定压缩的位置
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		// 压缩 gzip
		GZIPOutputStream gzip = new GZIPOutputStream(baos); // 压缩的位置
		// 压缩数据
		gzip.write(data.getBytes());
		
	  
		gzip.finish();  
	  
		gzip.flush();  
		gzip.close();  
		
	}

}
