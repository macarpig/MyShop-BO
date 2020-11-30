<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>MyShop ::: 상품 추가</title>
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Font Awesome -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/plugins/fontawesome-free/css/all.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<!-- DataTables -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/dist/css/adminlte.min.css">
<!-- Google Font: Source Sans Pro -->
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700"
	rel="stylesheet">
<script src="//cdn.ckeditor.com/4.15.1/standard/ckeditor.js"></script>


</head>
<body class="hold-transition sidebar-mini">
	<div class="wrapper">
		<!-- Navbar -->
		<%@ include file="../include/navigation.jsp"%>
		<!-- /.navbar -->

		<!-- Main Sidebar Container -->
		<%@ include file="../include/sidebar.jsp"%>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1>상품 추가</h1>
						</div>
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">Home</a></li>
								<li class="breadcrumb-item active">DataTables</li>
							</ol>
						</div>
					</div>
				</div>
				<!-- /.container-fluid -->
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-12">

							<div class="card card-primary">
								<div class="card-header">
									<h3 class="card-title">등록할 상품을 추가하세요</h3>
								</div>
								<!-- /.card-header -->
								<div class="card-body">
									<form role="form" method="post" autocomplete="off" enctype="multipart/form-data">
										<div class="inputArea">
											<!-- 상품 추가 main area -->
											<label>카테고리 분류</label> <select class="category"
												name="cateCode" id="cateCode">
												<option value="100">상하의</option>
												<option value="101">아우터</option>
												<option value="200">악세서리</option>
												<option value="201">신발</option>
												<option value="202">가방</option>
											</select> <label for="gdsCode">상품코드</label> <input type="text"
												id="gdsCode" name="gdsCode" />
										</div>

										<div class="inputArea">
											<label for="gdsName">상품명</label> <input type="text"
												id="gdsName" name="gdsName" class="form-control" />
										</div>

										<div class="inputArea">
											<label for="gdsPrice">상품가격</label> <input type="text"
												id="gdsPrice" name="gdsPrice" class="form-control" />
										</div>

										<div class="inputArea">
											<label for="gdsImg">상품이미지</label> <input type="file"
												id="gdsImg" name="file" />
											<div class="select_img">
												<img src="" />
											</div>
											<script>
												$("#gdsImg").change(function() {
																	if (this.files&& this.files[0]) {
																		var reader = new FileReader;
																		reader.onload = function(data) {
																			$(".select_img img").attr("src",data.target.result).width(500);
																		}
																		reader.readAsDataURL(this.files[0]);
																	}
																});
											</script>

											<%=request.getRealPath("/") %>
										</div>
										<div class="inputArea">
											<label for="gdsDesc">상품설명</label>
											<textarea rows="5" cols="50" id="gdsDesc" name="gdsDesc"></textarea>
											<script>	
											 var ckeditor_config = {
													   resize_enaleb : false,
													   enterMode : CKEDITOR.ENTER_BR,
													   shiftEnterMode : CKEDITOR.ENTER_P,
													   filebrowserUploadUrl : "/controller/goods/ckUpload"
													 };
											CKEDITOR.replace('gdsDesc', ckeditor_config);
											</script>
										</div>
									
								</div>
								<!-- /.card-body -->
							</div>
							<!-- /.card -->
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
					<div class="inputArea">
						<div class="col-12">
							<button type="submit" id="add_Btn" class="btn btn-primary">등록</button>
						</div>
					</div>
				</form>
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
			<strong>Copyright &copy; 2014-2019 <a
				href="http://adminlte.io">AdminLTE.io</a>.
			</strong> All rights reserved.
		</footer>

		<!-- Control Sidebar -->
		<aside class="control-sidebar control-sidebar-dark">
			<!-- Control sidebar content goes here -->
		</aside>
		<!-- /.control-sidebar -->
	</div>
	<!-- ./wrapper -->
	<!-- jQuery -->
	<script
		src="<%=request.getContextPath()%>/resources/plugins/jquery/jquery.min.js"></script>
	<!-- Bootstrap 4 -->
	<script
		src="<%=request.getContextPath()%>/resources/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- ckeditor -->
	<script src="<%=request.getContextPath()%>/resources/ckeditor/ckeditor.js" ></script>
	<!-- DataTables -->
	<script
		src="<%=request.getContextPath()%>/resources/plugins/datatables/jquery.dataTables.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
	<!-- AdminLTE App -->
	<script
		src="<%=request.getContextPath()%>/resources/dist/js/adminlte.min.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="<%=request.getContextPath()%>/resources/dist/js/demo.js"></script>
	
	<!-- page script -->
	<script>
</script>
<style> 
.select_img img { margin:20px 0;}
</style>
</body>
</html>
