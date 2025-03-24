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
 margin-top: 50px;
}
.row{
  margin: opx auto;
  width: 800px;
}
</style>
</head>
<body>
   <div class="container">
   <div class="row">
   <h3 class="text-center">글쓰기</h3>
   <form method="post" action="insert_ok.do">
   <table class="table">
     <tr>
      <th width=15%>이름</th>
      <td width=85%>
       <input type=text name=name size=20 required
        class="input-sm"
       >
      </td>
     </tr>
     <tr>
      <th width=15%>제목</th>
      <td width=85%>
       <input type=text name=subject size=50 required
        class="input-sm"
       >
      </td>
     </tr>
     <tr>
      <th width=15%>내용</th>
      <td width=85%>
       <textarea rows="5" cols="52" name=content required></textarea>
      </td>
     </tr>
     <tr>
      <th width=15%>비밀번호</th>
      <td width=85%>
       <input type=password name=pwd size=10 required
        class="input-sm"
       >
      </td>
     </tr>
     <tr>
       <td colspan="2" align=center>
         <input type=submit value="글쓰기">
         <input type=button value="취소"
          onclick="javascript:history.back()"
         >
       </td>
     </tr>
   </table>
   </form>
   </div>
  </div>
</body>
</html>