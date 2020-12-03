<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>상품 수정 페이지</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <!-- Font Awesome -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/plugins/fontawesome-free/css/all.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <!-- overlayScrollbars -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/dist/css/adminlte.min.css">
  <!-- Google Font: Source Sans Pro -->
  <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
  <script src="//cdn.ckeditor.com/4.15.1/standard/ckeditor.js"></script>
</head>
<body class="hold-transition sidebar-mini">
<!-- Site wrapper -->
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
            <h1>Project Edit</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">Project Edit</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">
      <form role="form" method="post" autocomplete="off" enctype="multipart/form-data">
      	<div class="row">
	        <div class="col-md-12">
	          <div class="card card-primary">
	            <div class="card-header">
	              <h3 class="card-title">상품을 수정하세요.</h3>
	            </div>
	            <div class="card-body">
	              <div class="inputArea">
	              	<label for="cateCode">카테고리 분류</label>
 						<select class="category" name="cateCode" id="cateCode">
  						<option value="100" <c:if test="${goods.cateCode == '100'}">selected</c:if>>상하의</option>
	                  	<option value="101" <c:if test="${goods.cateCode == '101'}">selected</c:if>>아우터</option>
	                  	<option value="200" <c:if test="${goods.cateCode == '200'}">selected</c:if>>악세서리</option>
	                  	<option value="201" <c:if test="${goods.cateCode == '201'}">selected</c:if>>신발</option>
	                  	<option value="202" <c:if test="${goods.cateCode == '202'}">selected</c:if>>가방</option>
 						</select>
	                <label for="gdsCode">상품 코드</label>
	                <input type="text" id="gdsCode" name="gdsCode" value="${goods.gdsCode}" readonly="readonly">
	              </div>
	              <div class="inputArea">
	                <label for="gdsName">상품 이름</label>
	                <input type="text" id="gdsName" name="gdsName" class="form-control" value="${goods.gdsName}">
	              </div>
	              <div class="form-group">
	                
	              </div>
	              <div class="inputArea">
	                <label for="gdsPrice">상품 가격</label>
	                <input type="text" id="gdsPrice" name="gdsPrice" value="${goods.gdsPrice}">
	              </div>
	              <div class="inputArea">
	                <label for="gdsImg">상품 이미지</label>
	                <input type="file" id="gdsImg" name="file"/>
	                <div class="select_img">
	                	<img src="${goods.gdsImg}" class="oriImg"/>
	                	<input type="hidden" name="gdsImg" value="${goods.gdsImg}"/>
	                	<input type="hidden" name="gdsThumbImg" value="${goods.gdsThumbImg}"/>
	                </div>
	                
	                <script>
	                	$("#gdsImg").change(function() {
	                		if(this.files && this.files[0]) {
	                			var reader = new FileReader;
	                			reader.onload = function(data) {
	                				$(".select_img img").attr("src", data.target.result).width(500);
	                			}
	                			reader.readAsDataURL(this.files[0]);
	                		}
	                	});
	                </script>
	         
	              </div> 
	              
	              <div class="inputArea">
	                <label for="gdsDesc">상품 설명</label>
	                <textArea rows="5" cols="50"id="gdsDesc" name="gdsDesc" class="form-control" value="${goods.gdsDesc}"></textArea>
										<script>	
											 var ckeditor_config = {
													   resize_enaleb : false,
													   enterMode : CKEDITOR.ENTER_BR,
													   shiftEnterMode : CKEDITOR.ENTER_P,
													   filebrowserUploadUrl : "/controller/goods/ckUpload"
													 };
											CKEDITOR.config.allowContent = true;
											CKEDITOR.replace('gdsDesc', ckeditor_config);
											
											</script>
									</div>
	            </div>
	            <!-- /.card-body -->
	          </div>
	          <!-- /.card -->
	        </div>
	      </div>
	      <div class="row">
	        <div class="col-12">
	          <button type="reset" class="btn btn-secondary">초기화</button>
	          <button id="modify_Btn" type="submit" class="btn btn-primary float-right ml-1">수정</button>
	          <button id="delete_Btn" class="btn btn-danger float-right">삭제</button>
	        </div>
	      </div>
      </form>
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
<!-- AdminLTE App -->
<script src="<%=request.getContextPath()%>/resources/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="<%=request.getContextPath()%>/resources/dist/js/demo.js"></script>

<script>
	var formObj = $("form[role='form']");
	
	$("#modify_Btn").click(function(){
		formObj.attr("action", "<%=request.getContextPath()%>/goods/modify");
		formObj.attr("method", "post")
		formObj.submit();
	});

	$("#delete_Btn").click(function() {
		var question = confirm("정말로 상품을 삭제하시겠습니까?");
		
		if(question) {
			formObj.attr("action", "<%=request.getContextPath()%>/goods/deletewindow");
			formObj.submit();
		}
	});
</script>
<style>
.orgImg{width:500px; height:auto;}

</style>
</body>
</html>
