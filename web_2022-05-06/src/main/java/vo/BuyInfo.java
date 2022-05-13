package vo;

import java.time.LocalDateTime;

public class BuyInfo {

	private String paymentMethod;
	private int userId;
	private int productId;
	private LocalDateTime buyDate;
	
	public BuyInfo(String paymentMethod, int userId, int productId, LocalDateTime buyDate) {
		this.paymentMethod = paymentMethod;
		this.userId = userId;
		this.productId = productId;
		this.buyDate = buyDate;
	}
	
	public LocalDateTime getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(LocalDateTime buyDate) {
		this.buyDate = buyDate;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
}