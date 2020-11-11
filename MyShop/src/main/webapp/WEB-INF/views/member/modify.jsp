<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>AdminLTE 3 | Project Edit</title>
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
      <form role="form" method="post">
      	<div class="row">
	        <div class="col-md-12">
	          <div class="card card-primary">
	            <div class="card-header">
	              <h3 class="card-title">General</h3>
	            </div>
	            <div class="card-body">
	              <div class="form-group">
	                <label for="userId">회원 ID</label>
	                <input type="text" id="userId" name="userId" class="form-control" value="${member.userId}" readonly="readonly">
	              </div>
	              <div class="form-group">
	                <label for="userName">이름</label>
	                <input type="text" id="userName" name="userName" class="form-control" value="${member.userName}">
	              </div>
	              <div class="form-group">
	                <label for="userEmail">이메일</label>
	                <input type="text" id="userEmail" name="userEmail" class="form-control" value="${member.userEmail}">
	              </div>
	              <div class="form-group">
	                <label for="userTel">연락처</label>
	                <input type="text" id="userTel" name="userTel" class="form-control" value="${member.userTel}">
	              </div>
	              <div class="form-group">
	                <label for="userZipcode">우편번호</label>
	                <input type="text" id="userZipcode" name="userZipcode" class="form-control" value="${member.userZipcode}">
	              </div>
	              <div class="form-group">
	                <label for="userAddr1">주소</label>
	                <input type="text" id="userAddr1" name="userAddr1" class="form-control" value="${member.userAddr1}">
	              </div>
	              <div class="form-group">
	                <label for="userAddr2">상세 주소</label>
	                <input type="text" id="userAddr2" name="userAddr2" class="form-control" value="${member.userAddr2}">
	              </div>
	              <div class="form-group">
	                <label>등급</label>
	                <select name="userRank" class="form-control custom-select">
	                  <option selected disabled>선택</option>
	                  <option value="VIP" <c:if test="${member.userRank == 'VIP'}">selected</c:if>>VIP</option>
	                  <option value="우수회원" <c:if test="${member.userRank == '우수회원'}">selected</c:if>>우수회원</option>
	                  <option value="일반회원" <c:if test="${member.userRank == '일반회원'}">selected</c:if>>일반회원</option>
	                </select>
	              </div>
	              <div class="form-group">
	                <label>권한</label>
	                <select name="userAuth" class="form-control custom-select">
	                  <option selected disabled>선택</option>
	                  <option value=false <c:if test="${member.userAuth == false}">selected</c:if>>사용자</option>
	                  <option value=true <c:if test="${member.userAuth == true}">selected</c:if>>관리자</option>
	                </select>
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
		formObj.attr("action", "<%=request.getContextPath()%>/member/modify");
		formObj.attr("method", "post")
		formObj.submit();
	});

	$("#delete_Btn").click(function() {
		var question = confirm("정말로 회원을 삭제하시겠습니까?");
		
		if(question) {
			formObj.attr("action", "<%=request.getContextPath()%>/member/delete");
			formObj.submit();
		}
	});
</script>
</body>
</html>
