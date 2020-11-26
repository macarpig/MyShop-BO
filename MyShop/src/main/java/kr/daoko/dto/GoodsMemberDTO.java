package kr.daoko.dto;

public class GoodsMemberDTO {
   private String gdsCode;
   private String userId;
   private String userName;
   private String userEmail;
   private String userTel;
   private String userRank;
   private String orderDate;
   private String status;
   private String orderId;
   public String getGdsCode() {
      return gdsCode;
   }
   public void setGdsCode(String gdsCode) {
      this.gdsCode = gdsCode;
   }
   public String getUserId() {
      return userId;
   }
   public void setUserId(String userId) {
      this.userId = userId;
   }
   public String getUserName() {
      return userName;
   }
   public void setUserName(String userName) {
      this.userName = userName;
   }
   public String getUserEmail() {
      return userEmail;
   }
   public void setUserEmail(String userEmail) {
      this.userEmail = userEmail;
   }
   public String getUserTel() {
      return userTel;
   }
   public void setUserTel(String userTel) {
      this.userTel = userTel;
   }
   public String getUserRank() {
      return userRank;
   }
   public void setUserRank(String userRank) {
      this.userRank = userRank;
   }
   public String getStatus() {
      return status;
   }
   public void setStatus(String status) {
      this.status = status;
   }
   public String getOrderDate() {
      return orderDate;
   }
   public void setOrderDate(String orderDate) {
      this.orderDate = orderDate;
   }
   public String getOrderId() {
      return orderId;
   }
   public void setOrderId(String orderId) {
      this.orderId = orderId;
   }
}