package org.hy.commons.web.example.code.verification;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hy.commons.io.core.ProjectPathUtil;
import org.hy.commons.web.example.request.encoding.GetCNDataRequestServlet;
import org.hy.server.jetty8.JettyUtil;

public class GetImageServlet extends HttpServlet {

	public static void main(String[] args) {
		JettyUtil.getServer();
		JettyUtil.setAppContextPath(JettyUtil.MY_APP, ProjectPathUtil.getWebRootPath());
		JettyUtil.getWebAppContext().addServlet(GetImageServlet.class, JettyUtil.HELLO);
		JettyUtil.startServer();
		
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//获得一张图片
		
		// 创建图片 -- 在内存中
		int width = 80;
		int height = 40;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		//创建图层，获得画板
		Graphics g = image.getGraphics();
		//确定画笔颜色
		g.setColor(Color.BLACK);
		//填充一个矩形
		g.fillRect(0, 0, width, height);
		//只需要一个边框
		
		
		//设置颜色
		g.setColor(Color.WHITE);
		//填充一个矩形
		g.fillRect(1, 1, width -2, height -2);
		
		//填充字符
		String data = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		//设置字体
		g.setFont(new Font("宋体",Font.BOLD,30));
		
		//缓存随机生成的字符
		StringBuffer buf = new StringBuffer();
		
		//随机获得4个字符
		Random random = new Random();
		for(int i = 0 ; i < 4 ; i++){
			//设置随机颜色
			g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
			//获得一个随机字符
			int index = random.nextInt(61);
			//截取字符串
			String str = data.substring(index, index + 1);  //[)
			//需要将随机的字符，写到图片中
			g.drawString(str, 20 * i, 30);
			//缓存
			buf.append(str);
		}
		
		//将获得随机字符串，保存到session
		// * 获得session
		HttpSession session = request.getSession();
		// * 保存值
		session.setAttribute("number", buf.toString());
		
		//干扰线
		for(int i = 0 ; i < 10 ; i ++){
			//设置随机颜色
			g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
			//随机画直线
			g.drawLine(random.nextInt(width), random.nextInt(height), random.nextInt(width), random.nextInt(height));
		}
		
		
		
		/**
		 * <extension>jpg</extension>
        <mime-type>image/jpeg</mime-type>
		 */
		//通知浏览器发送的数据时一张图片
		response.setContentType("image/jpeg");
		//将图片发送给浏览器
		ImageIO.write(image, "jpg", response.getOutputStream());
		
		

	}

}
