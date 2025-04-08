package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;
// 스프링 관리하는 클래스 => 기능을 가지고 있는 클래스 
// ~DAO , ~Manager , ~Service 
@Repository
public class RecipeDAO {
   @Autowired
   private RecipeMapper mapper;
   
   /*
    *   @Select("SELECT no,poster,title,num "
		 +"FROM (SELECT no,poster,title,rownum as num "
		 +"FROM (SELECT + INDEX_ASC(recipe recipe_no_pk)no,poster,title "
		 +"FROM recipe WHERE no IN(SELECT no FROM recipe INTERSECT SELECT no FROM recipedetail))) "
		 +"WHERE num BETWEEN #{start} AND #{end}")
		  public List<RecipeVO> recipeListData(@Param("start") int start,
				  @Param("end") int end);
		  
		  @Select("SELECT CEIL(COUNT(*)/12.0) FROM recipe "
				 +"WHERE no IN(SELECT no FROM recipe INTERSECT SELECT no FROM recipedetail)")
		  public int recipeTotalPage();
    */
   public List<RecipeVO> recipeListData(int start,int end)
   {
	   return mapper.recipeListData(start, end);
   }
   public int recipeTotalPage()
   {
	   return  mapper.recipeTotalPage();
   }
}
