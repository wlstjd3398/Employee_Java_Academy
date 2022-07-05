package service;

import dao.MemberInfoDao;
import vo.MemberInfo;

public class MemberService {

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
		
		// 유니크 아이디
		if(isAlreadyID(id)) {
			return true;
		}
		// 유니크 연락처
		if(isAlreadyTel(tel)) {
			return true;
		}
		// 유니크 이메일
		if(isAlreadyEmail(email)) {
			return true;
		}
		
		return false;
	}
	
	// 회원가입
	public int join(MemberInfo memberInfo) {
		
		MemberInfoDao dao = new MemberInfoDao();
		
		boolean result = dao.insert(memberInfo);
		
		if(result) {
			return 200;
		}else {
			return 400;
		}
	}
	
	// 로그인
	public MemberInfo selectById(String id) {
		MemberInfoDao dao = new MemberInfoDao();
		
		return dao.selectById(id);
	}
	
	// 회원정보 수정
	public boolean isAlreadyTelorEmail(String id, String tel, String email) {
		// 로그인한 회원 정보에 들어있는 id를 사용해서 회원 정보를 조회함
		MemberInfoDao dao = new MemberInfoDao();
		MemberInfo oldMemberInfo = dao.selectById(id);
		
		// 회원 정보를 수정할 때 이메일을 바꾼다면 이메일 중복 여부를 체크
		// 위에서 조회한 정보의 이메일과 email로 전달 받은 이메일이 다르면 이메일을 바꾼다
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
		
		// 회원 정보를 수정할 때 연락처를 바꾼다면 연락처 중복 여부를 체크함
		String oldTel = oldMemberInfo.getTel();
		// 연락처가 같지 않다면
		if(!oldTel.equals(tel)) {
			MemberInfo memberInfo = dao.selectByTel(tel);
	
			if(memberInfo != null) {
				// 연락처 중복(null값아님)
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
	
	// 회원정보 수정 후 
	public void updateMemberInfo(MemberInfo loginInfo) {
		MemberInfoDao dao = new MemberInfoDao();
		
		dao.updateByID(loginInfo);
		
	}
	
	// 회원 탈퇴
	public void deleteMemberInfo(String id) {
		MemberInfoDao dao = new MemberInfoDao();
		
		dao.deleteMemberInfoByID(id);
		
	}
	
	
}
