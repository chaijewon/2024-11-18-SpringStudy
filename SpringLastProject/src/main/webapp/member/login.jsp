<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
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
    <%--
      1. 페이징 : 목록 
      2. 상세보기 = Map / 댓글 
      3. 로그인 / 로그아웃 (security) 
      4. 검색 = Vue
      5. 예약 / 결재 / 추천
      ========================== 
      6. websocket 
     --%>
    <section class="single_blog_area section_padding_80" id="loginApp">
        <div class="container">
            <div class="row justify-content-center ">
            
             <form method="post" action="../member/login.do" id="frm">
             <table class="table text-center">
               <tr>
                 <th width="20%">ID</th>
                 <td width="80%">
                  <input type=text name="userid" 
                  ref="userid" v-model="userid" class="form-control-sm">
                 </td>
               </tr>
               <tr>
                 <th width="20%">PW</th>
                 <td width="80%">
                  <input type=password name="userpwd"
                  ref="userpwd" v-model="userpwd" class="form-control-sm">
                 </td>
               </tr>
               <tr>
                 <td colspan="2">
                  <input type=checkbox name="remember-me">자동로그인
                 </td>
               </tr>
               <tr>
                 <td colspan="2" class="text-center">
                   <span style="color:red">${message }</span>
                 </td>
               </tr>
               <tr>
                 <td colspan="2">
                   <input type=button value="로그인" class="btn-sm btn-danger" @click="login()">
                   <input type=button value="취소" class="btn-sm btn-success" @click="cancel()">
                 </td>
               </tr>
             </table>
             </form>
            </div>
        </div>
        
    </section> 
    <script>
    let loginApp=Vue.createApp({
    	data(){
    		return {
    			userid:'',
    			userpwd:''
    		}
    	},
    	methods:{
    		login(){
    			if(this.userid==="")
    			{
    				this.$refs.userid.focus()
    				return
    			}
    			if(this.userpwd==="")
    			{
    				this.$refs.userpwd.focus()
    				return
    			}
    			
    			$('#frm').submit()
    		},
    		cancel(){
    			history.back();
    		}
    	}
    }).mount('#loginApp')
    </script>
</body>
</html>