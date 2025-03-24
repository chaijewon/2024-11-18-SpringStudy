<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
  margin-top: 50px
}
.row {
  width: 500px;
  margin: 0px auto;
}
</style>
</head>
<!-- 
    1. pom.xml : 라이브러리 추가 
    2. 버전 변경 : 1.6 = Spring 5이상은 1.8이상 
    ***3. web.xml : 변경 
    4. application-context.xml : 클래스 등록 
    5. DI / AOP / ORM 
 -->
<body>
  <div class="container">
    <div class="row">
     <h3 class="text-center">사원 등록</h3>
     <form method=post action="insert_ok4.do">
     <table class="table">
       <tr>
         <th width=20%>사번</th>
         <td width=80%>
          <input type=text name=sabun size=10 class="input-sm">
         </td>
       </tr>
       <tr>
         <th width=20%>이름</th>
         <td width=80%>
          <input type=text name=name size=20 class="input-sm">
         </td>
       </tr>
       <tr>
         <th width=20%>부서</th>
         <td width=80%>
          <input type=text name=dept size=20 class="input-sm">
         </td>
       </tr>
       <tr>
         <th width=20%>직위</th>
         <td width=80%>
          <input type=text name=job size=20 class="input-sm">
         </td>
       </tr>
       <tr>
         <th width=20%>근무지</th>
         <td width=80%>
          <input type=text name=loc size=20 class="input-sm">
         </td>
       </tr>
       <tr>
         <th width=20%>연봉</th>
         <td width=80%>
          <input type=text name=pay size=20 class="input-sm">
         </td>
       </tr>
       <tr>
         <td colspan="2" class="text-center">
           <input type=submit value="전송">
         </td>
       </tr>
     </table>
     </form>
    </div>
  </div>
</body>
</html>