package com.sist.service;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.vo.*;
import com.sist.dao.*;
@Service
public class BusanInfoServiceImpl implements BusanInfoService{
    @Autowired
    private BusanInfoDAO bDao;

	@Override
	public List<BusanInfoVO> busanInfoListData(Map map) {
		// TODO Auto-generated method stub
		return bDao.busanInfoListData(map);
	}
	
	@Override
	public int busanInfoTotalPage(int cno) {
		// TODO Auto-generated method stub
		return bDao.busanInfoTotalPage(cno);
	}
  
  
}
