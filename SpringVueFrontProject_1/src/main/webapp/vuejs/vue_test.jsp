<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
  <div id="app">{{message}}</div>
  <!-- <script>
  const { createApp, ref } = Vue

  createApp({
    setup() {
      const message = ref('Hello vue!')
      return {
        message
      }
    }
  }).mount('#app') -->
  <!-- <div id="app">{{ message }}</div> -->

<script type="module">
  import { createApp, ref } from 'https://unpkg.com/vue@3/dist/vue.esm-browser.js'
  createApp({
    setup() {
      //const message = ref('Hello Vue!')
      return {
        message:'Vue'
      }
    }
  }).mount('#app')
</script>
  
</script>
  
</body>
</html>