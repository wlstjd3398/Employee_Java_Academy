package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.Database;
import vo.MemberInfo;

public class MemberInfoDao {

	public boolean insert(MemberInfo memberInfo) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		
		try {
			
			String sql = "INSERT INTO member_info(id, pw, name, tel, addr, email, joinDate) VALUES(?, ?, ?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberInfo.getId());
			pstmt.setString(2, memberInfo.getPw());
			pstmt.setString(3, memberInfo.getName());
			pstmt.setString(4, memberInfo.getTel());
			pstmt.setString(5, memberInfo.getAddr());
			pstmt.setString(6, memberInfo.getEmail());
			// 회원가입일을 문자열화 시켜서 하면 편하다
			pstmt.setString(7, memberInfo.getJoinDate().toString());
			
			
			int count = pstmt.executeUpdate();
			
			return count == 1;
		} catch (SQLException e) {
			e.printStackTrace();
			
			return false;
		} finally {
			db.closePstmt(pstmt);
			db.closeConnection(conn);
			
		}
	}
	
	
//	public MemberInfo login(MemberInfo memberInfo) {
//		
//		Database db = new Database();
//		
//		Connection conn = db.getConnection();
//		PreparedStatement pstmt = null;
//		
//		ResultSet rs = null;
//		
//		try {
//			
//			String sql = "SELECT * FROM member_info WHERE id = ? AND pw = ?";
//			
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, memberInfo.getId());
//			pstmt.setString(2, memberInfo.getPw());
//			
//			
//			rs = pstmt.executeQuery();
//			
//			
//			//아디랑 비번을 찾았다면
//			if(rs.next()) {
//				// 조회한 회원 정보를 매개변수로 받은 객체에 담음
//				String name = rs.getString("name");
//				
//				memberInfo.setName(name);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			db.closeResultSet(rs);
//			db.closePstmt(pstmt);
//			db.closeConnection(conn);
//		}
//		return memberInfo;
//	}
	
}
