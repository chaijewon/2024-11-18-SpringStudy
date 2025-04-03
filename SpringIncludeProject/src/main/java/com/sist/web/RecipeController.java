package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
import com.sist.vo.*;
import com.sist.commons.CommonsPagination;
import com.sist.service.*;
@Controller
public class RecipeController {
   @Autowired
   private RecipeService service; // 자동 주입 (주소값)
   
   @GetMapping("recipe/detail.do")
   public String recipe_detail(int no,Model model)
   {
	   
	   RecipeDetailVO vo=service.recipeDetailData(no);
	   
	   String data=vo.getFoodmake();
	   String[] makes=data.split("\n");
	   
	   List<String> mList=new ArrayList<String>();
	   List<String> iList=new ArrayList<String>();
	   
	   for(String line:makes)
	   {
		   StringTokenizer st=new StringTokenizer(line,"^");
		   mList.add(st.nextToken());
		   iList.add(st.nextToken());
	   }
	   
	   model.addAttribute("mList", mList);
	   model.addAttribute("iList", iList);
	   
	   model.addAttribute("vo", vo);
	   model.addAttribute("main_jsp", "../recipe/detail.jsp");
	   // kList
	   return "main/main";
   }
   // GET / POST  
   @RequestMapping("recipe/find.do")
   public String recipe_find(String page,String fd,
		   Model model)
   {
	   // request => Model을 이용해서 전송 
	   Map map=CommonsPagination.pageConfig(page, 12);
	   //            => request가 포함 
	   int curpage=(int)map.get("curpage");
	   // map => start/end 
	   if(fd==null)
		   fd="감자";
	   map.put("fd", fd);
	   List<RecipeVO> list=service.recipeFindData(map);
	   final int BLOCK=10;
	   int startPage=((curpage-1)/BLOCK*BLOCK)+1;
	   int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
	   int totalpage=service.recipeFindTotalPage(map);
	   if(endPage>totalpage)
		   endPage=totalpage;
	   
	   model.addAttribute("list", list);
	   model.addAttribute("startPage", startPage);
	   model.addAttribute("endPage", endPage);
	   model.addAttribute("curpage", curpage);
	   model.addAttribute("totalpage", totalpage);
	   model.addAttribute("fd", fd); // JSP(X) => Ajax , Vue
	   
	   model.addAttribute("main_jsp", "../recipe/find.jsp");
	   return "main/main";
   }
   /*
    *     ?id=admin&pwd=1234
    *     (@RequestParam("id") String id,
    *      @RequestParam("pwd") String pwd)
    *      
    *     <form ...>
    *     (BoardVO vo)
    *     (@ModelAttribute("vo") BoardVO vo)
    *     
    *     
    */
   @GetMapping("recipe/chef_list.do")
   public String recipe_chef_list(Model model,String page)
   {
	   // 매개변수 => 순서가 없다 
	   /*
	    *   보안 
	    *   => 전송된 데이터 : String / 일반 데이터(int ,double...)
	    *                 ------- 숫자형 => null이 있는 경우 
	    *   => VO 단위
	    *   => String[] => checkbox
	    *   => List => name="a[]"
	    *   => 내장 객체 
	    *      = HttpServletRequest = Model 
	    *      = HttpServletResponse
	    *      = HttpSession 
	    *      = RedirectAttributes 
	    *   @Controller 
	    *    리턴형은 void , String 
	    *   @RestController 
	    *    String => json/일반데이터 전송 => javascript / kotlin 
	    */
	   Map map=CommonsPagination.pageConfig(page, 20);
	   int curpage=(int)map.get("curpage");
	   List<ChefVO> list=service.chefListData(map);
	   int totalpage=service.chefTotalPage();
	   final int BLOCK=10;
	   int startPage=((curpage-1)/BLOCK*BLOCK)+1;
	   int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
	   if(endPage>totalpage)
		   endPage=totalpage;
	   
	   model.addAttribute("list", list);
	   model.addAttribute("startPage", startPage);
	   model.addAttribute("endPage", endPage);
	   model.addAttribute("curpage", curpage);
	   model.addAttribute("totalpage", totalpage);
	   
	   model.addAttribute("main_jsp", "../recipe/chef_list.jsp");
	   return "main/main";
   }
}





