package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface MusicMapper {
  @Insert("INSERT INTO musicData VALUES("
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
}
