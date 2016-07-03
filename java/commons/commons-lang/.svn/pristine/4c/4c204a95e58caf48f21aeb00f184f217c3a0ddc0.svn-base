package org.hy.commons.lang;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hy.commons.lang.date.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ByteUtil {
	
	private static Logger logger = LoggerFactory.getLogger(ByteUtil.class);
	/**
	 * 系统提供的数组拷贝方法arraycopy
	 * */
	public static byte[] combineBytes(List<byte[]> srcArrays) {
	//	long t = DateUtil.getCurrentTimeMillis();
		int len = 0;
		for (byte[] srcArray : srcArrays) {
			len += srcArray.length;
		}
		byte[] destArray = new byte[len];
		int destLen = 0;
		for (byte[] srcArray : srcArrays) {
			System.arraycopy(srcArray, 0, destArray, destLen, srcArray.length);
			destLen += srcArray.length;
		}

		//long t2 = DateUtil.getCurrentTimeMillis();
		//System.err.println(DateUtil.getTimeStr(t2 - t));
		;
		return destArray;
	}
	
	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：比较两个byte数组内的数据是否一样</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2013-7-4；时间：上午9:11:25</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param b
	 * @param b2
	 * @return
	 * @return
	 */
	public static boolean compareByteArray(byte[] b,byte[] b2) {
		if (b==null||b2==null) {
			return false;
		}
		if (b.length==0&&b2.length==0) {
			return true;
		}
		if (b.length!=b2.length) {
			logger.warn("两个数组,长度不相等,b的长度是【" +
					b.length+
					"】，b2的长度是【" +
					b2.length+
					"】");
			return false;
		}else {
			for (int i = 0; i < b.length; i++) {
				if(b[i]!=b2[i]){
					logger.warn("两个数组,长度相等,长度都是【" +
							b.length+
							"】，【b[" +
							i +
							"]】的是数值是【" +
							b[i]+
							"】，，【b2[" +
							i +
							"]】的是数值是【" +
							b2[i]+
							"】");
					return false;
				}
			}
			return true;
		}
		
	}
	
	
	

	
	public static byte[] subBytes(byte[] srcArray,int beginIndex,int endIndex) {
		//	long t = DateUtil.getCurrentTimeMillis();
		
			
		byte[] destArray = new byte[ endIndex - beginIndex];
		System.arraycopy(srcArray, beginIndex, destArray, beginIndex, endIndex - beginIndex);			

			//long t2 = DateUtil.getCurrentTimeMillis();
			//System.err.println(DateUtil.getTimeStr(t2 - t));
		;
		return destArray;
	}
	

	/**
	 * 借助字节输出流ByteArrayOutputStream来实现字节数组的合并
	 * */
	public static byte[] streamCopy(List<byte[]> srcArrays) {
		long t = DateUtil.getCurrentTimeMillis();

		byte[] destAray = null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			for (byte[] srcArray : srcArrays) {
				bos.write(srcArray);
			}
			bos.flush();
			destAray = bos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bos.close();
			} catch (IOException e) {
			}
		}

		long t2 = DateUtil.getCurrentTimeMillis();
		System.err.println(DateUtil.getTimeStr(t2 - t));
		;
		return destAray;
	}

	public static void main(String[] args) {
		List<byte[]> bytes = new ArrayList<byte[]>();
		Byte byte00 = Byte.parseByte("e",16);//-28
		//Byte byte002 = Byte.valueOf("e4",16);//-28
		System.err.println(byte00.toString());
		byte[] byte1 = new byte[3];
		byte1[0] = 1;
		byte1[1] = 2;
		byte1[2] = 3;

		bytes.add(byte1);

		byte[] byte2 = new byte[3];
		byte2[0] = 4;
		byte2[1] = 5;
		byte2[2] = 6;

		bytes.add(byte2);

		byte[] byte3 = new byte[3];
		byte3[0] = 7;
		byte3[1] = 8;
		byte3[2] = 9;

		bytes.add(byte3);
		bytes.add(RandomUtil.getRandomBytes(900000));
		bytes.add(RandomUtil.getRandomBytes(900000));
		bytes.add(RandomUtil.getRandomBytes(900000));
		byte[] newByte = combineBytes(bytes);
		System.out.println("方法一:");
		System.err.println("99" + newByte.length);
		// for (int i = 0; i < newByte.length; i++) {
		// System.out.print(newByte[i]+" ");
		// }
		System.out.println();
		System.out.println("方法二:");
		newByte = streamCopy(bytes);
		System.err.println("77" + newByte.length);

		// for (int i = 0; i < newByte.length; i++) {
		// System.out.print(newByte[i]+" ");
		// }
	}
}
