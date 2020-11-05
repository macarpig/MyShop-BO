package kr.daoko.dto;

import java.sql.Date;

public class OrderDTO {

	private String orderId;
	private String userId;
	private String orderRecvr;
	private String orderZipCode;
	private String orderAddr1;
	private String orderAddr2;
	private String orderTel;
	private Date orderDate;
	private String orderStatus;
	private String userrank;
	private int totalPrice;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getOrderRecvr() {
		return orderRecvr;
	}
	public void setOrderRecvr(String orderRecvr) {
		this.orderRecvr = orderRecvr;
	}
	public String getOrderZipCode() {
		return orderZipCode;
	}
	public void setOrderZipCode(String orderZipCode) {
		this.orderZipCode = orderZipCode;
	}
	public String getOrderAddr1() {
		return orderAddr1;
	}
	public void setOrderAddr1(String orderAddr1) {
		this.orderAddr1 = orderAddr1;
	}
	public String getOrderAddr2() {
		return orderAddr2;
	}
	public void setOrderAddr2(String orderAddr2) {
		this.orderAddr2 = orderAddr2;
	}
	public String getOrderTel() {
		return orderTel;
	}
	public void setOrderTel(String orderTel) {
		this.orderTel = orderTel;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getUserrank() {
		return userrank;
	}
	public void setUserrank(String userrank) {
		this.userrank = userrank;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
}
