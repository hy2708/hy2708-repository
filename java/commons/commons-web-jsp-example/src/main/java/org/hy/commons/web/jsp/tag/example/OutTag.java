package org.hy.commons.web.jsp.tag.example;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class OutTag extends TagSupport{

	String name= null;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int doStartTag() throws JspException {
		try {
			pageContext.getResponse().getWriter().println("name is "+name);
			pageContext.getResponse().getWriter().println("value is "+getValue("value"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return super.doStartTag();
	}

	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return super.doEndTag();
	}

	@Override
	public int doAfterBody() throws JspException {
		// TODO Auto-generated method stub
		return super.doAfterBody();
	}

	@Override
	public void release() {
		// TODO Auto-generated method stub
		super.release();
	}

	@Override
	public void setParent(Tag t) {
		// TODO Auto-generated method stub
		super.setParent(t);
	}

	@Override
	public Tag getParent() {
		// TODO Auto-generated method stub
		return super.getParent();
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		super.setId(id);
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return super.getId();
	}

	@Override
	public void setPageContext(PageContext pageContext) {
		// TODO Auto-generated method stub
		super.setPageContext(pageContext);
	}

	@Override
	public void setValue(String k, Object o) {
		// TODO Auto-generated method stub
		super.setValue(k, o);
	}

	@Override
	public Object getValue(String k) {
		// TODO Auto-generated method stub
		return super.getValue(k);
	}

	@Override
	public void removeValue(String k) {
		// TODO Auto-generated method stub
		super.removeValue(k);
	}

	@Override
	public Enumeration<String> getValues() {
		// TODO Auto-generated method stub
		return super.getValues();
	}

	
}
