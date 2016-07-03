package org.hy.commons.io.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import jodd.io.FileUtilParams;
import jodd.io.StreamUtil;

import org.apache.commons.io.FileUtils;
import org.hy.commons.io.find.FindFileUtil;
import org.hy.commons.lang.CollectionUtil;
import org.hy.commons.lang.character.FullCharConverter;
import org.hy.commons.lang.exception.CommonRuntimeException;
import org.hy.commons.lang.string.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static jodd.JoddCore.fileUtilParams;


/*
 * 文件的创建 复制(不用缓冲刘) 删除 读写 和查找(复杂的查找使用FindFileUtil)
 * 方法的参数是文件路径或者File对象
 */
public class FileUtil extends jodd.io.FileUtil
{
	private static Logger logger = LoggerFactory.getLogger(FileUtil.class);
	public static final String fileSeparator = File.separator;
	private static final String dirSeparator = File.separator;
    public static FileUtilParams defaultParams = org.hy.commons.io.core.FileUtilParams.getInstance();
    //public static FileUtilParams defaultParams = JoddCore.fileUtilParams;

	// 验证字符串是否为正确路径名的正则表达式
	private static String matches = "[A-Za-z]:\\\\[^:?\"><*]*";
	// 通过 sPath.matches(matches) 方法的返回值判断是否正确
	// sPath 为路径字符串
	
	public static void main(String[] args) {
		
		//第一步：获取新名称的hashcode
		int code = "ffffffffffff.txt".hashCode();
		
		System.err.println(code);
		//第二步：获取后一位做为第一层目录
		String dir1 = 
				Integer.toHexString(240 & 0xf);
		System.err.println(dir1+".........");
		//获取第二层的目录
		String dir2 = 
				Integer.toHexString((code>>4)&0xf);
		System.err.println(dir2);
		String savePath = dir1+"/"+dir2;
		System.err.println(savePath);
		//组成保存的目录
		savePath="/root"+"/"+savePath;
		System.err.println(savePath);
		//判断目录是否存在
		File f = new File(savePath);
		if(!f.exists()){
			//创建目录
			f.mkdirs();
		}
	}
	
	public static void main2(String[] args) {

	    	List<File> targetFiles = new LinkedList<File>(); 
	    			findFiles("d:/11", "11.txt",targetFiles);
	    			System.err.println(targetFiles.size());
	        FileUtil hfc = new FileUtil();
	        String path = "D:\\Abc\\123\\Ab1";
	        //boolean result = hfc.CreateFolder(path);
	        //System.out.println(result);
	        path = "D:\\11\\33.txt";
	       // boolean result = hfc.DeleteFolder(path);
	        //System.out.println(result);
	        
	        String cookie  ="%appdata%" +
					File.separator +
					"Microsoft" +
					File.separator +
					"Windows" +
					File.separator +
					"Cookies";
	        
	       // boolean xx = hfc.DeleteFolder(cookie);


	    }
	
	
	
	///------------------------------------------------------------------
		/**
		 * @see FileUtil#createFile(File)
		 */
		public static File createFile(String filePath) {
			return createFile(new File(filePath));
		}
		
		/**
		 * 
		 * 
		 * <ul>
		 * <li>方法含义：创建文件或者目录</li>
		 * <li>方法作者：花宏宇</li>
		 * <li>编写日期：2013-3-8；时间：下午5:21:47</li>
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
		 * @throws IOException
		 * @return
		 */
		public static File createFile(File filePath2) {// throws IOException {
			File filePath = null;
			try {
				filePath = filterFilePath(filePath2);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// 如果文件或者目录,存在，返回true
			if (filePath.exists()) {

				logger.debug("文件名为" + "【" + filePath.getAbsolutePath() + "】"
						+ "的文件或目录已经存在。 ");
				return filePath;
			
			}
			//如果文件或者目录不存在
			else {
				// 如果是目录，则创建目录
				if (filePath.isDirectory()
						|| filePath.getAbsolutePath().indexOf(".") == -1) {
					if (createDir(filePath)) {
						return new File(filePath.getAbsolutePath());
					}else {
						throw new RuntimeException("文件创建失败");
					}
					//return createDir(filePath);

					
				}
				// 如果是文件，先创建目录，再创建文件
				else {
					String dirPath = null;
					String absolutePath = filePath.getAbsolutePath();
					if (absolutePath.indexOf("/") != -1) {

						dirPath = absolutePath.substring(0,
								absolutePath.lastIndexOf("/"));
					} else if (absolutePath.indexOf("\\") != -1) {

						dirPath = absolutePath.substring(0,
								absolutePath.lastIndexOf("\\"));
					} else {
						throw new RuntimeException("文件创建失败");
					}

					// 创建文件，对应路径中的目录部分
					createDir(new File(dirPath));

					if ((new File(dirPath)).exists()) {

						createAFile(filePath);
						return new File(filePath.getAbsolutePath());

					} else {

						throw new RuntimeException("目录【" + dirPath
								+ "】,不存在,并且创建失败！");
					}

				}

			}

			//return null;

		}
		
		
		protected static boolean createAFile(File filePath) {// throws IOException {
			if (!filePath.getAbsoluteFile().exists()) {

				logger.debug("文件名为" + "【" + filePath.getAbsolutePath() + "】"
						+ "的文件不存在。 ");
				try {
					if (filePath.createNewFile()) {
						logger.debug("创建文件【" +
						// filePath.getName() +
								filePath.getAbsolutePath() + "，是否成功：是");
					} else {
						logger.debug("创建文件【" + filePath.getName() + "，是否成功：否");
						return false;
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {
				logger.debug("文件名为" + "【" +
				// filePath.getName() +
						filePath.getAbsolutePath() +

						"】" + "的文件存在。 ");
				;

			}

			return true;
		}
		
		protected static boolean createDir(File filePath) {
			if (filePath.isDirectory()
					|| filePath.getAbsolutePath().indexOf(".") == -1) {

				if (!filePath.getAbsoluteFile().exists()) {

					logger.warn("目录名为" + "【" + filePath.getAbsolutePath() + "】"
							+ "的目录不存在。 ");
					if (filePath.mkdirs()) {
						logger.warn("创建目录【" +
						// filePath.getName() +
								filePath.getAbsolutePath() + "，是否成功：是");
						return true;
					} else {
						logger.warn("创建目录【" + filePath.getName() + "】，是否成功：否");
						return false;
					}

				} else {
					logger.info("目录名为" + "【" +
					// filePath.getName() +
							filePath.getAbsolutePath() +

							"】" + "的目录存在。 ");
					;

					return true;
				}
			} else {
				throw new RuntimeException(filePath.getAbsolutePath() + ",不是目录！");
			}
		}
		
		

	
	
	
	
	/**
	 *  @see #copy(File, File, FileUtilParams)
	 */    
	public static void copy(String src, String dest) throws IOException {
		FileUtil.copy(file(src), file(dest), defaultParams);
	}

	
	/**
	 *  @see #copy(File, File, FileUtilParams)
	 */
	public static void copy(String src, String dest, FileUtilParams params)
			throws IOException {
		FileUtil.copy(file(src), file(dest), params);
	}

	/**
	 *  @see #copy(File, File, FileUtilParams)
	 */
	public static void copy(File src, File dest) throws IOException {
		FileUtil.copy(src, dest, defaultParams);
		
	}

	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：智能拷贝<br/>
	 * 复制文件或目录,到目标目录；复制文件,到目标文件
	 * </li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2014-2-26；时间：下午3:51:05</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param src
	 * @param dest
	 * @param params
	 * @throws IOException
	 */
	public static void copy(File src, File dest, FileUtilParams params)
			throws IOException {
		jodd.io.FileUtil.copy(src, dest, params);
		//Boolean boolean1 = params.isFullWidth2SingleByte();
		logger.info("复制文件或目录：源路径是【" +
				src.getAbsolutePath()+"】,目标路径是【" +
						dest.getAbsolutePath()+"】,参数是【" +
								params+"】.");
	}

	   
	public static void copyDir(String srcDir, String destDir)
			throws IOException {
		FileUtil.copyDir(new File(srcDir), new File(destDir), defaultParams);
	}

	public static void copyDir(String srcDir, String destDir,
			FileUtilParams params) throws IOException {
		FileUtil.copyDir(new File(srcDir), new File(destDir), params);
	}

	public static void copyDir(File srcDir, File destDir) throws IOException {
		FileUtil.copyDir(srcDir, destDir, defaultParams);
	}

	public static void copyDir(File srcDir, File destDir, FileUtilParams params)
	        throws IOException
	{
		logger.info("把源目录【" +
				srcDir.getAbsolutePath()+"】中的内容，复制到目标目录【" +
						destDir.getAbsolutePath()+"】中!");
		jodd.io.FileUtil.copyDir(srcDir, destDir, defaultParams);
	}
	
	
	
	public static Boolean copyFile(File sourceFilePath,String sourceCharsetName,File 
			destinationFilePath,String	destinationCharsetName) {
		return copyFile(sourceFilePath.getPath(), sourceCharsetName, destinationFilePath.getPath(), destinationCharsetName);
	}

	/*
	 * 复制，不用缓冲刘
	 */
	public static Boolean copyFile(String sourceFilePath,String sourceCharsetName,String 
			destinationFilePath,String	destinationCharsetName) {
		sourceFilePath = filterFilePath(sourceFilePath);
		destinationFilePath = filterFilePath(destinationFilePath);
		InputStream in = null;
		InputStreamReader reader = null;
		OutputStreamWriter writer = null;
		try {
			in = new FileInputStream(sourceFilePath);
			reader = new InputStreamReader(in, sourceCharsetName);
			
			FileOutputStream out = new FileOutputStream(destinationFilePath, false);
			writer =new OutputStreamWriter(out,destinationCharsetName);
			
			char[] buf = new char[1024];
			int len = 0;
			
			while ((len = reader.read(buf)) != -1) {
				writer.write(buf, 0, len);
			}
			
			writer.flush();
			
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
		
		return true;
		
	}
	
	public static void copyFile(File srcFile,File destFile) {
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/*@Deprecated
	public static Boolean copyFile(File sourceFilePath,String sourceCharsetName,File 
			destinationFilePath,String	destinationCharsetName) {
		return copyFile(sourceFilePath.getPath(), sourceCharsetName, destinationFilePath.getPath(), destinationCharsetName);
	}

	@Deprecated
	public static Boolean copyFile(String sourceFilePath,String sourceCharsetName,String 
			destinationFilePath,String	destinationCharsetName) {
		return FileUtil.copyFile(sourceFilePath, sourceCharsetName, destinationFilePath, destinationCharsetName);
		
	}
	
	@Deprecated
	public static void copyFile(File srcFile,File destFile) {
		FileUtil.copyFile(srcFile, destFile);
	}*/

	public static Boolean copyTextFile(String sourceFilePath,String sourceCharsetName,String 
			destinationFilePath,String	destinationCharsetName,org.hy.commons.io.core.FileUtilParams fileUtilParams) {
		//是否把全角，变成，半角
		Boolean boolean1 = fileUtilParams.isFullWidth2SingleByte();
		if (boolean1) {
			return copyTextFileWithCharConvert(sourceFilePath, sourceCharsetName, destinationFilePath, destinationCharsetName, fileUtilParams);
		}else {
			return FileUtil.copyFile(sourceFilePath, sourceCharsetName, destinationFilePath, destinationCharsetName);
		}
	}

	
	public static Boolean copyTextFileWithCharConvert(String sourceFilePath,String sourceCharsetName,String 
			destinationFilePath,String	destinationCharsetName,FileUtilParams fileUtilParams) {
		sourceFilePath = FileUtil.filterFilePath(sourceFilePath);
		destinationFilePath = FileUtil.filterFilePath(destinationFilePath);
		InputStream in = null;
		try {
			in = new FileInputStream(sourceFilePath);
			InputStreamReader reader = new InputStreamReader(in, sourceCharsetName);
			
			FileOutputStream out = new FileOutputStream(destinationFilePath, false);
			OutputStreamWriter writer = new OutputStreamWriter(out,destinationCharsetName);
			
			char[] buf = new char[1024];
			int len = 0;
			
			while ((len = reader.read(buf)) != -1) {
				char[] result = FullCharConverter.ToDBC(buf).toCharArray();
				writer.write(result, 0, result.length);
			}
			/*while ((len = reader.read(buf)) > 0) {
				writer.write(buf, 0, len);
			}*/
			reader.close();
			writer.flush();
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return true;
		
	}
	

    public static void delete(List<File> list) {
    	int size =  list.size();
    	for (int i = size-1; i >=0; i--) {
			try {
				FileUtil.delete(list.get(i));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    }

	
//    /**
//     *  根据路径删除指定的目录或文件，无论存在与否
//     *@param sPath  要删除的目录或文件
//     *@return 删除成功返回 true，否则返回 false。
//     */
//    public static boolean DeleteFolder(String sPath) {
//        Boolean flag = false;
//        File file = new File(sPath);
//        // 判断目录或文件是否存在
//        if (!file.exists()) {  // 不存在返回 false
//            return flag;
//        } else {
//            // 判断是否为文件
//            if (file.isFile()) {  // 为文件时调用删除文件方法
//                return deleteFile(sPath);
//            } else {  // 为目录时调用删除目录方法
//                return deleteDirectory(sPath);
//            }
//        }
//    }
    
//    /**
//     * 删除单个文件
//     * @param   sPath    被删除文件的文件名
//     * @return 单个文件删除成功返回true，否则返回false
//     */
//    public static boolean deleteFile(String sPath) {
//        Boolean flag = false;
//        File file = new File(sPath);
//        // 路径为文件且不为空则进行删除
//        if (file.isFile() && file.exists()) {
//            file.delete();
//            flag = true;
//            logger.debug("删除文件【" +
//            		sPath+"】是否成功:是");
//        }else {
//        	logger.debug("删除文件【" +
//            		sPath+"】是否成功:否");
//		}
//        
//        return flag;
//    }
    
//    /**
//     * 删除目录（文件夹）以及目录下的文件
//     * @param   sPath 被删除目录的文件路径
//     * @return  目录删除成功返回true，否则返回false
//     */
//    public static boolean deleteDirectory(String sPath) {
//        //如果sPath不以文件分隔符结尾，自动添加文件分隔符
//        if (!sPath.endsWith(File.separator)) {
//            sPath = sPath + File.separator;
//        }
//        File dirFile = new File(sPath);
//        //如果dir对应的文件不存在，或者不是一个目录，则退出
//        if (!dirFile.exists() || !dirFile.isDirectory()) {
//            return false;
//        }
//        Boolean flag = true;
//        //删除文件夹下的所有文件(包括子目录)
//        File[] files = dirFile.listFiles();
//        for (int i = 0; i < files.length; i++) {
//            //删除子文件
//            if (files[i].isFile()) {
//                flag = deleteFile(files[i].getAbsolutePath());
//                if (!flag) break;
//            } //删除子目录
//            else {
//                flag = deleteDirectory(files[i].getAbsolutePath());
//                if (!flag) break;
//            }
//        }
//        if (!flag) return false;
//        //删除当前目录
//        if (dirFile.delete()) {
//            return true;
//        } else {
//            return false;
//        }
//    }
    
   
///--------------------------------------------------------
	
	public static void doCopyFile(File src, File dest, FileUtilParams params) throws IOException {
		if (dest.exists()) {
			if (dest.isDirectory()) {
				throw new IOException("Destination '" + dest + "' is a directory");
			}
			/*if (params.overwrite == false) {
				throw new IOException(MSG_ALREADY_EXISTS + dest);
			}*/
		}

		// do copy file
		FileInputStream input = new FileInputStream(src);
		try {
			FileOutputStream output = new FileOutputStream(dest);
			try {
				StreamUtil.copy(input, output);
			} finally {
				StreamUtil.close(output);
			}
		} finally {
			StreamUtil.close(input);
		}

		// done

		if (src.length() != dest.length()) {
			throw new IOException("Copy file failed of '" + src + "' to '" + dest + "' due to different sizes");
		}
		/*if (params.preserveDate) {
			dest.setLastModified(src.lastModified());
		}*/
	}
	
	
	public static Boolean existsFile(String path) {
		File file = new File(path);
		return existsFile(file);
	}
	
	public static Boolean existsFile(File file) {		
		if (file.exists()) {			
			return true;
		}
		return false;
	}
	
	
	/**
	 *  @see #findFiles(String, String, String, List)
	 */
    public static void findFiles(String dir,String fileName,List<File> targetFiles) {
    	findFiles(dir, fileName, null, targetFiles);
    }

    
    /**
     * 
     * 
     * <ul>
     * <li>方法含义：</li>
     * <li>方法作者：花宏宇</li>
     * <li>编写日期：2013-6-21；时间：下午4:03:10</li>
     * </ul>
     * <ul>
     * <b>修订编号：</b>
     * <li>修订日期：</li>
     * <li>修订作者：</li>
     * <li>修订原因：</li>
     * <li>修订内容：</li>
     * </ul>
     * @param dir 要查找的文件目录
     * @param fileName 要查找的文件名称
     * @param regex 正则表达式
     * @param targetFiles 存放查找到的文件结果（要包含文件的扩展名）
     * @return
     */
    public static void findFiles(String dir,String fileName,String regex,List<File> targetFiles) {
    	
    	File[] files = listFiles(dir);
        for (int i = 0; i < files.length; i++) {
			String name = files[i].getName();
			if(files[i].isFile()){
				Boolean flag = false;
				if (fileName.equalsIgnoreCase(name)) {
					flag = true;
					//targetFiles.add(files[i]);
				}
				/*if (name.indexOf(fileName)!=-1) {
					targetFiles.add(files[i]);
				}*/
				if (!(regex==null||"".equals(regex))) {
					if (name.matches(regex)) {
						flag = true;
						//targetFiles.add(files[i]);
					}
				}
				if (flag) {
					targetFiles.add(files[i]);
				}
				
				//System.err.println(files[i]);
			}else {
				//递归查找，子文件夹
				findFiles(files[i].toString(), fileName,regex,targetFiles);
			}
		}
        
	}
    
    
    public static void blurFindFiles(String dir,String fileName,String regex,List<File> targetFiles) {
    	File[] files = listFiles(dir);
        for (int i = 0; i < files.length; i++) {
			String name = files[i].getName();
			if(files[i].isFile()){
				Boolean flag = false;
				if (fileName.equalsIgnoreCase(name)) {
					flag = true;
					//targetFiles.add(files[i]);
				}
				if (name.toLowerCase().indexOf(fileName.toLowerCase())!=-1) {
					flag = true;
					//targetFiles.add(files[i]);
				}
				if (!(regex==null||"".equals(regex))) {
					if (name.matches(regex)) {	
						flag = true;
						//targetFiles.add(files[i]);
					}
				}
				if (flag) {
					targetFiles.add(files[i]);
				}
				//System.err.println(files[i]);
			}else {
				//递归查找，子文件夹
				blurFindFiles(files[i].toString(), fileName,regex,targetFiles);
			}
		}
        
	}
    
        
   
    
    /**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：用空格" "，代替文件路径filePath中的"%20"</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2012-6-17；时间：下午11:13:45</li>
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
	 * @return
	 * @throws IOException
	 * @return
	 */
	public static String filterFilePath(String filePath) {
		return FileNameUtil.filterFilePath(filePath);
		
	}

	/**
	 * @see #filterFilePath(String)
	 */
	public static File filterFilePath(File filePath) throws IOException {
		File currentFile = new File(filterFilePath(filePath.toString()));
		return currentFile;
	}
	
	

    public static File getFile(URI pathname) {
    	return getFile(pathname.getPath());
    }

    
    public static File getFile(String pathname) {
		File file = new File(pathname);
		if ( !existsFile(file)) {
			try {
				throw new FileNotFoundException(pathname);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return file;
	}
    

	
	
	public static Boolean isBeginWithDirSeparator(String path) {
		if (StringUtil.isEmpty(path)) {
			throw new CommonRuntimeException("7777777");
		}
		if (path.substring(0,1).equals("/")
				||path.substring(0,1).equals("\\")) {
			return true;
		}
		return false;
	}
	
	 /**
     * 
     * 
     * <ul>
     * <li>方法含义：列出目录【dir】下的，所有直接文件夹和直接文件</li>
     * <li>方法作者：花宏宇</li>
     * <li>编写日期：2013-7-2；时间：下午5:59:29</li>
     * </ul>
     * <ul>
     * <b>修订编号：</b>
     * <li>修订日期：</li>
     * <li>修订作者：</li>
     * <li>修订原因：</li>
     * <li>修订内容：</li>
     * </ul>
     * @param dir
     * @return
     */
    public static File[] listFiles(String dir) {    	
    	return listFiles(getFile(dir), false);
	}
    

	/**
	 * @see #listFiles(File, Boolean)
	 */
	public static File[] listFiles(File dirFile) {
		return listFiles(dirFile, false);

	}

	/**
	 * @see #listFiles(File, Boolean)
	 */
	public static File[] listFiles(String dir,Boolean containsSubDir) {    	
    	return listFiles(getFile(dir), containsSubDir);
	}
	
	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：列出目录下的子文件</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2013-5-13；时间：下午4:26:21</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * 
	 * @param dirFile
	 * @param containsSubDir
	 *            是否迭代，对子目录，也进行显示
	 * @return
	 * @return
	 */
	public static File[] listFiles(File dirFile, Boolean containsSubDir) {
		File[] files = dirFile.listFiles();
		List<File> returnFiles = new ArrayList<File>();

		if (containsSubDir) {
			//本来应该进行递归。现在直接调用现成的
			returnFiles = FindFileUtil.findFiles(dirFile.toString(), null);
			/*for (int i = 0; i < files.length; i++) {
				// 是子文件
				if (files[i].isFile()) {
					returnFiles.add(files[i]);
				} // 是子目录
				else {
					// flag = deleteDirectory(files[i].getAbsolutePath());
					// if (!flag) break;
				}
			}*/
			return (File[]) returnFiles.toArray(new File[returnFiles.size()]);
		}else {
			return files;
		}
	}
	
	
	public static Boolean containsText(String file, String keyword) {
		List<Integer> list = findText(file, keyword, true);
		if (CollectionUtil.isNotEmpty(list)) {
			return true;
		}
		return false;
	}
	public static List<Integer> findText(String file, String keyword) {
		return findText(file, keyword, false);
	}
	public static List<Integer> findText(String file, String keyword,Boolean isOnce) {
		String str;
		BufferedReader bufferedReader;
		List<Integer> list = new LinkedList<Integer>();
		int rownum = 0;
		try {
			bufferedReader = new BufferedReader(new FileReader(file));
			while ((str = bufferedReader.readLine()) != null) {
				rownum++;
				if (str.indexOf(keyword) != -1) {
					//System.out.println("line:" + rownum + "  " + file);
					list.add(rownum);
					if (isOnce) {
						break;
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	public static void printDir(File dir) {
		logger.debug("打印信息：");
		File[] files = FileUtil.listFiles(dir);
		for (File file2 : files) {
			if (file2.isDirectory()) {
				logger.debug(file2.toString() + "是目录，打印子目录");
				printDir(file2);
			} else {
				logger.debug(file2.toString());
			}
		}

	}
	
	
	public static String readProperty(String filePath, String key) {
		Map<String, String> map = PropertiesUtil.readProperties(filePath);
		return map.get(key);

	}

	public static String readProperty(File filePath, String key) {

		return readProperty(filePath.toString(), key);

	}
	
	
	public static String readString(File source)
		        throws IOException
		    {
		        return readString(source, defaultParams.getEncoding());
		    }

	
	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：读取文本文件中的字符串</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2014-2-2；时间：下午6:22:41</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param file
	 * @param encoding
	 * @return
	 */
	public static String readString(File file, String encoding)
	{
		String data =null;
		try {
			data = jodd.io.FileUtil.readString(file, encoding);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("读取文件的文本：文件路径是【" +
				file.getAbsolutePath()+"】,数据长度是【" +
						data.length()+"个字符】,数据是【" +
						data.substring(0, 10)+"】,编码是【" +
								encoding+"】.");
		return data;
	}


	public static void writeString(String dest, String data)
	        //throws IOException
	    {
	        outString(file(dest), data,defaultParams.getEncoding() , false);
	    }

	public static void writeString(String dest, String data, String encoding)
	// throws IOException
	{
		outString(file(dest), data, encoding, false);
	}
	public static void replaceLine(String dest, Integer srcLineNoIndex, String newLineStr, String encoding) throws IOException{
		
	}
	
	
	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：替换文本文件中的，某一行</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2015-6-4；时间：下午5:20:20</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param dest 目标文件
	 * @param startLineNoIndex 目标文件的起始行的下标
	 * @param endLineNoIndex
	 * @param srcStr  被替换的关键字
	 * @param newLineStr 插入的新行
	 * @param encoding
	 * @throws IOException
	 */
	public static void replaceLine(String dest, Integer startLineNoIndex, Integer endLineNoIndex,String srcStr,String newLineStr, String encoding) throws IOException{

		Boolean flag= false;
		String[] lines=  FileUtil.readLines(dest, encoding);
		if (endLineNoIndex==null||endLineNoIndex<=0||endLineNoIndex>lines.length) {
			endLineNoIndex=lines.length;
		}
		for (int i = startLineNoIndex; i < endLineNoIndex; i++) {
			if (StringUtil.contains(lines[i], srcStr)) {
				lines[i]=newLineStr;
				logger.debug("替换文件【{}】的含有【{}】的行",dest,srcStr);
				flag=true;
			}
		}
		
		if (flag) {
		
			PrintWriter printWriter = new PrintWriter(dest);
			for (int i = 0; i < lines.length; i++) {			
				printWriter.write(lines[i]+System.getProperty("line.separator"));
			}
			printWriter.flush();
			printWriter.close();

			
		}
		
		

	}
	public static void replaceString(String dest, Integer startLineNoIndex, Integer endLineNoIndex,String srcStr,String newStr, String encoding) throws IOException{

		Boolean flag= false;
		String[] lines=  FileUtil.readLines(dest, encoding);
		if (endLineNoIndex==null||endLineNoIndex<=0||endLineNoIndex>lines.length) {
			endLineNoIndex=lines.length;
		}
		for (int i = startLineNoIndex; i < endLineNoIndex; i++) {
			//System.out.println(lines[i]);
			if (StringUtil.contains(lines[i], srcStr)) {
				
				lines[i]= StringUtil.replace(lines[i], srcStr, newStr);
				logger.debug("替换文件【{}】的含有【{}】的行",dest,srcStr);
				flag=true;
			}
		}
		
		if (flag) {
		
			PrintWriter printWriter = new PrintWriter(dest,encoding);
			for (int i = 0; i < lines.length; i++) {			
				printWriter.write(lines[i]+System.getProperty("line.separator"));
			}
			printWriter.flush();
			printWriter.close();

			
		}
	}
	public static void insertString(String dest, Integer startLineNoIndex, Integer endLineNoIndex,String data, String encoding) throws IOException
	// throws IOException
	{
		String[] lines=  FileUtil.readLines(dest, encoding);
		
		for (String string : lines) {
			
		}
		PrintWriter printWriter = new PrintWriter("D:/1.txt");
			printWriter.write('a');
			printWriter.flush();
			printWriter.close();

		outString(file(dest), data, encoding, false);
	}

	    public static void writeString(File dest, String data)
	       // throws IOException
	    {
	        outString(dest, data, defaultParams.getEncoding(), false);
	    }

	    public static void writeString(File dest, String data, String encoding)
	       // throws IOException
	    {
	        outString(dest, data, encoding, false);
	    }

	    public static void appendString(String dest, String data)
	       // throws IOException
	    {
//	        outString(file(dest), data, defaultParams.encoding, true);
	        outString(file(dest), data, "UTF-8", true);
	    }

	    public static void appendString(String dest, String data, String encoding)
	        //throws IOException
	    {
	        outString(file(dest), data, encoding, true);
	    }

	    public static void appendString(File dest, String data)
	        //throws IOException
	    {
//	        outString(dest, data, defaultParams.encoding, true);
	        outString(dest, data, "utf-8", true);
	    }

	    public static void appendString(File dest, String data, String encoding)
	        //throws IOException
	    {
	        outString(dest, data, encoding, true);
	    }
	
/////////////////////////////////////////////////////////////////////////////////////////////////////
    protected static void outString(File dest, String data, String encoding, boolean append){
		try {
			jodd.io.FileUtil.outString(dest, data, encoding, append);
			logger.info("写入文件：文件路径是【" +
					dest.getAbsolutePath()+"】,数据长度是【" +
							data.length()+"个字符】,数据是【" +
							data.substring(0, 10)+"】,编码是【" +
									encoding+"】,是否追加在文件尾部【" +
											append+"】.");
		} catch (IOException e) {
			e.printStackTrace();
		}

    }
	private static File file(String fileName)
	    {
	        return new File(fileName);
	    }
}
