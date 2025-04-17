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
<div id="app">
  
</div>
<script type="importmap">
  {
    "imports": {
      "vue": "https://unpkg.com/vue@3/dist/vue.esm-browser.js"
    }
  }
</script>
<script type="module">
import { createApp } from 'vue'
import axiosClient from '../js/ax.js'
const app = createApp({
  data() {
    return {
      food_list:[],
      curpage:1,
      totalpage:0,
      startPage:0,
      endPage:0,
      type:1,
      title:'한식'
    }
  },
  mounted(){
     const res=
        axiosClient.get('food/list_vue.do',{
           params:{
              type:this.type,
              page:this.curpage
           }   
     })
     console.log(res)
  }
})

app.mount('#app')
</script>

</body>
</html>
