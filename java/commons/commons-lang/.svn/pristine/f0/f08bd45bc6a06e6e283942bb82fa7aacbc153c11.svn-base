package org.hy.commons.lang;

import java.util.Random;

public class RandomUtil {

	// 填充字符
	public static final String data = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

	public static byte[] getRandomBytes(Integer bytesLength) {		
		byte[] bytes = new byte[bytesLength];
		getRandomInstance().nextBytes(bytes);			
		return bytes;
	}
	
	public static String getRandomDigital(Integer length) {		
		StringBuilder sb = new StringBuilder();
		int index = 0;
		for (int i = 0; i < length; i++) {
			index = nextInt(10);				
			sb.append(index);
		}
		return sb.toString();
	}
	
	public static String getRandomCharacter() {		
		int index = nextInt(62);				
		return data.substring(index, index+1);
	}
	
	public static String getRandomString(Integer textLength) {
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < textLength; i++) {
			stringBuffer.append(getRandomCharacter());
		}
		return stringBuffer.toString();
	}

	public static String getRandomText(Integer textLength) {
		return getRandomString(textLength);
	}

	public static void nextBytes(byte[] bytes) {
		
		getRandomInstance().nextBytes(bytes);
	}

	/*
	 * @see java.util.Random#ne
	 */
	public static int nextInt() {
		// TODO Auto-generated method stub
		return getRandomInstance().nextInt();
	}

	public static int nextInt(int n) {
		// TODO Auto-generated method stub
		return getRandomInstance().nextInt(n);
	}

	public static long nextLong() {
		// TODO Auto-generated method stub
		return getRandomInstance().nextLong();
	}

	public static boolean nextBoolean() {
		// TODO Auto-generated method stub
		return getRandomInstance().nextBoolean();
	}

	public static float nextFloat() {
		// TODO Auto-generated method stub
		return getRandomInstance().nextFloat();
	}

	public static double nextDouble() {
		// TODO Auto-generated method stub
		return getRandomInstance().nextDouble();
	}

	private static Random random = null;

	public static Random getRandomInstance() {
		if (random == null) {
			random = new Random();
		}
		return random;
	}
}
