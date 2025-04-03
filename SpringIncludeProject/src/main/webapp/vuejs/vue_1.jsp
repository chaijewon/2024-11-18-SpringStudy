<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<!-- <script type="text/javascript">
$(function(){
	$('#msg').keyup(function(){
		let msg=$('#msg').val()
		$('#print').text(msg)
	})
})
</script> -->
</head>
<body>
 <div id="container">
   <input type=text size=30 v-model="msg">
   <div id="print">{{msg}}</div>
 </div>
  <script>
   let app1=Vue.createApp({
	   data(){
		   return {
			   msg:''
		   }
	   },   
	   mounted:function(){
		   alert("Hello Vue")
	   }
   }).mount('#container')
   
  </script>
</body>
</html>