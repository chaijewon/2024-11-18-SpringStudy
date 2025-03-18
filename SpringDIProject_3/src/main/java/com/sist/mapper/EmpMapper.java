package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.main.EmpVO;
public interface EmpMapper {
   public List<EmpVO> empListData();
   
}
