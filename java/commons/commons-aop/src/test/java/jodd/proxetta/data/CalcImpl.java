// Copyright (c) 2003-2014, Jodd Team (jodd.org). All Rights Reserved.

package jodd.proxetta.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CalcImpl extends CalcImplBase implements Calc {

	private static Logger logger = LoggerFactory.getLogger(CalcImpl.class);
	
	public int calculate(int a, int b) {
		logger.debug("正在执行【111111CalcImpl.calculate(args)】方法");
		
		return a + b;
	}

	public double calculate(double a, double b) {
		return a + b;
	}

	public long calculate(long a, long b) {
		return a + b;
	}

	public float calculate(float a, float b) {
		return a + b;
	}

	public short calculate(short a, short b) {
		return (short) (a + b);
	}

	public byte calculate(byte a, byte b) {
		return (byte) (a + b);
	}

	public void customMethod() {
		System.out.println("custom");
	}

	public static void main(String[] args) {
		System.out.println(args);
	}
}
