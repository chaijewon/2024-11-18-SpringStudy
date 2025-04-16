package com.sist.dao;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
  @Transactional
  public void memberInsert(MemberVO vo)
  {
	  mapper.memberInsert(vo);
	  mapper.memberAuthorityInsert(vo.getUserid());
  }
  /*
   *   @Select("SELECT userid,username,sex,email,phone,post,"
  		 +"addr1,addr2 "
		 +"FROM projectMember "
		 +"WHERE userid=#{userid}")
       public MemberVO memberSessionData(String userid);
   */
  // => login_ok
  public MemberVO memberSessionData(String userid)
  {
	  return mapper.memberSessionData(userid);
  }
}
