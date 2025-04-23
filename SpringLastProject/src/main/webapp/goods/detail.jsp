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
                        <h2>상품 상세보기</h2>
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
    <section class="single_blog_area section_padding_80" id="detailApp">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-12 col-lg-8">
                    <div class="row no-gutters">
                          
                    <%-- 상세보기 --%>
                    <table class="table">
                      <tr>
                       <td width=30% class="text-center" rowspan="7">
                         <img :src="vo.goods_poster" style="width:270px;height: 300px">
                       </td>
                       <td colspan="2">
                        <h3>{{vo.goods_name}}</h3>
                       </td>
                      </tr>
                      <tr>
        
                        <td colspan="2" style="color:gray">{{vo.goods_sub}}</td>
                      </tr>
                      <tr>
                        <th width=25% style="color:red">{{vo.goods_discount}}%</th>
                        <td width=45%>{{vo.goods_price }}</td>
                      </tr>
                      <tr>
                        <th width=25%>배송</th>
                        <td width=45%>{{vo.goods_delivery}}</td>
                      </tr>
                      <tr>
                        <th width=25%>수량</th>
                        <td width=45%></td>
                      </tr>
                      <tr>
                        <th width=25%>총금액</th>
                        <td width=45%></td>
                      </tr>
                      <tr>
                        
                        <td colspan="2"></td>
                      </tr>
                    </table>
                    
                    </div>
                </div>
            </div>
        </div>
        
        <%--  댓글 위치 --%>
        <div style="height: 10px"></div>
            <div id="replyApp">
              <%-- 댓글 : Vue --%>
              <!-- Comment Area Start -->
                            <div class="comment_area section_padding_50 clearfix">
                                

                                <ol>
                                    <!-- Single Comment Area -->
                                    <li class="single_comment_area" v-for="rvo in reply_list">
                                        <div class="comment-wrapper d-flex" v-if="rvo.group_step===0">
                                            <!-- Comment Meta -->
                                            <div class="comment-author">
                                                <img :src="rvo.sex==='남자'?'../img/man.png':'../img/woman.png'" alt="">
                                            </div>
                                            <!-- Comment Content -->
                                            <div class="comment-content">
                                                <span class="comment-date text-muted">{{rvo.dbday}}</span>
                                                <h5>{{rvo.username}}</h5>
                                                <p>{{rvo.msg}}</p>
                                                <button v-if="sessionId===rvo.userid" class="btn-xs btn-danger update" style="margin-left: 2px" :id="'u'+rvo.no" @click="replyUpdateForm(rvo.no)">Update</button>
                                                <button v-if="sessionId===rvo.userid" class="btn-xs btn-info" style="margin-left: 2px" @click="replyDelete(rvo.no)">Delete</button>
                                                <button v-if="sessionId!==''" class="btn-xs btn-success insert" style="margin-left: 2px" :id="'i'+rvo.no" @click="replyReplyInsertForm(rvo.no)">Reply</button>
                                                <%-- 수정창 --%>
                                                <table class="table ups" style="display:none" :id="'up'+rvo.no">
			                                     <tr>
			                                      <td>
			                                       <textarea rows="4" cols="45" style="float: left" :id="'umsg'+rvo.no">{{rvo.msg}}</textarea>
			                                       <input type="button" value="수정"
			                                        style="float: left;background-color: blue;color:white;width: 80px;height: 94px"
			                                         @click="replyUpdate(rvo.no)"
			                                        >
			                                      </td>
			                                     </tr>
			                                    </table>
                                                <%-- 대댓글창 --%>
                                                <table class="table ins" style="display:none" :id="'in'+rvo.no">
			                                     <tr>
			                                      <td>
			                                       <textarea rows="4" cols="45" style="float: left" :id="'imsg'+rvo.no"></textarea>
			                                       <input type="button" value="댓글"
			                                        style="float: left;background-color: blue;color:white;width: 80px;height: 94px"
			                                         @click="replyReplyInsert(rvo.no)"
			                                        >
			                                      </td>
			                                     </tr>
			                                    </table>
                                            </div>
                                        </div>
                                        <ol class="children" v-if="rvo.group_step>0">
                                            <li class="single_comment_area">
                                                <div class="comment-wrapper d-flex">
                                                    <!-- Comment Meta -->
                                                    <div class="comment-author">
		                                                <img :src="rvo.sex==='남자'?'../img/man.png':'../img/woman.png'" alt="">
		                                            </div>
		                                            <!-- Comment Content -->
		                                            <div class="comment-content">
		                                                <span class="comment-date text-muted">{{rvo.dbday}}</span>
		                                                <h5>{{rvo.username}}</h5>
		                                                <p>{{rvo.msg}}</p>
		                                                <button v-if="sessionId===rvo.userid" class="btn-xs btn-danger update" style="margin-left: 2px" :id="'u'+rvo.no" @click="replyUpdateForm(rvo.no)">Update</button>
                                                        <button v-if="sessionId===rvo.userid" class="btn-xs btn-info" style="margin-left: 2px" @click="replyDelete(rvo.no)">Delete</button>
		                                                <table class="table ups" style="display:none" :id="'up'+rvo.no">
					                                     <tr>
					                                      <td>
					                                       <textarea rows="4" cols="45" style="float: left" :id="'umsg'+rvo.no">{{rvo.msg}}</textarea>
					                                       <input type="button" value="수정"
					                                        style="float: left;background-color: blue;color:white;width: 80px;height: 94px"
					                                         @click="replyUpdate(rvo.no)"
					                                        >
					                                      </td>
					                                     </tr>
					                                    </table>
		                                            </div>
                                                </div>
                                            </li>
                                        </ol>
                                    </li>
                                    
                                </ol>
                            </div>

                            <!-- Leave A Comment -->
                            
                            <c:if test="${sessionScope.userid!=null }">
                             <div class="leave-comment-area section_padding_50 clearfix">
                                <div class="comment-form">
                                    <table class="table">
                                     <tr>
                                      <td>
                                       <textarea rows="4" cols="70" style="float: left" ref="msg" v-model="msg"></textarea>
                                       <input type="button" value="댓글"
                                        style="float: left;background-color: blue;color:white;width: 80px;height: 94px"
                                         @click="replyInsert()"
                                        >
                                      </td>
                                     </tr>
                                    </table>
                                </div>
                             </div>
                            </c:if>

            </div>
                   
    </section>
    <script>
    let replyApp=Vue.createApp({
   	 data(){
   		 return {
   			 vo:{},
   			 reply_list:[],
   			 cno:${no},
   			 type:3,
   			 curpage:1,
   			 sessionId:'${sessionId}',
   			 totalpage:0,
   			 startPage:0,
   			 endPage:0,
   			 msg:'',
   			 upReply:false,
   			 inReply:false
   		 }
   	 },
   	 mounted(){
   		 axios.get("../goods/detail_vue.do",{
   			 params:{
   				 no:this.cno
   			 }
   		 }).then(res=>{
   			 this.vo=res.data
   		 }).catch(error=>{
   			 console.log(error.response)
   		 })
   		 
   		 this.dataRecv()
   	 },
   	 methods:{
   		 replyDelete(no){
   			 //alert("no:"+no)
   			 axios.get('../comment/delete_vue.do',{
   				 params:{
   					 no:no,
   					 cno:this.cno,
   					 type:this.type
   				 }
   			 }).then(res=>{
   				 console.log(res.data)
   				 // res.data=Map {list=[],curpage:1....}
   				 this.reply_list=res.data.list
   				 this.curpage=res.data.curpage
   				 this.totalpage=res.data.totalpage
   				 this.startPage=res.data.startPage
   				 this.endPage=res.data.endPage
   				 
   			 }).catch(error=>{
   				 console.log(error.response)
   			 })
   		 },
   		 replyReplyInsertForm(no){
   			 $('.ins').hide()
   			 $('.insert').text("Reply")
   			 $('.ups').hide()
   			 $('.update').text("Update")
   			 if(this.inReply===false)
   			 {
   				 this.inReply=true
   				 $('#in'+no).show()
   				 $('#i'+no).text("Cancel")
   			 }
   			 else
   			 {
   				 this.inReply=false
   				 $('#in'+no).hide()
   				 $('#i'+no).text("Reply")
   			 }
   		 },
   		 replyReplyInsert(no){
   			 let msg=$('#imsg'+no).val()
   			 if(msg.trim()==="")
   			 {
   				 $('#imsg'+no).focus()
   				 return
   			 }
   			 axios.post('../comment/reply_insert_vue.do',null,{
   				 params:{
   					 pno:no,
   					 cno:this.cno,
   					 type:this.type,
   					 msg:msg
   				 }
   			 }).then(res=>{
   				 console.log(res.data)
   				 // res.data=Map {list=[],curpage:1....}
   				 this.reply_list=res.data.list
   				 this.curpage=res.data.curpage
   				 this.totalpage=res.data.totalpage
   				 this.startPage=res.data.startPage
   				 this.endPage=res.data.endPage
   				 $('#imsg'+no).val("")
   				 // textarea
   				 $('#in'+no).hide()
   				 // table
   				 $('#i'+no).text("Reply")
   				 // Button
   			 }).catch(error=>{
   				 console.log(error.response)
   			 })
   		 },
   		 replyUpdate(no){
   			 let msg=$('#umsg'+no).val()
   			 if(msg.trim()==="")
   			 {
   				 $('#umsg'+no).focus()
   				 return
   			 }
   			 
   			 axios.post('../comment/update_vue.do',null,{
   				 params:{
   					 no:no,
   					 cno:this.cno,
   					 type:this.type,
   					 msg:msg
   				 }
   			 }).then(res=>{
   				 console.log(res.data)
   				 // res.data=Map {list=[],curpage:1....}
   				 this.reply_list=res.data.list
   				 this.curpage=res.data.curpage
   				 this.totalpage=res.data.totalpage
   				 this.startPage=res.data.startPage
   				 this.endPage=res.data.endPage
   				 $('#umsg'+no).val("")
   				 // textarea
   				 $('#up'+no).hide()
   				 // table
   				 $('#u'+no).text("Update")
   				 // Button
   			 }).catch(error=>{
   				 console.log(error.response)
   			 })
   		 },
   		 replyUpdateForm(rno){
   			 $('.ins').hide()
   			 $('.insert').text("Reply")
   			 $('.ups').hide()
   			 $('.update').text("Update")
   			 if(this.upReply===false)
   			 {
   				 this.upReply=true
   				 $('#up'+rno).show()
   				 $('#u'+rno).text("Cancel")
   			 }
   			 else
   			 {
   				 this.upReply=false
   				 $('#up'+rno).hide()
   				 $('#u'+rno).text("Update")
   			 }
   		 },
   		 replyInsert(){
   			 /*
   			    데이터 읽기 쓰기 => data()안 있는 변수 
   			                => v-model
   			    해당 태그 제어 
   			     => ref
   			     => $refs.ref명...
   			 */
   			 if(this.msg==='')
   			 {
   				 this.$refs.msg.focus()
   				 return
   			 }
   			 // 데이터를 서버로 전송 
   			 axios.post('../comment/insert_vue.do',null,{
   				 params:{
   					 cno:this.cno,
   					 type:this.type,
   					 msg:this.msg
   				 }
   			 }).then(res=>{
   				 console.log(res.data)
   				 // res.data=Map {list=[],curpage:1....}
   				 this.reply_list=res.data.list
   				 this.curpage=res.data.curpage
   				 this.totalpage=res.data.totalpage
   				 this.startPage=res.data.startPage
   				 this.endPage=res.data.endPage
   				 this.msg=''
   			 }).catch(error=>{
   				 console.log(error.response)
   			 })
   		 },
   		 dataRecv(){
   			 axios.get("../comment/list_vue.do",{
   				 params:{
   					page:this.curpage,
   					cno:this.cno,
   					type:this.type
   				 }
   			 }).then(res=>{
   				 console.log(res.data)
   				 // res.data=Map {list=[],curpage:1....}
   				 this.reply_list=res.data.list
   				 this.curpage=res.data.curpage
   				 this.totalpage=res.data.totalpage
   				 this.startPage=res.data.startPage
   				 this.endPage=res.data.endPage
   				 
   			 }).catch(error=>{
   				 console.log(error.response)
   			 })
   		 }
   	 }
    }).mount("#detailApp")
    
    </script>
</body>
</html>