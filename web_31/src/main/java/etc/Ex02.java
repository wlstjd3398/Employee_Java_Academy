package etc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		
		System.out.println("<< ㅁㅁㅁ 프로그램 >>");
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		System.out.println("메뉴 선택 -> ");
		
		int menu = scan.nextInt();
		
		switch(menu) {
			case 1:
				System.out.print("<< 회원가입 >>");
				
				System.out.print("아이디 -> ");
				String id = scan.next();
				
				System.out.print("비밀번호 -> ");
				String pw = scan.next();
				
				System.out.print("이름 -> ");
				String name = scan.next();
				
				Connection conn = null;
				Statement stmt = null;
				
				try {
					Class.forName("org.mariadb.jdbc.Driver");
					
					conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopdb?user=root&password=1234");
					
					stmt = conn.createStatement();
					
					String sql = "INSERT INTO usertbl(id, pw, name) VALUES('" + id + "', '" + pw + "', '" + name + "')";
					
					System.out.println("sql => " + sql);// heidiSQL에서 insert를 사용해서 오류 확인해야함
					
					int count = stmt.executeUpdate(sql);
					// executeUpdate 메서드가 return 해주는 것 -> 정수
					// 정수를 return 해주는 이유는 쿼리를 실행해서 영향 받은 행을 알려주기 위해
					if(count == 1) {
						System.out.println("회원 가입 완료");
					}else {
						System.out.println("회원 가입 실패");
					}
					
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				} finally {
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
						}
					}
				}
				
				
				
				
				
				break;
			case 2:
				System.out.println("<< 로그인 >>");
				break;
			default:
				System.out.println("번호를 잘못 입력하셨습니다");
				
		}
		
		
	}

}
