<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
   margin-top:50px;
}
.row {
   width: 960px;
   margin: 0px auto;
}
.dataTr:hover{
  cursor: pointer;
  background-color: cyan;
}

</style>
</head>
<body>
  <div class="container">
   <div class="row">
    <div class="col-sm-8">
      <table class="table">
       <tr>
         <th class="text-center">순위</th>
         <th class="text-center"></th>
         <th>영화명</th>
         <th>감독</th>
       </tr>
       <%-- vo = {} , List = []  --%>
       <tr v-for="vo in movie" class="dataTr" v-on:mouseover="movie_detail(vo)">
         <td class="text-center">{{vo.rank}}</td>
         <td class="text-center">
           <img :src="'https://www.kobis.or.kr'+vo.thumbUrl" style="width:35px;height: 35px">
         </td>
         <td>{{vo.movieNm}}</td>
         <td>{{vo.director}}</td>
       </tr>
      </table>
    </div>
    <%--
          v-xxx="data안에 있는 변수만  사용이 가능"
          {{data안에 있는 변수만 사용이 가능}}
     --%>
    <div class="col-sm-4" v-show="isShow">
      <table class="table">
        <tr>
         <td width=30% class="text-center" rowspan="6">
           <img :src="'https://www.kobis.or.kr'+detail.thumbUrl" style="width:100%">
         </td>
         <td colspan="2"><h3>{{detail.movieNm}}</h3></td>
        </tr>
        <tr>
          <td width=20%>감독</td>
          <td width=50%>{{detail.director}}</td>
        </tr>
        <tr>
          <td width=20%>장르</td>
          <td width=50%>{{detail.genre}}</td>
        </tr>
        <tr>
          <td width=20%>등급</td>
          <td width=50%>{{detail.watchGradeNm}}</td>
        </tr>
        <tr>
          <td width=20%>순위</td>
          <td width=50%>{{detail.rank}}</td>
        </tr>
        <tr>
          <td width=20%>개봉일</td>
          <td width=50%>{{detail.startYearDate}}</td>
        </tr>
      </table>
    </div>
   </div>
  </div>
  <script>
   let app=Vue.createApp({
	  data(){
		  return {
			  movie:[{"startYearDate":"2025.04.06","endYearDate":"2025.04.06","startDate":"2025년 04월 06일(일)","endDate":"2025년 04월 06일(일)","movieCd":"20203863","showDt":"20250406","thumbUrl":"/common/mast/movie/2025/03/thumb/thn_ddc29260e2ca4e16997ecb5242e2a0de.jpg","movieNm":"승부","movieNmEn":"The Match","synop":"세계 최고 바둑 대회에서 국내 최초 우승자가 된 조훈현.\r\n전 국민적 영웅으로 대접받던 그는 바둑 신동이라 불리는 이창호를 제자로 맞는다.\r\n\r\n“실전에선 기세가 8할이야”\r\n제자와 한 지붕 아래에서 먹고 자며 가르친 지 수년.\r\n모두가 스승의 뻔한 승리를 예상했던 첫 사제 대결에서\r\n조훈현은 전 국민이 지켜보는 가운데, 기세를 탄 제자에게 충격적으로 패한다.\r\n오랜만에 패배를 맛본 조훈현과 이제 승부의 맛을 알게 된 이창호\r\n조훈현은 타고난 승부사적 기질을 되살리며 다시 한번 올라갈 결심을 하게 되는데…","prdtYear":"2025","indieYn":null,"artmovieYn":null,"multmovieYn":null,"showTm":"114","showTs":"33","director":"김형주","prNm":"(주)영화사 월광","dtNm":"(주)바이포엠스튜디오","repNationCd":"한국","movieType":"장편","moviePrdtStat":"개봉","genre":"드라마","watchGradeNm":"12세이상관람가","openDt":"20250326","salesAmt":1436535750,"audiCnt":150540,"totalSalesAmt":12600446480,"totalAudiCnt":1351652,"scrCnt":1504,"showCnt":6249,"rank":1,"rankInten":0,"rankOldAndNew":"OLD","rownum":1},{"startYearDate":"2025.04.06","endYearDate":"2025.04.06","startDate":"2025년 04월 06일(일)","endDate":"2025년 04월 06일(일)","movieCd":"20233008","showDt":"20250406","thumbUrl":"/common/mast/movie/2025/04/thumb/thn_4b254a02eeb7479699c5d3030cf3ee21.jpg","movieNm":"로비","movieNmEn":"LOBBY","synop":"\"더럽게 싸움을 걸면, 어떻게 더럽게 싸우죠?\"\r\n연구밖에 모르는 스타트업 대표 창욱(하정우)은 \r\n라이벌 회사 대표 광우(박병은)의 뒷거래 때문에 기회도, 기술도 번번히 빼앗긴다. \r\n그의 회사의 유일한 탈출구는 4조 원에 달하는 국책사업을 따내어, 한방에 자본을 확보하는 것!\r\n\r\n하지만 로비에 있어선 한수 위인 광우는 조장관(강말금)을 일찌감치 포섭한 상황, \r\n창욱은 눈을 돌려 조장관의 최측근이자 실무를 쥐고 있는 남편 최실장(김의성)에게 접근해 \r\n더러운 싸움에 참전하게 되는데... \r\n\r\n마침내 뒷거래가 이뤄지는 골프장에\r\n한날 한시 각자의 목적을 위해 모인 로비팀들, \r\n이들의 진흙탕 로비가 펼쳐진다!","prdtYear":"2023","indieYn":null,"artmovieYn":null,"multmovieYn":null,"showTm":"105","showTs":"48","director":"하정우","prNm":"워크하우스컴퍼니(주),(주)필름모멘텀","dtNm":"(주)쇼박스","repNationCd":"한국","movieType":"장편","moviePrdtStat":"개봉","genre":"드라마,코미디","watchGradeNm":"15세이상관람가","openDt":"20250402","salesAmt":319558720,"audiCnt":32686,"totalSalesAmt":1565537300,"totalAudiCnt":165313,"scrCnt":932,"showCnt":3076,"rank":2,"rankInten":0,"rankOldAndNew":"OLD","rownum":2},{"startYearDate":"2025.04.06","endYearDate":"2025.04.06","startDate":"2025년 04월 06일(일)","endDate":"2025년 04월 06일(일)","movieCd":"20253101","showDt":"20250406","thumbUrl":"/common/mast/movie/2025/03/thumb/thn_ddd3614078964eb5973c182872c466e1.jpg","movieNm":"극장판 진격의 거인 완결편 더 라스트 어택","movieNmEn":"Attack on Titan The Movie : THE LAST ATTACK","synop":"거인의 위협으로부터 몸을 지키기 위해 거대한 벽을 쌓고 그 안에서 숨을 죽이고 살고 있는 인류.\r\n백 년의 평화는 초대형 거인의 습격으로 파괴됐고, 어머니를 잃은 소년 엘런 예거는\r\n모든 거인을 없앨 것을 맹세하고 거인과 싸우는 조사병단의 일원이 되었다.\r\n\r\n글자 그대로 목숨을 건 싸움 속에서 엘런 예거는 자신도 거인이 되는 능력을 손에 넣었고 \r\n인류의 승리에 공헌하면서 조금씩 세계의 진실에 가까워지고 있었다. 이윽고 시간이 흘러 벽 밖으로 나간 엘런은\r\n조사병단의 동료들과 갈라섰고 어떤 무시무시한 계획을 실행한다.\r\n\r\n수많은 거인을 이끌고, 이 세계의 살아있는 모든 것들을 짓밟는 「땅울림」.\r\n\r\n미카사와 아르민을 시작으로 남겨진 자들은 세계를 멸망시키려 하는 엘런을 막기\r\n위해 최후의 싸움에 나선다.","prdtYear":"2024","indieYn":null,"artmovieYn":null,"multmovieYn":null,"showTm":"144","showTs":"14","director":"하야시 유이치로","prNm":null,"dtNm":"(주)애니플러스","repNationCd":"일본","movieType":"장편","moviePrdtStat":"개봉","genre":"애니메이션","watchGradeNm":"15세이상관람가","openDt":"20250313","salesAmt":220883380,"audiCnt":21570,"totalSalesAmt":6400115520,"totalAudiCnt":642113,"scrCnt":298,"showCnt":872,"rank":3,"rankInten":0,"rankOldAndNew":"OLD","rownum":3},{"startYearDate":"2025.04.06","endYearDate":"2025.04.06","startDate":"2025년 04월 06일(일)","endDate":"2025년 04월 06일(일)","movieCd":"20241827","showDt":"20250406","thumbUrl":"/common/mast/movie/2025/02/thumb/thn_89face3d199740de9043faec4710ffa7.jpg","movieNm":"플로우","movieNmEn":"FLOW","synop":"파도가 끝나는 곳,\r\n고양이의 모험이 시작된다!\r\n\r\n인간이 살았던 흔적만이 남아있는 세상,\r\n홀로 집을 지키던 '고양이'는 갑작스러운 대홍수로\r\n평화롭던 일상과 아늑했던 터전을 잃고 만다.\r\n\r\n때마침 다가온 낡은 배에 올라탄 '고양이'는\r\n그 안에서 '골든 리트리버', '카피바라', '여우원숭이', '뱀잡이수리'를 만나고\r\n서로의 차이점을 극복하고 팀을 이뤄 험난한 파도를 헤쳐나간다.","prdtYear":"2024","indieYn":null,"artmovieYn":"Y","multmovieYn":null,"showTm":"84","showTs":"57","director":"긴츠 질발로디스","prNm":null,"dtNm":"판씨네마(주)","repNationCd":"기타","movieType":"장편","moviePrdtStat":"개봉","genre":"애니메이션","watchGradeNm":"전체관람가","openDt":"20250319","salesAmt":74025000,"audiCnt":7818,"totalSalesAmt":1322894700,"totalAudiCnt":138523,"scrCnt":466,"showCnt":632,"rank":4,"rankInten":0,"rankOldAndNew":"OLD","rownum":4},{"startYearDate":"2025.04.06","endYearDate":"2025.04.06","startDate":"2025년 04월 06일(일)","endDate":"2025년 04월 06일(일)","movieCd":"20244821","showDt":"20250406","thumbUrl":"/common/mast/movie/2025/01/thumb/thn_25382cdac19547bc8fcb3e20c3d593cc.jpg","movieNm":"미키 17","movieNmEn":"Mickey 17","synop":"“당신은 몇 번째 미키입니까?” \r\n\r\n친구 ‘티모’와 함께 차린 마카롱 가게가 쫄딱 망해 거액의 빚을 지고 \r\n못 갚으면 죽이겠다는 사채업자를 피해 지구를 떠나야 하는 ‘미키’. \r\n기술이 없는 그는, 정치인 ‘마셜’의 얼음행성 개척단에서 위험한 일을 도맡고, 죽으면 다시 프린트되는 익스펜더블로 지원한다. \r\n4년의 항해와 얼음행성 니플하임에 도착한 뒤에도 늘 ‘미키’를 지켜준 여자친구 ‘나샤’. \r\n그와 함께, ‘미키’는 반복되는 죽음과 출력의 사이클에도 익숙해진다. \r\n그러나 ‘미키 17’이 얼음행성의 생명체인 ‘크리퍼’와 만난 후 죽을 위기에서 돌아와 보니 이미 ‘미키 18’이 프린트되어 있다. \r\n행성 당 1명만 허용된 익스펜더블이 둘이 된 ‘멀티플’ 상황. \r\n둘 중 하나는 죽어야 하는 현실 속에 걷잡을 수 없는 사건이 기다리고 있었으니… \r\n\r\n“자알 죽고, 내일 만나”","prdtYear":"2025","indieYn":null,"artmovieYn":null,"multmovieYn":null,"showTm":"136","showTs":"48","director":"봉준호","prNm":"플랜 비 엔터테인먼트,(주)오프스크린","dtNm":"워너브러더스 코리아(주)","repNationCd":"미국","movieType":"장편","moviePrdtStat":"개봉","genre":"어드벤처,SF,드라마,코미디","watchGradeNm":"15세이상관람가","openDt":"20250228","salesAmt":59336700,"audiCnt":5958,"totalSalesAmt":29557710520,"totalAudiCnt":2998372,"scrCnt":448,"showCnt":723,"rank":5,"rankInten":0,"rankOldAndNew":"OLD","rownum":5},{"startYearDate":"2025.04.06","endYearDate":"2025.04.06","startDate":"2025년 04월 06일(일)","endDate":"2025년 04월 06일(일)","movieCd":"20253093","showDt":"20250406","thumbUrl":"/common/mast/movie/2025/03/thumb/thn_97f564fedf474bd48e453510bd504d42.jpg","movieNm":"헤레틱","movieNmEn":"Heretic","synop":"외딴 집을 찾은 신앙심 깊은 두 소녀에게\r\n집주인은 믿음을 뒤흔드는 이야기를 꺼낸다.\r\n무언가 의심스럽다고 느끼는 순간,\r\n두 소녀는 꼼짝없이 집안에 갇히게 된다.\r\n친절했던 남자는 돌변하고,\r\n그녀들은 살기 위해 위험한 선택을 하는데…","prdtYear":"2024","indieYn":null,"artmovieYn":null,"multmovieYn":null,"showTm":"111","showTs":"14","director":"스콧 벡,브라이언 우즈","prNm":null,"dtNm":"(주)이놀미디어,롯데컬처웍스(주)롯데시네마","repNationCd":"미국","movieType":"장편","moviePrdtStat":"개봉","genre":"스릴러,공포(호러)","watchGradeNm":"15세이상관람가","openDt":"20250402","salesAmt":41124600,"audiCnt":4645,"totalSalesAmt":196496900,"totalAudiCnt":24740,"scrCnt":151,"showCnt":499,"rank":6,"rankInten":0,"rankOldAndNew":"OLD","rownum":6},{"startYearDate":"2025.04.06","endYearDate":"2025.04.06","startDate":"2025년 04월 06일(일)","endDate":"2025년 04월 06일(일)","movieCd":"20249251","showDt":"20250406","thumbUrl":"/common/mast/movie/2025/03/thumb/thn_a50b9c94ac68400eadc4dfb7f2094ba5.jpg","movieNm":"콘클라베","movieNmEn":"Conclave","synop":"교황의 예기치 못한 죽음 이후 새로운 교황을 선출하는 ‘콘클라베’가 시작되고,\r\n로렌스(랄프 파인즈)는 단장으로서 선거를 총괄하게 된다.\r\n한편 당선에 유력했던 후보들이 스캔들에 휘말리면서\r\n교활한 음모와 탐욕이 수면 위로 드러나는데…\r\n","prdtYear":"2024","indieYn":null,"artmovieYn":"Y","multmovieYn":null,"showTm":"120","showTs":"14","director":"에드워드 버거","prNm":null,"dtNm":"(주)디스테이션","repNationCd":"미국","movieType":"장편","moviePrdtStat":"개봉","genre":"드라마,스릴러","watchGradeNm":"12세이상관람가","openDt":"20250305","salesAmt":42807800,"audiCnt":4241,"totalSalesAmt":2411837520,"totalAudiCnt":253572,"scrCnt":263,"showCnt":326,"rank":7,"rankInten":0,"rankOldAndNew":"OLD","rownum":7},{"startYearDate":"2025.04.06","endYearDate":"2025.04.06","startDate":"2025년 04월 06일(일)","endDate":"2025년 04월 06일(일)","movieCd":"20251573","showDt":"20250406","thumbUrl":"/common/mast/movie/2025/03/thumb/thn_22cb956527eb4e29a439a22e32c0e774.jpg","movieNm":"미스터 로봇","movieNmEn":"Mr.Robot","synop":"인공지능 로봇으로 자동화된 근 미래.\r\nK-ROBOT 인더스트리의 쇼케이스 현장에서\r\n새로 출시된 로봇 ‘맥스’가 치명적인 사고를 일으키고,\r\n로봇 관리대 대원(RCC) ‘한태평’은 그 과정에서 혼수상태에 빠지게 된다.\r\n이후, '한태평'은 폐기 직전에 놓인 '맥스'의 몸으로 눈을 뜨게 되는데...\r\n\r\n한편, K-ROBOT 인더스트리의 부사장이자 삼촌 '강민'에 의해 위험에 처한 소녀 '나나'.\r\n그 순간 등장한 '맥스'에 의해 '강민'의 위협에서 탈출하고\r\n두 사람의 특별한 여정이 시작된다!\r\n","prdtYear":"2025","indieYn":null,"artmovieYn":null,"multmovieYn":null,"showTm":"90","showTs":"0","director":"이대희","prNm":"(주)이대희 애니메이션스튜디오,(주)302플래닛,㈜인디스토리","dtNm":"(주)넥스트엔터테인먼트월드(NEW)","repNationCd":"한국","movieType":"장편","moviePrdtStat":"개봉","genre":"애니메이션","watchGradeNm":"12세이상관람가","openDt":"20250404","salesAmt":33389900,"audiCnt":3852,"totalSalesAmt":132301700,"totalAudiCnt":15513,"scrCnt":427,"showCnt":640,"rank":8,"rankInten":0,"rankOldAndNew":"OLD","rownum":8},{"startYearDate":"2025.04.06","endYearDate":"2025.04.06","startDate":"2025년 04월 06일(일)","endDate":"2025년 04월 06일(일)","movieCd":"20253233","showDt":"20250406","thumbUrl":"/common/mast/movie/2025/03/thumb/thn_cb173d751f7a46bc81248668b78a7262.jpg","movieNm":"세븐틴 [라잇 히어] 월드 투어 인 시네마","movieNmEn":"SEVENTEEN [RIGHT HERE] WORLD TOUR IN CINEMAS","synop":"SEVENTEEN RIGHT HERE!\r\n\r\n전 세계에 세븐틴의 강한 발자취를 남긴 월드투어 [RIGHT HERE]\r\n그 시작을 알린 고양 콘서트의 감동을 스크린에서 만난다!\r\n\r\n‘독 : Fear’ 콘서트 버전부터, ‘LOVE, MONEY, FAME (feat. DJ Khaled)’, ‘Ash’ 등\r\n오직 콘서트에서만 만날 수 있는 스페셜 셋 리스트 전체 상영 확정!\r\n\r\n힙합팀, 퍼포먼스팀, 보컬팀 세 고유 유닛의 다채로운 매력부터,\r\n세븐틴의 A to Z를 이루는 타이틀 곡 릴레이까지!\r\n\r\n세븐틴만의, 세븐틴을 위한, 세븐틴에 의한 역대급 현장이\r\nSCREENX, 4DX, ULTRA 4DX 그리고 IMAX로 되살아난다!\r\n","prdtYear":"2025","indieYn":null,"artmovieYn":null,"multmovieYn":null,"showTm":"131","showTs":"15","director":"오윤동","prNm":"씨제이포디플렉스 주식회사,스크린엑스 스튜디오,(주)하이브","dtNm":"씨제이포디플렉스 주식회사","repNationCd":"한국","movieType":"장편","moviePrdtStat":"개봉","genre":"공연","watchGradeNm":"전체관람가","openDt":"20250402","salesAmt":106849500,"audiCnt":3843,"totalSalesAmt":395921500,"totalAudiCnt":14728,"scrCnt":96,"showCnt":259,"rank":9,"rankInten":0,"rankOldAndNew":"OLD","rownum":9},{"startYearDate":"2025.04.06","endYearDate":"2025.04.06","startDate":"2025년 04월 06일(일)","endDate":"2025년 04월 06일(일)","movieCd":"20243562","showDt":"20250406","thumbUrl":"/common/mast/movie/2025/02/thumb/thn_3a72b15160fa4db0b88b6785de82e5f3.jpg","movieNm":"백설공주","movieNmEn":"SNOW WHITE","synop":"동화 그 이상의 마법 같은 이야기\r\n2025년 봄과 함께 찾아온 디즈니 최초의 프린세스\r\n\r\n눈보라가 몰아치던 겨울 밤 태어난 백설공주.\r\n온정이 넘치던 왕국에서 모두의 사랑을 받았지만,\r\n강력한 어둠의 힘으로 왕국을 빼앗은 여왕의 위협에 숲으로 도망친다.\r\n마법의 숲에서 간신히 살아남은 백설공주는\r\n신비로운 일곱 광부들과 만나게 되며 새로운 세상을 마주하고,\r\n마음속 깊이 숨겨진 용기와 선한 힘을 깨닫게 된다.\r\n그리고 마침내, 빼앗긴 왕국을 되찾기 위해 여왕과 맞서 싸우기로 결심하는데…\r\n\r\n<미녀와 야수>, <알라딘> 제작진이 선보이는 디즈니 판타지 뮤지컬 영화\r\n눈부시게 아름다운 판타지와 환상의 음악이 선사하는 마법 같은 기적!","prdtYear":"2024","indieYn":null,"artmovieYn":null,"multmovieYn":null,"showTm":"108","showTs":"40","director":"마크 웹","prNm":null,"dtNm":"월트디즈니컴퍼니코리아 유한책임회사","repNationCd":"미국","movieType":"장편","moviePrdtStat":"개봉","genre":"판타지,뮤지컬","watchGradeNm":"전체관람가","openDt":"20250319","salesAmt":32985700,"audiCnt":3601,"totalSalesAmt":1753412970,"totalAudiCnt":186462,"scrCnt":303,"showCnt":378,"rank":10,"rankInten":0,"rankOldAndNew":"OLD","rownum":10}],
		      detail:{},
		      isShow:false
		  }
	  },
	  methods:{
		  movie_detail:function(vo){
			  this.isShow=true
			  this.detail=vo
		  }
	  }
   }).mount(".container")
  </script>
</body>
</html>


