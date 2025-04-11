<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
 margin-top: 50px;
}
.row{
  margin: 0px auto;
  width: 100%;
}
</style>
</head>
<body>
  <div class="container">
    <div class="row">
      <input type=checkbox value="사과" v-model="f">사과
      <input type=checkbox value="배" v-model="f">배
      <input type=checkbox value="딸기" v-model="f">딸기
      <input type=checkbox value="수박" v-model="f">수박
      <input type=checkbox value="메론" v-model="f">메론
      <div>선택된 과일:{{f}}</div>
      <div>선택된 갯수:{{len}}</div>
      <div>선택된 갯수:{{hello()}}</div>
    </div>
  </div>
  <script>
   let app=Vue.createApp({
	   data(){
		   return {
			   f:[]
		   }
	   },
	   computed:{
		   len:function(){
			   return this.f.length
		   }
	   },
	   methods:{
		   hello(){
			   return "Hello"
		   }
	   }
   }).mount(".container")
  </script>
</body>
</html>