package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.dao.*;
import com.sist.vo.*;

/*
 *   
 */

@RestController
public class RecipeRestController {
   // 필요한 객체 => 스프링에 요청 
   @Autowired
   private RecipeDAO dao;
   
   @GetMapping(value="recipe/list_vue.do",
		   produces = "text/plain;charset=UTF-8")
   public String list_vue() throws Exception
   {
	   List<RecipeVO> list=dao.recipeListData();
	   // javascript에서 인식 (연동) => JSON
	   ObjectMapper mapper=
			   new ObjectMapper();
	   String json=mapper.writeValueAsString(list);
	   return json;
   }
   /*
    *       params:{
        			   page:this.curpage,
        			   fd:this.fd
        		   }
    */
   @GetMapping(value="recipe/find_vue.do",
		   produces = "text/plain;charset=UTF-8")
   public String find_vue(int page,String fd)throws Exception
   {
	   
	   return "";
   }
}
