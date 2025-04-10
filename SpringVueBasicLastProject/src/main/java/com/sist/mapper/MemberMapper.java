package com.sist.mapper;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.MemberVO;

public interface MemberMapper {
  @Select("SELECT COUNT(*) FROM project_member "
		 +"WHERE id=#{id}")
  public int memberIdCount(String id);
  
  @Select("SELECT id,name,pwd,sex FROM project_member "
		 +"WHERE id=#{id}")
  public MemberVO memberGetInfoData(String id);
  
}
