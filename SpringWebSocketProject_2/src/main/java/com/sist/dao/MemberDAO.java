package com.sist.dao;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;
@Repository
public class MemberDAO {
   @Autowired
   private MemberMapper mapper;
   
   /*
    *  @Select("SELECT COUNT(*) FROM project_member "
		 +"WHERE id=#{id}")
       public int memberIdCount(String id);
  
       @Select("SELECT pwd,id,name,sex FROM project_member "
		 +"WHERE id=#{id}")
       public MemberVO memberInfoData(String id);
    */
   public MemberVO memberLogin(String id,String pwd)
   {
	   MemberVO vo=new MemberVO();
	   int count=mapper.memberIdCount(id);
	   if(count==0) // ID가 없는 상태
	   {
		   vo.setMsg("NOID");   
	   }
	   else // ID가 있는 상태
	   {
		   MemberVO dbvo=mapper.memberInfoData(id);
		   if(pwd.equals(dbvo.getPwd()))
		   {
			  vo.setMsg("OK");
			  vo.setId(dbvo.getId());
			  vo.setName(dbvo.getName());
			  vo.setSex(dbvo.getSex());
			  // 로그인시에 세션에 저장할 데이터 
		   }
		   else
		   {
			   vo.setMsg("NOPWD");
		   }
	   }
	   return vo;
   }
}
