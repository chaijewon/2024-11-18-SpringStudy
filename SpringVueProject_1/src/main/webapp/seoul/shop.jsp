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
  width: 960px
}
p{
   overflow: hidden;
   white-space: nowrap;
   text-overflow: ellipsis;
}
.nav-link:hover{
   cursor: pointer;
}
</style>
</head>
<body>
  <div class="container" id="app">
    
    <div class="row">
     <div class="col-sm-3" v-for="vo in list">
       <div class="thumbnail">
        <a :href="'../seoul/location_detail.do?no='+vo.no">
         <img :src="vo.poster" style="width:230px;height:130px">
         <p>{{vo.title}}</p>
        </a>
       </div>
     </div>
    </div>
    <div style="height: 10px"></div>
    <%--
          v-for="i in endPage"  1~10
     --%>
    <div class="row text-center">
     <ul class="pagination">
       <li v-if="startPage>1"><a class="nav-link" @click="prev()">&lt;</a></li>
       <li v-for="i in range(startPage,endPage)" :class="i===curpage?'active':''"><a class="nav-link" @click="pageChange(i)">{{i}}</a></li>
       <li v-if="endPage<totalpage"><a class="nav-link" @click="next()">&gt;</a></li>
     </ul>
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
            list:[],
            curpage:1,
            totalpage:0,
            startPage:0,
            endPage:0
            
         }
      },
      mounted(){
          this.dataRecv()
      },
     
      methods:{
         async dataRecv(){
            const res= await axiosClient.get('seoul/shop_vue.do',{
               params:{
                  page:this.curpage
               }
            })
            console.log(res)
            this.list=res.data.list
            console.log(res.data.list)
            this.curpage=res.data.curpage
            this.totalpage=res.data.totalpage
            this.startPage=res.data.startPage
            this.endPage=res.data.endPage
            
         },
         range(start,end){
            let arr=[]
            let len=end-start
            for(let i=0;i<=len;i++)
            {
                 arr[i]=start
                 start++
            }
            return arr
         },
         prev(){
            this.curpage=this.startPage-1
            this.dataRecv()
         },
         next(){
            this.curpage=this.endPage+1
            this.dataRecv()
         },
         pageChange(page){
            this.curpage=page
            this.dataRecv()
         }
        
      }
   })
   app.mount("#app")
  </script>
</body>
</html>