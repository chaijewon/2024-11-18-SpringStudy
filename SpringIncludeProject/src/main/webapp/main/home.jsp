<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
p {
   overflow: hidden;
   white-space: nowrap;
   text-overflow: ellipsis;
}
</style>
</head>
<body>
  <c:forEach var="vo" items="${list }">
     <div class="col-md-3">
	    <div class="thumbnail">
	      <a href="#">
	        <img src="${vo.poster }" title="${vo.title }"
	          style="width:180px;height: 150px">
	        <div class="caption">
	          <p>${vo.title }</p>
	        </div>
	      </a>
	    </div>
	  </div>
  </c:forEach>
</body>
</html>