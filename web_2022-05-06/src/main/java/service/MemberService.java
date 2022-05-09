package service;

import javax.servlet.http.HttpServletRequest;

import dao.MemberInfoDao;
import vo.MemberInfo;

public class MemberService {

	public int join(MemberInfo memberInfo) {
		
		MemberInfoDao dao = new MemberInfoDao();
		
		boolean result = dao.insert(memberInfo);
		
		if(result) {
			return 200;
		}else {
			return 400;
		}
	}

	
//	public int login(MemberInfo memberInfo) {
//		
//		MemberInfoDao dao = new MemberInfoDao();
//		
//		boolean result = dao.login(memberInfo);
//		
//		if(result) {
//			return 200;
//		}else {
//			return 400;
//		}
//	}
	
	public int duplicate() {
		
		
	}
	
}
