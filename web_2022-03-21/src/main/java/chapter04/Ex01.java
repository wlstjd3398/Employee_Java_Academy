package chapter04;

import java.io.Console;
import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ch04_Ex01", urlPatterns = { "/ch04_ex01" })
public class Ex01 extends HttpServlet {
       
//chapter04_ex01.html -> Ex01로 값을 꺼내보자(클라이언트가 서블릿으로)
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String id = request.getParameter("id");
//		String pw = request.getParameter("pw");
//		String name = request.getParameter("name");
//		//hobby는 선택안하거나, 하나 선택하거나, 여러개 선택할수도 있음
//		String[] hobbies = request.getParameterValues("hobby");
//		
//		String gender = request.getParameter("gender");
//		String religion = request.getParameter("religion");
//		String intro = request.getParameter("intro");
//		
//		System.out.println("POST 파라미터 출력");
//		System.out.println("id = " + id);		
//		System.out.println("pw = " + pw);		
//		System.out.println("name = " + name);		
//		System.out.println("hobbies = " + Arrays.toString(hobbies));		
//		System.out.println("gender = " + gender);	
//		System.out.println("religion = " + religion);			
//		System.out.println("intro = " + intro);		
//		
//   }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//클라이언트가 보낸것을 서버가 utf-8로 인식
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		//hobby는 선택안하거나, 하나 선택하거나, 여러개 선택할수도 있음
		String[] hobbies = request.getParameterValues("hobby");
		
		String gender = request.getParameter("gender");
		String religion = request.getParameter("religion");
		String intro = request.getParameter("intro");
		
		System.out.println("POST 파라미터 출력");
		System.out.println("id = " + id);		
		System.out.println("pw = " + pw);		
		System.out.println("name = " + name);	
		
		// http 500상태코드생김  -> 서버에 문제

//		취미가 전달되지 않았다면 "전달된 취미가 없습니다" console에 출력하세요
		//1. 예외 메세지 분석
		//2. 분석에 맞게 예외 처리(if, try catch)
		try {
		for(int i=0; i<hobbies.length; i++) {
			System.out.print(hobbies[i] + " ");
		}
		}catch(NullPointerException e) {
			System.out.println("전달된 취미가 없습니다.");
		}

		
		
//		System.out.println("hobbies = " + Arrays.toString(hobbies));		
		System.out.println("gender = " + gender);
		
		System.out.println("religion = " + religion);			
		System.out.println("intro = " + intro);	
	}

}
