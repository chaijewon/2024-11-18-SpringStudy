<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<style type="text/css">
.row{
  margin: 0px auto;
  width:800px;
}
</style>
</head>
<body>
  <div class="container" id="app">
    <div class="row">
     <table class="table">
      <tr>
        <td class="text-center" v-for="img in images">
         <img :src="'https://www.menupan.com'+img" style="width:100%">
        </td>
      </tr>
     </table>
     <table class="table">
       <tr>
        <td width=30% class="text-center" rowspan="8">
          <img :src="'https://www.menupan.com'+vo.poster" style="width: 240px;height: 300px">
        </td>
        <td width=70% colspan="2">
          <h3><span id="name">{{vo.name}}</span>&nbsp;<span style="color:orange">{{vo.score}}</span></h3>
        </td>
       </tr>
       <tr>
         <td width=20%>주소</td>
         <td width=50%>{{vo.address}}</td>
       </tr>
       <tr>
         <td width=20%>전화</td>
         <td width=50%>{{vo.phone}}</td>
       </tr>
       <tr>
         <td width=20%>음식종류</td>
         <td width=50%>{{vo.type}}</td>
       </tr>
       <tr>
         <td width=20%>가격대</td>
         <td width=50%>{{vo.price}}</td>
       </tr>
       <tr>
         <td width=20%>영업시간</td>
         <td width=50%>{{vo.time}}</td>
       </tr>
       <tr>
         <td width=20%>주차</td>
         <td width=50%>{{vo.parking}}</td>
       </tr>
       <tr>
         <td width=20%>테마</td>
         <td width=50%>{{vo.theme}}</td>
       </tr>
     </table>
     <table class="table">
       <tr>
         <td>{{vo.content}}</td>
       </tr>
     </table>
     <div id="map" style="width:100%;height:350px;"></div>
    </div>
  </div>
  <script type="module">
   import {createApp} from "https://unpkg.com/vue@3/dist/vue.esm-browser.js"
   import axiosClient from "../js/api.js"

   createApp({
       data(){
          return {
             fno:${fno},
             vo:{},
             images:[]
          }
       },
       mounted(){
           this.dataRecv()
       },
       methods:{
          addScript(){
    			const script=document.createElement("script")
    			/* global kakao */
    			script.onload=()=>kakao.maps.load(this.initMap)
    			script.src="http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=72fa81817487692b6dc093004af97650&libraries=services"
    		    document.head.appendChild(script)
    		},
    		initMap(){
    			var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    		    mapOption = {
    		        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
    		        level: 3 // 지도의 확대 레벨
    		    };  

    		// 지도를 생성합니다    
    		var map = new kakao.maps.Map(mapContainer, mapOption); 

    		// 주소-좌표 변환 객체를 생성합니다
    		var geocoder = new kakao.maps.services.Geocoder();

    		// 주소로 좌표를 검색합니다
    		geocoder.addressSearch(this.vo.address, function(result, status) {

    		    // 정상적으로 검색이 완료됐으면 
    		     if (status === kakao.maps.services.Status.OK) {

    		        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

    		        // 결과값으로 받은 위치를 마커로 표시합니다
    		        var marker = new kakao.maps.Marker({
    		            map: map,
    		            position: coords
    		        });

    		        // 인포윈도우로 장소에 대한 설명을 표시합니다
    		        var infowindow = new kakao.maps.InfoWindow({
    		            content: '<div style="width:150px;text-align:center;padding:6px 0;">'+$('#name').text()+'</div>'
    		        });
    		        infowindow.open(map, marker);

    		        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
    		        map.setCenter(coords);
    		    } 
    		});    
    	  },
          async dataRecv(){
            const res=await axiosClient.get('food/detail_vue.do',{
               params:{
                  fno:this.fno
               }
            })
            console.log(res)
            this.vo=res.data
            this.images=res.data.images.split(",")
            if(window.kakao && window.kakao.maps)
    		{
    			console.log("initMap()")
    			this.initMap()
    		}
    		else
    		{
    			console.log("addScript()")
    			this.addScript()
    		}
          }
       }
   }).mount("#app")
  </script>
</body>
</html>