<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
 margin-top: 50px;
}
.row{
  margin: 0px auto;
  width: 300px;
}
h3{
  text-align: center;
}
</style>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
  <div class="container">
    <div class="row">
     <h3>삭제하기</h3>
     <table class="table">
      <tr>
       <td width=30%>비밀번호</td>
       <td width=70%>
        <input type="password" name=pwd size=20
         class="input-sm" v-model="pwd" ref="pwd">
       </td>
      </tr>
      <tr>
        <td colspan="2" class="text-center">
         <input type=button value="삭제" class="btn-sm btn-danger"
          @click="boardDel()" 
         >
         <input type=button value="취소" 
         onclick="javascript:history.back()" class="btn-sm btn-primary">
        </td>
      </tr>
     </table>
    </div>
  </div>
  <script>
    let deleteApp=Vue.createApp({
    	data(){
    		return {
    			no:${no},
    			pwd:''
    		}
    	},
    	methods:{
    		boardDel:function(){
    		  if(this.pwd==="")
    		  {
    			  this.$refs.pwd.focus() //$('#pwd').focus()
    			  return
    		  }
    		  // axios.post()
    		  axios.get('delete_ok.do',{
    			  params:{
    				  no:this.no,
    				  pwd:this.pwd
    			  }
    		  }).then(response=>{
    			  // 결과값을 받아서 처리
    			  if(response.data==='yes')
    			  {
    				  location.href="list.do";
    			  }
    			  else
    		      {
    				  alert("비밀번호가 틀립니다")
    				  this.pwd=''
    				  this.$refs.pwd.focus()
    		      }
    		  })
    		}
    	}
    }).mount('.container')
  </script>
</body>
</html>