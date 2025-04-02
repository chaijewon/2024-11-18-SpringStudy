package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import com.sist.vo.*;
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
}
