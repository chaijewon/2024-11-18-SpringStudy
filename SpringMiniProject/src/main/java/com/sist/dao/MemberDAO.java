package com.sist.dao;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;
@Repository
public class MemberDAO {
  @Autowired
  private MemberMapper mapper;
  
  /*
   *   @Insert("INSERT INTO projectMember(userid,username,userpwd,"
		 +"sex,birthday,email,post,addr1,addr2,phone,content) "
		 +"VALUES(#{userid},#{username},#{userpwd},"
		 +"#{sex},#{birthday},#{email},#{post},#{addr1},"
		 +"#{addr2},#{phone},#{content})")
       public void memberInsert(MemberVO vo);
  
       @Insert("INSERT INTO authority VALUES("
		 +"#{userid},'ROLE_USER')")
       public void memberAuthorityInsert(String id);
   */
  public void memberInsert(MemberVO vo)
  {
	  mapper.memberInsert(vo);
  }
  public void memberAuthorityInsert(String id)
  {
	  mapper.memberAuthorityInsert(id);
  }
}
