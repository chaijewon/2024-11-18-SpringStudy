package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;
@Repository("dDao")
public class DeptDAO {
	@Autowired
    private DeptMapper mapper;
	
	public List<DeptVO> deptListData()
	{
		return mapper.deptListData();
	}
}
