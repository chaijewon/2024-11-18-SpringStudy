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
      <h3>내용보기</h3>
      <table class="table">
        <tr>
          <th width=20% class="text-center">번호</th>
          <td width=30% class="text-center">{{vo.no}}</td>
          <th width=20% class="text-center">작성일</th>
          <td width=30% class="text-center">{{vo.dbday}}</td>
        </tr>
        <tr>
          <th width=20% class="text-center">이름</th>
          <td width=30% class="text-center">{{vo.name}}</td>
          <th width=20% class="text-center">조회수</th>
          <td width=30% class="text-center">{{vo.hit}}</td>
        </tr>
        <tr>
          <th width=20% class="text-center">제목</th>
          <td colspan="3">{{vo.subject}}</td>
        </tr>
        <tr>
          <td colspan="4" valign="top" height="200">
           <pre style="white-space: pre-wrap;">{{vo.content}}</pre>
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
   const app=createApp({
      data(){
         return {
            no:${no},
            vo:{}
         }
      },
      mounted(){
         this.dataRecv()
      },
      methods:{
         
         async dataRecv(){
            
            const res= await axios.get('/board/detail_vue/'+this.no)
            this.vo=res.data
            
         }
      }
   })
   app.mount(".container")
  </script>
</body>
</html>