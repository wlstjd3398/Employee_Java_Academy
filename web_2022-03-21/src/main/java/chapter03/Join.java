package chapter03;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="/ch03_Join", urlPatterns= {"/ch03_join"})
public class Join extends HttpServlet {
       private List<MemberInfo> memberInfoList = new ArrayList<>();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트가 전달한 id, pw 값을 꺼냄
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		
		// 회원가입 : 새로운 회원의 정보를 이 사이트의 데이터베이스에 저장하는 것
		// 아직 db 연결을 안배웠으니 db 역할을 할 list를 사용할 예정
		MemberInfo memberInfo = new MemberInfo(id, pw);
		
		// 아이디 중복 여부 체크
		// memberInfoList의 처음부터 끝까지 접근
		// n번째 회원 정보를 꺼냄
		// n번째 회원 정보에서 ID를 꺼냄
		// 꺼낸 ID와 사용자가 입력한 아이디가 같다면 아이디 중복 이라고 표시
		// 꺼낸 ID와 사용자가 입력한 아이디가 같지않다면 아이디 중복 아님이라고 표시
		
		boolean exist = false; // 사용자가 입력한 아이디는 무조건 중복된 상황을 가정해야함
		
		for(MemberInfo nthMemberInfo : memberInfoList) {
			String nthID = nthMemberInfo.getId();
			if(nthID.equals(id)) {
				// 아이디 중복 표시
				exist = true;
				break; // 다음사용자와 중복될 일이 없다하고 빠져나감
			}
			
		}
		
		// 아이디가 사용 중이라면 
		// 회원 가입 실패 페이지로 이동
		if(exist) {
			response.sendRedirect("/joinFail.html");
		}else {
			// 아이디가 사용중이지 않으면
			//회원가입
			memberInfoList.add(memberInfo);
			
			//회원가입 완료 페이지로 이동
			response.sendRedirect("/joinSuccess.html");
		}
		
		
		
		
		
		
	}

}
