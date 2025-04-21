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
                        <h2>상세보기</h2>
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
    <section class="archive-area section_padding_80" id="listApp">
        <div class="container">
            <div class="row">
              <table class="table">
               <tr>
                <td class="text-center" colspan="2">
                 <img src="${vo.poster }" style="width: 700px;height: 250px">
                </td>
               </tr>
               <tr>
                 <th width=20%>주소</th>
                 <td width=80%>${vo.address }</td>
               </tr>
               <tr>
                 <th width=20%>전화</th>
                 <td width=80%>${vo.phone }</td>
               </tr>
               <tr>
                 <th width=20%>교통정보/운영시간</th>
                 <td width=80%>${vo.info }</td>
               </tr>
              </table>
            </div>
            <div style="height: 10px"></div>
            <div class="row">
              <%-- 지도출력 --%>
            </div>
            <div style="height: 10px"></div>
            <div class="row" id="replyApp">
              <%-- 댓글 : Vue --%>
            </div>
        </div>
    </section>
</body>
</html>