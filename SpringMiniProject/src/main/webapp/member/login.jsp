<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="breadcumb-area" style="background-image: url(../img/bg-img/breadcumb.jpg);">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                    <div class="bradcumb-title text-center">
                        <h2>로그인</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="breadcumb-nav">
        <div class="container">
            <div class="row">
                <div class="col-12">
                </div>
            </div>
        </div>
    </div>
    <section class="archive-area section_padding_80">
        <div class="container">
            <div class="row justify-content-center">
              <form action="../member/login.do" method="post" id="frm">
                <table class="table text-center">
                  <tr>
                   <th width=20% class="text-center">ID</th>
                   <td width=80%>
                     <input type=text name="userid" ref="userid"
                      v-model="userid" class="form-control-sm">
                   </td>
                  </tr>
                  <tr>
                   <th width=20% class="text-center">PW</th>
                   <td width=80%>
                     <input type=password name="userpwd" ref="userpwd"
                      v-model="userpwd" class="form-control-sm">
                   </td>
                  </tr>
                  <tr>
                    <td colspan="2">
                     <input type=checkbox name="id-me">ID저장
                     <input type=checkbox name="remember-me">자동로그인
                    </td>
                  </tr>
                  <tr>
                    <%--security --%>
                    <td colspan="2" class="text-center"
                     style="color:red">${message }</td>
                  </tr>
                  <tr>
                    <td colspan="2" class="text-center">
                      <input type=button value="로그인"
                       class="btn-sm btn-primary">
                      <input type=button value="취소"
                       class="btn-sm btn-primary"
                       onclick="javascript:history.back()" 
                      >
                    </td>
                  </tr>
                </table>
              </form>
            </div>
        </div>
    </section>
</body>
</html>