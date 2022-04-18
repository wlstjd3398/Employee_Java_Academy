package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import etc.Database;
import vo.MemberInfo;

public class UserInfo {

	
	// 쿼리 실행과관련된 메서드 합쳐놓음
	public boolean insertUserInfo(MemberInfo newMemberInfo) {
		
		Database db = new Database();
		
		Connection conn = db.getConnection();
//		Statement stmt = null;
	
		PreparedStatement pstmt = null;
		
		try {
//			stmt = conn.createStatement();
			
			// 3. 쿼리 작성
			String sql = "INSERT INTO usertbl(id, pw, name) VALUES(?, ?, ?)";
						
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newMemberInfo.getId());
			pstmt.setString(2, newMemberInfo.getPw());
			pstmt.setString(3, newMemberInfo.getNickname());
			
			// 4. stmt 를 통해서 쿼리 실행 및 결과 전달
//			int count = pstmt.executeUpdate(sql);
//			sql을 위에서 사용했기에 다시 사용하면 에러생김
			
			int count = pstmt.executeUpdate();
			
			
			return count == 1;
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			return false;
			
		} finally {
			db.closeStmt(pstmt);
			db.closeConnection(conn);
		}
		
	}
	
	
	public MemberInfo selectUserInfo(MemberInfo memberInfo) {
		
		Database db = new Database();
		
		Connection conn = db.getConnection();
		
		PreparedStatement pstmt = null;
		
		// String 써도 되지만 범용적으로 쓰이게 MemberInfo로 리턴하고
//		MemberInfo memberInfo = null;
		
		ResultSet rs = null;
		
		String sql = "SELECT * FROM usertbl WHERE id = ? AND pw = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberInfo.getId());
			pstmt.setString(2, memberInfo.getPw());
			
			 rs = pstmt.executeQuery();
			
			//아디랑 비번을 찾았다면
			if(rs.next()) {
				// 조회한 회원 정보를 매개변수로 받은 객체에 담음
				String name = rs.getString("name");
				
				memberInfo.setNickname(name);

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeResultSet(rs);
			db.closePstmt(pstmt);
			db.closeConnection(conn);
			
		}
		
		return memberInfo;
	
	}
	
}
