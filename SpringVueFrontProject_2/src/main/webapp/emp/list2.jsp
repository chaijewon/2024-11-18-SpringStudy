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
h3{
  text-align: center;
}
</style>
</head>
<body>
  <%-- View --%>
  <div class="container">
      <div class="row">
        <h3 class="text-center">사원 목록</h3>
        <table class="table">
          <tr>
            <th>사번</th>
            <th>이름</th>
            <th>입사일</th>
            <th>직위</th>
            <th>급여</th>
          </tr>
        </table>
      </div>
   </div>
   <script>
    let app=Vue.createApp({
    	// Model => 데이터 관리 => VO
    	data(){
    		return {
    	      list:[]		
    		}
    	},
    	// ViewModel => 데이터 처리 => 서버에서 데이터 읽기,사용자 이벤트 처리 
    	// DAO
    	mounted(){
    		// => main메소드 => 서버에서 데이터 읽기 
    		axios.get('http://localhost:8080/web/emp/list_vue.do')
    		.then(response=>{
    			console.log(response)
    			// 실행된 데이터 읽기 => 
    			/*
    			   axios.get (post) : 요청 
    			   then : 응답 
    			*/
    		})
    	}
    }).mount(".container")
   </script>
</body>
</html>