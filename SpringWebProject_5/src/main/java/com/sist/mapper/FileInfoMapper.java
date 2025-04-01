package com.sist.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.FileInfoVO;
import java.util.*;
public interface FileInfoMapper {
	   
	   @Insert("INSERT INTO springFileInfo VALUES("
			  +"#{no},#{filename},#{filesize})")
	   public void boardFileInsert(FileInfoVO vo);
	   
	   @Select("SELECT * FROM springfileinfo "
			  +"WHERE no=#{no}")
	   public List<FileInfoVO> fileListData(int no);
}
