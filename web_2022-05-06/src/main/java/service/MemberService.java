package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberInfoDao;
import vo.MemberInfo;

public class MemberService {

	// 아이디가 사용중인지 여부를 판단하는 메서드
	// true -> 아이디가 사용중이다
	// false -> 아이디가 사용중이지 않다 -> 사용가능하다
	
//	public -> private 로 바꿀수 있음 내부에서만 쓰고있기에
	private boolean isAlreadyID(String id) {
		
		MemberInfoDao dao = new MemberInfoDao();
		
		MemberInfo memberInfo = dao.selectById(id);
		
		if(memberInfo == null) {
			return false;
		} else {
			return true;
		}
		
	}
	
	private boolean isAlreadyTel(String tel) {
		
		MemberInfoDao dao = new MemberInfoDao();
		
		MemberInfo memberInfo = dao.selectByTel(tel);
		
		if(memberInfo == null) {
			return false;
		} else {
			return true;
		}
		
	}
	
	private boolean isAlreadyEmail(String email) {
		
		MemberInfoDao dao = new MemberInfoDao();
		
		MemberInfo memberInfo = dao.selectByEmail(email);
		
		if(memberInfo == null) {
			return false;
		} else {
			return true;
		}
		
	}
	
	public boolean isAlreadyIDorTelorEmail(MemberInfo memberInfo) {
		String id = memberInfo.getId();
		String tel = memberInfo.getTel();
		String email = memberInfo.getEmail();
		
		
		// Service를 활용해서 아이디 또는 연락처 또는 이메일 중에 중복된 값이 있다면 409 상태코드 보내도록 하기

		// id에 unique가 걸려있음
		// db에 저장하기 전에 id를 사용해서 회원정보를 조회한다
		// 조회된 결과가 있으면 사용중인 아이디이므로 409 상태코드를 보낸다
		if(isAlreadyID(id)) {
//			response.setStatus(HttpServletResponse.SC_CONFLICT);
			return true;
		}
		// 연락처
		if(isAlreadyTel(tel)) {
//			response.setStatus(HttpServletResponse.SC_CONFLICT);
			return true;
		}
		// 이메일
		if(isAlreadyEmail(email)) {
//			response.setStatus(HttpServletResponse.SC_CONFLICT);
			return true;
		}
		
		return false;
	}
	
	public int join(MemberInfo memberInfo) {
		
		MemberInfoDao dao = new MemberInfoDao();
		
		boolean result = dao.insert(memberInfo);
		
		if(result) {
			return 200;
		}else {
			return 400;
		}
	}
	
	
	public boolean isLogin(MemberInfo loginInfo) {
		MemberInfoDao dao = new MemberInfoDao();
		
		MemberInfo memberInfo = dao.selectById(loginInfo.getId());
		
		if(memberInfo == null) {
			return false;
		}else {
			if(loginInfo.getPw().equals(memberInfo.getPw())) {
				return false;
			}else {
				return true;
			}
		}
	}
	
	public void updateMemberInfo(MemberInfo loginInfo) {
		MemberInfoDao dao = new MemberInfoDao();
		
		dao.updateByID(loginInfo);
		
	}
	
	public boolean isAlreadyTelorEmail(String id, String tel, String email) {
		// 1. 로그인한 회원 정보에 들어있는 id를 사용해서 회원 정보를 조회
		MemberInfoDao dao = new MemberInfoDao();
		MemberInfo oldMemberInfo = dao.selectById(id);
		
		// 2. 회원 정보를 수정할 때 이메일을 바꾼다면 이메일 중복 여부를 체크
		//		(1)에서 조회한 정보의 이메일과 email로 전달 받은 이메일이 다르면 이메일을 바꾼다
		String oldEmail = oldMemberInfo.getEmail();
		if(!oldEmail.equals(email)) {
			// email로 전달 받은 이메일을 사용해서 회원 정보를 조회한다
			MemberInfo memberInfo = dao.selectByEmail(email);
			
			if(memberInfo != null) {
				// 조회가 됐다면 이메일 중복
				return true;
			}else {
				// 조회되지 않았다면 이메일 중복 아님
				return false;
			}
		}
		
		// 3. 회원 정보를 수정할 때 연락처를 바꾼다면 연락처 중복 여부를 체크
		String oldTel = oldMemberInfo.getTel();
		if(!oldTel.equals(tel)) {
			MemberInfo memberInfo = dao.selectByTel(tel);
			if(memberInfo != null) {
				// 연락처 중복
				return true;
			}else {
				// 연락처 중복 아님
				return false;
			}
		}	
		
		// 이메일이나 연락처를 바꾸지 않는 상황이라면 이 return을 만나
		// false를 반환
		return false;
	
	}
	
	public void deleteMemberInfo(String id) {
		MemberInfoDao dao = new MemberInfoDao();
		
		dao.deleteMemberInfoByID(id);
		
	}
	
}
