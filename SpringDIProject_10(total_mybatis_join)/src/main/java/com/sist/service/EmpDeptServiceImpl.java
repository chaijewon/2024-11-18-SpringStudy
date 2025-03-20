package com.sist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.DeptDAO;
import com.sist.dao.EmpDAO;
import com.sist.vo.DeptVO;
import com.sist.vo.EmpVO;

@Service
public class EmpDeptServiceImpl implements EmpDeptService{

	@Autowired
	private EmpDAO eDao;
	
	@Autowired
	private DeptDAO dDao;
	
	@Override
	public List<EmpVO> empListData() {
		// TODO Auto-generated method stub
		return eDao.empListData();
	}

	@Override
	public EmpVO empDetailData(int empno) {
		// TODO Auto-generated method stub
		return eDao.empDetailData(empno);
	}

	@Override
	public List<EmpVO> empJoinData() {
		// TODO Auto-generated method stub
		return eDao.empJoinData();
	}

	@Override
	public List<DeptVO> deptListData() {
		// TODO Auto-generated method stub
		return dDao.deptListData();
	}

}
