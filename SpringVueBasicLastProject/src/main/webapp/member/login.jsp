<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
 margin-top: 50px;
}
.row{
  margin: 0px auto;
  width: 350px;
}
</style>
</head>
<body>
  <div class="container">
    <div class="row">
      <h3 class="text-center">Login</h3>
      <form method=post action="login_ok.do">
      <table class="table">
        <tr>
          <td width=20%>ID</td>
          <td width=80%>
           <input type=text name="id" class="input-sm"
            size=15
           >
          </td>
        </tr>
        <tr>
          <td width=20%>PW</td>
          <td width=80%>
           <input type=password name="pwd" class="input-sm"
            size=15
           >
          </td>
        </tr>
        <tr>
          <td colspan="2" class="text-center">
           <input type=submit value="로그인">
          </td>
        </tr>
      </table>
      </form>
    </div>
  </div>  
</body>
</html>






