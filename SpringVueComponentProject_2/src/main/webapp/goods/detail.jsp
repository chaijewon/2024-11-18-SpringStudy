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
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
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
        <td class="text-center" width=30% rowspan="5">
          <img :src="detail.goods_poster" style="width:100%">
        </td>
        <td colspan="2">{{detail.goods_name}}</td>
       </tr>
       <tr>
         <td colspan="2"><sup>{{detail.goods_sub}}</sup></td>
       </tr>
       <tr>
        <td width=25%>{{detail.goods_discount}}%</td>
        <td width=45%>{{detail.goods_price}}</td>
       </tr>
       <tr>
        <td width=25%>배송</td>
        <td width=45%>{{detail.goods_delivery}}</td>
       </tr>
       <tr>
         <td colspan="2">
          <input type=button value="구매하기" class="btn-lg btn-danger"
           @click="btnClick()"
          >
         </td>
       </tr>
     </table>
   </div>
  </div>
  <script>
   var IMP = window.IMP; 
   IMP.init("imp68206770"); 
   let app=Vue.createApp({
	   data(){
		   return {
			   no:${no},
			   detail:{},
			   price:0
		   }
	   },
	   mounted(){
		 axios.get("../goods/detail_vue.do",{
			 params:{
				 no:this.no
			 }
		 }).then(res=>{
			 console.log(res.data)
			 this.detail=res.data.detail
			 this.price=res.data.price
			 // 데이터가 2개이상이면 => Map
			 // => vo:{} , list:[]
		 }).catch(error=>{
			 console.log(error.response)
		 })
	   },
	   methods:{
		   btnClick(){
			   this.requestPay(this.detail.goods_name,this.price)
		       //this.requestPay()
		   },
		   requestPay(name,price) {
			    IMP.request_pay({
			        pg: "html5_inicis",
			        pay_method: "card",
			        merchant_uid: "ORD20180131-0000011",   // 주문번호
			        name: name,
			        amount: price,         // 숫자 타입
			        buyer_email: '',
			        buyer_name: '',
			        buyer_tel:'',
			        buyer_addr: '',
			        buyer_postcode: ''
			    }, function (rsp) { // callback
			    	//location.href='http://localhost/JSPLastProject/mypage/mypage_buy_list.do' 
			        alert("결재 완료!!")
			    });
			}
	   }
	   
   }).mount(".container")
  </script>
</body>
</html>


