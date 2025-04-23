package com.sist.service;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;

import com.sist.dao.GoodsDAO;
import com.sist.service.*;
import com.sist.vo.*;
/*
 *     요청 = Service = DAO = 오라클 
 *     응답 = Service = DAO = 오라클 
 *                    ----------- 유지보수시에 클라이언트에 오류가 없게 ...
 */
public class GoodsServiceImpl implements GoodsService{
    @Autowired
    private GoodsDAO gDao;
    // Cart
	@Override
	public List<GoodsVO> busanGoodsListData(int start, int end) {
		// TODO Auto-generated method stub
		return gDao.busanGoodsListData(start, end);
	}

	@Override
	public int busanGoodsTotalPage() {
		// TODO Auto-generated method stub
		return gDao.busanGoodsTotalPage();
	}

	@Override
	public GoodsVO busanGoodsDetailData(int no) {
		// TODO Auto-generated method stub
		return gDao.busanGoodsDetailData(no);
	}

}
