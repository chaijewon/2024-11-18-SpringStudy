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
   margin-top:50px;
}
.row {
   width: 960px;
   margin: 0px auto;
}
</style>
</head>
<body>
  <div class="container">
   <div class="row">
    <h3 class="text-center">v-if/v-else/v-elseif</h3>
    <input type=button class="btn-sm btn-danger" value="한식" @click="select(1)">
    <input type=button class="btn-sm btn-info" value="중식" v-on:click="select(2)">
    <input type=button class="btn-sm btn-success" value="일식" @click="select(3)">
    <input type=button class="btn-sm btn-warning" value="양식" @click="select(4)">
   </div>
  
  <!-- 
      v- : 디렉티브 => 태그안에서 처리 
      => 가장 단순한 방법 
   -->
  <div class="row">
    <div v-if="type===1">
     한식을 선택 
    </div>
    <div v-if="type===2">
     중식을 선택 
    </div>
    <div v-if="type===3">
     일식을 선택 
    </div>
    <div v-if="type===4">
     양식을 선택 
    </div>
  </div>
 </div>
  <script>
   let app=Vue.createApp({
	   data(){
		   return {
			   type:0
		   }
	   },
	   methods:{
		   select:function(no){
			   this.type=no
		   }
	   }
   }).mount(".container")
  </script>
</body>
</html>