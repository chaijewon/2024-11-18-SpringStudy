<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
 <div class="breadcumb-area" style="background-image: url(../img/bg-img/breadcumb.jpg);">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                    <div class="bradcumb-title text-center">
                        <h2>마이페이지</h2>
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
            <div class="col-sm-3">
              <div class="panel panel-primary">
                <div class="panel-heading">
                 <h3 class="panel-title">관리 정보</h3>
                </div>
                <ul class="list-group">
                 <li class="list-group-item"><a href="../mypage/reserve_list.do">예약정보</a></li>
                 <li class="list-group-item"><a href="../mypage/cart_list.do">장바구니정보</a></li>
                 <li class="list-group-item"><a href="../mypage/buy_list.do">구매정보</a></li>
                </ul>
              </div>
            </div>
            <div class="col-sm-9">
              <jsp:include page="${mypage_jsp }"></jsp:include>
            </div>
        </div>
    </section>        
         
</body>
</html>