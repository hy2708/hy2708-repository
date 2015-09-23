package org.hy.commons.xml.w3c;

import static org.junit.Assert.fail;

import java.io.InputStream;

import org.hy.commons.web.http.HttpClientUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DOMUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testNewXMLDocument() {
		fail("Not yet implemented");
	}

	@Test
	public void testNewDocumentBuilder() {
		fail("Not yet implemented");
	}

	@Test
	public void testNewDocumentBuilderFactory() {
		fail("Not yet implemented");
	}

	@Test
	public void testParseXMLDocumentString() {
		fail("Not yet implemented");
	}

	@Test
	public void testParseXMLDocumentInputStream() {
		String url = "http://detail.tmall.com/item.htm?id=15916077445&ali_trackid=2:mm_31651633_0_0:1379495059_6k4_724291913";

       InputStream in0 =HttpClientUtil.getInputStreamByvisitUrl(url, "gbk", "get");

	   DOMUtil.parseXMLDocument(in0);
	}

	@Test
	public void testLoadXMLDocumentFromFile() {
		fail("Not yet implemented");
	}

	@Test
	public void testNewXMLDocumentNode() {
		fail("Not yet implemented");
	}

	@Test
	public void testNewTransformer() {
		fail("Not yet implemented");
	}

	@Test
	public void testErrXMLString() {
		fail("Not yet implemented");
	}

	@Test
	public void testParseDocument() {
		fail("Not yet implemented");
	}

	@Test
	public void testParseDocument1() {
		fail("Not yet implemented");
	}

	@Test
	public void testToStringFromDoc() {
		fail("Not yet implemented");
	}

	@Test
	public void testWriteToFile() {
		fail("Not yet implemented");
	}

}
