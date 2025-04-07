<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
       MVC => 서버에서 (Model / View를 나눠서 작업)
                    =======  ====
                      |        |
                    요청 처리    데이터를 받아서 출력 
                    데이터 관리 
                    출력 데이터 전송 
                    => ~DAO / ~Manager / ~Service / ~VO
       => Vue : MVVM 
          M(Model) : 데이터 저장 / 데이터를 관리 
                     data(){
                         멤버 변수 설정 => VO
                         ================
                         숫자형
                         no:1 , no:10.5 .... => 초기값 부여 
                         문자형 
                         name:'' name:""
                         --------------------- 자바에서 전송 
                         객체형
                         vo:{} => JSON
                         --------------------- VO와 매칭이 안된다 
                                               JSON변경후에 전송 
                                               => @RestController
                         배열형 
                         food_list:[]
                         --------------------- List => JSON변경후에 전송
                         함수형 
                         display:function(){}
                     }
          V(View) : 화면 출력 
                    => 데이터 출력 : {{data에 선언된 변수만}}
                       *** React : {}
                       *** Django : 파이썬 => {{}}'
                       *** JSP : ${} => EL
                       => 제어문 지원 : 디렉티브
                          => 태그안에서 처리 => 
                       => 반복문 / 조건문 / 화면 출력여부
                          v-for
                          v-if / v-if~v-else
                          v-if ~ v-elseif ... v-else
                          v-show / v-hide 
                       => 양방향 통신 
                          v-model / v-bind => : 속성안에 처리 
                       => 이벤트 처리 
                          v-on:click  => @click="함수명" 
                          v-on:change => @change="함수명"
                       => Spring / Vue , React 가능자 
                          
          VM(ViewModel): 상태 관리 (데이터가 변경이 되는 경우)
                         => View에 알려준다 => 갱신 
                   => 생명주기 
                      beforeCreate : vue 객체 생성전  
                      created : vue 객체 생성 
                      beforeMount : window.onload 전 
                      mounted     : onload => $(function())
                         => 서버연결 => 서버에서 전송한 데이터를 받는다 
                      beforeUpdate
                      updated
                         => 데이터 변경시에 처리 
                      beforeDestory
                      destoryed  
                         => 화면 변경이 된 경우 
                   형식)
                       let app=Vue.CreateApp({
                           data()
                           {
                           },
                           mounted:function()
                           {
                           },
                           ..
                           ..
                           methods:{
                              사용자 정의 메소드 => 버튼 
                           },
                           component:{
                           
                           },
                           filter:{
                             => 10000 => 10,000
                           },
                           watch / computed 
                       }).mount("제어하는 HTML영역지정")
                          => id => #
                          => class => .
        HTML => ViewModel = View => 가상돔 = 실제 돔 
                ---------            | 필수 (면접)
                |  데이터 갱신           | Buffer
        동작 	방법  => 저장은 가상돔에 저장 
        -------         --------- 실제 돔과 비교 (변경된 부분만 전송)
                           diff
        1. MVVM / 가상돔 
        --------------- 
        => VueJS에서 DOM이벤트 감지 
        => 이벤트가 감지 서버로부터 데이터 요청 
                    --------------- axios 
        => 결과값을 받아서 View에 데이터를 바인딩 한다 => 화면이 변경
        => 영역지정 
        
     => 데이터형 
        숫자형 : number => int / double 
        문자형 : string => '' ,""
        객체형 : {}
        배열형 : []
        논리형 : boolean => true/false 
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
  <div class="container">
    <div class="row" id="a">
     {{a_msg}}<p> <!-- {{data()에 선언된 변수,methods에 선언된 메소드}} -->
     <input type=button value="변경" v-on:click="btnClick()">
    </div>
    <div class="row" id="b">
     {{b_msg}}
    </div>
  </div>
  <script>
   let app=Vue.createApp({
	   // Model => 데이터가 변경이 되면 HTML에 전송 
	   // 멤버변수 
	   data(){
		   return {
			   a_msg:'Hello Vue(a)'
		   }
	   },
	   // ViewModel
	   methods:{
		   btnClick:function(){
			 this.a_msg='갱신된 값';  
			 // data에 선언된 값을 읽는 경우 => this.변수명
		   }
	   }
	   // ViewModel => 데이터 변경 / 서버에서 데이터를 읽어온다
	   
   }).mount("#a")
   
   let bpp=Vue.createApp({
	   // Model => 데이터가 변경이 되면 HTML에 전송 
	   data(){
		   return {
			   b_msg:'Hello Vue(b)'
		   }
	   }
	   // ViewModel => 데이터 변경 / 서버에서 데이터를 읽어온다
	   
   }).mount("#b")
  </script>
</body>
</html>