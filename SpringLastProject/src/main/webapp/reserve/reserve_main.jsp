<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href='https://cdn.jsdelivr.net/npm/@fullcalendar/icalendar@5.11.3/main.css' rel='stylesheet' />
<script src="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.15/index.global.min.js"></script>
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
                     <tr v-for="vo in food_list" class="food-click">
                       <td class="text-center">
                        <img :src="'https://www.menupan.com'+vo.poster"
                            style="width: 35px;height: 35px">
                       </td>
                       <td>{{vo.name}}</td>
                     </tr>
                   </table>
                 </div>
                </td>
              
                <td width="50%" height="500">
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
            
                <td width="30%" height="500" rowspan="2">
                 <table class="table">
                   <tr>
                    <td colspan="2">
                      <h4>예약 정보</h4>
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
                 </table>
                </td>
                <td width="35%" height="150">
                 <table class="table">
                   <tr>
                    <td colspan="2">
                      <h4>인원 정보</h4>
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
					  alert("Click Date:"+info.dateStr)
				  })
			  })
			  calendar.render()
		  })
		  
	  },
	  methods:{
		  dataRecv(){
			  axios.get('../reserve/main_vue.do')
			  .then(res=>{
				  this.food_list=res.data.list  
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