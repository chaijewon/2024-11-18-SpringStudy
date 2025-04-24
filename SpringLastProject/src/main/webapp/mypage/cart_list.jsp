<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
</head>
<body>
<div class="breadcumb-nav">
        <div class="container" id="cartApp">
            <div class="row">
                <div class="col-12">
                  <table class="table">
                   <tr>
                    <th class="text-center">번호</th>
                    <th class="text-center"></th>
                    <th class="text-center">상품명</th>
                    <th class="text-center">가격</th>
                    <th class="text-center">수량</th>
             
                    <th class="text-center">구매일</th>
                    <th class="text-center">비고</th>
                   </tr>
                  <c:forEach var="vo" items="${list }">
                    <tr>
                     <td class="text-center">${vo.cno }</td>
                     <td class="text-center">
                      <img src="${vo.gvo.goods_poster }"
                        style="width: 35px;height: 35px">
                     </td>
                     <td>${vo.gvo.goods_name }</td>
                     <td class="text-center">
                      ${vo.gvo.goods_price }
                     </td>
                     <td class="text-center">
                      ${vo.account }
                     </td>
                     <td class="text-center">${vo.dbday }</td>
                     
                     <td class="text-center">
                      <input type=button value="구매" 
                        class="btn-sm btn-success" @click="buy(${vo.cno },'${vo.gvo.goods_name}','${vo.gvo.goods_price}')">
                      <a href="../mypage/cart_delete.do?cno=${vo.cno }" class="btn-sm btn-info">취소</a>
                     </td>
                    </tr>
                  </c:forEach>
                   
                  </table>
                </div>
            </div>
        </div>
 </div>
 <section class="single_blog_area section_padding_80" id="reserveApp">
    <div class="container">
      <div class="row justify-content-center ">
        <div class="col-12 col-lg-12">
           <div class="row no-gutters">
           </div>
        </div>
      </div>
    </div>
 </section>
 <script>
  var IMP = window.IMP; 
  IMP.init("imp68206770"); 
  let cartApp=Vue.createApp({
	  data(){
		return {
			price:0,
			name:'',
			cno:0
		}  
	  },
	  methods:{
		  buy(cno,name,price){
			  //console.log("name:"+name)
			  //console.log("price:"+price)
			  this.name=name;
			  let temp=price.replace("원","")
			  temp=temp.replace(",","")
			  this.price=parseInt(temp)
			  this.cno=cno
			  axios.get("../goods/buy_vue.do",{
				  params:{
					  cno:this.cno
				  }
			  }).then(res=>{
				  if(res.data==='yes')
				  {
					  this.requestPay(name,price)
				  }
				  else 
				  {
					  alert("구매 실패!!")
				  }
				  
			  })
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
			    	location.href="../mypage/buy_list.do"
			    });
			}
	  }
  }).mount("#cartApp")
 </script>
</body>
</html>