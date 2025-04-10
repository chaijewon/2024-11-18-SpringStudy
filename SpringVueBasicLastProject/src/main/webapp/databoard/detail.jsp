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
  width: 800px;
}
</style>
</head>
<body>
  <div class="container">
   <div class="row">
     <h3 class="text-center">내용보기</h3>
     <table class="table">
       <tr>
        <th width=20% class="text-center">번호</th>
        <td width=30% class="text-center"></td>
        <th width=20% class="text-center">작성일</th>
        <td width=30% class="text-center"></td>
       </tr>
       <tr>
        <th width=20% class="text-center">이름</th>
        <td width=30% class="text-center"></td>
        <th width=20% class="text-center">조회수</th>
        <td width=30% class="text-center"></td>
       </tr>
       <tr>
        <th width=20% class="text-center">제목</th>
        <td colspan="3"></td>
       </tr>
       <tr>
         <td colspan="4" valign="top" class="text-left"
          height="200">
           <pre style="white-space: pre-wrap;"></pre>
         </td>
       </tr>
       <tr>
         <td colspan="4" class="text-right">
          <a href="list.do" class="btn btn-xs btn-primary">목록</a>
         </td>
       </tr>
     </table>
   </div>
  </div>
</body>
</html>