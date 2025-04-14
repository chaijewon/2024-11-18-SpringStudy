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
   <div class="container-fluid">
    <div class="row">
      <div class="col-sm-8">
        <%-- --%> 
        <div style="height: 10px"></div>
        <div class="text-center">
         <%-- 페이지 출력 --%>
        </div>
      </div>
      <div class="col-sm-4">
        <%-- 상세보기:component --%>
      </div>
    </div>
   </div>
   <script>
     let foodApp=Vue.createApp({
    	data(){
    		return {
    			list:[],
    			curpage:1,
    			totalpage:0,
    			startPage:0,
    			endPage:0,
    			detail:{}
    		}
    	},
    	mounted(){
    		
    	},
    	methods:{
    		// 공통사용 
    		dataRecv(){
              axios.get("../food/list_vue.do",{
            	  params:{
            		  page:this.curpage
            	  }
              }).then(res=>{
            	  console.log(res.data)
            	  this.list=res.data.list
            	  this.curpage=res.data.curpage
            	  this.totalpage=res.data.totalpage
            	  this.startPage=res.data.startPage
            	  this.endPage=res.data.endPage
            	  
              }).catch(error=>{
            	  console.log(error.response)
              })  			
    		}
    	}
     }).mount(".container-fluid")
   </script>
</body>
</html>