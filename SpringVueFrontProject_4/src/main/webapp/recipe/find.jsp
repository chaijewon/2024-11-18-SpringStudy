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
p{
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
}
</style>
</head>
<body>
  <div class="container">
    <div class="row">
     <input type="text" size=20 class="input-sm"
      ref="fd" v-model="fd" v-on:keyup.enter="find()">
    </div>
    <div style="height: 10px"></div>
    <div class="row">
      <div class="col-md-3" v-for="vo in recipe_list">
	    <div class="thumbnail">
	      <a href="#">
	        <img :src="vo.poster" style="width:230px;height: 250px">
	        <div class="caption">
	          <p>{{vo.title}}</p>
	        </div>
	      </a>
	    </div>
	  </div>
    </div>
    <div style="height: 10px"></div>
    <div class="row">
     <div class="text-center">
      <input type=button class="btn-sm btn-danger"
       value="이전" @click="prev()"
      >
      {{curpage}} page / {{totalpage}} pages
      <input type=button class="btn-sm btn-danger"
       value="다음" v-on:click="next()"
      >
     </div>
    </div>
  </div>
  <script>
    let app=Vue.createApp({
       data(){
    	   return {
    		   recipe_list:[],
    		   curpage:1,
    		   totalpage:0,
    		   fd:'디저트'
    	   }
       },
       // response.data={list:[],curpage:1,totalpage:100}
       mounted(){
    	   // 화면 시작과 동시에 데이터 전송 
    	   // => React  => ?page=1
    	   this.dataRecv()
       },
       // 사용자 정의 함수 => 이벤트 처리 
       methods:{
    	   find(){
    		 this.curpage=1
    		 if(this.fd==="")
    		 {
    			 this.$refs.fd.focus()// 태그를 가지고 온다 
    			 // $('#fd').focus()
    			 // document.querySelector("#fd").focus()
    			 return
    		 }
    		 this.dataRecv()
    	   },
    	   prev:function(){
    		   this.curpage=this.curpage>1?this.curpage-1:this.curpage
    		   this.dataRecv()
    	   },
    	   next(){
    		   
    		   this.curpage=this.curpage<this.totalpage?this.curpage+1:this.curpage
    		   this.dataRecv()
    	   },
    	   // ?page=1&fd=마포
    	   dataRecv(){
    		   axios.get('../recipe/find_vue.do',{
        		   params:{
        			   page:this.curpage,
        			   fd:this.fd
        		   }
        	   }).then(response=>{
        		   console.log(response.data)
        		   this.recipe_list=response.data.list
        		   this.curpage=response.data.curpage
        		   this.totalpage=response.data.totalpage
        	   }).catch(error=>{
     			  console.log(error.response)
     		   }) 
    	   }
       }
    }).mount(".container")
  </script>
</body>
</html>