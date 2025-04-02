<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
.row {
   width: 960px;
   margin: 0px auto;
}
</style>
</head>
<body>
  <jsp:include page="header.jsp"></jsp:include>
  <div class="container">
   <div class="row">
     <div class="text-right">
      <%-- 로그인 : Password 암호화 / 인터셉트 (ID저장,자동 로그인) --%>
     </div>
   </div>
   <div class="row">
    <div class="col-sm-9">
     <jsp:include page="${main_jsp }"></jsp:include>
    </div>
    <div class="col-sm-3"></div>
   </div>
  </div>
</body>
</html>