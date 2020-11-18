<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>MyShop ::: 회원 관리</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <!-- Font Awesome -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/plugins/fontawesome-free/css/all.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <!-- DataTables -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
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
            <h1>DataTables</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">DataTables</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
        <div class="row">
          <div class="col-12">

            <div class="card">
              <div class="card-header">
              <a href="<%=request.getContextPath()%>/order/processing?page=0">
                <table style="float:left;width:18%;margin:1%;text-align:center;" border="1">
                	<tr>
                		<th>주문접수</th>
                	</tr>
                	<tr>
                		<td>${states.receipt}</td>
                	</tr>
				</table>
				</a>
				
				<a href="<%=request.getContextPath()%>/order/processing?page=1">	
				<table style="float:left;width:18%;margin:1%;text-align:center;" border="1">
					<tr>
                		<th>주문처리</th>
                	</tr>
                	<tr>
                		<td>${states.processing}</td>
                	</tr>
				</table>
				</a>
				
				<a href="<%=request.getContextPath()%>/order/processing?page=2">
				<table style="float:left;width:18%;margin:1%;text-align:center;" border="1">
                	<tr>
                		<th>교환접수</th>
                	</tr>
                	<tr>
                		<td>${states.exchange}</td>
                	</tr>
				</table>
				</a>
				
				<a href="<%=request.getContextPath()%>/order/processing?page=3">
				<table style="float:left;width:18%;margin:1%;text-align:center;" border="1">
                	<tr>
                		<th>환불접수</th>
                	</tr>
                	<tr>
                		<td>${states.refund}</td>
                	</tr>
				</table>
				</a>
				
				<a href="<%=request.getContextPath()%>/order/processing?page=4">
				<table style="float:left;width:18%;margin:1%;text-align:center;" border="1">
                	<tr>
                		<th>취소접수</th>
                	</tr>
                	<tr>
                		<td>${states.cancel}</td>
                	</tr>
				</table>
				</a>
              </div>
              <!-- /.card-header -->
              <div class="card-body">
                <table id="order" class="table table-bordered table-striped">
                  <thead>
                  <tr>
                    <th>주문번호</th>
                    <th>주문일</th>
                    <th>회원ID</th>
                    <th>등급</th>
                    <th>총 구매금액</th>
                    <th>상태</th>
                  </tr>
                  </thead>
                  <tfoot>
                  <tr>
                    <th>주문번호</th>
                    <th>주문일</th>
                    <th>회원ID</th>
                    <th>등급</th>
                    <th>총 구매금액</th>
                    <th>상태</th>
                  </tr>
                  </tfoot>
                </table>
              </div>
              <!-- /.card-body -->
            </div>
            <!-- /.card -->
          </div>
          <!-- /.col -->
        </div>
        <!-- /.row -->
      </div>
      <!-- /.container-fluid -->
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
<!-- DataTables -->
<script src="<%=request.getContextPath()%>/resources/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
<!-- AdminLTE App -->
<script src="<%=request.getContextPath()%>/resources/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="<%=request.getContextPath()%>/resources/dist/js/demo.js"></script>
<!-- page script -->
<script>
var table =  $('#order').DataTable({
      ajax: {
			url: '<%=request.getContextPath()%>/api/order/inquiry',
			dataSrc: ''
		},
		
		columns: [
			{"data" : "orderId",
				"render": function(data, type, full, meta) {
					return "<a href='detail?orderId="+ data +"'>"+data+"</a>";
				}},
			{"data" : "orderDate",
					"render": function(data, type, full, meta) {
						return data;
					}},
			{"data" : "userId",
				"render": function(data, type, full, meta) {
					return "<a href='../member/detail?userId="+ data +"'>"+data+"</a>";
				}},
			{"data" : "userRank"},
			{"data" : "totalPrice"},
			{"data" : "status"}
		]
    });
</script>
</body>
</html>
