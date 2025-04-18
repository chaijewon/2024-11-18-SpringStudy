<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap-vue-3@0.5.1/dist/bootstrap-vue-3.umd.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap-vue-3@0.5.1/dist/bootstrap-vue-3.min.css" rel="stylesheet">

</head>
<body>
  <div class="container" id="app">
   <div class="row">
     <input type=button class="btn btn-sm btn-danger"
       value="Click"
     >
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
            msg:'Hello BootStrap'      
         }
      },
      mounted(){
         
      },
      methods:{
         
      }
   })
   app.mount("#app")
  </script>
</body>
</html>