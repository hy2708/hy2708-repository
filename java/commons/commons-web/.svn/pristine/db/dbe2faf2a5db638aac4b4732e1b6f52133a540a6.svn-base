package org.hy.commons.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.hy.commons.lang.EntityBeanUtil;
import org.hy.commons.lang.string.StringUtil;

/*
 * 自动为变量赋值
 * 自动调用方法
 */
public abstract class BaseHttpServlet extends HttpServlet{

	protected String assignType= ASSIGNTYPE_BASE;
	protected static final String ASSIGNTYPE_OBJECT="object" ;
	protected static final String ASSIGNTYPE_BASE="base" ;
	protected static final String ASSIGNTYPE_ALL="all" ;
	protected static ThreadLocal<Object> map= new ThreadLocal<Object>() ;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		_handleRequest(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		_handleRequest(req, resp);
	}
	
	private void acceptParameters(HttpServletRequest req) {
		if (StringUtil.isEmpty(getAssignType())) {

		} else if (ASSIGNTYPE_BASE.equals(getAssignType())) {
			List<String> propertyNames = EntityBeanUtil
					.getBasePropertyNamesOfEntity(getClass());
			Object value = null;
			for (String propertyName : propertyNames) {
				try {
					// value = BeanUtils.getSimpleProperty(this, propertyName);
					BeanUtils.setProperty(this, propertyName,
							req.getParameter(propertyName));
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		// TODO 未完成
		else if (ASSIGNTYPE_OBJECT.equals(getAssignType())) {
			List<Class> propertyNames = EntityBeanUtil
					.getObjectPropertyNamesOfEntity(getClass());
			for (Class class1 : propertyNames) {
				Object value = null;
				// for (String propertyName : propertyNames) {
				// try {
				// value = BeanUtils.get
				// BeanUtils.setProperty(this, propertyName, value);
				// } catch (IllegalAccessException e) {
				// e.printStackTrace();
				// } catch (InvocationTargetException e) {
				// e.printStackTrace();
				// } catch (NoSuchMethodException e) {
				// e.printStackTrace();
				// }
				// }
			}

			throw new RuntimeException("111111111");

		}

	}
	protected  void _handleRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*
		 * 接收参数
		 */
		acceptParameters(req);
		String methodName =req.getParameter("methodName");
		if (methodName!=null) {
			try {
				getClass().getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class)
				.invoke(this, req , resp);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			}
		}else {	
			
			handleRequest(req, resp);
		}
		
		
	}
	
	public abstract  void handleRequest(HttpServletRequest request, HttpServletResponse response)
		        throws ServletException, IOException;
	
	
	public String getAssignType() {
		return assignType;
	}

	public void setAssignType(String assignType) {
		this.assignType = assignType;
	}
	
}
