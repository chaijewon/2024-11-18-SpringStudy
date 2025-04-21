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
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="#"><i class="fa fa-home" aria-hidden="true"></i></a></li>
                            <li class="breadcrumb-item active" aria-current="page"></li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <section class="archive-area section_padding_80" id="loginApp">
        <div class="container">
            <div class="row justify-content-center">
             <form method="post" action="../member/login.do" id="frm">
             <table class="table">
               <tr>
                 <th width="20%">ID</th>
                 <td width="80%">
                  <input type=text name="userid" 
                  ref="userid" v-model="userid" class="input-sm">
                 </td>
               </tr>
               <tr>
                 <th width="20%">PW</th>
                 <td width="80%">
                  <input type=password name="userpwd"
                  ref="userpwd" v-model="userpwd" class="input-sm">
                 </td>
               </tr>
               <tr>
                 <td colspan="2">
                  <input type=checkbox name="remember-me">자동로그인
                 </td>
               </tr>
               <tr>
                 <td colspan="2">
                   <input type=button value="로그인" class="btn-sm btn-danger">
                   <input type=button value="취소" class="btn-sm btn-success">
                 </td>
               </tr>
             </table>
             </form>
            </div>
        </div>
    </section> 
</body>
</html>