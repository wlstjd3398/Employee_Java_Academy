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
	
	public boolean insertNoticeInfo(NoticeInfo noticeInfo) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			// 3. 쿼리 작성
			String sql = "INSERT INTO noticeInfo(`title`, `contents`, `filePath`) VALUES(?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, noticeInfo.getTitle());
			pstmt.setString(2, noticeInfo.getContents());
			pstmt.setString(3, noticeInfo.getFilePath());
			
			// 4. stmt 를 통해서 쿼리 실행 및 결과 전달
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
	
	public List<NoticeInfo> selectNoticeInfo(int pageNumber) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<NoticeInfo> noticeInfoList = new ArrayList<>();
		
		try {
			String sql = "SELECT * FROM noticeInfo ORDER BY id DESC LIMIT ?, 5";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (pageNumber - 1) * 5);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String contents = rs.getString("contents");
				
				NoticeInfo nthNoticeInfo = new NoticeInfo(id, title, contents);
				
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
	
	
	public int getAmountOfNotice() {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int amount = 0;
		
		try {
			String sql = "SELECT COUNT(*) AS amount FROM noticeInfo";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			rs.next();
			
			amount = rs.getInt("amount"); // 칼럼 이름을 amount으로 사용
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeResultSet(rs);
			db.closePstmt(pstmt);
			db.closeConnection(conn);
		}
		
		return amount;
	}
	
	
	public NoticeInfo selectNoticeInfoById(int id) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		NoticeInfo noticeInfo = null;
		
		try {
			String sql = "SELECT * FROM noticeInfo WHERE id = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String title = rs.getString("title");
				String contents = rs.getString("contents");
				String filePath = rs.getString("filePath");
				
				noticeInfo = new NoticeInfo(id, title, contents, filePath);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeResultSet(rs);
			db.closePstmt(pstmt);
			db.closeConnection(conn);
		}
		
		return noticeInfo;
	}
	
	
	public boolean deleteNoticeInfoById(int id) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		boolean result = false;
		
		try {
			String sql = "DELETE FROM noticeInfo WHERE id = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			int count = pstmt.executeUpdate();
			
			result = count == 1;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closePstmt(pstmt);
			db.closeConnection(conn);
		}
		return result;
		
		
	}
	
	public boolean updateNoticeInfo(NoticeInfo noticeInfo) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		boolean result = false;
		
		try {
			String sql = "UPDATE noticeInfo SET title = ?, contents = ?, filePath = ? WHERE id = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  noticeInfo.getTitle());
			pstmt.setString(2,  noticeInfo.getContents());
			pstmt.setString(3,  noticeInfo.getFilePath());
			pstmt.setInt(4,  noticeInfo.getId());
			
			int count = pstmt.executeUpdate();
			
			result = count == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closePstmt(pstmt);
			db.closeConnection(conn);
		}
		return result;
	}
	
	
	
	
}