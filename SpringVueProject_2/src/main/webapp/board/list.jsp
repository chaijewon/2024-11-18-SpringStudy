<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<style type="text/css">
.container{
   margin-top: 50px;
}
.row {
   margin: 0px auto;
   width: 800px;
}
h3{
  text-align: center;
}
</style>
</head>
<body>
   <div class="container">
     <div class="row">
       <h3>{{msg}}</h3>
       <table class="table">
        <tr>
         <td>
           <a href="/board/insert" class="btn btn-sm btn-danger">새글</a>
         </td>
        </tr>
       </table>
       <table class="table">
        <tr>
         <th width=10% class="text-center">번호</th>
         <th width=45% class="text-center">제목</th>
         <th width=15% class="text-center">이름</th>
         <th width=20% class="text-center">작성일</th>
         <th width=10% class="text-center">조회수</th>
        </tr>
        <tr v-for="vo in list">
          <td width=10% class="text-center">{{vo.no}}</td>
          <td width=45%>{{vo.subject}}</td>
          <td width=15% class="text-center">{{vo.name}}</td>
          <td width=20% class="text-center">{{vo.dbday}}</td>
          <td width=10% class="text-center">{{vo.hit}}</td>
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
   const app=createApp({
      data(){
         return {
            list:[],
            curpage:1,
            totalpage:0,
            msg:''
         }
      },
      mounted(){
          this.dataRecv()
      },
      methods:{
         async dataRecv(){
            const res= await axios.get('/board/list_vue/'+this.curpage)
            console.log(res)
            this.msg=res.data.msg
            this.curpage=res.data.curpage
            this.totalpage=res.data.totalpage
            this.list=res.data.list
         }
      }
   })
   app.mount(".container")
</script>  
</body>
</html>




