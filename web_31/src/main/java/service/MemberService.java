package service;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import dao.UserInfoDao;
import vo.MemberInfo;

public class MemberService {

	public MemberInfo getLoginResult(HttpServletRequest request) {
		// HttpServletRequest를 가져오다가 상태를 보고 원상복구 시키기도함
		
		// 클라이언트가 보낸 파라미터를 꺼냄
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		MemberInfo memberInfo = new MemberInfo(id, pw);
		
		UserInfoDao userInfo = new UserInfoDao();
		
		memberInfo = userInfo.selectUserInfo(memberInfo);
		
		
		// 로그인 처리
		memberInfo = memberInfo.getNickname() == null ? null : memberInfo;
		// 이름이 들어있는 memberInfo는 그대로 memberInfo를 받음,
		// 이름이 없는 경우는 null을 받음
		
		return memberInfo;
		// boolean을 return하지않고 memberInfo를 return해서 controller로 감
		
	}
	
	
}
