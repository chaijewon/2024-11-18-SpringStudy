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
  width: 960px;
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
      <div class="text-center">
       <input type="button" value="명소" class="btn-lg btn-success" @click="seoul(1)">
       <input type="button" value="자연" class="btn-lg btn-info" @click="seoul(2)">
       <input type="button" value="쇼핑" class="btn-lg btn-warning" @click="seoul(3)">
       <input type="button" value="음식" class="btn-lg btn-danger" @click="seoul(4)">
      </div>
     </div>
     <div style="height: 10px"></div>
     <div class="row">
       <h3 class="text-center">{{title}}</h3>
       <div class="col-md-3" v-for="vo in seoul_list">
	    <div class="thumbnail">
	      <a :href="'../seoul/detail.do?no='+vo.no">
	        <img :src="vo.poster" style="width:230px;height: 180px">
	        <div class="caption">
	          <p>{{vo.title}}</p>
	        </div>
	      </a>
	    </div>
	  </div>
     </div>
     <div style="height: 10px"></div>
     <div class="row">
      
     </div>
   </div>
   <script>
     let listApp=Vue.createApp({
    	 data(){
    		 return {
    			 seoul_list:[],
    			 curpage:1,
    			 totalpage:0,
    			 startPage:0,
    			 endPage:0,
    			 type:1,
    			 title:'서울 명소'
    		 }
    	 },
    	 mounted(){
    		 // 시작과 동시에 한페이지 읽기
    		 this.dataRecv()
    	 },
    	 // updated
    	 // Vue의 멤버함수 
    	 methods:{
    		seoul(type){
    			this.type=type
    			this.curpage=1
    			this.dataRecv()
    		},
    		dataRecv(){
    			//let _this=this
    			axios.get("http://localhost:8080/web/seoul/list_vue.do",{
    				params:{
    					page:this.curpage,
    					type:this.type
    				}
    			}).then(response=>{
    				console.log(response.data)
    				this.seoul_list=response.data.list;
    				this.title=response.data.title
    			}).catch(function(error){
    				console.log(error.response)
    			})
    		}
    	 }
    	 // watch / computed / components
     }).mount(".container")
   </script>
</body>
</html>