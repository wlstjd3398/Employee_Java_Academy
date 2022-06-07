package chapter07;

import java.time.LocalDateTime;
import java.util.Collection;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex01 {

	private static MemberDao memberDao;
	// memberDao를 멤버변수로 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 컨테이너 생성
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
		
		// memberDao 꺼내서 쓸 것
		memberDao = ctx.getBean("memberDao", MemberDao.class);
		
		// 가입된 모든 회원 정보 조회
		selectAll();
		
		// 회원 가입 
//		join(); 대신에
		updateMember();
		
		// 가입된 모든 회원 정보 조회
		selectAll();
		
		
		
		ctx.close();
	}

	private static void selectAll() {
		System.out.println("----- selectAll -----");
		
		int total = memberDao.count();
		System.out.println("전체 가입자 수 : " + total);
		
		Collection<Member> members = memberDao.selectAll();
		if(members != null) {
			for(Member member : members) {
				System.out.println(member.getId() + ", " + member.getEmail() + ", " + member.getName());
			}
		}
	}
	
	// selectAll을 통해서 
	
	private static void join() {
		System.out.println("----- join -----");
		
		String email = "b@gmail.com";
		String password = "1234";
		String name = "고영희";
		LocalDateTime registerDateTime = LocalDateTime.now();
		
		Member newMember = new Member(email, password, name, registerDateTime);
		
		memberDao.insert(newMember);
		
	}
	
	private static void updateMember() {
		System.out.println("----- updateMember -----");
		
		Member member = memberDao.selectByEmail("a@gmail.com");
		
		String oldPw = member.getPassword();
		String newPw = "4321";
		member.changePassword(oldPw, newPw);
		
		member.setName("김철수");
		
		memberDao.update(member);
		
	}
	
}
