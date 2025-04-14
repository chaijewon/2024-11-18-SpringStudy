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
.container-fluid{
 margin-top: 50px;
}
.row{
  margin: 0px auto;
  width: 100%;
}
</style>
</head>
<body>
 <div id="app">
  <select ref="sel" v-model="sel">
   <option>1</option>
   <option>2</option>
   <option>3</option>
  </select><p>
  total:<span>{{won}}</span>
  </div>
  <script>
    let app=Vue.createApp({
    	data(){
    		return {
    			val:20000,
    			sel:1
    		}
    	},
    	computed:{
    		won(){
    			return this.val*this.sel
    		}
    	}
    }).mount("#app")
  </script>
</body>
</html>