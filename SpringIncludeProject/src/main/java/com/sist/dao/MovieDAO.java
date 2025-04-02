package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;
@Repository
public class MovieDAO {
  @Autowired
  private MovieMapper mapper;
  
  /*
   *   @Insert("INSERT INTO aopMovie VALUES("
		 +"#{mno},#{title},#{poster},#{director},#{genre})")
	  public void movieInsert(MovieVO vo);
	  
	  @Delete("DELETE FROM aopMovie")
	  public void movieDelete();
	  
	  @Select("SELECT * FROM aopMovie")
	  public List<MovieVO> movieListData();
   */
  public void movieInsert(MovieVO vo)
  {
	  mapper.movieInsert(vo);
  }
  public void movieDelete()
  {
	  mapper.movieDelete();
  }
  public List<MovieVO> movieListData()
  {
	  return mapper.movieListData();
  }
  
  
}
