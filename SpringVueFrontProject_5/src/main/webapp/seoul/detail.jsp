<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
 margin-top: 50px;
}
.row{
  margin: 0px auto;
  width: 800px;
}

</style>
</head>
<body>
   <div class="container">
     <div class="row">
      <table class="table">
       <tr>
        <td class="text-center">
         <img :src="detail_vo.poster" style="width: 750px;height: 350px">
        </td>
       </tr>
       <tr>
        <td class="text-center"><h3 id="name">{{detail_vo.title}}</h3></td>
       </tr>
       <tr>
        <td>{{detail_vo.msg}}</td>
       </tr>
       <tr>
        <td>{{detail_vo.address}}</td>
       </tr>
      </table>
      <div id="map" style="width:100%;height:350px;"></div>
     </div>
   </div>
   <script>
    let detailApp=Vue.createApp({
    	data(){
    		return {
    		   no:${param.no},
    		   type:${param.type},
    		   detail_vo:{}
    		}
    	},
    	mounted(){
    		axios.get('http://localhost:8080/web/seoul/detail_vue.do',{
    			params:{
    				no:this.no,
    				type:this.type,
    				address:''
    			}
    		}).then(response=>{
    			console.log(response.data)
    			this.detail_vo=response.data.vo
    			this.address=response.data.address
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
    		}).catch(error=>{
    			console.log(error.response)
    		})
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
    		geocoder.addressSearch(this.address, function(result, status) {

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
    		}
    	}
    }).mount(".container")
   </script>
</body>
</html>