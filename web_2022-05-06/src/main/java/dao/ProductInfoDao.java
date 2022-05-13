package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import util.Database;
import vo.MemberInfo;
import vo.ProductInfo;

public class ProductInfoDao {

public boolean insertProductInfo(ProductInfo productInfo) {
		
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			
			String sql = "INSERT INTO product_info(name, category, stock, price, img, insertDate) VALUES(?, ?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, productInfo.getName());
			pstmt.setString(2, productInfo.getCategory());
			pstmt.setInt(3, productInfo.getStock());
			pstmt.setInt(4, productInfo.getPrice());
			pstmt.setString(5, productInfo.getImg());
			// 회원가입일을 문자열화 시켜서 하면 편하다
			pstmt.setString(6, productInfo.getInsertDate().toString());
			
			
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
	
	
	public void updateProductInfo(ProductInfo productInfo) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			String sql = "UPDATE product_info SET name = ?, category = ?, stock = ?, price = ?, img = ? WHERE idx = ?";
//			if(productInfo.getImg() == null) {
//				sql = "UPDATE product_info SET name = ?, category = ?, stock = ?, price = ? WHERE idx = ?";
//			}else {
//				sql = "UPDATE product_info SET name = ?, category = ?, stock = ?, price = ?, img = ? WHERE idx = ?";
//			}
			// 이렇게 바꿀수 있다는 것을 보여줌
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, productInfo.getName());
			pstmt.setString(2, productInfo.getCategory());
			pstmt.setInt(3, productInfo.getStock());
			pstmt.setInt(4, productInfo.getPrice());
			pstmt.setString(5, productInfo.getImg());
			pstmt.setInt(6, productInfo.getIdx());
			
//			if(productInfo.getImg() == null) {
//				pstmt.setInt(5, productInfo.getIdx());
//			}else {
//				pstmt.setString(5, productInfo.getImg());
//				pstmt.setInt(6, productInfo.getIdx());
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
			String sql = "DELETE FROM product_info WHERE idx = ?";
			
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
	
	
	public ProductInfo selectByIdx(int idx) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;

		ProductInfo productInfo = null;
		
		try {
			
			String sql = "SELECT * FROM product_info WHERE idx = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				// select 결과를 memberInfo에 담음
				String name = rs.getString("name");
				String category = rs.getString("category");
				int stock  = rs.getInt("stock");
				int price = rs.getInt("price");
				String img = rs.getString("img");
				String t_insertDate = rs.getString("insertDate");
				t_insertDate = t_insertDate.substring(0, t_insertDate.indexOf('.'));
				t_insertDate = t_insertDate.replace(' ', 'T');
				
				LocalDateTime insertDate = LocalDateTime.parse(t_insertDate);
				
				productInfo = new ProductInfo();
				productInfo.setIdx(idx);
				productInfo.setName(name);
				productInfo.setCategory(category);
				productInfo.setStock(stock);
				productInfo.setPrice(price);
				productInfo.setImg(img);
				productInfo.setInsertDate(insertDate);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeResultSet(rs);
			db.closePstmt(pstmt);
			db.closeConnection(conn);
		}
		return productInfo;
		
	}
	
	
	public int getCount() {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int amount = 0;
		
		try {
			
			String sql = "SELECT COUNT(*) AS amount FROM product_info";
			
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
	
	public List<ProductInfo> selectAll(int pageNumber){
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<ProductInfo> productInfoList = new ArrayList<>();
		
		try {
			String sql = "SELECT * FROM product_info LIMIT ?, 10";
			
			// * 10 에서 10이 의미하는 바는 한 페이지에 보여줘야할 상품의 수
			int startIndex = (pageNumber - 1) * 10;
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startIndex);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int nthIdx = rs.getInt("idx");
				String name = rs.getString("name");
				String category = rs.getString("category");
				int stock = rs.getInt("stock");
				int price = rs.getInt("price");
				String img = rs.getString("img");
				String t_insertDate = rs.getString("insertDate");
				
				t_insertDate = t_insertDate.substring(0, t_insertDate.indexOf('.'));
				t_insertDate = t_insertDate.replace(' ', 'T');
				
				LocalDateTime insertDate = LocalDateTime.parse(t_insertDate);
				
				ProductInfo nthProductInfo = new ProductInfo(nthIdx, name, category, stock, price, img, insertDate);
				
				productInfoList.add(nthProductInfo);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			db.closeResultSet(rs);
			db.closePstmt(pstmt);
			db.closeConnection(conn);
			
		}

		return productInfoList;
		
	}
	
	
	public void decreaseStockById(int productId) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			
			String sql = "UPDATE product_info SET stock = stock - 1 WHERE idx = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productId);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			db.closePstmt(pstmt);
			db.closeConnection(conn);
		}
		
	}
	
}