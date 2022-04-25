package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.MemberDTO;


// DAO는 데이터베이스와 커뮤니케이션이 핵심
// 쿼리를 실행하고 결과르르 받아오는게 핵심
// 그 이상을 해도 큰 문제는 없지만 
// 좀더 완벽하게 객체지향적으로 개발하려면
// 쿼리를 실행하고 결과만 받아오도록 해야함

public class MemberDAO {

	public MemberDTO selectMemberInfo(MemberDTO memberInfo) {
		Connection con = Database.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM usertbl WHERE id = ? AND pw = ?";
		
		// 예외가 발생하면 값을 저장하지못하고 지나가버리니 try밖에서 return값을 저장해줌
		MemberDTO returnMemberInfo = null;
		
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberInfo.getId());
			pstmt.setString(2, memberInfo.getPw());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				
				returnMemberInfo = new MemberDTO(id, pw, name);
				
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.closeResultSet(rs);
			Database.closePstmt(pstmt);
			Database.closeConnection(con);;
		}
		
		return returnMemberInfo;
	}
	
	
	public boolean insertMemberInfo(MemberDTO memberInfo) {
		
//		Database db = new Database();
		// db에서 코드가독성을 높이기 위해 Database로 수정한다
		
		Connection con = Database.getConnection();
		
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO usertbl(id, pw, name) VALUES(?, ?, ?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, memberInfo.getId());
			pstmt.setString(2, memberInfo.getPw());
			pstmt.setString(3, memberInfo.getName());

			int count = pstmt.executeUpdate();
			
			return count == 1; // true 1이 리턴된것은 회원가입을 성공했다, false 0은 회원가입 실패
			// 따라서 void를 boolean으로 고쳐주면됨
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			return false; // 회원가입 실패경우 
			
		} finally {
			Database.closePstmt(pstmt);
			Database.closeConnection(con);
			
		}
		
		
		
		

	}

	
}
