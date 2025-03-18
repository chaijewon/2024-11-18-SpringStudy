package com.sist.main;
import java.util.*;
// SqlSessionFactory

import com.sist.mapper.EmpMapper;

public class EmpDAO {
    private EmpMapper mapper;

	public void setMapper(EmpMapper mapper) {
		this.mapper = mapper;
	}
	
	public List<EmpVO> empListData()
	{
		return mapper.empListData();
	}
   
}
