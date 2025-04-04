<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  
     <h3>삭제하기</h3>
     <form method=post action="delete_ok.do">
     <table class="table">
      <tr>
       <td width=30%>비밀번호</td>
       <td width=70%>
        <input type="password" name=pwd size=20
         class="input-sm" required>
        <input type="hidden" name=no value="${no }">
       </td>
      </tr>
      <tr>
        <td colspan="2" class="text-center">
         <input type=submit value="삭제" class="btn-sm btn-danger">
         <input type=button value="취소" 
         onclick="javascript:history.back()" class="btn-sm btn-primary">
        </td>
      </tr>
     </table>
     </form>
   
</body>
</html>