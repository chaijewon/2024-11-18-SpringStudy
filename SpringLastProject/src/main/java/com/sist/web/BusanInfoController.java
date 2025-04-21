package com.sist.web;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
/*
 *    7:3 => 6:4 
 *    => 검색 , 페이지 , 댓글 , 결재 , 예약 
 *    
 *    = 데이터베이스 연동 => Service/DAO 
 *    = 브라우저 연동 => Model (화면,데이터만 전송)
 *    
 *                      | 등록 : web.xml
 *                        => HandelrMapping 생성 
 *                        => 클래스 등록 => xml을 전송
 *                      | 자동 설정 / 톰캣 자동 설정 => Spring-Boot 
 *    사용자 요청 (.do) ==> DispatcherServlet 
 *                            |
 *                         HandlerMapping : Model을 찾아서 기능 수행
 *                            |
 *                          ViewResolver : JSP를 찾아서 request전송
 *                            | 경로명/확장자
 *                          JSP
 */
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.service.BusanInfoService;
import com.sist.vo.BusanInfoVO;
@Controller
public class BusanInfoController {
  // @Autowired => 전역에서 설정이 가능 
  // 필요한 객체 => 스프링에서 메모리 할당한 경우 
  @Autowired
  private BusanInfoService service;
  
  private String[] titles={"","명소","음식","쇼핑"};
  // HandlerMapping이 찾기 => 기능 설정 
  @GetMapping("busan/info.do")
  public String busan_info(int cno,Model model)
  {
	  // include할 파일 전송 
	  model.addAttribute("cno", cno);
	  model.addAttribute("titles", titles[cno]);
	  model.addAttribute("main_jsp", "../busan/info_list.jsp");
	  return "main/main";
  }
  // 웹 => 사용자가 보내는 값 <a> <form> params(Vue,React) / data(Ajax)
  // 출력할때 받아서 JSP에서 출력변수 => model.addAttribute() , data(){}
  // 주고 받기 
  // => useState(React)
  @GetMapping("busan/detail.do")
  public String busan_detail(int no,Model model)
  {
	  BusanInfoVO vo=service.busanInfoDetailData(no);
	  String addr1=vo.getAddress();
	  addr1=addr1.substring(addr1.indexOf(" "));
	  String addr2=addr1.trim();
	  addr2=addr2.substring(0,addr2.indexOf(" "));
	  model.addAttribute("vo", vo);
	  model.addAttribute("addr", addr2);
	  model.addAttribute("main_jsp", "../busan/info_detail.jsp");
	  return "main/main";
  }
}
