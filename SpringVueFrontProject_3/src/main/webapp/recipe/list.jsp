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
  <%--
    :src="'https://menupan.com'+vo.poster"
   --%>
  <div class="container">
   <div class="row">
     <div class="col-md-3" v-for="vo in list">
	    <div class="thumbnail">
	      <a href="#">
	        <img :src="vo.poster" style="width:230px;height: 200px">
	        <div class="caption">
	          <p>{{vo.title}}</p>
	        </div>
	      </a>
	    </div>
	  </div>
   </div>
  </div>
  <script>
    let app=Vue.createApp({
    	data(){
    		return {
    			list:[] //{}
    		}
    	},
    	// 시작과 동시에 데이터 읽기
    	mounted(){
    		axios.get("http://localhost:8080/web/recipe/list_vue.do")
    		.then(response=>{
    			this.list=response.data
    		})
    	}
    }).mount(".container")
  </script>
</body>
</html>