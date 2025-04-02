package com.sist.mapper;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface RecipeDetailMapper {
  @Select("SELECT * FROM recipedetail "
		 +"WHERE no=#{no}")
  public RecipeDetailVO recipeDetailData(int no);
}
