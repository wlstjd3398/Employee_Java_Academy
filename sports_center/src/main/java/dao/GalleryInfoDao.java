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

public boolean insertGalleryInfo(GalleryInfo galleryInfo) {
		
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			
			String sql = "INSERT INTO Gallery_info(title, content, img, writer, insertDate, hits) VALUES(?, ?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, galleryInfo.getTitle());
			pstmt.setString(2, galleryInfo.getContent());
			pstmt.setString(3, galleryInfo.getImg());
			pstmt.setString(4, galleryInfo.getWriter());
			// 회원가입일을 문자열화 시켜서 하면 편하다
			pstmt.setString(5, galleryInfo.getInsertDate().toString());
			pstmt.setInt(6, galleryInfo.getHits());
			
			
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
	
	
	public void updateGalleryInfo(GalleryInfo galleryInfo) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			String sql = "UPDATE gallery_info SET title = ?, content = ?, img = ? WHERE idx = ?";
//			if(GalleryInfo.getImg() == null) {
//				sql = "UPDATE Gallery_info SET name = ?, category = ?, stock = ?, price = ? WHERE idx = ?";
//			}else {
//				sql = "UPDATE Gallery_info SET name = ?, category = ?, stock = ?, price = ?, img = ? WHERE idx = ?";
//			}
			// 이렇게 바꿀수 있다는 것을 보여줌
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, galleryInfo.getTitle());
			pstmt.setString(2, galleryInfo.getContent());
			pstmt.setString(3, galleryInfo.getImg());
			pstmt.setInt(4, galleryInfo.getIdx());
			
//			if(GalleryInfo.getImg() == null) {
//				pstmt.setInt(5, GalleryInfo.getIdx());
//			}else {
//				pstmt.setString(5, GalleryInfo.getImg());
//				pstmt.setInt(6, GalleryInfo.getIdx());
//			}
			// 이렇게 바꿀수 있다는 것을 보여줌
			
			pstmt.executeUpdate();
			// 따로 업데이트 결과를 리턴하지는 않고
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closePstmt(pstmt);
			db.closeConnection(conn);
		}
		
	}
	
	public void deleteByIdx(int idx) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		
		try {
			String sql = "DELETE FROM gallery_info WHERE idx = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closePstmt(pstmt);
			db.closeConnection(conn);
		}
		
	}
	
	
	public GalleryInfo selectByIdx(int idx) {
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
			
			if(rs.next()) {
				// select 결과를 memberInfo에 담음
				String title = rs.getString("title");
				String content = rs.getString("content");
				String img = rs.getString("img");
				img = img == null ? "" : img;
				
				String writer = rs.getString("writer");
				
				String t_insertDate = rs.getString("insertDate");
				t_insertDate = t_insertDate.substring(0, t_insertDate.indexOf('.'));
				t_insertDate = t_insertDate.replace(' ', 'T');
				LocalDateTime insertDate = LocalDateTime.parse(t_insertDate);
				
				int hits = rs.getInt("hits");
				
				galleryInfo = new GalleryInfo();
				galleryInfo.setIdx(idx);
				galleryInfo.setTitle(title);
				galleryInfo.setContent(content);
				galleryInfo.setImg(img);
				galleryInfo.setWriter(writer);
				galleryInfo.setInsertDate(insertDate);
				galleryInfo.setHits(hits);
				
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
	
	
	public int getCount() {
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
			
			amount = rs.getInt("amount");
			
		} catch (SQLException e) {
			e.printStackTrace();
			// 예외 발생할 일이 없어서 생략해도 됨
			
		} finally {
			db.closeResultSet(rs);
			db.closePstmt(pstmt);
			db.closeConnection(conn);
		}
		
		return amount;
		
	}
	
	public List<GalleryInfo> selectAll(int pageNumber){
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<GalleryInfo> galleryInfoList = new ArrayList<>();
		
		try {
			String sql = "SELECT * FROM gallery_info ORDER BY insertDate DESC LIMIT ?, 8";
			
			// * 8 에서 8이 의미하는 바는 한 페이지에 보여줘야할 상품의 수
			int startIndex = (pageNumber - 1) * 6;
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startIndex);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int nthIdx = rs.getInt("idx");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String img = rs.getString("img");
				String writer = rs.getString("writer");
				String t_insertDate = rs.getString("insertDate");
				t_insertDate = t_insertDate.substring(0, t_insertDate.indexOf('.'));
				t_insertDate = t_insertDate.replace(' ', 'T');
				LocalDateTime insertDate = LocalDateTime.parse(t_insertDate);

				int hits = rs.getInt("hits");
				
				GalleryInfo nthGalleryInfo = new GalleryInfo(nthIdx, title, content, img, writer, insertDate, hits);
				
				galleryInfoList.add(nthGalleryInfo);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			db.closeResultSet(rs);
			db.closePstmt(pstmt);
			db.closeConnection(conn);
			
		}

		return galleryInfoList;
		
	}
	
	
	public void decreaseStockById(int idx) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			
			String sql = "UPDATE gallery_info SET stock = stock - 1 WHERE idx = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			db.closePstmt(pstmt);
			db.closeConnection(conn);
		}
	}

	public void deleteImgById(int idx) {
		
		// idx를 사용해서 img 칼럼의 값을 null로 설정(DB상에서 이미지 삭제)
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			String sql = "UPDATE gallery_info SET img = null WHERE idx = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closePstmt(pstmt);
			db.closeConnection(conn);
		}
		
	}
	
}