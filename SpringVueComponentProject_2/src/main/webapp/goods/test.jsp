<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
 margin-top: 50px;
}
.row{
  margin: 0px auto;
  width: 100%;
}

</style>
</head>
<body>
  <div class="container">
    <div class="row">
     <table class="table">
      <tr>
        <td>
        수량:<select class="input-sm" v-model="sel">
            <option>1</option>
            <option>2</option>
            <option>3</option>
            <option>4</option>
            <option>5</option>
        </select>
        </td>
      </tr>
      <tr>
        <td>
         총금액:<span>{{total}}</span>
        </td>
      </tr>
     </table>
    </div>
  </div>
  <script>
    let app=Vue.createApp({
    	data(){
    		return {
    			sel:1,
    			price:25000
    		}
    	},
    	// 데이터 변경 (상태)
    	computed:{
    		total:function(){
    			return this.sel*this.price
    		}
    	},
    	// 부수 효과 => 데이터 변경시에 처리하는 내용
    	watch:{
    		// 지정된 데이터가 변경이 될때 수행 => 비동기적 
    		sel(){
    			console.log("수량변경:"+this.sel)
    		}
    	}
    }).mount(".container")
  </script>
</body>
</html>