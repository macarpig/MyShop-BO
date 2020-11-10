package kr.daoko.dto;

public class OrderDetailDTO {
	public int orderDetailId;
	public String orderId;
	public String gdsCode;
	public String gdsName;
	public String gdsPrice;
	public int cartStock;
	public String orderRequest;
	public int getOrderDetailId() {
		return orderDetailId;
	}
	public void setOrderDetailId(int orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getGdsCode() {
		return gdsCode;
	}
	public void setGdsCode(String gdsCode) {
		this.gdsCode = gdsCode;
	}
	public String getGdsName() {
		return gdsName;
	}
	public void setGdsName(String gdsName) {
		this.gdsName = gdsName;
	}
	public String getGdsPrice() {
		return gdsPrice;
	}
	public void setGdsPrice(String gdsPrice) {
		this.gdsPrice = gdsPrice;
	}
	public int getCartStock() {
		return cartStock;
	}
	public void setCartStock(int cartStock) {
		this.cartStock = cartStock;
	}
	public String getOrderRequest() {
		return orderRequest;
	}
	public void setOrderRequest(String orderRequest) {
		this.orderRequest = orderRequest;
	}
	
}
