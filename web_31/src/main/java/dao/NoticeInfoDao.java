package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import etc.Database;
import vo.NoticeInfo;

public class NoticeInfoDao {

	public boolean inserNoticeInfo(NoticeInfo noticeInfo) {
		
		Database db = new Database();
		
		Connection conn = db.getConnection();
//		Statement stmt = null;
	
		PreparedStatement pstmt = null;
		
		try {
//			stmt = conn.createStatement();
			
			// 3. 쿼리 작성
			String sql = "INSERT INTO noticeInfo(`title`, `contents`) VALUES(?, ?)";
						
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, noticeInfo.getTitle());
			pstmt.setString(2, noticeInfo.getContents());
			
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
	
	
	public NoticeInfo selectNoticeInfo() {
		Database db = new Database();
		
		Connection conn = db.getConnection();
//		Statement stmt = null;
	
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		
		List<NoticeInfo> noticeInfoList = new ArrayList<>();
		
		try {
			String sql = "SELECT* FROM noticeInfo ORDER BY id DESC";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String title = rs.getString("title");
				String contents = rs.getString("contents");
				
				NoticeInfo nthNoticeInfo = new NoticeInfo(title, contents);
				
				noticeInfoList.add(nthNoticeInfo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			db.closeResultSet(rs);
			db.closePstmt(pstmt);
			db.closeConnection(conn);
			
		}
		
		return noticeInfoList;
		
		
	}
}
