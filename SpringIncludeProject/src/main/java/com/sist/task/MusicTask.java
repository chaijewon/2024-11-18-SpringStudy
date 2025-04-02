package com.sist.task;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.sist.vo.*;
import com.sist.dao.*;
// 실시간 스케쥴러 => 크롤링 => 타켓형 광고 
/*
 *   {"startYearDate":"2025.04.01",
 *   "endYearDate":"2025.04.01",
 *   "startDate":"2025년 04월 01일(화)",
 *   "endDate":"2025년 04월 01일(화)",
 *   "movieCd":"20203863",
 *   "showDt":"20250401",
 *   "thumbUrl":"/common/mast/movie/2025/03/thumb/thn_ddc29260e2ca4e16997ecb5242e2a0de.jpg",
 *   "movieNm":"승부",
 *   "movieNmEn":"The Match",
 *   "synop":"세계 최고 바둑 대회에서 국내 최초 우승자가 된 조훈현.\r\n전 국민적 영웅으로 대접받던 그는 바둑 신동이라 불리는 이창호를 제자로 맞는다.\r\n\r\n“실전에선 기세가 8할이야”\r\n제자와 한 지붕 아래에서 먹고 자며 가르친 지 수년.\r\n모두가 스승의 뻔한 승리를 예상했던 첫 사제 대결에서\r\n조훈현은 전 국민이 지켜보는 가운데, 기세를 탄 제자에게 충격적으로 패한다.\r\n오랜만에 패배를 맛본 조훈현과 이제 승부의 맛을 알게 된 이창호\r\n조훈현은 타고난 승부사적 기질을 되살리며 다시 한번 올라갈 결심을 하게 되는데…","prdtYear":"2025","indieYn":null,"artmovieYn":null,"multmovieYn":null,
 *   "showTm":"114",
 *   "showTs":"33",
 *   "director":"김형주",
 *   "prNm":"(주)영화사 월광",
 *   "dtNm":"(주)바이포엠스튜디오",
 *   "repNationCd":"한국",
 *   "movieType":"장편",
 *   "moviePrdtStat":"개봉",
 *   "genre":"드라마",
 *   "watchGradeNm":"12세이상관람가",
 *   "openDt":"20250326",
 *   "salesAmt":526480860,
 *   "audiCnt":57735,
 *   "totalSalesAmt":7653913740,
 *   "totalAudiCnt":826975,"scrCnt":1548,"showCnt":6303,"rank":1,"rankInten":0,"rankOldAndNew":"OLD","rownum":1}
 */
@Component
public class MusicTask {
  @Autowired
  private MovieDAO mDao;
  // https://www.kobis.or.kr/kobis/business/main/searchMainDailyBoxOffice.do
  //@Scheduled(fixedRate = 60*1000)
  public void movieSchedul()
  {
	  try
	  {
		  mDao.movieDelete();
		  Document doc=Jsoup.connect("https://www.kobis.or.kr/kobis/business/main/searchMainDailyBoxOffice.do").get();
		  String data=doc.toString();
		  data=data.substring(data.indexOf("["),data.lastIndexOf("]")+1);
		  //System.out.println(data);
		  // [{},{},{},{}...] => Array {} Object
		  JSONParser jp=new JSONParser();
		  JSONArray root=(JSONArray)jp.parse(data);
		  for(int i=0;i<root.size();i++)
		  {
			  JSONObject obj=(JSONObject)root.get(i);
			  MovieVO vo=new MovieVO();
			  vo.setMno(i+1);
			  vo.setTitle((String)obj.get("movieNm"));
			  vo.setPoster("https://www.kobis.or.kr"+(String)obj.get("thumbUrl"));
			  vo.setDirector((String)obj.get("director"));
			  vo.setGenre((String)obj.get("genre"));
			  System.out.println("번호:"+vo.getMno());
			  System.out.println("제목:"+vo.getTitle());
			  System.out.println("이미지:"+vo.getPoster());
			  System.out.println("감독:"+vo.getDirector());
			  System.out.println("장르:"+vo.getGenre());
			  mDao.movieInsert(vo);
		  }
	  }catch(Exception ex){}
  }
	/*
	 * public static void main(String[] args) { MusicTask m=new MusicTask();
	 * m.movieSchedul(); }
	 */
}
