package com.sist.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.FoodDAO;
import com.sist.vo.FoodVO;
/*
 *    요청 =====> Service ====> DAO ===> 오라클 
 *    응답 <===== Service <==== DAO <=== 오라클
 * 
 */
@Service
public class FoodRecipeServiceImpl implements FoodRecipeService{
    @Autowired
	private FoodDAO fDao;
    
	@Override
	public List<FoodVO> foodListData(Map map) {
		// TODO Auto-generated method stub
		return fDao.foodListData(map);
	}

	@Override
	public FoodVO foodDetailData(int fno) {
		// TODO Auto-generated method stub
		return fDao.foodDetailData(fno);
	}

}
