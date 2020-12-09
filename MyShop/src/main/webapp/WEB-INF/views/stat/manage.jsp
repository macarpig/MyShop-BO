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
  <!-- daterange picker -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/plugins/daterangepicker/daterangepicker.css">
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
            <div class="card"><form>
              <div class="card-body">
              	<!-- Date range -->
                  <div class="row">
                   <div class="col-sm-6">
                	<div class="form-group"><label>상품코드</label>
                  	<input type="text" class="form-control" id="gdsCode">
                   </div></div>
                   <div class="col-sm-6">
                	<div class="form-group"><label>카테고리</label>
                  	<select class="form-control" id="cateName">
                  	<option></option>
                  	<option value="상하의">상하의</option>
	                <option value="아우터">아우터</option>
	                <option value="악세서리">악세서리</option>
	                <option value="신발">신발</option>
	                <option value="가방">가방</option>
                  	</select>
                  </div></div>
                  </div>
                  <div class="row">
                   <div class="col-sm-6">
                	<div class="form-group"><label>상품명</label>
                  	<input type="text" class="form-control" id="gdsName">
                   </div></div>
                   <div class="col-sm-6">
                	<div class="form-group"><label>고객 ID</label>
                  	<input type="text" class="form-control" id="userId">
                  </div></div>
                  </div>
                <div class="form-group">
                 <div class="input-group">
                  <label>기간 : </label>
                  <div class="input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text">
                        <i class="far fa-calendar-alt"></i>
                      </span>
                    </div>
                    <input type="text" class="form-control float-right" id="reservation">
                  </div>
                  </div></div></div>
              <div class="card-footer">
                <input type="button" class="btn btn-info" style="width:30%;" onclick="inquiry();" value="조회">
                <button type="reset" class="btn btn-default float-right" style="width:30%;">초기화</button><br>
              </div></form>
              <!-- 차트 영역 -->
              <div class="card-header">
              	<canvas id="chart"></canvas>
              </div>
              <div class="card-header">
              	<h3 class="card-title">차트영역</h3>
              </div>
              <!-- /.card-header -->
              <div class="card-body">
                <table id="manage" class="table table-bordered table-striped">
                  <thead>
                  <tr>
                    <th>주문번호</th>
                    <th>상품명</th>
                    <th>상품코드</th>
                    <th>카테고리</th>
                    <th>주문자</th>
                    <th>주문일</th>
                  </tr>
                  </thead>
                  <tfoot>
                  <tr>
                    <th>주문번호</th>
                    <th>상품명</th>
                    <th>상품코드</th>
                    <th>카테고리</th>
                    <th>주문자</th>
                    <th>주문일</th>
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
<!-- ChartJS -->
<script src="<%=request.getContextPath()%>/resources/plugins/chart.js/Chart.min.js"></script>
<!-- AdminLTE App -->
<script src="<%=request.getContextPath()%>/resources/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="<%=request.getContextPath()%>/resources/dist/js/demo.js"></script>
<!-- date-range-picker -->
<script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
<!-- page script -->
<script>
$(function () {
	$('#manage').DataTable({
	      ajax: {
				url: '<%=request.getContextPath()%>/api/stat/manage',
				dataType: 'json',
	            dataSrc: ''
			},
			
			columns: [
				{"data" : "orderId",
					"render": function(data, type, full, meta) {
						return "<a href='../order/detail?orderId="+ data +"'>"+data+"</a>";
					}},
				{"data" : "gdsName"},
				{"data" : "gdsCode",
					"render": function(data, type, full, meta) {
						return "<a href='../goods/detail?gdsCode="+ data +"'>"+data+"</a>";
					}},
				{"data" : "cateName"},
				{"data" : "userId",
					"render": function(data, type, full, meta) {
						return "<a href='../member/detail?userId="+ data +"'>"+data+"</a>";
					}},
				{"data" : "orderDate"}
			]
	    });

	//Date range picker
    $('#reservation').daterangepicker({
    	locale: {
    		format: 'YYYY-MM-DD',
    		applyLabel: 'Apply',
    		cancelLabel: 'Cancel'
    	},
    	showDropdowns: true,
    	minYear: 2000,
    	maxYear: parseInt(moment().format('YYYY'), 10),
    	opens: 'left',
    });
    
});

var chartLabels = [];
var chartData1=[], chartData2=[], chartData3=[];
var txtTitle = '전체 매출 차트';

	window.onload = function() {
		$.getJSON("<%=request.getContextPath()%>/api/stat/manageChart",
				function(data) {
		  $.each(data, function(idx, obj) {
			 chartLabels.push(obj.period);
		     chartData1.push(obj.totalPrice);
		     chartData2.push(obj.orderCnt);
		     chartData3.push(obj.cancleCnt);
		  });
		  createChart();
		});
	};
	
	function createChart() {
		window.myMixedChart = null;
		var ctx = document.getElementById('chart').getContext('2d');
		var chartData = {
				labels: chartLabels,
				datasets: [{
					type: 'line',
					label: '총 주문금액(단위:10만원)',
					borderColor: '#FF5E00',
					borderWidth: 2,
					fill: false,
					data: chartData1
				}, {
					type: 'bar',
					label: '주문 수',
					backgroundColor: '#1DDB16',
					data: chartData2,
					borderColor: 'white',
					borderWidth: 2
				}, {
					type: 'bar',
					label: '취소/교환/반품 수',
					backgroundColor: '#FF00DD',
					data: chartData3
				}]

			};
		window.myMixedChart = new Chart(ctx, {
			type: 'bar',
			data: chartData,
			options: {
				responsive: true,
				title: {
					display: true,
					text: txtTitle
				},
				tooltips: {
					mode: 'index',
					intersect: true
				}
			}
		});
	}

//조회 버튼 클릭
function inquiry() {
	var strRsv = $('#reservation').val().split(' - ');
	$('#manage').DataTable().clear();
	$('#manage').DataTable().ajax.url("${pageContext.request.contextPath}/api/stat/manage?gdsCode="+$('#gdsCode').val()+"&cateName="+encodeURIComponent($('#cateName').val())+"&gdsName="+$('#gdsName').val()+"&userId="+$('#userId').val()+"&startDate="+strRsv[0]+"&endDate="+strRsv[1]).load();
	chartLabels = [];
	chartData1 = [];
	chartData2 = [];
	chartData3 = [];
	if(strRsv.length > 1){
		txtTitle = strRsv[0] + ' - ' + strRsv[1] + '의 매출 차트';
	}else{
		txtTitle = '전체 매출 차트';
	}
	$.getJSON("<%=request.getContextPath()%>/api/stat/manageChart",
    		{startDate:strRsv[0], endDate:strRsv[1]},
			function(data) {
	  $.each(data, function(idx, obj) {
		 chartLabels.push(obj.period);
	     chartData1.push(obj.totalPrice);
	     chartData2.push(obj.orderCnt);
	     chartData3.push(obj.cancleCnt);
	  });
	  createChart();
	});
}
</script>
</body>
</html>
