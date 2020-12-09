<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
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
            <div class="card card-primary">
              <div class="card-header">
                <h3 class="card-title">클릭 시 회원정보 수정 페이지로 이동합니다.</h3>
              </div>
              <!-- /.card-header -->
              <div class="card-body">
                <table id="member" class="table table-bordered table-hover">
                  <thead>
	                  <tr>
	                    <th>아이디</th>
	                    <th>이름</th>
	                    <th>연락처</th>
	                    <th>주소</th>
	                    <th>등급</th>
	                  </tr>
                  </thead>
                  <tbody>
                      <tr>
                          <td>${member.userId}</td>
                          <td>${member.userName}</td>
                          <td>${member.userTel}</td>
                          <td>${member.userAddr1}</td>
                          <td>${member.userRank}</td>
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
          <div class="col-6">
            <div class="card">
              <div class="card-header">
                <h3 class="card-title">클릭 시 해당 주문 상세 페이지로 이동합니다.</h3>
              </div>
              <!-- /.card-header -->
              <div class="card-body">
              	<a href="<%=request.getContextPath()%>/order/processing?page=0">
                <table style="float:left;width:18%;margin:1%;text-align:center;" border="1">
                	<tr>
                		<th>주문접수</th>
                	</tr>
                	<tr>
                		<td>${status.receipt}</td>
                	</tr>
				</table>
				</a>
				
				<a href="<%=request.getContextPath()%>/order/processing?page=1">	
				<table style="float:left;width:18%;margin:1%;text-align:center;" border="1">
					<tr>
                		<th>주문처리</th>
                	</tr>
                	<tr>
                		<td>${status.processing}</td>
                	</tr>
				</table>
				</a>
				
				<a href="<%=request.getContextPath()%>/order/processing?page=2">
				<table style="float:left;width:18%;margin:1%;text-align:center;" border="1">
                	<tr>
                		<th>교환접수</th>
                	</tr>
                	<tr>
                		<td>${status.exchange}</td>
                	</tr>
				</table>
				</a>
				
				<a href="<%=request.getContextPath()%>/order/processing?page=3">
				<table style="float:left;width:18%;margin:1%;text-align:center;" border="1">
                	<tr>
                		<th>반품접수</th>
                	</tr>
                	<tr>
                		<td>${status.refund}</td>
                	</tr>
				</table>
				</a>
				
				<a href="<%=request.getContextPath()%>/order/processing?page=4">
				<table style="float:left;width:18%;margin:1%;text-align:center;" border="1">
                	<tr>
                		<th>취소접수</th>
                	</tr>
                	<tr>
                		<td>${status.cancel}</td>
                	</tr>
				</table>
				</a>
                <table id="order" class="table table-bordered table-hover">
                  <thead>
	                  <tr>
	                    <th>주문번호</th>
	                    <th>주문일자</th>
	                    <th>주문금액</th>
	                    <th>주문상태</th>
	                  </tr>
                  </thead>
                </table>
              </div>
              <!-- /.card-body -->
            </div>
            <!-- /.card -->
          </div>
          <!-- /.col -->
          <div class="col-6">
            <div class="card">
              <div class="card-header">
                <h3 class="card-title">클릭 시 해당 Q&A 페이지로 이동합니다.</h3>
              </div>
              <!-- /.card-header -->
              <div class="card-body">
                <table id="qna" class="table table-bordered table-hover">
                  <thead>
	                  <tr>
	                    <th>문의번호</th>
	                    <th>문의사항</th>
	                    <th>문의일자</th>
	                    <th>문의상태</th>
	                  </tr>
                  </thead>
                </table>
              </div>
              <table id="memo" class="table table-bordered table-hover">
                  <thead>
	                  <tr>
	                    <th>메모</th>
	                  </tr>
                  </thead>
                  <tbody>
                  	<tr>
                  		<td>${member.userMemo}</td>
                  	</tr>
                  </tbody>
                </table>
              <!-- /.card-body -->
            </div>
            <!-- /.card -->
          </div>
        </div>
      </div>
      <!-- /.container-fluid -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  
  <%@ include file="../include/footer.jsp" %>

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
function getParameterByName(name) {
    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
        results = regex.exec(location.search);
    return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}

var userId = getParameterByName("userId");
var userRank = "${member.userRank}";

$('#member tbody').on('click', 'tr', function() {
	location.href="modify?userId=" + userId;
});

if(userRank === 'VIP') {
	$("#member tr:odd").css("background-color", "#00FF00");
}

else if(userRank === '우수회원') {
	$("#member tr:odd").css("background-color", "#FF00FF");
}

var order = $('#order').DataTable({
	ajax: {
		url: '<%=request.getContextPath()%>/api/order/list?userId=' + userId,
		dataSrc: ''
	},
	
	columns: [
		{"data" : "orderId"},
		{"data" : "orderDate"},
		{"data" : "totalPrice"},
		{"data" : "status"}
	]
});

$('#order tbody').on('click', 'tr', function() {
	location.href="<%=request.getContextPath()%>/order/detail?orderId=" + order.row(this).data().orderId;
});

var qna = $('#qna').DataTable({
	ajax: {
		url: '<%=request.getContextPath()%>/api/qna/listuser?userId=' + userId,
		dataSrc: ''
	},
	
	columns: [
		{"data" : "idx"},
		{"data" : "question"},
		{"data" : "date"},
		{
			"data" : "answer",
			"render" : function(data, type, row) {
				
				if(data === undefined) {
					return '대기';
				}
				
				else {
					return '완료';
				}
			}
		}
	]
});

$('#qna tbody').on('click', 'tr', function() {
	location.href="<%=request.getContextPath()%>/qna/view?idx=" + qna.row(this).data().idx;
});
$('#memo tbody').on('click','tr',function() {
	location.href="<%=request.getContextPath()%>/member/memo?userId="+userId;
});
</script>
</body>
</html>
