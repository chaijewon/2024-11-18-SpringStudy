package com.sist.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.FileInfoVO;

public interface FileInfoMapper {
	   
	   @Insert("INSERT INTO springFileInfo VALUES("
			  +"#{no},#{filename},#{filesize})")
	   public void boardFileInsert(FileInfoVO vo);
}
