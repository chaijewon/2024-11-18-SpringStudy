<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <table class="table">
   <tr>
    <td class="text-center"><h3>영화 순위</h3></td>
   </tr>
  </table>
  <table class="table">
    <tr>
      <th class="text-center">순위</th>
      <th class="text-center"></th>
      <th class="text-center">영화명</th>
    </tr>
    <c:forEach var="mvo" items="${kList}">
      <tr>
       <td class="text-center">${mvo.mno }</td>
       <td class="text-center">
        <img src="${mvo.poster }" style="width: 30px;height: 30px">
       </td>
       <td>${mvo.title }</td>
      </tr>
    </c:forEach>
  </table>
</body>
</html>