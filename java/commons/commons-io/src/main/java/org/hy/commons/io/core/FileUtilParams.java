package org.hy.commons.io.core;

//import jodd.io.FileUtilParams;

public class FileUtilParams extends jodd.io.FileUtilParams{

	private static FileUtilParams defaultParams = null;
	public static FileUtilParams  getInstance() {
		if (null==defaultParams) {
			bulid();
		}
		return defaultParams;
		
	}
	
	private static synchronized FileUtilParams bulid() {
		if (null==defaultParams) {
			defaultParams = new FileUtilParams();
		}
		return defaultParams;
	}
	
	public boolean isFullWidth2SingleByte() {
		return FullWidth2SingleByte;
	}

	public void setFullWidth2SingleByte(boolean fullWidth2SingleByte) {
		FullWidth2SingleByte = fullWidth2SingleByte;
	}

	
	public FileUtilParams() {
		super();
	}

	//全角字符是否转换为半角字符
	protected boolean FullWidth2SingleByte = false;
	
}
