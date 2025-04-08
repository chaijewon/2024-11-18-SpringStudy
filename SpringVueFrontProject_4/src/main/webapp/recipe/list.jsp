<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
      1. 생성 : 여러개 생성이 가능 => 상세보기 , 댓글 => 재사용 (.js)
               ----                   => 페이지 나누기 
               | 범위 지정 => Vue에서 제어 
               | .mount("태그명(id(#),class(.))")
                 ------- 가상메모리에 올리는 상태 
         let 변수명=Vue.createApp({
             데이터 관리 영역 : Model 
             data(){
               return {
                 HTML에서 사용할 변수 설정
               }
             }
             데이터 변경/수정 : ViewModel
             생명주기 함수 
             mounted(){
                시작과 동시에 (화면 변경) 읽어올 데이터 있는 경우
                window.onload=function()
                main
                $(function(){})
                componentDidMount()
                ----------------------------------
                jquery 연동 / angularJS 
                
                angularJS / react (단방향)
                => 양방향     => 가상돔 
                    |            |
                    ==============
                          |
                     장점을 이용해서 제작 
                     운영체제 : facebook / google 
                                       | go / angularjs
                
                
             }
             updated(){
                 데이터 갱신시에 처리 
             }
             사용자 정의 함수
             methods:{
                이벤트 처리 
                함수명:function(){
                   익명의 함수
                }
                함수명(){
                   선언적 함수 
                }
             },
             computed:{
             }
             watch:{
               => props 감지 => component
             }
         }).mount(범위)
      
         => 서버연결 전송 
            axios.get(서버URL,{
               데이터 전송 
               params:{
                  no:1,
                  page:1
               }
            })
            
            formData
            axios.post(서버URL,null,{
               서버에 요청값 전송 
            })
            
            => 결과값 
            axios.get(URL,{
                params:{
                   no:1
                }
            }).then(res=>{
               실행 결과값을 읽어 온다 => res안에 값이 저장 
            }).catch(e){
                에러 처리 
            }
      2. 이벤트 처리
         methods:{
            btnClick(){
            }
            mouseClick(){
            }
         } 
      3. 생명주기 
         beforeCreate 
         created
         beforeMount
         mounted =====> 
         beforeUpdate
         updated =====> 
         beforeDestory
         destoryed
      4. 출력 {{}} :속성 
      5. 재사용 
         components:{
           template:'<div></div>'
         }
         
         <template>
           HTML 
         </template>
         => vue-bootstrap
      6. 출력 / 이벤트 등록
         HTML안에서 처리 
         -----------
         화면 출력 => <태그>{{변수명}}</태그>
                       --------- [[]] => 변경 
                       => 장고 {{}}
                   <태그 :속성="변수명">
                        => src , href 
                   <태그 v-bind:속성="변수명">
         ----------------------------------- 디렉티브 v-
                                             th:
         제어문 
           반복문 => 반복되는 태그안에 설정 
           <태그 v-for="변수 in 배열">
           <태그 v-for="(변수,index) in 배열">
                           ------ varStatus="s"
           조건문 
             v-if="true/false"
             v-if="" v-else
             <태그 v-if="">
               v-if가 true
             </태그>
             <태그 v-else>
               false 
             </태그>
             
             v-if ~ v-else-if ~ v-else
             
             v-show="true/false"  => display:none , display:''
                .show() , .hide()
            기타 
             v-model="" => Vue에 설정된 데이터에 값을 설정 
             -------- 검색기 , 입력 , 수정 
             -------- 양방향 통신 
             => 삼항연산자 : 조건?"":""
                         i===curpage?"active":""
         이벤트 등록  
           v-on:click="함수명" => @click="함수명"
           v-on:change="함수명"
           v-on:mouseover="함수명"
           v-on:keyup="함수명"
           ----------------- v-on:keyup.enter="함수명"
                             v-on:keyup.space
                             v-on:submit="함수"
           v-on:keydown="함수명"
           
        Vue => 패턴 (MVVM)
        
        Model : 데이터 관리(VO , DTO)
        View : 화면 출력 
        ViewModel : 상태 관리 , 연산처리 ,이벤트 ,데이터 읽기 
        
        초기값    초기값 출력       처리결과
        Model = View = ViewModel = Model = View 
                    이벤트 처리           갱신된 값 전송 
        ----------------------------------------
         | 양방향 
         
       => Model에 값을 설정 
        
          data(){
             return {
                 int => no:0
                 string => fd:''
                 list:[]
                 vo:{}
                 isShow:false      
             }
          }
          
          axios.get => @GetMapping 
          axios.post => @PostMapping
           
 --%>
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
  width: 800px;
}
p{
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
}
</style>
</head>
<body>
  <div class="container">
    <div class="row">
      <div class="col-md-3" v-for="vo in recipe_list">
	    <div class="thumbnail">
	      <a :href="'../recipe/detail.do?no='+vo.no">
	        <img :src="vo.poster" style="width:230px;height: 250px">
	        <div class="caption">
	          <p>{{vo.title}}</p>
	        </div>
	      </a>
	    </div>
	  </div>
    </div>
    <div style="height: 10px"></div>
    <div class="row">
     <div class="text-center">
      <input type=button class="btn-sm btn-danger"
       value="이전" @click="prev()"
      >
      {{curpage}} page / {{totalpage}} pages
      <input type=button class="btn-sm btn-danger"
       value="다음" v-on:click="next()"
      >
     </div>
    </div>
  </div>
  <script>
    let app=Vue.createApp({
       data(){
    	   return {
    		   recipe_list:[],
    		   curpage:1,
    		   totalpage:0
    	   }
       },
       // response.data={list:[],curpage:1,totalpage:100}
       mounted(){
    	   // 화면 시작과 동시에 데이터 전송 
    	   // => React  => ?page=1
    	   this.dataRecv()
       },
       // 사용자 정의 함수 => 이벤트 처리 
       methods:{
    	   prev:function(){
    		   this.curpage=this.curpage>1?this.curpage-1:this.curpage
    		   this.dataRecv()
    	   },
    	   next(){
    		   
    		   this.curpage=this.curpage<this.totalpage?this.curpage+1:this.curpage
    		   this.dataRecv()
    	   },
    	   dataRecv(){
    		   axios.get('../recipe/list_vue.do',{
        		   params:{
        			   page:this.curpage
        		   }
        	   }).then(response=>{
        		   console.log(response.data)
        		   this.recipe_list=response.data.list
        		   this.curpage=response.data.curpage
        		   this.totalpage=response.data.totalpage
        	   }).catch(error=>{
     			  console.log(error.response)
     		   }) 
    	   }
       }
    }).mount(".container")
  </script>
</body>
</html>