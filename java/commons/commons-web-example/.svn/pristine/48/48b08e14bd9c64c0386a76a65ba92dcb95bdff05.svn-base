package org.hy.commons.web.example.servlet.singlethreadmodel;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.SingleSelectionModel;

import sun.reflect.generics.tree.IntSignature;

public class OneServlet extends HttpServlet implements SingleThreadModel {
	private String name;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getHeader("referer");//null - 记录来自于哪一个网点
		System.err.println("this:"+this);
		name = request.getParameter("name");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
		response.getWriter().print(name);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.err.println("this:"+this);
		InputStream in = 
				request.getInputStream();
		//输出字节大小
		if(in!=null){
			System.err.println("post大小："+request.getContentLength());
			byte[] b= new byte[1024];
			int len = 0;
			while((len=in.read(b))!=-1){
				String s = new String(b,0,len,"UTF-8");
				System.err.println(">>>:"+s);
			}
			
		}else{
			System.err.println("没有数据。。。。");
		}
	}

}
