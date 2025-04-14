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
  width: 350px;
}
h3{
  text-align: center;
}
</style>
</head>
<body>
  <div class="container">
    <div class="row">
      <h3>로그인</h3>
      <table class="table">
       <tr>
        <td width=20%>ID</td>
        <td width=80%>
         <input type="text" size=15 class="input-sm"
           ref="id" v-model="id">
        </td>
       </tr>
       <tr>
        <td width=20%>PW</td>
        <td width=80%>
         <input type="password" size=15 class="input-sm"
           ref="pwd" v-model="pwd">
        </td>
       </tr>
       <tr>
        <td colspan="2" class="text-center">
         <input type=button value="로그인"
          class="btn-sm btn-danger" @click="login()">
        </td>
       </tr>
      </table>
    </div>
  </div>
  <script>
    let app=Vue.createApp({
    	data(){
    		return {
    			id:'',
    			pwd:''
    		}
    	},
    	methods:{
    		login(){
    			if(this.id==="")
    			{
    				this.$refs.id.focus()
    				return
    			}
    			if(this.pwd==="")
    			{
    				this.$refs.pwd.focus()
    				return
    			}
    			let formData=new FormData()
    			formData.append("id",this.id)
    			formData.append("pwd",this.pwd)
    			axios.post('../member/login_vue.do',
    				 formData)
    				 .then(res=>{
    					if(res.data==='NOID')
    					{
    						alert("아이디가 존재하지 않습니다")
    						this.id=''
    						this.pwd=''
    						this.$refs.id.focus()
    					}
    					else if(res.data=='NOPWD')
    					{
    						alert("비밀번호가 틀립니다")
    						this.pwd=''
    						this.$refs.pwd.focus()
    					}
    					else
    					{
    						location.href="../chat/chat.do"
    					}
    				 })
    				 .catch(error=>{
    					 console.log(error.response)
    				 })
    		}
    	}
    }).mount(".container")
  </script>
</body>
</html>