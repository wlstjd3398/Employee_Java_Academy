package etc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		// 위가 모르는 상태로 mariadb에 아무것도 저장못하고 finally로 내려가서
		// 초기화하지 않았다라고 뜸 = 선언만했다라는뜻
		
		// 이 객체에는 아무것도 저장하지 않았다
		// null상태에서 finally로 이어져
		// stmt을 적용이 안되기에 nullpointerException이 발생
		// nullpointer예외처리를 해주기 위해서 if문을 사용해서 해결해줌
		
		
		try {
			
			Class.forName("org.mariadb.jdbc.Driver");
			
			// 접속 정보 구성 요소
			// 프로토콜 : jdbc:mariadb
			// DBMS 서버 도메인 또는 주소 : localhost or 127.0.0.1 or 서버의 도메인 또는 IP주소
			// 포트번호 : mysql이나 mariadb는 일반적으로 3306번 포트를 사용
			// 접속할 DB명
			// 접속할 사용자 계정과 비밀번호 : GET Parameter 형식으로 접속 정보의 마지막에 
			// 							? 가 붙고 name=value로 넣음
			
			//예로 http://localhost:80/web_31 
			//jdbc:mariadb://localhost:3306/employees?user=root&password=1234
			
			
			
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/employees?user=root&password=1234");
			// getconnection 리턴하는것이 있다
			
			
			// 쿼리를 실행하고 결과를 받아오는 객체
			// 우리의 쿼리를 실행시켜주고 쿼리의 실행 결과를 가져오는 객체
			stmt = conn.createStatement();
			
			
			// 실행하고자 하는 쿼리 작성
			String sql = "SELECT * FROM employees LIMIT 5";
			
			// stmt를 통해서 쿼리 실행 및 결과 받아오기
			// 1. SELECT 쿼리를 실행 하고 싶다 -> executeQuery 메서드 호출
			// 2. INSERT, UPDATE, DELETE 쿼리를 실행하고 싶다 -> executeUpdate 메서드 호출
			
			
			ResultSet rs = stmt.executeQuery(sql); 
			//while(rs.next())하면 true로 쭉 진행하다가 5개니까 6번째일때는 false를 리턴해줌
			
			int count = 1;
			
			while(rs.next()) {
				System.out.println("<< " + count + " 번째 데이터 출력 >>");
				
				int empNo = rs.getInt("emp_no");
				// 가져올 데이터타입에 따라 get~~을써야함 emp_no값이 숫자니 getint를 가져옴
				String birthDate = rs.getString("birth_date");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				char gender = rs.getString("gender").charAt(0);
				// string 문자열로 가져와서 문자로 꺼냄
				String hireDate = rs.getString("hire_date");
				
				// 가져온 데이터 출력
				System.out.println("emp_no => " + empNo);
				System.out.println("birth_date => " + birthDate);
				System.out.println("first_name => " + firstName);
				System.out.println("last_name => " + lastName);
				System.out.println("gender => " + gender);
				System.out.println("hire_date => " + hireDate);
				
				count++;
			}
			
			
			// executeQuery마우스로 대보면 resultset에 담는다는것을 볼수있다
			
			// 위 ResultSet 안에는 SELECT의 결과들이 들어있는 것
			// 결과들이 우리말로는 2개이상인데 프로그래밍언어에서는 하나도 결과들에 포함됨
			
			
			
			System.out.println("count = > " + count);
			
			//해제할때는 stmt먼저 close하고 connection close한다
			// DB와 관련된 자원을 해제해줄 때는 반드시 finally 안에서 해제해줘야함
			// 예외발생해서 close를 못하고 catch로 넘어가는경우가 잦으면 DB사용못하게됨
			
			
			
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			//stmt conn을 try밖에 connection statement를 선언해주어야함
			
			try{
				if(stmt != null) {
					stmt.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
			
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		
		
	}

}
