package com.sist.dao;

import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.*;
@Repository
public class FileInfoDAO {
  @Autowired
  private FileInfoMapper mapper;
  
  /*
   *   @Insert("INSERT INTO springFileInfo VALUES("
			  +"#{no},#{filename},#{filesize})")
	   public void boardFileInsert(FileInfoVO vo);
   */
  public void boardFileInsert(FileInfoVO vo)
  {
	  mapper.boardFileInsert(vo);
  }
}
