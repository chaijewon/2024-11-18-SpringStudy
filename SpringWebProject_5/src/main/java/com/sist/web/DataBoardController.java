package com.sist.web;
import org.springframework.beans.factory.annotation.Autowired;
/*
 *   
 *   @GetMapping : 목록출력 , 상세보기 => SELECT 
 *     default => 화면 출력 
 *                <a> sendRedirect , location.href
 *   @PostMapping : 입력값 INSERT 
 *                <form> ajax => type:'post'
 *                axios.post()
 *   ----------------------------- web에서는 두개만 사용 
 *   @PutMapping  :  수정 UPDATE
 *   @DeleteMapping : 삭제 DELETE 
 *   ---------------- RestFul @RequestMapping
 */
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
/*
 *    1. DataBase 연동 
 *    2. Web 연동
 *    
 *    NodeJS
 *      |     Model        DAO
 *    브라우저  <=====> 자바 <=====> 오라클 
 *                    |
 *                   파이썬
 *                   C#
 *           DispatcherServlet = HandleMapping 
 *                                   |
 *                                ViewResolver 
 *                                   |
 *                                  JSP
 *                |
 *              동작하기 위한 작업 설정 (메뉴얼 작업)
 *                               --------- XML , properties
 *                                         ----------------
 *                                         메타 데이터 
 *          1. 사용자가 요청한 데이터 읽기 => detail.do?no=10
 *             <a> <form> ajax , axios
 *                               | vue,react,next 
 *                        | Jquery
 *             *** detail.do  => *.do /*  => <url-mapping>
 *                       ---- DispatcherServlet web.xml
 *                             | => interceptor (자동로그인)
 *          2. DispatchServlet => HandlerMapping 
 *                                --------------
 *                                | @RequestMapping
 *                                | @GetMapping
 *                                | @PostMapping
 *                                  => 밑에 있는 메소드 호출 
 *                                  | 출력에 필요한 데이터를 JSP
 *                              -------------------------
 *                                      | => interceptor
 *                              | JSP로 데이터를 전송 
 *                                => 어떤 JSP로 전송 할지 
 *                                   = return "main/main.jsp"
 *                                => 어떤 값을 보낼지 
 *                                   = request.setAttribute()
 *                                   = model.addAttribute()
 *                                => 전송하는 클래스 
 *                                   = ViewResolver
 *                                     | 경로명 / 확장자 
 *                                      
 *                                      | => interceptor
 *          
 *             
 *                                  
 */
import java.util.*;
import com.sist.vo.*;
import com.sist.dao.*;
@Controller
public class DataBoardController {
   @Autowired
   private DataBoardDAO dDao;
   
   @Autowired
   private FileInfoDAO fDao;
   
   @GetMapping("databoard/list.do")
   // list.do
   public String databoard_list(String page,Model model)
   {
	   // request대신 JSP 전송하는 객체 : Model
	   // request => Cookie 읽기
	   // response => Cookie 저장 , 다운로드시에 사용 
	   /*
	    *  매개변수로 데이터를 받는 경우 
	    *  => 값이 없다 : String (null값이 들어간다)
	    *  => 모든 값이 있는 경우 : 해당 데이터형 
	    *  
	    *  => 요청값을 받는 경우 
	    *     ------------
	    *     1. 순서가 없다 
	    *     2. 모든 요청값은 String으로 받을 수 있다 
	    *     3. 데이터변경 요청 => 해당 데이터형 
	    *     4. 커맨드 객체 => 여러개가 동시에 => VO
	    *     5. List , String[]
	    *               | 동적 쿼리 
	    *        | 파일 업로드 
	    *     6. JSP 내장 객체를 받을 수 있다 
	    *        HttpServletRequest 
	    *        HttpServletResponse 
	    *        HttpSession 
	    *        RedirectAttributes 
	    *        ServletContext => application => realPath
	    */
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   List<DataBoardVO> list=dDao.boardListData((curpage*10)-9, curpage*10);
	   int count=dDao.boardRowCount();
	   int totalpage=(int)(Math.ceil(count/10.0));
	   count=count-((curpage*10)-10);
	   // 전송 
	   model.addAttribute("list", list);
	   model.addAttribute("curpage", curpage);
	   model.addAttribute("totalpage", totalpage);
	   model.addAttribute("count", count);
	   return "databoard/list";
	   
   }
   @GetMapping("databoard/insert.do")
   public String databoard_insert()
   {
	   return "databoard/insert";
   }
   
   @PostMapping("databoard/insert_ok.do")
   public String databoard_insert_ok(DataBoardVO vo)
   {
	   List<MultipartFile> list=vo.getFiles();
	   System.out.println("전송된 파일 수:"+list.size());
	   String path="c:\\download\\";
	   try
	   {
		   if(list.size()==0)
		   {
			   vo.setFilecount(0);
		   }
		   else
		   {
			   vo.setFilecount(list.size());
			  
		   }
		   
		   int no=dDao.boardInsert(vo);
		   System.out.println("no="+no);
		   // 파일 저장 => 데이터베이스에 저장 
		   
		   FileInfoVO fvo=new FileInfoVO();
		   if(list.size()>0)
		   {
			   for(MultipartFile mf:list)
			   {
				   String filename=mf.getOriginalFilename();
				   File file=new File(path+filename);
				   mf.transferTo(file);// 업로드 
				   
				   fvo.setFilename(filename);
				   fvo.setFilesize(file.length());
				   fvo.setNo(no);
				   
				   fDao.boardFileInsert(fvo);
			   }
		   }
		   
		   
	   }catch(Exception ex){}
	   return "redirect:list.do";
   }
	   
}
