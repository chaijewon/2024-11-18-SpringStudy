package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.dao.*;
import com.sist.vo.*;
@RestController
/*
 *  [
 *     {empno:1....},
 *     {},
 *     {},
 *     
 *  ]
 *  {emp:[],dept:[]}
 */
public class EmpRestController {
   @Autowired
   private EmpDAO dao;
   
   @GetMapping(value="emp/list_vue.do",produces = "text/plain;charset=UTF-8")
   public String emp_list_vue() throws Exception
   {
	   List<EmpVO> eList=dao.empListData();
	   List<DeptVO> dList=dao.deptListData();
	   Map map=new HashMap();
	   map.put("emp", eList);
	   map.put("dept", dList);
	   // [] => JSON
	   ObjectMapper mapper=
			     new ObjectMapper();
	   String json=mapper.writeValueAsString(map);
	   return json;
   }
}
