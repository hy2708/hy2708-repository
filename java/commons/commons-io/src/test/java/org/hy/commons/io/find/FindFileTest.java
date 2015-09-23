package org.hy.commons.io.find;

// Copyright (c) 2003-2013, Jodd Team (jodd.org). All Rights Reserved.


import jodd.io.findfile.FindFile;
import jodd.io.findfile.RegExpFindFile;
import jodd.io.findfile.WildcardFindFile;

import org.hy.commons.io.core.FileNameUtil;
import org.hy.commons.io.core.FileUtilTest;
import org.hy.commons.io.path.FilePathUtil;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.URL;
import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FindFileTest {

	protected String dataRoot;
	
	private static Logger logger  = LoggerFactory.getLogger(FindFileTest.class);

	@Before
	public void setUp() throws Exception {
		if (dataRoot != null) {
			return;
		}
		URL data = FileUtilTest.class.getClassLoader().getResource("");
//		dataRoot = FilePathUtil.filterFilePath(data.getFile());
		dataRoot = "F:\\temp-test\\5花\\5花";
		
		//System.err.println(dataRoot);
	}
	
	@Test
	public void namXe() {
		logger.debug("File paht is 【{}】*", dataRoot);
		//System.err.println(dataRoot);
	}

	@Test
	public void testWildcardFile() {
		FindFile ff = new WildcardFindFile()
				.include("**/*file/a*")
				.setRecursive(true)
				.setIncludeDirs(true)
				.searchPath(dataRoot);

		int countDirs = 0;
		int countFiles = 0;

		File f;
		while ((f = ff.nextFile()) != null) {
			if (f.isDirectory() == true) {
				countDirs++;
			} else {
				countFiles++;
				String path = f.getAbsolutePath();
				path = FileNameUtil.separatorsToUnix(path);
				if (path.startsWith("/") == false) {
					path = '/' + path;
				}
				boolean matched =
						path.equals(dataRoot + "/file/a.png") ||
								path.equals(dataRoot + "/file/a.txt");

				assertTrue(matched);

			}
		}

		assertEquals(0, countDirs);
		assertEquals(2, countFiles);

		ff.searchPath(dataRoot);

		countDirs = 0;
		countFiles = 0;

		Iterator<File> iterator = ff.iterator();

		while (iterator.hasNext()) {
			f = iterator.next();

			if (f.isDirectory() == true) {
				countDirs++;
			} else {
				countFiles++;
				String path = f.getAbsolutePath();
				path = FileNameUtil.separatorsToUnix(path);
				if (path.startsWith("/") == false) {
					path = '/' + path;
				}

				boolean matched =
						path.equals(dataRoot + "/file/a.png") ||
								path.equals(dataRoot + "/file/a.txt");

				assertTrue(matched);
			}
		}

		assertEquals(0, countDirs);
		assertEquals(2, countFiles);

	}


	@Test
	public void testWildcardPath() {
		FindFile ff = new WildcardFindFile()
				//.include("**/file/*")
		.setIncludeDirs(true)
		.setIncludeFiles(true)
		.setRecursive(true)
		.setWalking(true)
				.searchPath(dataRoot);

		int countDirs = 0;
		int countFiles = 0;

		File f;
		while ((f = ff.nextFile()) != null) {
			System.err.println(f.getAbsolutePath());
			if (f.isDirectory() == true) {
				countDirs++;
			} else {
				countFiles++;
				String path = f.getAbsolutePath();
				path = FileNameUtil.separatorsToUnix(path);
				if (path.startsWith("/") == false) {
					path = '/' + path;
				}

				boolean matched =
						path.equals(dataRoot + "/file/a.png") ||
								path.equals(dataRoot + "/file/a.txt");

				//assertTrue(matched);

			}
		}

		//assertEquals(0, countDirs);
		//assertEquals(2, countFiles);
		System.err.println(countDirs+countFiles);
	}

	@Test
	public void testRegexp() {
		FindFile ff = new RegExpFindFile()
				.include(".*/a[.].*")
				.setRecursive(true)
				.setIncludeDirs(true)
				.searchPath(dataRoot);

		int countDirs = 0;
		int countFiles = 0;

		File f;
		while ((f = ff.nextFile()) != null) {
			if (f.isDirectory() == true) {
				countDirs++;
			} else {
				countFiles++;
				String path = f.getAbsolutePath();
				path = FileNameUtil.separatorsToUnix(path);
				if (path.startsWith("/") == false) {
					path = '/' + path;
				}

				boolean matched =
						path.equals(dataRoot + "/file/a.png") ||
								path.equals(dataRoot + "/file/a.txt");

				assertTrue(matched);

			}
		}

		assertEquals(0, countDirs);
		assertEquals(2, countFiles);
	}

}
