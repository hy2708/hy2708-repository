package org.hy.commons.web.example.filter.refer;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import javax.servlet.Filter;

import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.webapp.WebAppContext;
import org.hy.commons.web.example.servlet.io.OneServlet;
import org.hy.commons.web.filter.ReferFilter;
import org.hy.commons.web.http.HttpClientUtil;
import org.hy.commons.web.http.HttpUnitUtil;
import org.hy.commons.web.test.AbstractJettyTest;
import org.hy.server.jetty8.JettyUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ReferFilterTest extends AbstractJettyTest{

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		//super.tearDown(10000000);
	}

	@Test
	public void test() throws Exception {
		
		//startServer(OneServlet.class);
		String string =HttpUnitUtil.visitUrl("http://mdskip.taobao.com/core/initItemDetail.htm?isSpu=false&isIFC=false&isNewDecorate=true&sellerUserTag4=1729382399350965635&notAllowOriginPrice=false&sellerUserTag2=18020085113290752&sellerUserTag3=633318731186304&isAreaSell=false&isForbidBuyItem=false&rtk=rstime_sid64581872pid391480980&tmallBuySupport=true&itemTags=775,907,1163,1478,1483,1803,2049,2123,2251,3974,4166,8258&household=false&sellerUserTag=303632416&queryMemberRight=true&tgTag=false&isRegionLevel=false&isUseInventoryCenter=false&itemId=15916077445&isSecKill=false&renderTime=1379584117669&isApparel=true&showTagPrice=false&lastVersionMD5=5dd86f86b12418b6da85c8755950b7aa&releaseTime=1379322216000&hitPrizeAuction=false&showShopProm=true&service3C=false&cartEnable=true&callback=onMdskip&ip=&campaignId=&key=&abt=&cat_id=&q=&u_channel=&areaId=&ref=http%253A%252F%252Fs.click.taobao.com%252Ft_js%253Ftu%253Dhttp%25253A%25252F%25252Fs.click.taobao.com%25252Ft%25253Fe%25253DzGU34CA7K%2525252BPkqB07S4%2525252FK0CFcRfH0GoT805sipKkHWyjqLnsc4Vz0rz%2525252BFvz6bGzP3YH8lF4CkN%2525252Fm9khLXO1hZx6ZTdqZ7VRIii2GDiu731Qt9iA%2525253D%2525253D%252526ref%25253D%252526et%25253DjFBDMTp0JqFFAg%2525253D%2525253D&brandSiteId=0",
				"get");
		System.err.println(string);
		//HttpClientUtil.visitUrl(JettyUtil.WHOLE_URL);
	}
	
	@Override
	protected void configureFilters(WebAppContext context,
			List<Class<? extends Filter>> filters,
			List<FilterHolder> filterHolders, Map<Class<Filter>, String> map) {
		
		context.addFilter(ReferFilter.class, "/*", JettyUtil.getDispatcherTypes());
	}

	@Override
	protected void initServlet(Map<String, Object> map) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initSession(Map<String, Object> map) {
		// TODO Auto-generated method stub
		
	}

}
