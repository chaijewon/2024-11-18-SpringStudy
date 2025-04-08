package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// 화면 변경 => forward => request(model) 전송
// return "폴더/파일명" 
// sendRedirect => 이미 만즐어진 화면으로 다시 이동 
// --- request(model) 전송이 불가능 _ok 
// return "redirect: list.do"
// 리턴형 => void(다운로드) , String 
/*
 *    1. 매칭 
 *       사용자 URI 매칭 => 메소드를 찾아서 호출 
 *       -----------
 *       @GetMapping(URI)
 *       @PostMapping 
 *       ------------- + @RequestMapping
 *    2. 매개변수
 *       => request.getParameter를 처리후에 매개변수에 전송 
 *          --------------------
 *          => 사용자 전송한 데이터는 String 
 *          => 변환후 받는 경우 
 *          (String page) (int page)
 *                        =========== 모든 데이터 값을 가지고 있는 경우
 *          => 여러개 데이터를 동시에 String[] , List
 *                            ---------  ------
 *                            checkbox    file[0]...
 *          => VO단위 값을 받을 수 있다 : 커맨드 객체 
 *             ?no=10 .... ?page=1
 *              --          -----
 *             (int no)    (int page)
 *             <input type=text name=name>
 *                                   -----
 *             <input type=text name=subject>
 *                                   --------
 *             (String name , String subject)
 *          => 객체 사용이 가능 
 *             -----------
 *             Model => 전송 
 *             HttpServletRequest 
 *             HttpServletResponse 
 *             HttpSession
 *             RedirectAttributes 
 *          => 매개변수는 순서가 없다 
 *          
 *          
 *          1. 사용자 요청값 받기 => 매개변수 
 *          2. 요청처리후 JSP로 값 전송 
 *                    ------------
 *                    model.addAttribute()
 *               |
 *              DAO 
 *             -----
 *             
 */
@Controller
public class RecipeController {
    // 스프링에 저장되는 객체를 가지고 온다 => 스프링에서는 지역변수는 제어가 불가능 
	// 스프링은 전역변수만 제어 가능 => @Autowired
	// router
	@GetMapping("recipe/list.do")
	public String recipe_list()
	{
		return "recipe/list";
	}
}
