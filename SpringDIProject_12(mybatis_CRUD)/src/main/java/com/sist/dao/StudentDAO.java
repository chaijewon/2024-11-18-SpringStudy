package com.sist.dao;
import java.util.*;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sist.vo.*;
// Annotation => 자동 구현 
// XML => 개발자 구현 
public class StudentDAO extends SqlSessionDaoSupport{
	public List<StudentVO> studentListData()
	{
		// SqlSession session=ssf.openSession()
		return getSqlSession().selectList("studentListData");
	}
	
	public StudentVO studentDetailData(int hakbun)
	{
		return getSqlSession().selectOne("studentDetailData",hakbun);
	}
	public void studentInsert(StudentVO vo)
	{
		getSqlSession().insert("studentInsert",vo);
	}
	public void studentDelete(int hakbun)
	{
		getSqlSession().delete("studentDelete",hakbun);
	}
	public void studentUpdate(StudentVO vo)
	{
		getSqlSession().update("studentUpdate",vo);
	}
}
