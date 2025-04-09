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

</style>
</head>
<body>
   <div class="container">
     <div class="row">
      <table class="table">
       <tr>
        <td class="text-center">
         <img :src="detail_vo.poster" style="width: 750px;height: 350px">
        </td>
       </tr>
       <tr>
        <td class="text-center"><h3 id="name">{{detail_vo.title}}</h3></td>
       </tr>
       <tr>
        <td>{{detail_vo.msg}}</td>
       </tr>
       <tr>
        <td>{{detail_vo.address}}</td>
       </tr>
      </table>
     </div>
   </div>
   <script>
    let detailApp=Vue.createApp({
    	data(){
    		return {
    		   no:${param.no},
    		   type:${param.type},
    		   detail_vo:{}
    		}
    	},
    	mounted(){
    		axios.get('http://localhost:8080/web/seoul/detail_vue.do',{
    			params:{
    				no:this.no,
    				type:this.type
    			}
    		}).then(response=>{
    			console.log(response.data)
    			this.detail_vo=response.data
    		}).catch(error=>{
    			console.log(error.response)
    		})
    	},
    	methods:{
    		
    	}
    }).mount(".container")
   </script>
</body>
</html>