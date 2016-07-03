package org.hy.commons.web.servlet;

import static org.junit.Assert.*;
import jodd.http.HttpBrowser;
import jodd.http.HttpRequest;
import jodd.http.HttpResponse;

import org.eclipse.jetty.server.Server;
import org.hy.commons.web.http.HttpClientUtil;
import org.hy.commons.web.request.method.MethodsInRequestOfServlet2;
import org.hy.server.jetty8.JettyUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HttpServletUtilTest {

	@Before
	public void setUp() throws Exception {
		Server server =JettyUtil.getServer();
		JettyUtil.setAppContextPath(HttpClientUtil.MY_APP);
		JettyUtil.addServlet(HttpServletUtilTestServlet.class, HttpClientUtil.HELLO);
		JettyUtil.startServer();
		//String content = HttpClientUtil.visitUrl(HttpClientUtil.WHOLE_URL);
		
		//System.err.println(content);
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		JettyUtil.stopServer();
	}

	@Test
	public void testGetAttributeFromContext() {
		HttpBrowser browser = new HttpBrowser();
		HttpRequest httpRequest = //new HttpRequest();
		HttpRequest.get(HttpClientUtil.WHOLE_URL);
		browser.sendRequest(httpRequest );
		HttpResponse httpResponse =browser.getHttpResponse();
		//System.err.println(httpResponse.bodyText());
		
	}

	@Test
	public void testGetRequestDoamin() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetRequestHostName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetRequestPort() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetRequestContextPath() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetRequestServletPath() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetRequestURI() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetWholeUrl() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetInitParameterFromContext() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetContextPathHttpServletRequest() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetServletContext() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetResource() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetResourceAsStream() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveAttributeFromContext() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetAttributeFromContext() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsMultipartRequest() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsGzipSupported() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAuthUsername() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAuthPassword() {
		fail("Not yet implemented");
	}

	@Test
	public void testRequireAuthentication() {
		fail("Not yet implemented");
	}

	@Test
	public void testPrepareDownloadHttpServletResponseFile() {
		fail("Not yet implemented");
	}

	@Test
	public void testPrepareDownloadHttpServletResponseFileString() {
		fail("Not yet implemented");
	}

	@Test
	public void testPrepareResponse() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCookie() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllCookies() {
		fail("Not yet implemented");
	}

	@Test
	public void testReadRequestBody() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetContextPathHttpServletRequest1() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetContextPathServletContext() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetContextPathPageContext() {
		fail("Not yet implemented");
	}

	@Test
	public void testStoreContextPathPageContextString() {
		fail("Not yet implemented");
	}

	@Test
	public void testStoreContextPathServletContextString() {
		fail("Not yet implemented");
	}

	@Test
	public void testStorePageContextInThread() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPageContextFromThread() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetContextPath() {
		fail("Not yet implemented");
	}

	@Test
	public void testAttributePageContextString() {
		fail("Not yet implemented");
	}

	@Test
	public void testAttributeHttpServletRequestString() {
		fail("Not yet implemented");
	}

	@Test
	public void testValuePageContextString() {
		fail("Not yet implemented");
	}

	@Test
	public void testValueHttpServletRequestString() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetScopeAttribute() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveScopeAttribute() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsAbsoluteUrl() {
		fail("Not yet implemented");
	}

	@Test
	public void testStripSessionId() {
		fail("Not yet implemented");
	}

	@Test
	public void testResolveUrlStringPageContext() {
		fail("Not yet implemented");
	}

	@Test
	public void testResolveUrlStringHttpServletRequest() {
		fail("Not yet implemented");
	}

	@Test
	public void testResolveUrlStringString() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetRequestParameter() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsGetParameter() {
		fail("Not yet implemented");
	}

	@Test
	public void testPrepareParameters() {
		String[] p = new String[]{"one", "", " three ", null, "five"};
		p = HttpServletUtil.prepareParameters(p, true, false, false);
		assertEquals("three", p[2]);
		assertNotNull(p[1]);
		assertNull(p[3]);
		p = HttpServletUtil.prepareParameters(p, true, true, false);
		assertNull(p[1]);
		assertNull(p[3]);
	
		p = HttpServletUtil.prepareParameters(new String[]{"", null, "   "}, true, true, true);
		assertNull(p);
	}

	@Test
	public void testCopyParamsToAttributes() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsServletsVersion2_5() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetServletError() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetServletError() {
		fail("Not yet implemented");
	}

	@Test
	public void testDebugHttpServletRequest() {
		fail("Not yet implemented");
	}

	@Test
	public void testDebugPageContext() {
		fail("Not yet implemented");
	}

	@Test
	public void testDebugHttpServletRequestPageContext() {
		fail("Not yet implemented");
	}

	@Test
	public void testPreventCaching() {
		fail("Not yet implemented");
	}
	
	

}
