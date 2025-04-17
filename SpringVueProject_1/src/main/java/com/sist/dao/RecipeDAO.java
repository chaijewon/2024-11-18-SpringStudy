package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;
@Repository
public class RecipeDAO {
   @Autowired
   private RecipeMapper mapper;
   
   /*
    *   @Select("SELECT no,poster,title,num "
		  +"FROM (SELECT no,poster,title,rownum as num "
		  +"FROM (SELECT + INDEX_ASC(recipe recipe_no_pk)no,poster,title "
		  +"FROM recipe)) "
		  +"WHERE num BETWEEN #{start} AND #{end}")
		   public List<RecipeVO> recipeListData(@Param("start") int start,
				   @Param("end") int end);
		   @Select("SELECT CEIL(COUNT(*)/12.0) FROM recipe")
		   public int recipeTotalPage();
    */
   public List<RecipeVO> recipeListData(int start,int end)
   {
	   return mapper.recipeListData(start, end);
   }
   public int recipeTotalPage()
   {
	   return mapper.recipeTotalPage();
   }
}
