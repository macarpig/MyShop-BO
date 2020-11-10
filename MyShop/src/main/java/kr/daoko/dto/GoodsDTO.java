package kr.daoko.dto;

import java.util.Date;

public class GoodsDTO {
	private int gdsCode;
	private String gdsName;
	private int cateCode;
	private int gdsPrice;
	private String gdsDesc;
	private String gdsImg;
	private String gdsThumbImg;
	private Date gdsDate;
	private String gdsView;
	public int getGdsCode() {
		return gdsCode;
	}
	public void setGdsCode(int gdsCode) {
		this.gdsCode = gdsCode;
	}
	public String getGdsName() {
		return gdsName;
	}
	public void setGdsName(String gdsName) {
		this.gdsName = gdsName;
	}
	public int getCateCode() {
		return cateCode;
	}
	public void setCateName(int cateCode) {
		this.cateCode = cateCode;
	}
	public int getGdsPrice() {
		return gdsPrice;
	}
	public void setGdsPrice(int gdsPrice) {
		this.gdsPrice = gdsPrice;
	}
	public String getGdsDesc() {
		return gdsDesc;
	}
	public void setGdsDesc(String gdsDesc) {
		this.gdsDesc = gdsDesc;
	}
	public String getGdsImg() {
		return gdsImg;
	}
	public void setGdsImg(String gdsImg) {
		this.gdsImg = gdsImg;
	}
	public String getGdsThumbImg() {
		return gdsThumbImg;
	}
	public void setGdsThumbImg(String gdsThumbImg) {
		this.gdsThumbImg = gdsThumbImg;
	}
	public Date getGdsDate() {
		return gdsDate;
	}
	public void setGdsDate(Date gdsDate) {
		this.gdsDate = gdsDate;
	}
	public String getGdsView() {
		return gdsView;
	}
	public void setGdsView(String gdsView) {
		this.gdsView = gdsView;
	}
}
