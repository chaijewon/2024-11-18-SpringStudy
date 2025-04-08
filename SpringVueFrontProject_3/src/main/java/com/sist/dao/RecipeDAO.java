package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;
@Repository // 스프링에서 메모리 할당 => 스프링에서 관리 
public class RecipeDAO {
   @Autowired
   private RecipeMapper mapper;
   
   public List<RecipeVO> recipeListData()
   {
	   return mapper.recipeListData();
   }
   
   
}
