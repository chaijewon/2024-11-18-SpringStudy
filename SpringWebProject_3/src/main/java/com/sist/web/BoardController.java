package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
/*
 *   Mapper => 스프링에서 구현 
 *   --------------------
 *          |
 *       BoardDAO
 *          |
 *       Model => JSP
 *       
 *       1. request는 보안문제로 사용 금지 
 *          --------
 *          1) 요청값 받기 ==> 매개변수 
 *                         ------
 *                         순서와 관계없다 
 *                         => 처리하는 내장 객체를 받아서 처리 
 *                         request/response/session
 *                         RedirectAttributes
 *                         => VO
 *          2) JSP로 값을 전송 ==> Model
 *       
 *       2. 기본 틀 => 메인 보드 
 *                   ------ 부품 제작 (CPU/하드디스크...)
 *          DispatcherServlet : 요청 / 응답 
 *            => web.xml에 등록 
 *          HandlerMapping : Model을 찾기 
 *                           @RequestMapping을 찾아서
 *                           메소드 호출 
 *                           => 셋팅 
 *          ViewResolver : 결과값(request)를 JSP로 전송 
 *                         => 경로명 / 확장자 
 *                         => application-context.xml
 *       3. JSP는 변경 사항이 없다 
 *       
 *    => 매개변수?
 *    => request를 전송 => return "jsp파일명"
 *                       forward 
 *    => request를 미전송 => return "redirect:"
 *                       sendRedirect => _ok
 *                       
 *    1. 동작 순서 
 *       사용자 전송 => 요청 받아서 => Model로 요청값 전송 => 데이터베이스 연동 
 *       => 요청 처리 => 결과값을 => JSP로 전송 
 *       
 *       jsp(forword) => 결과값 전송이 잇는 경우
 *       jsp(redirect) => 결과값이 없는 상태 => 기존의 화면이동 
 *       
 *       detail.do = detail.jsp 
 *       insert_ok.do = list.jsp 
 *       update_ok.do = detail.jsp
 *          
 */
@Controller  // 화면 변경 => forward / sendRedirect
@RequestMapping("board/")
public class BoardController {
	
	@Autowired
    private BoardDAO dao;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@RequestMapping("list.do")
	public String board_list(String page,Model model)
	{
		if(page==null)
			page="1";
		
		int curpage=Integer.parseInt(page);
		List<BoardVO> list=dao.boardListData((10*curpage)-9, curpage*10);
		int totalpage=dao.boardTotalPage();
		
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("list", list);
		
		return "board/list";
	}
	
	@RequestMapping("insert.do")
	public String board_insert()
	{
		return "board/insert";
	}
	@RequestMapping("insert_ok.do")
	public String board_insert_ok(BoardVO vo)
	{
		String pwd=encoder.encode(vo.getPwd());
		vo.setPwd(pwd);
		System.out.println("pwd="+pwd);
		dao.boardInsert(vo);
		// => if(pwd.matchs(vo.getPwd())
		
		return "redirect:list.do";
	}
	
	// 상세보기 요청 
	@RequestMapping("detail.do")
	// 데아터형 => String 통합 , 각 데이터형으로 받을 수 있다
	// 처음 시작에 데이터가 없는 경우 => String 
	public String board_detail(int no,Model model)
	{
		// Model => 전송객체 : request를 대체
		/*
		 *   => Cookie 
		 */
		BoardVO vo=dao.boardDetailData(no);
		model.addAttribute("vo", vo);
		
		return "board/detail";
	}
	// 수정 / 삭제 => 비번 검색 
	/*
	 *   메소드명은 상관없다 
	 *   리턴형 
	 *     String : 파일명 지정 / .do
	 *     void => 다운로드 
	 *   매개변수 사용 
	 *     일반데이터형 
	 *     배열 
	 *     List 
	 *     VO
	 *     내장 객체 : request,response,session
	 *              보안 객체 / RedirectAttributes
	 *                       | 
	 */
	@RequestMapping("update.do")
	public String board_update(int no,Model model)
	{
		BoardVO vo=dao.boardUpdateData(no);
		model.addAttribute("vo", vo);
		return "board/update";
	}
	
	/*@RequestMapping("update_ok.do")
	public String board_update_ok(BoardVO vo,Model model)
	{
		boolean bCheck=dao.boardUpdate(vo);
		model.addAttribute("bCheck", bCheck);
		model.addAttribute("no", vo.getNo());
		
		return "board/update_ok";
	}*/
	/*@RequestMapping("update_ok.do")
	@ResponseBody ==> 승격 
	// out.write() => 자바스크립트 전송 , JSON , 일반 문자열 전송
	public String board_update_ok(BoardVO vo)
	{
		String result="";
		boolean bCheck=dao.boardUpdate(vo);
		if(bCheck==true)
		{
		    result="<script>"
		          +"location.href=\"detail.do?no="+vo.getNo()+"\""
		          +"</script>";
		}
		else
		{
			result="<script>"
				  +"alert(\"비밀번호가 틀립니다!!\");"
				  +"history.back();"
				  +"</script>";
				  
		}
		return result;
	}*/
	// delete.do?no=${vo.no } // 데이터형이 다른 경우 400 Bad request
	// 404 , 500 , 400 , 403
	@RequestMapping("delete.do")
	public String board_delete(int no,Model model)
	{
		model.addAttribute("no", no);
		return "board/delete";
	}
}








