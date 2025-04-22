<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href='https://cdn.jsdelivr.net/npm/@fullcalendar/icalendar@5.11.3/main.css' rel='stylesheet' />
<script src="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.15/index.global.min.js"></script>
<style type="text/css">
.food-click{
  cursor: pointer;
}
</style>
</head>
<body>
<div class="breadcumb-area" style="background-image: url(../img/bg-img/breadcumb.jpg);">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                    <div class="bradcumb-title text-center">
                        <h2>예약</h2>
                    </div>
                </div>
            </div>
        </div>
 </div>
 <div class="breadcumb-nav">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    
                </div>
            </div>
        </div>
 </div>
 <section class="single_blog_area section_padding_80" id="reserveApp">
    <div class="container">
      <div class="row justify-content-center ">
        <div class="col-12 col-lg-12">
           <div class="row no-gutters">
             <table class="table">
              <tr>
                <td width="20%" height="500">
                 <table class="table">
                   <tr>
                    <td colspan="2">
                      <h4>맛집 정보</h4>
                    </td>
                   </tr>
                 </table>
                 <div style="overflow-y:auto;height: 500px">
                   <table class="table">
                     <tr>
                      <th class="text-center"></th>
                      <th class="text-center">업체명</th>
                     </tr>
                     <tr v-for="vo in food_list" class="food-click"
                       @click="foodSelect(vo.fno,vo.poster,vo.name)"
                     >
                       <td class="text-center">
                        <img :src="'https://www.menupan.com'+vo.poster"
                            style="width: 35px;height: 35px">
                       </td>
                       <td>{{vo.name}}</td>
                     </tr>
                   </table>
                 </div>
                </td>
              
                <td width="45%" height="500">
                 <table class="table">
                   <tr>
                    <td>
                      <h4>예약일 정보</h4>
                    </td>
                   </tr>
                   <tr>
                     <td>
                      <div id="calendar" v-show="isDate"></div>
                     </td>
                   </tr>
                 </table>
                </td>
            
                <td width="35%" height="500" rowspan="2">
                 <table class="table">
                   <tr>
                    <td colspan="2">
                      <h4>예약 정보</h4>
                    </td>
                   </tr>
                   <tr>
                     <td colspan="2" class="text-center">
                      <img :src="image" style="width: 200px;height: 150px">
                     </td>
                   </tr>
                   <tr>
                     <th width="40%" class="text-center">업체명</th>
                     <td width="60%">{{name}}</td>
                   </tr>
                   <tr>
                     <th width="40%" class="text-center">예약일</th>
                     <td width="60%">{{day}}</td>
                   </tr>
                   <tr>
                     <th width="40%" class="text-center">시간</th>
                     <td width="60%">{{time}}</td>
                   </tr>
                   <tr>
                     <th width="40%" class="text-center">인원</th>
                     <td width="60%">{{inwon}}</td>
                   </tr>
                   <tr v-show="isReserveBtn">
                     <td colspan="2" class="text-center">
                      <button class="btn-lg btn-primary"
                       @click="reserve()"
                      >예약</button>
                     </td>
                   </tr>
                 </table>
                </td>
              </tr>
              <tr>
                <td width="30%" height="150">
                 <table class="table">
                   <tr>
                    <td colspan="2">
                      <h4>시간 정보</h4>
                    </td>
                   </tr>
                   <tr v-show="isTime">
                     <td class="text-center">
                      <span class="btn btn-xs btn-success"
                       v-for="t in time_list" style="margin: 2px"
                       @click="timeSelect(t)"
                      >{{t}}</span>
                     </td>
                   </tr>
                 </table>
                </td>
                <td width="35%" height="150">
                 <table class="table">
                   <tr>
                    <td colspan="2">
                      <h4>인원 정보</h4>
                    </td>
                   </tr>
                   <tr v-show="isInwon">
                    <td class="text-center">
                     <span class="btn btn-xs btn-danger"
                       v-for="i in inwon_list" style="margin-left: 2px"
                       @click="inwonSelect(i)"
                     >
                     {{i}}
                     </span>
                    </td>
                   </tr>
                 </table>
                </td>
              </tr>
             </table>
           </div>
        </div>
      </div>
    </div>
 </section>
 <script>
  /*
      FullCalendar.Calendar(
         _this
      )
  */
  let reserveApp=Vue.createApp({
	  data(){
		  return {
			  food_list:[],
			  image:'../img/noimage.jpeg',
			  fno:0,
			  name:'',
			  isDate:false,
			  day:'',
			  time:'',
			  inwon:'',
			  time_list:[],
			  inwon_list:[],
			  isTime:false,
			  isInwon:false,
			  isReserveBtn:false
		  }
	  },
	  mounted(){
		  this.dataRecv()
		  // 코딩 테스트 : 자바스크립트 
		  let date=new Date();
		  let year=date.getFullYear()
		  let month=("0"+(1+date.getMonth())).slice(-2)
		  // 012 => 12 ==> month => 0
		  let day=("0"+date.getDate()).slice(-2)
		  // 022 => 22
		  /*console.log("year:"+year)
		  console.log("month:"+month)
		  console.log("day:"+day)*/
		  let _this=this
		  // 달력 
		  document.addEventListener('DOMContentLoaded',function(){
			  let calendarEl=document.getElementById("calendar")
			  let calendar=new FullCalendar.Calendar(calendarEl,{
				  initialView:'dayGridMonth',
				  height:450,
				  width:360,
				  validRange:{
					 start:year+"-"+month+"-"+day  
				  },
				  themeSystem:'bootstrap',
				  editable:true,
				  dropable:true,
				  // 이벤트 => 날짜 클릭 
				  dateClick:((info)=>{
					  //alert("Click Date:"+info.dateStr)
					  _this.day=info.dateStr
					  _this.isTime=true
				  })
			  })
			  calendar.render()
		  })
		  
	  },
	  methods:{
		  reserve(){
			axios.post('../reserve/reserve_vue_ok.do',null,{
				params:{
					fno:this.fno,
					rday:this.day,
					rtime:this.time,
					rinwon:this.inwon
				}
			}).then(res=>{ // onSuccess
				if(res.data==='yes')
				{
					// 마이페이지 이동 
					location.href="../mypage/reserve_list.do"
				}
				else
				{
				    // 에러메세지 전송 	
				    alert(res.data)
				}
			}).catch(error=>{ // onError
				console.log(error.response)
			})
		  },
		  inwonSelect(inwon){
			 this.inwon=inwon
			 this.isReserveBtn=true
		  },
		  timeSelect(time){
			this.time=time
			this.isInwon=true
		  },
		  foodSelect(fno,poster,name)
		  {
			 this.fno=fno
			 this.image='https://www.menupan.com'+poster
			 this.name=name
			 this.isDate=true
		  },
		  dataRecv(){
			  axios.get('../reserve/main_vue.do')
			  .then(res=>{
				  this.food_list=res.data.list  
				  this.time_list=res.data.time
				  this.inwon_list=res.data.inwon
			  })
			  .catch(error=>{
				  console.log(error.response)
			  })
		  }
	  }
  }).mount("#reserveApp")
 </script>
</body>
</html>