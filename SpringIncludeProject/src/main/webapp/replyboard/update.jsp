<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
   
   <h3 class="text-center">수정</h3>
   <form method="post" action="update_ok.do" id="frm">
   <table class="table">
     <tr>
      <th width=15%>이름</th>
      <td width=85%>
       <input type=text name=name size=20 required
        class="input-sm" value="${vo.name }"
        ref="name" v-model="name"
       >
       <input type=hidden name=no value="${vo.no }"
        v-model="no"
       >
      </td>
     </tr>
     <tr>
      <th width=15%>제목</th>
      <td width=85%>
       <input type=text name=subject size=50 required
        class="input-sm" value="${vo.subject }"
        ref="subject" v-model="subject"
       >
      </td>
     </tr>
     <tr>
      <th width=15%>내용</th>
      <td width=85%>
       <textarea rows="5" cols="52" name=content required
         v-model="content" ref="content"
       >${vo.content }</textarea>
      </td>
     </tr>
     <tr>
      <th width=15%>비밀번호</th>
      <td width=85%>
       <input type=password name=pwd size=10 required
        class="input-sm" ref="pwd" v-model="pwd"
       >
      </td>
     </tr>
     <tr>
       <td colspan="2" align=center>
         <input type=submit value="글쓰기" class="btn-sm btn-danger">
         <input type=button value="취소" class="btn-sm btn-primary"
          onclick="javascript:history.back()"
         >
       </td>
     </tr>
   </table>
   </form>
   
</body>
</html>