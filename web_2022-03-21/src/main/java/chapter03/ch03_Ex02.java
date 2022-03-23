package chapter03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="/ch03_ex02", urlPatterns= {"/ch03_ex02"})
public class ch03_Ex02 extends HttpServlet {
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/ch03_ex02.html");
		// 응답은 ""으로 가봐라
		
		
//servlet방법 -> 오타나기 좋음 -> 그래서 다른방법(html을  sendRedirect로 가져옴)과 JSP가 나왔음
//		response.setContentType("text/html;");
//		PrintWriter outputstream = response.getWriter();
//		
//		outputstream.append("<html>");
//		outputstream.append("	<head>");
//		outputstream.append("	<title>ch03_ex02</title>");
//		outputstream.append("		<style>");
//		outputstream.append("		div{width:50px; height:50px; display: inline-block;}");
//		outputstream.append("			.red{background:red;}");
//		outputstream.append("			.orange{background:orange;}");
//		outputstream.append("			.yellow{background:yellow;}");
//		outputstream.append("			.green{background:green;}");
//		outputstream.append("			.blue{background:blue;}");
//		outputstream.append("			.navy{background:navy;}");
//		outputstream.append("			.purple{background:purple;}");
//		outputstream.append("		</style>");
//		outputstream.append("	</head>");
//		outputstream.append("	<body>");
//		outputstream.append("		<div class=red></div>");
//		outputstream.append("		<div class=orange></div>");
//		outputstream.append("		<div class=yellow></div>");
//		outputstream.append("		<div class=green></div>");
//		outputstream.append("		<div class=blue></div>");
//		outputstream.append("		<div class=navy></div>");
//		outputstream.append("		<div class=purple></div>");
//		outputstream.append("	</body>");
//		outputstream.append("</html>");
//		
//		outputstream.close();
		
		}



}
