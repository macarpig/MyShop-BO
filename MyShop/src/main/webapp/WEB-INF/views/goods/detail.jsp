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
                <h3 class="card-title">클릭 시 상품 수정 페이지로 이동</h3>
              </div>
              <!-- /.card-header -->
              <div class="card-body">
                <table id="goods" class="table table-bordered table-hover">
                  <thead>
                     <tr>
                       <th>썸네일 이미지 </th>
                       <th>상품코드 </th>
                       <th>상품명 </th>
                       <th>금액 </th>
                       <th>등록날짜</th>
                       <th>조회수</th>
                     </tr>
                  </thead>
                  <tbody>
                      <tr>
                          <td>${goods.gdsThumbImg}</td>
                          <td>${goods.gdsCode}</td>
                          <td>${goods.gdsName}</td>
                          <td>${goods.gdsPrice}</td>
                          <td>${goods.gdsDate}</td>
                          <td>${goods.gdsView}</td>
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
                <h3 class="card-title">클릭 시 해당 멤버를 조회합니다.</h3>
              </div>
              <!-- /.card-header -->
              <div class="card-body">            
                <table id="member" class="table table-bordered table-hover">
                  <thead>
                     <tr>
                       <th>주문번호 </th>
                       <th>주문일 </th>
                       <th>회원ID </th>
                       <th>등급</th>
                       <th>상품상태 </th>
                     </tr>
                  </thead>
                  <tbody>
                  </tbody>
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
                <h3 class="card-title">해당 상품의 댓글 </h3>
              </div>
              <!-- /.card-header -->
              <div class="card-body">
                <table id="answer" class="table table-bordered table-hover">
                  <thead>
                     <tr>
                       <th>댓글번호 </th>
                       <th>아이디 </th>
                       <th>댓글내용 </th>
                       <th>날짜 </th>
                     </tr>
                  </thead>
                </table>
              </div>
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

var gdsCode = getParameterByName("gdsCode");

$('#goods tbody').on('click', 'tr', function() {
   location.href="modify?gdsCode=" + gdsCode;
});

var member = $('#member').DataTable({
   ajax: {
      url: '<%=request.getContextPath()%>/api/member/purchaser?gdsCode=' + gdsCode,
      dataSrc: ''
   },
   
   columns: [
      {"data" : "orderId",
         "render": function(data, type, full, meta) {
            return "<a href='../order/detail?orderId="+ data +"'>"+data+"</a>";
         }},
      {"data" : "orderDate"},
      {"data" : "userId",
         "render": function(data, type, full, meta) {
            return "<a href='../member/detail?userId="+ data +"'>"+data+"</a>";
         }},
      {"data" : "userRank"},
      {"data" : "status"}
   ]
});

<%-- $('#member tbody').on('click', 'tr', function() {
   location.href="<%=request.getContextPath()%>goods/manage/detail?orderId=" + order.row(this).data().orderId;
}); --%>

var qna = $('#qna').DataTable({
   ajax: {
      url: '<%=request.getContextPath()%>/api/qna/list?userId=' + userId,
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
   location.href="<%=request.getContextPath()%>/qna/detail?idx=" + qna.row(this).data().idx;
});
</script>
</body>
</html>