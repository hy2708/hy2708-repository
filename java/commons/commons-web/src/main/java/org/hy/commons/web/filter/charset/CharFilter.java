package org.hy.commons.web.filter.charset;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.hy.commons.lang.character.CharacterCheckUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CharFilter implements Filter {
	// 声明编码的成员变量
	private String charsetName=null;

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	public void init(FilterConfig config) throws ServletException {
		charsetName = config.getInitParameter("charsetName");
		if (charsetName==null||charsetName.equals("")) {
			charsetName =config.getInitParameter("charset");
		}
		if (charsetName==null||charsetName.equals("")) {
			charsetName ="utf8";
		}
		
		logger.info("创建并初始化【" +
				getClass().getSimpleName()+"】");
	}

	/**
	 * 对request用post提交的数据，指定字符集
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		/*
		 * 对POST方法提交的数据，进行过滤
		 */
		request.setCharacterEncoding(charsetName);//对get没有效
		response.setCharacterEncoding(charsetName);
		response.setContentType("text/html;charset=" + charsetName);
		// 判断是否需要包装
		HttpServletRequest req = (HttpServletRequest) request;
		if (req.getMethod().equalsIgnoreCase("GET")) {
			//暂时，不度【get】进行过滤
			request = new MyRequest(req);
		}
		// 声明包装类的实例
		// 放行
		chain.doFilter(request, response);
	}
	public void destroy() {
	}
}

// 声明包装类
class MyRequest extends HttpServletRequestWrapper {

	private Logger logger = LoggerFactory.getLogger(getClass());

	public MyRequest(HttpServletRequest request) {
		super(request);
	}

	// 增强getParamter
	@Override
	public String getParameter(String name) {
		String val = super.getParameter(name);
		try {
			//如果得到的变量是乱码
			if (CharacterCheckUtil.isMessyCode(val)) {				
				logger.debug("包装前【getParameter(String name)】得到的参数值是【" +
						val+"】");
				val = new String(val.getBytes("ISO-8859-1"),
						super.getCharacterEncoding());
				logger.debug("包装后【getParameter(String name)】得到的参数值是【" +
						val+"】");
			}
			//如果得到的变量不是乱码
			else {
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return val;
	}
	
	@Override
	public Map<String, String[]> getParameterMap() {
		// TODO Auto-generated method stub
		Map<String, String[]> map = super.getParameterMap();
		return map;
	}
	
	@Override
	public String[] getParameterValues(String name) {
		
		String[] paras = super.getParameterValues(name);
		if (paras==null) {
			return null;
		}else {
			String[] returns= new String[paras.length];
			logger.debug("包装前【getParameterValues(String name)】得到的参数值是【" +
					paras+"】");

			for (int i = 0; i < paras.length; i++) {
				String val=paras[i];
				//如果得到的变量是乱码
				if (CharacterCheckUtil.isMessyCode(val)) {				
					try {
						val = new String(val.getBytes("ISO-8859-1"),
								super.getCharacterEncoding());
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}
				returns[i]=val;
			}
			logger.debug("包装后【getParameterValues(String name)】得到的参数值是【" +
					returns+"】");
			
			return returns;

		}
	}
}
