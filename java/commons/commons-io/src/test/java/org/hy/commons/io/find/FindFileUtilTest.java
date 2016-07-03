package org.hy.commons.io.find;

import static org.junit.Assert.fail;

import java.io.File;
import java.net.URL;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.hy.commons.io.core.FileUtil;
import org.hy.commons.io.maven.util.MavenUtil;
import org.hy.commons.io.path.FilePathUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FindFileUtilTest {

	private static Logger logger = LoggerFactory.getLogger(FindFileUtilTest.class);
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindFilesStringString() {
		//String searchPath = ProjectPathUtil.getProjectResourcesDirPath();
		String searchPath = "E:\\Program Files\\eclipse-jee-helios-SR2-win32\\workspace\\spring0909";
		List<File> list =FindFileUtil.findFiles(searchPath,"PersonDaoImpl.java*");
		for (File file : list) {
			System.err.println(file.getAbsolutePath());
		}
	}

	@Test
	public void testFindFilesStringStringString() {
		List<File> files = FindFileUtil.findFiles(MavenUtil.getTestResourcesPath(getClass()).toString()
				,null);
		for (File file : files) {
			logger.debug(file.toString());
		}
	}

	@Test
	public void testFindilesByWildCard() {
		String searchPath = "F:\\temp-test\\5花";
		/*URL data = FileUtilTest.class.getClassLoader().getResource("");
		String searchPath = 
		 FilePathUtil.filterFilePath(data.getFile());
		searchPath= searchPath.substring(1);*/
		//logger.debug("$$ searchPath is[{}]",searchPath);
		List<File> list = FindFileUtil.findFilesByWildCard(searchPath,false,true, "", "*",true);
		logger.debug("查询制定目录下的文件【不搜索子文件夹】，文件数目是 [{}]",list.size());
		logger.debug("=====================================");
		for (File file : list) {
			
			System.out.println(file.getAbsolutePath());
			
		}

		/*
		Set<String> extNames = new HashSet<String>();
		logger.debug(extNames.size()+"");
		for (String string : extNames) {
			logger.debug(string);
			
		}*/
		//FileUtil.delete(list);
		
		//List<File> list2 = FindFileUtil.findFilesByWildCard(searchPath, true,"", "*.java");
		//logger.debug("$$ list size is [{}] after files is deleted ",list2.size());
		
		
	}

}
