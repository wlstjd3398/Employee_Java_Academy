package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.Database;
import vo.BoardInfo;
import vo.BoardReviewInfo;

public class BoardInfoDao {

	// 새로운 자유게시판 저장 dao
	public boolean insertBoardInfo(BoardInfo boardInfo) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			// 3. 쿼리 작성
			String sql = "INSERT INTO board_info(`title`, `content`) VALUES(?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardInfo.getTitle());
			pstmt.setString(2, boardInfo.getContent());
			
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
	
	
	// 자유게시판 목록 불러오기 dao(페이지 번호에 맞는 pageNumber 불러오기)
	public List<BoardInfo> selectBoardInfo(int pageNumber) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<BoardInfo> boardInfoList = new ArrayList<>();
		
		try {
			String sql = "SELECT * FROM board_info ORDER BY idx DESC LIMIT ?, 5";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (pageNumber - 1) * 5);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int idx = rs.getInt("idx");
				String title = rs.getString("title");
				String content = rs.getString("content");
				int hits = rs.getInt("hits");
				
				BoardInfo nthBoardInfo = new BoardInfo(idx, title, content, hits);
				
				boardInfoList.add(nthBoardInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeResultSet(rs);
			db.closePstmt(pstmt);
			db.closeConnection(conn);
		}
		
		return boardInfoList;
	}
	
	
	// 자유게시판 수 불러오기 dao
	public int getAmountOfBoard() {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int amount = 0;
		
		try {
			String sql = "SELECT COUNT(*) AS amount FROM board_info";
			
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
	
	
	// 상세정보에서 idx로 자유게시판 불러오기 dao
	public BoardInfo selectBoardInfoByIdx(int idx) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		BoardInfo boardInfo = null;
		
		try {
			String sql = "SELECT * FROM board_info WHERE idx = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String title = rs.getString("title");
				String content = rs.getString("content");
				
				boardInfo = new BoardInfo(idx, title, content);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeResultSet(rs);
			db.closePstmt(pstmt);
			db.closeConnection(conn);
		}
		
		return boardInfo;
	}
	
	// 자유게시판 삭제 dao
	public boolean deleteBoardInfoByIdx(int idx) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		boolean result = false;
		
		try {
			String sql = "DELETE FROM board_info WHERE idx = ?";
			
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
	
	
	// 자유게시판 수정 dao
	public boolean updateBoardInfo(BoardInfo boardInfo) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		boolean result = false;
		
		try {
			String sql = "UPDATE board_info SET title = ?, content = ? WHERE idx = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  boardInfo.getTitle());
			pstmt.setString(2,  boardInfo.getContent());
			pstmt.setInt(3, boardInfo.getIdx());
			
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
	
	
	// 자유게시판 댓글dao
	public BoardReviewInfo selectReviewByIdx(int idx) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		BoardReviewInfo boardReviewInfo = null;
		
		try {
			String sql = "SELECT * FROM board_review_info WHERE idx = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String writer = rs.getString("reviewWriter");
				String content = rs.getString("reviewContent");
				
				boardReviewInfo = new BoardReviewInfo(idx, writer, content);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeResultSet(rs);
			db.closePstmt(pstmt);
			db.closeConnection(conn);
		}
		
		return boardReviewInfo;
	}
}
