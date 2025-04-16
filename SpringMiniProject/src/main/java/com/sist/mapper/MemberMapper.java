package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface MemberMapper {

  @Insert("INSERT INTO projectMember(userid,username,userpwd,"
		 +"sex,birthday,email,post,addr1,addr2,phone,content,enable) "
		 +"VALUES(#{userid},#{username},#{userpwd},"
		 +"#{sex},#{birthday},#{email},#{post},#{addr1},"
		 +"#{addr2},#{phone},#{content},1)")
  public void memberInsert(MemberVO vo);
  
  @Insert("INSERT INTO authority VALUES("
		 +"#{userid},'ROLE_USER')")
  public void memberAuthorityInsert(String id);
  
  @Select("SELECT userid,username,sex,email,phone,post,"
  		 +"addr1,addr2 "
		 +"FROM projectMember "
		 +"WHERE userid=#{userid}")
  public MemberVO memberSessionData(String userid);
  
}
