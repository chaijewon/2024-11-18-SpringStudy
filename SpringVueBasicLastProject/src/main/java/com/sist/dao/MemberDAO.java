package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.MemberMapper;
import com.sist.vo.MemberVO;

@Repository
public class MemberDAO {
   @Autowired
   private MemberMapper mapper;
   
   public MemberVO memberGetInfoData(String id,String pwd)
   {
	   MemberVO vo=new MemberVO();
	   int count=mapper.memberIdCount(id);
	   if(count==0)
	   {
		   vo.setMsg("NOID");
	   }
	   else
	   {
		   MemberVO dbVo=mapper.memberGetInfoData(id);
		   if(pwd.equals(dbVo.getPwd()))
		   {
			   vo.setMsg("OK");
			   vo.setId(dbVo.getId());
			   vo.setName(dbVo.getName());
			   vo.setSex(dbVo.getSex());
		   }
		   else
		   {
			   vo.setMsg("NOPWD");
		   }
	   }
	   
	   return vo;
   }
}
