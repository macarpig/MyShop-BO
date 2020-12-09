<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Macarpig | 주문 상세 페이지</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/plugins/fontawesome-free/css/all.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/dist/css/adminlte.min.css">
  <!-- Google Font: Source Sans Pro -->
  <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
   <!-- Navbar -->
  <%@ include file="../include/navigation.jsp" %>
  <!-- /.navbar -->

  <!-- Main Sidebar Container -->
  <%@ include file="../include/sidebar.jsp" %>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>주문 상세 페이지</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">주문 상세 페이지</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
      	<div class="row">
          <div class="col-md-6">
            <div class="card">
              <div class="card-body p-0">
                <table class="table table-striped" style="width:100%;">
                  <tbody>
                    <tr>
                      <th>주문 번호</th>
                      <td>${order.orderId }</td>
                      <th>주문 일자</th>
                      <td>${order.orderDate }</td>
                    </tr>
                  </tbody>
                </table>
              </div>
              <!-- /.card-body -->
            </div>
            <!-- /.card -->
          </div>
          <!-- /.col -->
        </div>
        <!-- /.row -->
        <div class="row">
          <div class="col-12">
            <div class="card">
              <div class="card-header">
                <h3 class="card-title">Order List Table</h3>

              </div>
              <!-- /.card-header -->
              <div class="card-body table-responsive p-0">
                <table class="table table-hover text-nowrap">
                  <thead>
                    <tr>
                      <th>주문상세번호</th>
                      <th>상품명</th>
                      <th>수량</th>
                      <th>요청사항</th>
                      <th>판매가</th>
                      <th>총 구매금액</th>
                      <th>상품상태</th>
                    </tr>
                  </thead>
                  <tbody>
                  <c:forEach var="detail" items="${detail}">
                  	<tr>
                      <td><c:out value="${detail.orderDetailId}" /></td>
                      <td><c:out value="${detail.gdsName}" /></td>
                      <td><c:out value="${detail.cartStock}" /></td>
                      <td><c:out value="${detail.orderRequest}" /></td>
                      <td><c:out value="${detail.gdsPrice}" /></td>
                      <td><c:out value="${detail.gdsPrice}" /></td>
                      <td>${order.status}</td>
                    </tr>
                   </c:forEach>
                  </tbody>
                </table>
              </div>
              <!-- /.card-body -->
            </div>
            <!-- /.card -->
          </div>
        </div>
        <!-- /.row -->
        <div class="row">
          <div class="col-md-6">
            <div class="card">
              <div class="card-header">
                <h3 class="card-title">total</h3>
              </div>
              <!-- /.card-header -->
              <div class="card-body p-0">
                <table class="table table-striped" style="width:100%">
                  <tbody>
                    <tr>
                      <td><c:forEach var="detail" items="${detail}">
                      	<p><c:out value="${detail.gdsName}" /> * <c:out value="${detail.cartStock}" />개 (<c:out value="${detail.gdsPrice}" />)=<c:out value="${detail.gdsPrice * detail.cartStock}" />
                      </c:forEach></td>
                    </tr>
                    <tr>
                      <td>총 구매 금액 : ${order.totalPrice}</td>
                    </tr>
                  </tbody>
                </table>
              </div>
              <!-- /.card-body -->
            </div>
            <!-- /.card -->
            <c:if test="${fn:contains(order.status, '반품') || fn:contains(order.status, '취소') ||fn:contains(order.status, '교환')}">
            <div class="card">
              <div class="card-header">
                <h3 class="card-title">${order.status} 사유</h3>
              </div>
              <!-- /.card-header -->
              <div class="card-body p-0">
                <table class="table table-striped" style="width:100%">
                  <tbody>
                    <tr>
                      <td>${order.reason}</td>
                    </tr>
                  </tbody>
                </table>
              </div>
              <!-- /.card-body -->
            </div>
            <!-- /.card -->
            </c:if>
          </div>
          <!-- /.col -->
        </div>
        <!-- /.row -->
        <div class="row">
          <div class="col-12">
            <div class="card">
              <div class="card-header">
                <h3 class="card-title">delivery information</h3>
              </div>
              <!-- /.card-header -->
              <div class="card-body">
                <table class="table table-bordered">
                  <thead>                  
                    <tr>
                      <th colspan="4">주문자 정보</th>
                      <th colspan="4">수령자 정보</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <th>회원ID</th>
                      <td>${member.userId}</td>
                      <th>전화번호</th>
                      <td>${member.userTel}</td>
                      <th>수령자명</th>
                      <td>${order.orderRecvr}</td>
                      <th>전화번호</th>
                      <td>${order.orderTel}</td>
                    </tr>
                    <tr>
                      <th>등급</th>
                      <td>${member.userRank}</td>
                      <th>이메일</th>
                      <td>${member.userEmail}</td>
                      <th>수령지</th>
                      <td colspan="3">${order.orderAddr1}<p>${order.orderAddr2}</td>
                    </tr>
                  </tbody>
                </table>
              </div>
              <!-- /.card-body -->
            </div>
            <!-- /.card -->
          </div>
        </div>
        <!-- /.row -->
      </div><!-- /.container-fluid -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  <footer class="main-footer">
    <div class="float-right d-none d-sm-block">
      <b>Version</b> 3.0.5
    </div>
    <strong>Copyright &copy; 2014-2019 <a href="http://adminlte.io">AdminLTE.io</a>.</strong> All rights
    reserved.
  </footer>

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
  </aside>
  <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->

<!-- jQuery -->
<script src="<%=request.getContextPath()%>/resources/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="<%=request.getContextPath()%>/resources/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="<%=request.getContextPath()%>/resources/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="<%=request.getContextPath()%>/resources/dist/js/demo.js"></script>
</body>
</html>
