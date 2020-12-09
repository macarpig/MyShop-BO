package kr.daoko.dto;

public class StatChartDTO {

	private String period;
	private float totalPrice;
	private int orderCnt;
	private int cancleCnt;
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getOrderCnt() {
		return orderCnt;
	}
	public void setOrderCnt(int orderCnt) {
		this.orderCnt = orderCnt;
	}
	public int getCancleCnt() {
		return cancleCnt;
	}
	public void setCancleCnt(int cancleCnt) {
		this.cancleCnt = cancleCnt;
	}
	
}
