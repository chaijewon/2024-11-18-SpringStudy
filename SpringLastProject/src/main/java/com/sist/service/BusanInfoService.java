package com.sist.service;

import java.util.List;
import java.util.Map;

import com.sist.vo.BusanInfoVO;

public interface BusanInfoService {
	public List<BusanInfoVO> busanInfoListData(Map map);
	public int busanInfoTotalPage(int cno);
	public BusanInfoVO busanInfoDetailData(int no);
}
