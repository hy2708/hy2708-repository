// Copyright (c) 2003-2014, Jodd Team (jodd.org). All Rights Reserved.

package org.hy.commons.net.http;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import jodd.http.HttpRequest;
import jodd.io.FileUtil;
import jodd.upload.FileUpload;

import org.junit.Assert;
import org.junit.Test;

public class HttpRequestTest {

	
	@Test
	public void testQueryParameters() {
		HttpRequest httpRequest = new HttpRequest();

		httpRequest.path("");
		assertEquals("/", httpRequest.path());

		httpRequest.path("jodd");
		assertEquals("/jodd", httpRequest.path());
		assertNotNull(httpRequest.query());
		assertEquals(0, httpRequest.query().size());

		httpRequest.queryString("one=two");
		assertEquals("/jodd", httpRequest.path());

		Map<String, Object[]> params = httpRequest.query();
		assertEquals(1, params.size());
		assertEquals("two", params.get("one")[0]);

		httpRequest.queryString("one");
		assertEquals("one", httpRequest.queryString());
		params = httpRequest.query();
		assertEquals(1, params.size());
		assertNull(params.get("one"));

		httpRequest.queryString("one=");
		assertEquals("one=", httpRequest.queryString());
		params = httpRequest.query();
		assertEquals(1, params.size());
		assertEquals("", params.get("one")[0]);

		httpRequest.queryString("one=aaa&two=bbb");
		assertEquals("one=aaa&two=bbb", httpRequest.queryString());
		params = httpRequest.query();
		assertEquals(2, params.size());
		assertEquals("aaa", params.get("one")[0]);
		assertEquals("bbb", params.get("two")[0]);

		httpRequest.queryString("one=&two=aaa");
		assertEquals("one=&two=aaa", httpRequest.queryString());
		params = httpRequest.query();
		assertEquals(2, params.size());
		assertEquals("", params.get("one")[0]);
		assertEquals("aaa", params.get("two")[0]);

		httpRequest.clearQueries();
		httpRequest.queryString("one=Супер");
		assertEquals("one=%D0%A1%D1%83%D0%BF%D0%B5%D1%80", httpRequest.queryString());
		params = httpRequest.query();
		assertEquals(1, params.size());
		assertEquals("Супер", params.get("one")[0]);

		httpRequest.queryString("one=Sуp");
		assertEquals("one=S%D1%83p", httpRequest.queryString());

		httpRequest.queryString("one=1&one=2");
		assertEquals("one=1&one=2", httpRequest.queryString());
		params = httpRequest.query();
		assertEquals(1, params.size());
		assertEquals("1", params.get("one")[0]);
		assertEquals("2", params.get("one")[1]);

		httpRequest.query("one", Integer.valueOf(3));
		assertEquals("one=1&one=2&one=3", httpRequest.queryString());
	}

	@Test
	public void testSet() {
		HttpRequest httpRequest = new HttpRequest();
		httpRequest.set("GET http://jodd.org:173/index.html?light=true");

		assertEquals("GET", httpRequest.method());
		assertEquals("http", httpRequest.protocol());
		assertEquals("jodd.org", httpRequest.host());
		assertEquals(173, httpRequest.port());
		assertEquals("/index.html", httpRequest.path());
		assertEquals("true", httpRequest.query().get("light")[0]);


		httpRequest = new HttpRequest();
		httpRequest.set("http://jodd.org:173/index.html?light=true");

		assertEquals("GET", httpRequest.method());
		assertEquals("http", httpRequest.protocol());
		assertEquals("jodd.org", httpRequest.host());
		assertEquals(173, httpRequest.port());
		assertEquals("/index.html", httpRequest.path());
		assertEquals("true", httpRequest.query().get("light")[0]);


		httpRequest = new HttpRequest();
		httpRequest.set("jodd.org:173/index.html?light=true");

		assertEquals("GET", httpRequest.method());
		assertEquals("http", httpRequest.protocol());
		assertEquals("jodd.org", httpRequest.host());
		assertEquals(173, httpRequest.port());
		assertEquals("/index.html", httpRequest.path());
		assertEquals("true", httpRequest.query().get("light")[0]);


		httpRequest = new HttpRequest();
		httpRequest.set("jodd.org/index.html?light=true");

		assertEquals("GET", httpRequest.method());
		assertEquals("http", httpRequest.protocol());
		assertEquals("jodd.org", httpRequest.host());
		assertEquals(80, httpRequest.port());
		assertEquals("/index.html", httpRequest.path());
		assertEquals("true", httpRequest.query().get("light")[0]);


		httpRequest = new HttpRequest();
		httpRequest.set("/index.html?light=true");

		assertEquals("GET", httpRequest.method());
		assertEquals("http", httpRequest.protocol());
		assertEquals("localhost", httpRequest.host());
		assertEquals(80, httpRequest.port());
		assertEquals("/index.html", httpRequest.path());
		assertEquals("true", httpRequest.query().get("light")[0]);


		httpRequest = new HttpRequest();
		httpRequest.set("http://jodd.org");

		assertEquals("GET", httpRequest.method());
		assertEquals("http", httpRequest.protocol());
		assertEquals("jodd.org", httpRequest.host());
		assertEquals(80, httpRequest.port());
		assertEquals("/", httpRequest.path());
	}


	@Test
	public void testInOutForm() {
		HttpRequest request = HttpRequest.get("http://jodd.org/?id=173");
		request.header("User-Agent", "Scaly");
		request.form("one", "funny");

		byte[] bytes = request.toByteArray();

		// read
		HttpRequest request2 = HttpRequest.readFrom(new ByteArrayInputStream(bytes));

		assertEquals(request.method(), request2.method());
		assertEquals(request.path(), request2.path());
		assertEquals(request.queryString(), request2.queryString());

		assertEquals(request.header("User-Agent"), request2.header("User-Agent"));
		assertEquals(request.header("Content-Type"), request2.header("content-type"));
		assertEquals(request.header("Content-Length"), request2.header("content-length"));

		Map params1 = request.form();
		Map params2 = request2.form();
		assertEquals(params1.size(), params2.size());
		assertEquals(params2.get("one"), params2.get("one"));
	}

	@Test
	public void testNegativeContentLength() {
		HttpRequest request = HttpRequest.get("http://jodd.org/?id=173");
		request.contentLength(-123);

		byte[] bytes = request.toByteArray();
		try {
			HttpRequest request2 = HttpRequest.readFrom(new ByteArrayInputStream(bytes));
			assertNull(request2.body());
		} catch (Exception ex) {
			Assert.fail(ex.toString());
		}

		// the same test but with missing content length

		request = HttpRequest.get("http://jodd.org/?id=173");

		bytes = request.toByteArray();
		try {
			HttpRequest request2 = HttpRequest.readFrom(new ByteArrayInputStream(bytes));
			assertNull(request2.body());
		} catch (Exception ex) {
			Assert.fail(ex.toString());
		}
	}

	@Test
	public void testFileUpload() throws IOException {
		HttpRequest request = HttpRequest.get("http://jodd.org/?id=173");

		request.header("User-Agent", "Scaly").form("one", "funny");

		File tempFile = FileUtil.createTempFile();
		tempFile.deleteOnExit();
		FileUtil.writeString(tempFile, "qwerty");
		request.form("two", tempFile);

		byte[] bytes = request.toByteArray();


		// read
		HttpRequest request2 = HttpRequest.readFrom(new ByteArrayInputStream(bytes));
		Map<String, Object[]> httpParams2 = request2.form();

		assertEquals(request.method(), request2.method());
		assertEquals(request.path(), request2.path());
		assertEquals(request.queryString(), request2.queryString());

		assertEquals(request.header("User-Agent"), request2.header("User-Agent"));
		assertEquals(request.header("Content-Type"), request2.header("content-type"));
		assertEquals(request.header("Content-Length"), request2.header("content-length"));

		Map params1 = request.form();
		Map params2 = request2.form();
		assertEquals(params1.size(), params2.size());
		assertEquals(params2.get("one"), params2.get("one"));

		FileUpload fu = (FileUpload) httpParams2.get("two")[0];
		assertEquals(6, fu.getSize());

		String str = new String(fu.getFileContent());
		assertEquals("qwerty", str);

		tempFile.delete();
	}

	@Test
	public void testUrl() {
		HttpRequest httpRequest = new HttpRequest();
		httpRequest.set("GET http://jodd.org:173/index.html?light=true");

		assertEquals("http://jodd.org:173/index.html?light=true", httpRequest.url());
	}

}