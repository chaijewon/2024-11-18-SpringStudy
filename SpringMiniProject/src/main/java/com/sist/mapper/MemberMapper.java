package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Insert;

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
  
  
}
