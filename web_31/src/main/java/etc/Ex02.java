package etc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.Scanner;

import vo.MemberInfo;

public class Ex02 {
	
	public static int inputMenuNumber() {
		Scanner scan = new Scanner(System.in);
		System.out.println("<< ㅁㅁㅁ 프로그램 >>");
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		
		System.out.println("3. 회원 정보 수정");
		System.out.println("4. 회원 탈퇴");
		
		System.out.println("5. 프로그램 종료");
		System.out.println("메뉴 선택 -> ");
		
		int menu = scan.nextInt();
		
		return menu; //반환타입 int로 잡힘
		
	}
	// 회원 가입 시 회원 정보를 입력받는 메서드
	public static MemberInfo joininput() {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("<< 회원가입 >>");
		
		System.out.print("아이디 -> ");
		String id = scan.next();
		
		System.out.print("비밀번호 -> ");
		String pw = scan.next();
		
		System.out.print("이름 -> ");
		String name = scan.next();
		
		MemberInfo memberInfo = new MemberInfo(id, pw, name);
		
		return memberInfo;
		
	}
	
	public static boolean executeJoinQuery(MemberInfo memberInfo) throws SQLIntegrityConstraintViolationException{
		// DB를 사용할 때 제~~~~~일 중요한 점
		// 우리가 원하는 동작을 다 했다면 반드시 close로 DB와 프로그램의 연결을 끊어줘야함
		
		Connection conn = null;
		Statement stmt = null;
		
		boolean isJoin = false;
		// isJoin 회원 가입에 성공했나요? false는 실패라는뜻으로 가정
		
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopdb?user=root&password=1234");
			
			stmt = conn.createStatement();
			
			String sql = "INSERT INTO usertbl(id, pw, name) VALUES('" + memberInfo.getId() + "', '" + memberInfo.getPw() + "', '" + memberInfo.getNickname() + "')";
			
			int count = stmt.executeUpdate(sql);
			// 잘못된값을 받았기에 쿼리 잘못이 아님 -> 호출된 쪽으로  예외를 던지는 throws SQLIntegrityConstraintViolationException 사용
			
			
			// 회원가입성공시 return 말고 isJoin = true;로
			if(count == 1) {
				isJoin = true;
			}
//			else {
//				return false; // 메서드 반환타입 boolean 바꿔야함
//			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLIntegrityConstraintViolationException e) {
			throw new SQLIntegrityConstraintViolationException(); 
			// throws 잘 받아들이게 하는 코드
			
			// 여기 예외가 아래의 하위예외임 해당 예외를 각자 처리하고 
			// 나머지는 아래 SQLException예외로 가서 처리하게됨
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}// end try
			}// end if
		}// end try
		
		return isJoin;
	}/// end method
	
	
	
// 메서드 -> 한번에 하나의 동작(역할)만 하는게 제일 좋음
	//
	public static void join() {
// 1. 회원 정보 입력받는 부분
		MemberInfo memberInfo = joininput();
// 1. 회원 정보 입력받는 부분
		
		
		
		try {
// 2. 회원 가입 쿼리를 실행하는 부분
			boolean isJoin = executeJoinQuery(memberInfo);
			// boolean isJoin으로 회원가입 결과로 출력받음
			
// 3. 회원 가입 결과를 출력하는 부분
			if(isJoin) {
				System.out.println("회원 가입 완료");
			}else {
				System.out.println("회원 가입 실패");
			}
		}catch (SQLIntegrityConstraintViolationException e) {
				System.out.println("이미 사용중인 아이디입니다");
		}
//3. 회원 가입 결과를 출력하는 부분
			
//			System.out.println("sql => " + sql);// heidiSQL에서 insert를 사용해서 오류 확인해야함
			
//			try {
				
// 2. 회원 가입 쿼리를 실행하는 부분
				
				// executeUpdate 메서드가 return 해주는 것 -> 정수
				// 정수를 return 해주는 이유는 쿼리를 실행해서 영향 받은 행을 알려주기 위해
				

				
//			}catch(SQLIntegrityConstraintViolationException e) {
//				System.out.println("이미 사용중인 아이디 입니다.");
//			}// 이미 사용중이라고 하고 프로그램 꺼짐
			
			
			
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		} finally {
//			if(stmt != null) {
//				try {
//					stmt.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			
//			if(conn != null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}// end try
//			}//end if
//		}// end finally
			
	}// end join method
	
	
	
	
//	//나중에 보면 switch case1이 무엇인지 알기 어려움
//	
//	// 클래스 멤버 변수를 활용해서 1번 메뉴의 이름을 생성
//	public static final int JOIN = 1;
//	// 2번 메뉴 이름은 로그인
//	public static final int LOGIN = 2;
//	// 3번 메뉴 이름은 종료
//	public static final int EXIT = 3; --> MenuNumber클래스 생성해서 넘김 -> 가독성 좋아짐
	
	public static MemberInfo loginInput() {
		Scanner scan = new Scanner(System.in);
		System.out.println("아이디 -> ");
		String id = scan.next();
		
		System.out.println("비밀번호 -> ");
		String pw = scan.next();
		
		MemberInfo memberInfo = new MemberInfo(id, pw, null);
		
		return memberInfo; // 반환타입 MemberInfo해줘야함
	}
	
	public static boolean executeLoginQuery(MemberInfo memberInfo) {
		
		Connection conn = null;
		Statement stmt = null;
		
		boolean isLogin = false;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopdb?user=root&password=1234");
			
			stmt = conn.createStatement();
			
			String sql = "SELECT * FROM usertbl WHERE id='" + memberInfo.getId()+ "' AND pw = '" + memberInfo.getPw() + "'";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			isLogin = rs.next();
			// next 하나로 로그인 성공 실패를 알수가 있음
			
		} catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			
			if(stmt != null) {
				try {
					stmt.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}

			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}// end try
			}// end if
		}// end finally
		
		return isLogin;
		
	}
	
	
	public static void login() {
		// 1. 로그인시 아이디, 비밀번호를 입력 받는 부분
		MemberInfo memberInfo = loginInput();
		
		
		// 2. 로그인 쿼리를 실행하고 결과를 받아오는 부분
		boolean isLogin = executeLoginQuery(memberInfo);
		
		
		// 3. 결과를 출력하는 부분
		if(isLogin) {
			System.out.println("로그인 성공!");
		}else{
			System.out.println("로그인 실패!");
		}
		
		
	}
	
public static MemberInfo executeUpdateQuery(MemberInfo memberInfo) {
		
		Connection conn = null;
		Statement stmt = null;	
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopdb?user=root&password=1234");
			
			stmt = conn.createStatement();
			
			String sql = "SELECT * FROM usertbl WHERE id='" + memberInfo.getId()+ "' AND pw = '" + memberInfo.getPw() + "'";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				String name = rs.getString("name");
				
				memberInfo.setNickname(name);
				
			}
			// next 하나로 로그인 성공 실패를 알수가 있음
			
		} catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			
			if(stmt != null) {
				try {
					stmt.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}

			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}// end try
			}// end if
		}// end finally
		
		return memberInfo;
		
	}
	

	public static boolean executeNameUpdateQuery(String newName, String id) {
		Connection conn = null;
		Statement stmt = null;
		
		boolean isUpdate = false;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopdb?user=root&password=1234");
			
			stmt = conn.createStatement();
			
			String sql = "UPDATE usertbl SET name = '" + newName + "' WHERE id = '" + id + "'";
			
			int count = stmt.executeUpdate(sql);
			// executeselect빼고는 다 executeUpdate
			// name id가 하나이기에 int count 잡아줌
			if(count ==1) {
				isUpdate = true;
			}else {
				isUpdate = false;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			
			if(stmt != null) {
				try {
					stmt.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}

			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}// end try
			}// end if
		}// end finally
		
		return isUpdate;
		
	}
	
	public static void update() {
		// 1. 회원 정보 수정을 하기 위한 아이디, 비밀번호 입력 받기
		MemberInfo memberInfo = loginInput();
		
		// 2. 사용자가 입력한 아이디, 비밀번호를 사용해서 수정할 회원의 정보 찾기
		memberInfo = executeUpdateQuery(memberInfo);
		if(memberInfo.getNickname() == null) {
			System.out.println("존재하지 않는 계정입니다");
		}else {
			// 3. 찾은 회원의 정보 출력(여기까지 가능)
			System.out.println("회원 이름 => " + memberInfo.getNickname());
			// 4. 수정할 이름 입력 받기
			Scanner scan = new Scanner(System.in);
			
			System.out.println("수정할 이름을 입력하세요 =>");
			String newName = scan.next();
			
			// 5. 사용자가 입력한 이름으로 회원 정보 수정
			boolean isUpdate = executeNameUpdateQuery(newName, memberInfo.getId());
			
			// 6. 수정 결과 출력
			if(isUpdate) {
				System.out.println("이름이 성공적으로 수정했습니다.");
			}else {
				System.out.println("이름을 수정하지 못했습니다.");
			}// end if
			
		}// end if

	}// end update method
	
	
	public static boolean executeDeleteQuery(MemberInfo memberInfo) {
		Connection conn = null;
		Statement stmt = null;
		
		boolean isDelete = false;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopdb?user=root&password=1234");
			
			stmt = conn.createStatement();
			
			String sql = "DELETE FROM usertbl WHERE id = '" + memberInfo.getId() + "'";
			
			int count = stmt.executeUpdate(sql);
			// executeselect빼고는 다 executeUpdate
			// name id가 하나이기에 int count 잡아줌
			if(count ==1) {
				isDelete = true;
			}else {
				isDelete = false;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			
			if(stmt != null) {
				try {
					stmt.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}

			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}// end try
			}// end if
		}// end finally
		
		return isDelete;
	}
	//executeNameUpdateQuery꺼 거의 다 가져옴
	
	
	public static void delete() {
		Scanner scan = new Scanner(System.in);
		
		// 1. 회원 탈퇴하기 위한 아이디, 비밀번호 입력 받기
		MemberInfo memberInfo = loginInput();
		
		// 2. 사용자가 입력한 아이디, 비밀번호를 사용해서 탈퇴할 회원의 정보 찾기
			// 정보를 굳이 보여주지않아도된다
		boolean isLogin = executeLoginQuery(memberInfo);
		if(isLogin) {
			// 3. 정말 탈퇴할 것인지 묻기
			System.out.println("정말 탈퇴하시겠습니까? ( y / n)");
			char answer = scan.next().charAt(0);
			
			
			// 4. 정말 탈퇴한다면 탈퇴(회원 정보 삭제) 처리
			if(answer == 'y') {
				boolean isDelete = executeDeleteQuery(memberInfo);
				
				if(isDelete){
					System.out.println("성공적으로 탈퇴되었습니다.");
				}else {
					System.out.println("문제가 생겼습니다! 잠시 후 다시 시도 하세요");
				}
				
			}
		}else {
			System.out.println("존재하지 않은 계정입니다");
		}
	}
	

	public static void main(String[] args) {
		// 메인 메서드가 프로그램의 전체적인 흐름을 관리하기위해 코드를 최소화 해야함

//		Scanner scan = new Scanner(System.in);
		
		boolean isRunning = true;
		
		while(isRunning) {
//			System.out.println("<< ㅁㅁㅁ 프로그램 >>");
//			System.out.println("1. 회원가입");
//			System.out.println("2. 로그인");
//			System.out.println("3. 프로그램 종료");
//			System.out.println("메뉴 선택 -> ");
			
//			int menu = scan.nextInt();
			
			int menu = inputMenuNumber(); // 받아올 메서드 menu에 넣음
			
			switch(menu) {
				case MenuNumber.JOIN:
					join();

					break;
				case MenuNumber.LOGIN:
					System.out.println("<< 로그인 >>");
					
					login();
					
					break;
				case MenuNumber.UPDATE:
					System.out.println("<< 회원 정보 수정 >>");
					
					update();
					
					break;
				case MenuNumber.DELETE:
					System.out.println("<< 회원 탈퇴 >>");
					
					delete();
					
					break;
				case MenuNumber.EXIT:
					System.out.println("프로그램을 종료합니다");
					isRunning = false;
					break;
				default:
					System.out.println("번호를 잘못 입력하셨습니다");
			} // end switch
		} // end while 해놓으면 나중에 코드블록을 확인하기 쉽다
		
		
		
		
	}// end main

}
