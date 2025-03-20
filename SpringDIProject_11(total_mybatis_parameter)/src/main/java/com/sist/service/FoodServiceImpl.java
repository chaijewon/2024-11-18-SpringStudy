package com.sist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.FoodDAO;
import com.sist.vo.FoodVO;

@Service
public class FoodServiceImpl {
   @Autowired
   private FoodDAO fDao;
   
   public List<FoodVO> foodListData(int start,int end)
   {
	   return fDao.foodListData(start, end);
   }
   public int foodTotalPage()
   {
	   return fDao.foodTotalPage();
   }
}
