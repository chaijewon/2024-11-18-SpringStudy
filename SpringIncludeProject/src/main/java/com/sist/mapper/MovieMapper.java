package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface MovieMapper {
  @Insert("INSERT INTO aopMovie VALUES("
		 +"#{mno},#{title},#{poster},#{director},#{genre})")
  public void movieInsert(MovieVO vo);
  
  @Delete("DELETE FROM aopMovie")
  public void movieDelete();
  
  @Select("SELECT * FROM aopMovie")
  public List<MovieVO> movieListData();
}
