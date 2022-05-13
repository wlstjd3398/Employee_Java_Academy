package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.Database;
import vo.BuyInfo;

public class BuyListDao {

	public boolean insertBuyInfo(BuyInfo buyInfo) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			
			String sql = "INSERT INTO buy_list(member_idx, product_idx, paymentMethod, buyDate) VALUES(?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, buyInfo.getUserId());
			pstmt.setInt(2, buyInfo.getProductId());
			pstmt.setString(3, buyInfo.getPaymentMethod());
			pstmt.setString(4, buyInfo.getBuyDate().toString());
			
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
	
}