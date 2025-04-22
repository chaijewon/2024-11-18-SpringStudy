package com.sist.service;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.*;
import com.sist.vo.*;
@Service
public class ReserveServiceImpl implements ReserveService{
    @Autowired
    private ReserveDAO rDao;
    
    
	@Override
	public List<FoodVO> busanFoodReserveData() {
		// TODO Auto-generated method stub
		return rDao.busanFoodReserveData();
	}

}
