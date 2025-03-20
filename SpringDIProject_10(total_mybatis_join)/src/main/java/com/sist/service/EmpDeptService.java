package com.sist.service;

import java.util.List;

import com.sist.vo.DeptVO;
import com.sist.vo.EmpVO;

public interface EmpDeptService {
	public List<EmpVO> empListData();
	public EmpVO empDetailData(int empno);
	public List<EmpVO> empJoinData();
	public List<DeptVO> deptListData();
}
