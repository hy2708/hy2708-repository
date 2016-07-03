package org.hy.commons.web.filter.compress;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.hy.commons.io.compress.GZipUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GzipCompressionFilter implements Filter {
	// 声明编码的成员变量
	private String charsetName;

	public void init(FilterConfig config) throws ServletException {
		charsetName = config.getInitParameter("charsetName");
		if (charsetName==null||charsetName.equals("")) {
			charsetName =config.getInitParameter("charset");
		}
		if (charsetName==null||charsetName.equals("")) {
			charsetName ="utf8";
		}
	}

	/**
	 * 对request用post提交的数据，指定字符集
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//request.setCharacterEncoding(charsetName);//对get没有效
		//response.setContentType("text/html;charset=" + charsetName);
		
		
		//ServletOutputStream servletOutputStream = response.getOutputStream();
		//PrintWriter writer0 = response.getWriter();
		GzipHttpServletResponse myResponse = new GzipHttpServletResponse((HttpServletResponse)response);
		myResponse.setHeader("content-encoding", "gzip");
		//resp.getOutputStream();
		chain.doFilter(request, myResponse);
		
		/*
		 * 不论是字节流,还是字符流,都被写入了,缓存中,然后再对缓存中的数据进行压缩	
		 */
		byte[] bytes = myResponse.getOriginalStreamDatas();
		System.err.println(bytes.length);		
		
		byte[] gzipBytes =  GZipUtil.gzipBytes(bytes);		
		myResponse.getOutputStream().write(gzipBytes);
		
		/*
		 * 使用原生的response的字节流
		 */
		response.getOutputStream().close();
		
		
	}
	public void destroy() {
	}
}

/*
 * 重写getWriter和getOutputStream，是字节流和字符流，都写入写入内存
 */
class GzipHttpServletResponse extends HttpServletResponseWrapper{

	public GzipHttpServletResponse(HttpServletResponse response) {
		super(response);
	}
	ByteArrayOutputStream byteArrayOutputStream = null;
	/*
	 * 自定义的字符流
	 */
	private PrintWriter out =null;
	
	public ByteArrayOutputStream getByteArrayOutputStream(){
		/*
		 * 如果不关闭字符流,那么如果从，字符流写入的内存中，拿出的字节数组就是空的
		 */
		if(out!=null){
			out.close();
		}
		return this.byteArrayOutputStream;
	}
	
	//提供一个方法获取原生 的数据
		public byte[] getOriginalStreamDatas(){
			/*
			 * 如果不关闭字符流,那么如果从，字符流写入的内存中，拿出的字节数组就是空的
			 */
			if(out!=null){
				out.close();
			}
			return byteArrayOutputStream.toByteArray();
		}
	
	/*
	 * Writer，把数据输出到byteArray内存中
	 */
	@Override
	public PrintWriter getWriter() throws IOException {
		
//		PrintWriter writer = super.getWriter();
//		return new MyPrintWriter(writer);
		
		//PrintWriter writer2 = super.getWriter();
		//return new MyPrintWriter2(new ByteArrayOutputStream());
		byteArrayOutputStream = new ByteArrayOutputStream();
		out = new PrintWriter(byteArrayOutputStream);
		return out;
	}
	
	/*
	 * ServletOutputStream，把数据输出到byteArray内存中
	 */
	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		/*
		 * 此类,只可,压缩OutputStream输出的数据
		 */
		//ServletOutputStream outputStream = null; 
		//outputStream = super.getOutputStream();
		//return new MyServletOutputStream(outputStream,byteArrayOutputStream);
		
		byteArrayOutputStream = new ByteArrayOutputStream();
		
		ServletOutputStream servletOutputStream = 
				new MyServletOutputStream(super.getOutputStream(),byteArrayOutputStream);
		
		return servletOutputStream;
	}
	
}


/*
 * 此类,只可,压缩OutputStream输出的数据
 */
class MyServletOutputStream extends ServletOutputStream{

	

	@Override
	public void write(byte[] b) throws IOException {
//		byte[] bytes = null;
//		//String s2 = null;
//		bytes = GZipUtil.gzipBytes(b);
//		logger.info("【" +
//				getClass().getSimpleName()+
//				"】，执行【write(byte[] b)】方法，【byte[]】数组的原长度是【" +
//				b.length+
//				"】，压缩后的数组长度是【" +
//				bytes.length+
//				"】");
//
//		super.write(bytes,0,bytes.length);
		super.write(b);
	}

	@Override
	public void write(byte[] b, int off, int len) throws IOException {
		
		super.write(b, off, len);
		throw new RuntimeException("4444444444");

	}


	@Override
	public void write(int b) throws IOException {
		byteArrayOutputStream.write(b);
		//outputStream.write(b);
		//throw new RuntimeException("99999999999999");
	}
	
	public MyServletOutputStream(ServletOutputStream outputStream) {
		super();
		this.outputStream = outputStream;
	}
	public MyServletOutputStream(ServletOutputStream outputStream2,
			ByteArrayOutputStream byteArrayOutputStream) {
		super();
		this.outputStream = outputStream;
		this.byteArrayOutputStream = byteArrayOutputStream;
	}
	ByteArrayOutputStream byteArrayOutputStream = null;
	private ServletOutputStream outputStream = null;
	private Logger logger = LoggerFactory.getLogger(getClass());
}


/*class MyPrintWriter2 extends PrintWriter{
	
	OutputStream outputStream = null;
	public OutputStream getOutputStream(){
		return this.outputStream;
	}
	
	@Override
	public void write(int c) {
		// TODO Auto-generated method stub
		super.write(c);
		throw new RuntimeException("4444444444");	

	}

	@Override
	public void write(char[] buf, int off, int len) {
		// TODO Auto-generated method stub
		super.write(buf, off, len);
		throw new RuntimeException("4444444444");	

	}

	@Override
	public void write(char[] buf) {
		// TODO Auto-generated method stub
		super.write(buf);
		throw new RuntimeException("4444444444");	

	}

	@Override
	public void write(String s, int off, int len) {
//		System.err.println("???????????????");
//		byte[] bytes = null;
//		String s2 = null;
//		s2 = GZipUtil.gzipText(s, "utf-8");
//		System.err.println(s2.length());
//		super.write(s);
		
		
		super.write(s, off, len);
		//throw new RuntimeException("4444444444");	

	}

	@Override
	public void write(String s) {
		
		super.write(s);
	}

	public MyPrintWriter2(File file, String csn) throws FileNotFoundException,
			UnsupportedEncodingException {
		super(file, csn);
		throw new RuntimeException("4444444444");	
	}

	public MyPrintWriter2(File file) throws FileNotFoundException {
		super(file);
		throw new RuntimeException("4444444444");	
	}

	public MyPrintWriter2(OutputStream out, boolean autoFlush) {
		super(out, autoFlush);
	}

	public MyPrintWriter2(OutputStream out) {
		super(out);
		outputStream = out;
	}

	public MyPrintWriter2(String fileName, String csn)
			throws FileNotFoundException, UnsupportedEncodingException {
		super(fileName, csn);
		throw new RuntimeException("4444444444");	}

	public MyPrintWriter2(String fileName) throws FileNotFoundException {
		super(fileName);
		throw new RuntimeException("4444444444");	
		
	}

	public MyPrintWriter2(Writer out, boolean autoFlush) {
		super(out, autoFlush);
		throw new RuntimeException("4444444444");
	}

	public MyPrintWriter2(Writer out) {
		super(out);
	}
	
	
}*/
