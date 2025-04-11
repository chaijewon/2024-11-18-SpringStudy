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
    <input type="checkbox" value="N" v-model="ss">업체명
    <input type="checkbox" value="A" v-model="ss">주소
    <input type="checkbox" value="T" v-model="ss">음식종류
    <input type=text size=15 class="input-sm"
      ref="fd" v-model="fd" @keyup.enter="find()">
    <input type="button" class="btn-sm btn-primary"
     value="검색" @click=find()>
   </div> 
   <div style="height:10px"></div>
   <div class="row">
     <div class="col-sm-8">
      <div class="col-md-3" v-for="vo in food_list">
		    <div class="thumbnail">
		      <a href="#">
		        <img :src="'http://www.menupan.com'+vo.poster" style="width:230px;height: 180px">
		        <div class="caption">
		          <p>{{vo.name}}</p>
		        </div>
		      </a>
		    </div>
		  </div>
     </div>
     <div class="col-sm-4">
       
     </div>
   </div>
  </div>
  <script>
   let foodApp=Vue.createApp({
	   data(){
		   return {
			  ss:[],
			  fd:'',
			  curpage:1,
			  food_list:[]
		   }
	   },
	   mounted(){
		   
	   },
	   updated(){
		   
	   },
	   methods:{
		   find(){
			   let formData = new FormData()
			   formData.append("page",this.curpage)
			   
			   formData.append("fd",this.fd)
			   for(let i=0;i<this.ss.length;i++)
			   {
				   formData.append("ss",this.ss[i])
			   }
			   
			   axios.post('list_vue.do',
			        formData
			   ).then(res=>{
				   console.log(res.data)
				   this.food_list=res.data
			   })
		   }
	   }
   }).mount(".container-fluid")
  </script>
</body>
</html>