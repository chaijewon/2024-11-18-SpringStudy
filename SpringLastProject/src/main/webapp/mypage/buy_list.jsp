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
<div class="breadcumb-nav">
        <div class="container">
            <div class="row">
                <div class="col-12">
                  <table class="table">
                   <tr>
                    <th class="text-center">번호</th>
                    <th class="text-center"></th>
                    <th class="text-center">상품명</th>
                    <th class="text-center">가격</th>
                    <th class="text-center">수량</th>
             
                    <th class="text-center">구매일</th>
                    <th class="text-center">비고</th>
                   </tr>
                  <c:forEach var="vo" items="${list }">
                    <tr>
                     <td class="text-center">${vo.cno }</td>
                     <td class="text-center">
                      <img src="${vo.gvo.goods_poster }"
                        style="width: 35px;height: 35px">
                     </td>
                     <td>${vo.gvo.goods_name }</td>
                     <td class="text-center">
                      ${vo.gvo.goods_price }
                     </td>
                     <td class="text-center">
                      ${vo.account }
                     </td>
                     <td class="text-center">${vo.dbday }</td>
                     
                     <td class="text-center">
                      <a href="../goods/detail.do?no=${vo.gno }" class="btn-sm btn-info">취소</a>
                     </td>
                    </tr>
                  </c:forEach>
                   
                  </table>
                </div>
            </div>
        </div>
 </div>
 <section class="single_blog_area section_padding_80" id="reserveApp">
    <div class="container">
      <div class="row justify-content-center ">
        <div class="col-12 col-lg-12">
           <div class="row no-gutters">
           </div>
        </div>
      </div>
    </div>
 </section>
</body>
</html>