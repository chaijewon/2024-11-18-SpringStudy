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
  <div class="container">
   <div class="row">
     <table class="table">
       <tr>
        <td colspan="3" class="text-center">
         <img :src="recipe_vo.poster" style="width:800px;height:250px">
        </td>
       </tr>
       <tr>
         <td colspan="3" class="text-center">
          <h3>{{recipe_vo.title}}</h3>
         </td> 
       </tr>
       <tr>
         <td colspan="3" class="text-center" style="color:gray">
          {{recipe_vo.content}}
         </td> 
       </tr>
       <tr>
         <td class="text-center"><img src="a1.png"></td>
         <td class="text-center"><img src="a2.png"></td>
         <td class="text-center"><img src="a3.png"></td>
       </tr>
       <tr>
         <td class="text-center">{{recipe_vo.info1}}</td>
         <td class="text-center">{{recipe_vo.info2}}</td>
         <td class="text-center">{{recipe_vo.info3}}</td>
       </tr>
     </table>
     <table class="table">
      <tr>
       <td><h3>[재료]</h3>
      </tr>
      <tr>
       <td>
         <ul>
          <li v-for="d in data_list">{{d}}</li>
         </ul>
       </td>
      </tr>
     </table>
     <table class="table">
      <tr>
       <td>
        <table class="table" v-for="(m,index) in food_make">
          <tr>
           <td width=80% class="text-left">{{m}}</td>
           <td width=20% class="text-right">
            <img :src="image_list[index]" style="width:120px;height: 80px">
           </td>
          </tr>
        </table>
       </td>
      </tr>
     </table>
   </div>
  </div>
  <script>
   let detailApp=Vue.createApp({
	   data(){
		   return {
			   no:${param.no},
			   recipe_vo:{},
			   image_list:[],
			   food_make:[],
			   data_list:[]
		   }
	   },
	   /*
	     "data":"우리한우 구이용 150g 구매,양배추 60g 구매,당근 1/3개 구매,노랑파프리카 1/2개 구매,청피망 1/2개 구매,마늘 2알 구매,생강 마늘크기만한것 조금 구매,청주 1작은술 구매,간장 1큰술 구매,참기름 1/2작은술 구매,후춧가루 1/4작은술 구매,굴소스 2큰술 구매,청주 1큰술 구매,참기름 1작은술 구매"
	   */
	   mounted(){
		   axios.get('../recipe/detail_vue.do',{
			   params:{
				   no:this.no
			   }
		   })//  데이터값 받기 
		   .then(res=>{
			   console.log(res.data)
			   this.recipe_vo=res.data.vo
			   this.food_make=res.data.mList
			   this.image_list=res.data.iList
			   this.data_list=res.data.vo.data.split(",")
		   })
		   .catch(error=>{
			   console.log(error.response)
		   })
		     //  에러 처리
	   },
	   methods:{
		   
	   }
   }).mount(".container")
  </script>
</body>
</html>