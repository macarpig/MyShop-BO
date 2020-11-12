package kr.daoko.dto;

public class OrderStatusDTO {
	private int receipt;
	private int processing;
	private int exchange;
	private int refund;
	private int cancel;
	public int getReceipt() {
		return receipt;
	}
	public void setReceipt(int receipt) {
		this.receipt = receipt;
	}
	public int getProcessing() {
		return processing;
	}
	public void setProcessing(int processing) {
		this.processing = processing;
	}
	public int getExchange() {
		return exchange;
	}
	public void setExchange(int exchange) {
		this.exchange = exchange;
	}
	public int getRefund() {
		return refund;
	}
	public void setRefund(int refund) {
		this.refund = refund;
	}
	public int getCancel() {
		return cancel;
	}
	public void setCancel(int cancel) {
		this.cancel = cancel;
	}
}
