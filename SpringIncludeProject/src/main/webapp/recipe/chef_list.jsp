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
  <%--
      ChefVO vo=new ChefVO(); => model.addAttribute("vo",vo)
      for(ChefVO vo:list)
      {
      }
      
      for(ChefVO vo:list)
      {
      }
   --%>
  <table class="table">
    <tr>
     <td>
       <c:forEach var="vo" items="${list }">
         <table class="table">
          <tr>
           <td width=20% class="text-center" rowspan="2">
             <img src="${vo.poster }" 
              style="width: 120px;height: 100px"
              class="img-circle">
           </td>
           <td width=80% colspan="4">
            <h3 style="color:orange">${vo.chef }</h3>
           </td>
          </tr>
          <tr>
            <td class="text-center">
              <img src="../recipe/icon/m1.png">
              &nbsp;${vo.mem_cont1 }
            </td>
            <td class="text-center">
              <img src="../recipe/icon/m2.png">
              &nbsp;${vo.mem_cont3 }
            </td>
            <td class="text-center">
              <img src="../recipe/icon/m3.png">
              &nbsp;${vo.mem_cont7 }
            </td>
            <td class="text-center">
              <img src="../recipe/icon/m4.png">
              &nbsp;${vo.mem_cont2 }
            </td>
          </tr>
         </table>
       </c:forEach>
     </td>
    </tr>
  </table>
  <div style="height: 10px"></div>
  <div class="text-center">
    <ul class="pagination">
      <c:if test="${startPage>1 }">
       <li><a href="../recipe/chef_list.do?page=${startPage-1 }">&lt;</a></li>
      </c:if>
      <c:forEach var="i" begin="${startPage }" end="${endPage }">
        <li ${i==curpage?"class=active":"" }><a href="../recipe/chef_list.do?page=${i }">${i }</a></li>
      </c:forEach>
      <c:if test="${endPage<totalpage }">
       <li><a href="../recipe/chef_list.do?page=${endPage+1 }">&gt;</a></li>
      </c:if>
    </ul>
  </div>
</body>
</html>