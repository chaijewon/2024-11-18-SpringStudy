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
                        <h2>회원 가입</h2>
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
                            <li class="breadcrumb-item"><a href="#"><i class="fa fa-home" aria-hidden="true"></i> Home</a></li>
                            <li class="breadcrumb-item active" aria-current="page">food-list Page</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <!-- ****** Breadcumb Area End ****** -->

    <!-- ****** Archive Area Start ****** -->
    <section class="archive-area section_padding_80">
        <div class="container">
            <div class="row" style="width:800px;margin:0px auto">
            <form method=post action="../member/join_ok.do" name="frm" id="frm">
             <table class="table">
              <tr>
               <th width=15% class="text-center" style="color:gray">ID</th>
               <td width=85%>
                <input type=text name="userid" id="id" size=15 class="form-control-sm">
                <input type=button id="idBtn" value="아이디중복체크"
                   class="btn-sm btn-primary">
               </td>
              </tr>
              <tr>
               <th width=15% class="text-center" style="color:gray">Password</th>
               <td width=85%>
                <input type=password name="userpwd" id="pwd1" size=15 class="form-control-sm">
                <input type=password name="pwd1" id="pwd2" size=15 class="form-control-sm"
                  placeholder="비밀번호 재입력" required
                >
               </td>
              </tr>
              
              <tr>
               <th width=15% class="text-center" style="color:gray">이름</th>
               <td width=85%>
                <input type=text name="username" id="name" size=15 class="form-control-sm">
               </td>
              </tr>
              
              <tr>
               <th width=15% class="text-center" style="color:gray">성별</th>
               <td width=85%>
                <input type="radio" name="sex" value="남자" checked>남자
                <input type="radio" name="sex" value="여자">여자
               </td>
              </tr>
              
              <tr>
               <th width=15% class="text-center" style="color:gray">생년월일</th>
               <td width=85%>
                <input type=date name="birthday" size=25 class="form-control-sm">
               </td>
              </tr>
              
              <tr>
               <th width=15% class="text-center" style="color:gray">이메일</th>
               <td width=85%>
                <input type=text name="email" size=55 class="form-control-sm">
               </td>
              </tr>
              
              <tr>
               <th width=15% class="text-center" style="color:gray">우편번호</th>
               <td width=85%>
                <input type=text id="post" name="post" size=10 class="form-control-sm" readonly>
                <input type=button value="우편번호검색" class="btn-sm btn-danger" id="postBtn">
               </td>
              </tr>
              
              <tr>
               <th width=15% class="text-center" style="color:gray">주소</th>
               <td width=85%>
                <input type=text id="addr1" name="addr1" size=55 class="form-control-sm" readonly>
               </td>
              </tr>
              
              <tr>
               <th width=15% class="text-center" style="color:gray">상세주소</th>
               <td width=85%>
                <input type=text name="addr2" size=55 class="form-control-sm">
               </td>
              </tr>
              
              <tr>
               <th width=15% class="text-center" style="color:gray">전화번호</th>
               <td width=85%>
                <select name="phone1" class="form-control-sm">
                  <option>010</option>
                </select>
                <input type=text name="phone2" size=15 class="form-control-sm">
               </td>
              </tr>
              
              <tr>
               <th width=15% class="text-center" style="color:gray">소개</th>
               <td width=85%>
                <textarea rows="7" cols="57" name="content"></textarea>
               </td>
              </tr>
              
              <tr>
               <td colspan="2" class="text-center">
                <input type=button value="회원가입" class="btn-sm btn-success" id="joinBtn">
                <input type=button value="취소" class="btn-sm btn-info"
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