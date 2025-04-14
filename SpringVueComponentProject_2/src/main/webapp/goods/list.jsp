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
p{
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
}
</style>
<script src="../js/page-card.js"></script>
</head>
<body>
  <div class="container">
    <div class="row">
      <div class="col-md-3" v-for="vo in list">
		    <div class="thumbnail">
		      <a href="#">
		        <img :src="vo.goods_poster" style="width:230px;height: 130px">
		        <div class="caption">
		          <p>{{vo.goods_name}}</p>
		        </div>
		      </a>
		    </div>
		  </div>
    </div>
    <div style="height: 10px"></div>
    <div class="row">
     <div class="text-center">
       <page-card></page-card>
     </div>
    </div>
  </div>
  <script>
   let app=Vue.createApp({
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
		// 이전 
   		prev(){
   			this.curpage=this.startPage-1
   			this.dataRecv()
   		},
   		// 다음 
   		next(){
   		   this.curpage=this.endPage+1
   		   this.dataRecv()
   		},
   		// 1 2 3 4 => 페이지 클릭 
   		pageChange(page){
   			this.curpage=page
   			this.dataRecv()
   		},
   		// 블럭별 페이지 나누기 
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
		   dataRecv(){
			   axios.get("../goods/list_vue.do",{
				   params:{
					   page:this.curpage
				   }
			   }).then(res=>{
				   console.log(res.data)
	               this.list=res.data.list
	               this.curpage=res.data.curpage
	               this.totalpage=res.data.totalpage
	               this.startPage=res.data.startPage
	               this.endPage=res.data.endPage
			   }).catch(error=>{
				   console.log(error.response)
			   })
		   }
	   },
	   components:{
		   'page-card':page_card
	   }
   }).mount(".container")
  </script>
</body>
</html>