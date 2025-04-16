package com.sist.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.MusicVO;
import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.*;
@Repository
public class MusicDAO {
   @Autowired
   private MusicMapper mapper;
  /*
   *   @Insert("INSERT INTO musicData VALUES("
		 +"(SELECT NVL(MAX(no)+1,1) FROM musicData),"
		 +"#{title},#{singer})")
	  public void musicInsert(MusicVO vo);
	  
	  @Delete("DELETE FROM musicData")
	  public void musicDelete();
	  
	  @Select("SELECT * FROM musicData "
			 +"WHERE no=1")
	  public MusicVO musicTop();
	  
	  // <delete id="allDelete" parameterType="int">
	  public void allDelete(int empno);
   */
   public void musicInsert(MusicVO vo)
   {
	   mapper.musicInsert(vo);
   }
   public void musicDelete()
   {
	   mapper.musicDelete();
   }
   public MusicVO musicTop()
   {
	   return mapper.musicTop();
   }
   public void allDelete(int empno)
   {
	   mapper.allDelete(empno);
   }
}
