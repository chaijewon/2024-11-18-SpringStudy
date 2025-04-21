<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
    AWS => tomcat : 9버전 
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <div class="breadcumb-area" style="background-image: url(img/bg-img/breadcumb.jpg);">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                    <div class="bradcumb-title text-center">
                        <h2>맛집 상세보기</h2>
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
                            <li class="breadcrumb-item"><a href="#"></a></li>
                            <li class="breadcrumb-item active" aria-current="page"></li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <section class="single_blog_area section_padding_80">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-12 col-lg-8">
                    <div class="row no-gutters">
                          <div class="col-12 col-sm-12">
                            <div class="related-post-area section_padding_50">
                              
                                <div class="related-post-slider owl-carousel">
                                    <!-- Single Related Post-->
                                    <c:forEach items="${list }" var="img">
	                                    <div class="single-post">
	                                        <!-- Post Thumb -->
	                                        <div class="post-thumb">
	                                            <img src="http://www.menupan.com${img }" alt="">
	                                        </div>
	                                    </div>
                                    </c:forEach>
                                </div>
                              </div>
                            </div>
                    <%-- 상세보기 --%>
                    <table class="table">
                      <tr>
                       <td width=30% class="text-center" rowspan="8">
                         <img src="https://www.menupan.com${vo.poster}" style="width:270px;height: 300px">
                       </td>
                       <td colspan="2">
                        <h3>${vo.name}&nbsp;<span style="color:orange">${vo.score }</span></h3>
                       </td>
                      </tr>
                      <tr>
                        <th width=25%>주소</th>
                        <td width=45%>${vo.address }</td>
                      </tr>
                      <tr>
                        <th width=25%>전화</th>
                        <td width=45%>${vo.phone }</td>
                      </tr>
                      <tr>
                        <th width=25%>음식종류</th>
                        <td width=45%>${vo.type }</td>
                      </tr>
                      <tr>
                        <th width=25%>가격대</th>
                        <td width=45%>${vo.price }</td>
                      </tr>
                      <tr>
                        <th width=25%>주차</th>
                        <td width=45%>${vo.parking }</td>
                      </tr>
                      <tr>
                        <th width=25%>영업시간</th>
                        <td width=45%>${vo.time }</td>
                      </tr>
                      <tr>
                        <th width=25%>테마</th>
                        <td width=45%>${vo.theme }</td>
                      </tr>
                    </table>
                    <table class="table">
                      <tr>
                        <td>${vo.content }</td>
                      </tr>
                    </table>
                    </div>
                </div>
            </div>
        </div>
        
        <%--  댓글 위치 --%>
        <div style="height: 10px"></div>
            <div class="row" id="replyApp">
              <%-- 댓글 : Vue --%>
              <!-- Comment Area Start -->
                            <div class="comment_area section_padding_50 clearfix">
                                <h4 class="mb-30">2 Comments</h4>

                                <ol>
                                    <!-- Single Comment Area -->
                                    <li class="single_comment_area">
                                        <div class="comment-wrapper d-flex">
                                            <!-- Comment Meta -->
                                            <div class="comment-author">
                                                <img src="img/blog-img/17.jpg" alt="">
                                            </div>
                                            <!-- Comment Content -->
                                            <div class="comment-content">
                                                <span class="comment-date text-muted">27 Aug 2018</span>
                                                <h5>Brandon Kelley</h5>
                                                <p>Neque porro qui squam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora.</p>
                                                <a href="#">Like</a>
                                                <a class="active" href="#">Reply</a>
                                            </div>
                                        </div>
                                        <ol class="children">
                                            <li class="single_comment_area">
                                                <div class="comment-wrapper d-flex">
                                                    <!-- Comment Meta -->
                                                    <div class="comment-author">
                                                        <img src="img/blog-img/18.jpg" alt="">
                                                    </div>
                                                    <!-- Comment Content -->
                                                    <div class="comment-content">
                                                        <span class="comment-date text-muted">27 Aug 2018</span>
                                                        <h5>Brandon Kelley</h5>
                                                        <p>Neque porro qui squam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora.</p>
                                                        <a href="#">Like</a>
                                                        <a class="active" href="#">Reply</a>
                                                    </div>
                                                </div>
                                            </li>
                                        </ol>
                                    </li>
                                    <li class="single_comment_area">
                                        <div class="comment-wrapper d-flex">
                                            <!-- Comment Meta -->
                                            <div class="comment-author">
                                                <img src="img/blog-img/19.jpg" alt="">
                                            </div>
                                            <!-- Comment Content -->
                                            <div class="comment-content">
                                                <span class="comment-date text-muted">27 Aug 2018</span>
                                                <h5>Brandon Kelley</h5>
                                                <p>Neque porro qui squam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora.</p>
                                                <a href="#">Like</a>
                                                <a class="active" href="#">Reply</a>
                                            </div>
                                        </div>
                                    </li>
                                </ol>
                            </div>

                            <!-- Leave A Comment -->
                            <div class="leave-comment-area section_padding_50 clearfix">
                                <div class="comment-form">
                                    <h4 class="mb-30">Leave A Comment</h4>

                                    <!-- Comment Form -->
                                    <form action="#" method="post">
                                        <div class="form-group">
                                            <input type="text" class="form-control" id="contact-name" placeholder="Name">
                                        </div>
                                        <div class="form-group">
                                            <input type="email" class="form-control" id="contact-email" placeholder="Email">
                                        </div>
                                        <div class="form-group">
                                            <input type="text" class="form-control" id="contact-website" placeholder="Website">
                                        </div>
                                        <div class="form-group">
                                            <textarea class="form-control" name="message" id="message" cols="30" rows="10" placeholder="Message"></textarea>
                                        </div>
                                        <button type="submit" class="btn contact-btn">Post Comment</button>
                                    </form>
                                </div>
                            </div>

                        </div>
                    </div>
    </section>
</body>
</html>