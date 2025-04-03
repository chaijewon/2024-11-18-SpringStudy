<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
  
      <h3>내용보기</h3>
      <table class="table">
        <tr>
          <th width=20% class="text-center">번호</th>
          <td width=30% class="text-center">${vo.no }</td>
          <th width=20% class="text-center">작성일</th>
          <td width=30% class="text-center">${vo.regdate}</td>
        </tr>
        <tr>
          <th width=20% class="text-center">이름</th>
          <td width=30% class="text-center">${vo.name }</td>
          <th width=20% class="text-center">조회수</th>
          <td width=30% class="text-center">${vo.hit }</td>
        </tr>
        <tr>
          <th width=20% class="text-center">제목</th>
          <td colspan="3">${vo.subject }</td>
        </tr>
        <tr>
          <td colspan="4" class="text-left" valign="top"
           height="200"><pre style="white-space: pre-wrap;border: none;background-color: white">${vo.content }</pre></td>
        </tr>
        <tr>
          <td colspan="4" class="text-right">
           <a href="reply.do?no=${vo.no }" class="btn btn-xs btn-warning">답변</a>
           <a href="update.do?no=${vo.no }" class="btn btn-xs btn-danger">수정</a>
           <a href="delete.do?no=${vo.no }" class="btn btn-xs btn-success">삭제</a>
           <a href="list.do" class="btn btn-xs btn-warning">목록</a>
          </td>
        </tr>
      </table>
   
</body>
</html>




