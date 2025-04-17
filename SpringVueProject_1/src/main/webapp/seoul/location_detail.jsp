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
  width: 800px;
}
</style>
</head>
<body>
  <div class="container" id="detail">
    <div class="row" >
     <table class="table">
      <tr>
       <td class="text-center" colspan="3">
        <img :src="vo.poster" style="width:750px;height: 300px">
       </td>
      </tr>
      <tr>
        <td class="text-center" colspan="3">
          <h3>{{vo.title}}</h3>
        </td>
      </tr>
      <tr>
        <td class="text-center" colspan="3">
          <span style="color:gray">{{vo.msg}}</span>
        </td>
      </tr>
      <tr>
        <td class="text-center" colspan="3">
          {{vo.address}}
        </td>
      </tr>
     </table>
    </div>
    <div class="row">
     <h3>인근 맛집</h3>
     <hr>
     <div class="col-sm-3" v-for="fvo in food_list">
       <div class="thumbnail">
        <a :href="'../food/detail.do?fno='+fvo.fno">
         <img :src="'https://www.menupan.com'+fvo.poster" style="width:230px;height:130px">
         <p>{{fvo.name}}</p>
        </a>
       </div>
     </div>
    </div>
   </div>
   <script type="importmap">
   {
     "imports":{
       "vue":"https://unpkg.com/vue@3/dist/vue.esm-browser.js"
     }
   }
  </script>
  <script type="module">
   import {createApp} from "vue"
   import axiosClient from "../js/api.js"
   const app=createApp({
      data(){
         return {
           no:${no},
           vo:{},
           food_list:[],
           address:'',
           count:0
         }
      },
      mounted(){
         this.dataRecv()
      },
      methods:{
         async dataRecv(){
            const res= await axiosClient.get('seoul/loc_detail_vue.do',{
              params:{
                 no:this.no
              }
           })
           console.log(res)
           this.vo=res.data.vo
           this.food_list=res.data.list
           this.count=res.data.count
         }
      }
   })
   app.mount("#detail")
  </script>
</body>
</html>