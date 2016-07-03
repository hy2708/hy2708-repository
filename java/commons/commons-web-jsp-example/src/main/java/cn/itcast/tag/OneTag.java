package cn.itcast.tag;

import java.io.PrintWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;
/**
 */
public class OneTag extends TagSupport {
	private String name;
	public void setName(String name) {
		this.name = name;
	}
	//标签开始时执行这个方法
	@Override
	public int doStartTag() throws JspException {
		try{
			JspWriter out = pageContext.getOut();
			out.print("你好:"+name);
		}catch(Exception e){
			e.printStackTrace();
		}
		return Tag.SKIP_BODY;
	}
}
