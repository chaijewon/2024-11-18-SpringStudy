<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
 margin-top: 50px;
}
.row{
  margin: 0px auto;
  width: 800px;
}
</style>
</head>
<body>
  <div class="container">
   <div class="row">
    <table class="table">
      <tr>
       <td>
        <a href="insert.do" class="btn btn-sm btn-danger">등록</a>
       </td>
      </tr>
    </table>
   </div>
   <div class="row">
    <table class="table">
      <tr>
       <th width=10% class="text-center">번호</th>
       <th width=40% class="text-center">제목</th>
       <th width=15% class="text-center">이름</th>
       <th width=15% class="text-center">작성일</th>
       <th width=10% class="text-center">조회수</th>
       <th width=10% class="text-center"></th>
      </tr>   
      <tr v-for="vo in board_list">
       <td width=10% class="text-center">{{vo.no}}</td>
       <td width=40%>{{vo.subject}}</td>
       <td width=15% class="text-center">{{vo.name}}</td>
       <td width=15% class="text-center">{{vo.dbday}}</td>
       <td width=10% class="text-center">{{vo.hit}}</td>
       <td width=10% class="text-center">{{vo.replycount}}</td>
      </tr>    
      <tr>
        <td colspan="6" class="text-center">
         {{curpage}} page / {{totalpage}} pages
        </td>
      </tr>
    </table>
   </div>
  </div>
  <script>
  let listApp=Vue.createApp({
	  data(){
		  return {
			  board_list:[],
			  curpage:1,
			  totalpage:0
		  }
	  },
	  /*
	     axios.post('list.do',null,{
			  params:{
				  
			  }
		  })  
	  */
	  mounted(){
		  axios.get('list_vue.do',{
			  params:{
				  page:this.curpage
			  }
		  }).then(response=>{
			  console.log(response.data)
			  this.board_list=response.data.list
			  this.curpage=response.data.curpage
			  this.totalpage=response.data.totalpage
		  }).catch(error=>{
			  console.log(error.response)
		  })
	  }
  }).mount(".container")
  </script>
</body>
</html>


