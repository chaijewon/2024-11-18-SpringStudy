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
  <div class="container">
    <div class="row" id="detail">
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
          <span style="color:gray">{{vo.content}}</span>
        </td>
      </tr>
      <tr>
        <td class="text-center"><img src="icon/a1.png"></td>
        <td class="text-center"><img src="icon/a2.png"></td>
        <td class="text-center"><img src="icon/a3.png"></td>
      </tr>
      <tr>
        <td class="text-center">{{vo.info1}}</td>
        <td class="text-center">{{vo.info2}}</td>
        <td class="text-center">{{vo.info3}}</td>
      </tr>
     </table>
     <table class="table">
      <tr>
       <td><h3>[재료]</h3></td>
      </tr>
      <tr>
        <td>
         <ul>
          <li v-for="d in rdata">{{d}}</li>
         </ul>
        </td>
      </tr>
     </table>
     <table class="table">
       <tr>
         <td><h3>[조리순서]</h3></td>
       </tr>
       <tr>
        <td>
          <table class="table" v-for="(m,index) in mlist">
           <tr>
             <td class="text-left" width="80%">{{m}}</td>
             <td class="text-right" width="20%">
               <img :src="ilist[index]" style="width: 120px;height: 80px">
             </td>
           </tr>
          </table>
        </td>
       </tr>
     </table>
     <table class="table">
       <tr>
         <td colspan="2"><h3>[레시피 작성자]</h3></td>
       </tr>
       <tr>
         <td width="30%" class="text-center">
          <img :src="vo.chef_poster" style="width: 50px;height: 50px" class="img-circle">
         </td>
         <td width=70%>
          {{vo.chef}}<br>
          <sub>{{vo.chef_profile}}</sub>
         </td>
       </tr>
     </table>
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
            mlist:[],
            ilist:[],
            rdata:[]
         }
      },
      mounted(){
         this.dataRecv()
      },
      methods:{
         async dataRecv(){
            const res= await axiosClient.get('recipe/detail_vue.do',{
              params:{
                 no:this.no
              }
           })
           console.log(res)
           this.vo=res.data.vo
           this.mlist=res.data.mlist
           this.ilist=res.data.ilist
           this.rdata=res.data.vo.data.split(",")
         }
      }
   })
   app.mount("#detail")
  </script>
</body>
</html>