package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import util.Database;
import vo.GalleryInfo;

public class GalleryInfoDao {

	// 새로운 갤러리 저장 dao
		public boolean insertGalleryInfo(GalleryInfo galleryInfo) {
			Database db = new Database();
			
			Connection conn = db.getConnection();
			PreparedStatement pstmt = null;
			
			try {
				// 3. 쿼리 작성
				String sql = "INSERT INTO gallery_info(`title`, `content`, `img`, `insertDate`) VALUES(?, ?, ?, ?)";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, galleryInfo.getTitle());
				pstmt.setString(2, galleryInfo.getContent());
				pstmt.setString(3, galleryInfo.getImg());
				pstmt.setString(4, galleryInfo.getInsertDate().toString());
				
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
		
		
		// 갤러리 목록 불러오기 dao(페이지 번호에 맞는 pageNumber 불러오기)
		public List<GalleryInfo> selectGalleryInfo(int pageNumber) {
			Database db = new Database();
			
			Connection conn = db.getConnection();
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			List<GalleryInfo> galleryInfoList = new ArrayList<>();
			
			try {
				String sql = "SELECT * FROM gallery_info ORDER BY idx DESC LIMIT ?, 5";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, (pageNumber - 1) * 5);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					int idx = rs.getInt("idx");
					String title = rs.getString("title");
					String content = rs.getString("content");
					String img = rs.getString("img");
					String writer = rs.getString("writer");
					String t_insertDate = rs.getString("insertDate");
					int hits = rs.getInt("hits");
					
					t_insertDate = t_insertDate.substring(0, t_insertDate.indexOf('.'));
					t_insertDate = t_insertDate.replace(' ', 'T');
					
					LocalDateTime insertDate = LocalDateTime.parse(t_insertDate);
					
					GalleryInfo nthGalleryInfo = new GalleryInfo(idx, title, content, img, writer, insertDate, hits);
					
					galleryInfoList.add(nthGalleryInfo);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				db.closeResultSet(rs);
				db.closePstmt(pstmt);
				db.closeConnection(conn);
			}
			
			return galleryInfoList;
		}
		
		
		// 갤러리 수 불러오기 dao
		public int getAmountOfGallery() {
			Database db = new Database();
			
			Connection conn = db.getConnection();
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			int amount = 0;
			
			try {
				String sql = "SELECT COUNT(*) AS amount FROM gallery_info";
				
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
		
		
		// 상세정보에서 idx로 갤러리 불러오기 dao
		public GalleryInfo selectGalleryInfoByIdx(int idx) {
			Database db = new Database();
			
			Connection conn = db.getConnection();
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			GalleryInfo galleryInfo = null;
			
			try {
				String sql = "SELECT * FROM gallery_info WHERE idx = ?";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, idx);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					String title = rs.getString("title");
					String content = rs.getString("content");
					String img = rs.getString("img");
					
					galleryInfo = new GalleryInfo(idx, title, content, img);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				db.closeResultSet(rs);
				db.closePstmt(pstmt);
				db.closeConnection(conn);
			}
			
			return galleryInfo;
		}
		
		// 갤러리 삭제 dao
		public boolean deleteGalleryInfoByIdx(int idx) {
			Database db = new Database();
			
			Connection conn = db.getConnection();
			PreparedStatement pstmt = null;
			
			boolean result = false;
			
			try {
				String sql = "DELETE FROM gallery_info WHERE idx = ?";
				
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
		
		
		// 갤러리 수정 dao
		public boolean updateGalleryInfo(GalleryInfo galleryInfo) {
			Database db = new Database();
			
			Connection conn = db.getConnection();
			PreparedStatement pstmt = null;
			
			boolean result = false;
			
			try {
				String sql = "UPDATE gallery_info SET title = ?, content = ? WHERE idx = ?";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,  galleryInfo.getTitle());
				pstmt.setString(2,  galleryInfo.getContent());
				pstmt.setInt(3, galleryInfo.getIdx());
				
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
