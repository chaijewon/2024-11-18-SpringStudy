<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.row{
  margin: 0px auto;
  width:800px;
}
</style>
</head>
<body>
  <div class="container" id="app">
    <div class="row">
     <table class="table">
      <tr>
        <td class="text-center" v-for="img in images">
         <img :src="'https://www.menupan.com'+img" style="width:100%">
        </td>
      </tr>
     </table>
     <table class="table">
       <tr>
        <td width=30% class="text-center" rowspan="8">
          <img :src="'https://www.menupan.com'+vo.poster" style="width: 240px;height: 300px">
        </td>
        <td width=70% colspan="2">
          <h3>{{vo.name}}&nbsp;<span style="color:orange">{{vo.score}}</span></h3>
        </td>
       </tr>
       <tr>
         <td width=20%>주소</td>
         <td width=50%>{{vo.address}}</td>
       </tr>
       <tr>
         <td width=20%>전화</td>
         <td width=50%>{{vo.phone}}</td>
       </tr>
       <tr>
         <td width=20%>음식종류</td>
         <td width=50%>{{vo.type}}</td>
       </tr>
       <tr>
         <td width=20%>가격대</td>
         <td width=50%>{{vo.price}}</td>
       </tr>
       <tr>
         <td width=20%>영업시간</td>
         <td width=50%>{{vo.time}}</td>
       </tr>
       <tr>
         <td width=20%>주차</td>
         <td width=50%>{{vo.parking}}</td>
       </tr>
       <tr>
         <td width=20%>테마</td>
         <td width=50%>{{vo.theme}}</td>
       </tr>
     </table>
     <table class="table">
       <tr>
         <td>{{vo.content}}</td>
       </tr>
     </table>
    </div>
  </div>
  <script type="module">
   import {createApp} from "https://unpkg.com/vue@3/dist/vue.esm-browser.js"
   import axiosClient from "../js/api.js"

   createApp({
       data(){
          return {
             fno:${fno},
             vo:{},
             images:[]
          }
       },
       mounted(){
           this.dataRecv()
       },
       methods:{
          async dataRecv(){
            const res=await axiosClient.get('food/detail_vue.do',{
               params:{
                  fno:this.fno
               }
            })
            console.log(res)
            this.vo=res.data
            this.images=res.data.images.split(",")
          }
       }
   }).mount("#app")
  </script>
</body>
</html>