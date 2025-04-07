package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface RecipeMapper {
  @Select("SELECT no,poster,title,rownum "
		 +"FROM recipe "
		 +"WHERE rownum<=12")
  public List<RecipeVO> recipeListData();
}
