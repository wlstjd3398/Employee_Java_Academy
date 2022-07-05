package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import util.Database;
import vo.NoticeInfo;

public class NoticeInfoDao {

	// 새로운 공지사항 저장 dao
	public boolean insertNoticeInfo(NoticeInfo noticeInfo) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			// 3. 쿼리 작성
			String sql = "INSERT INTO notice_info(`title`, `content`, `insertDate`) VALUES(?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, noticeInfo.getTitle());
			pstmt.setString(2, noticeInfo.getContent());
			pstmt.setString(3, noticeInfo.getInsertDate().toString());
			
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
	
	
	// 공지사항 목록 불러오기 dao(페이지 번호에 맞는 pageNumber 불러오기)
	public List<NoticeInfo> selectNoticeInfo(int pageNumber) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<NoticeInfo> noticeInfoList = new ArrayList<>();
		
		try {
			String sql = "SELECT * FROM notice_info ORDER BY idx DESC LIMIT ?, 5";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (pageNumber - 1) * 5);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int idx = rs.getInt("idx");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				String t_insertDate = rs.getString("insertDate");
				int hits = rs.getInt("hits");
				
				t_insertDate = t_insertDate.substring(0, t_insertDate.indexOf('.'));
				t_insertDate = t_insertDate.replace(' ', 'T');
				
				LocalDateTime insertDate = LocalDateTime.parse(t_insertDate);
				
				NoticeInfo nthNoticeInfo = new NoticeInfo(idx, title, content, writer, insertDate, hits);
				
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
	
	
	// 공지사항 수 불러오기 dao
	public int getAmountOfNotice() {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int amount = 0;
		
		try {
			String sql = "SELECT COUNT(*) AS amount FROM notice_info";
			
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
	
	
	// 상세정보에서 idx로 공지사항 불러오기 dao
	public NoticeInfo selectNoticeInfoByIdx(int idx) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		NoticeInfo noticeInfo = null;
		
		try {
			String sql = "SELECT * FROM notice_info WHERE idx = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String title = rs.getString("title");
				String content = rs.getString("content");
				
				noticeInfo = new NoticeInfo(idx, title, content);
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
	
	// 공지사항 삭제 dao
	public boolean deleteNoticeInfoByIdx(int idx) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		boolean result = false;
		
		try {
			String sql = "DELETE FROM notice_info WHERE idx = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			
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
	
	
	// 공지사항 수정 dao
	public boolean updateNoticeInfo(NoticeInfo noticeInfo) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		boolean result = false;
		
		try {
			String sql = "UPDATE noticeInfo SET title = ?, content = ? WHERE idx = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  noticeInfo.getTitle());
			pstmt.setString(2,  noticeInfo.getContent());
			pstmt.setInt(3, noticeInfo.getIdx());
			
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
