package com.sist.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.vo.SawonVO;

// Spring => ����� ���� => ~Controller
// Struts => ~Action
// ����� => ~Model
@Controller
public class SawonController {
    @RequestMapping("sawon/insert.do")
    public String swaon_insert(HttpServletRequest request,
    		HttpServletResponse response)
    {
    	
    	return "sawon/insert";
    }
    @RequestMapping("sawon/insert_ok.do")
    public String swaon_insert_ok(HttpServletRequest request,
    		HttpServletResponse response)
    {
    	String sabun=request.getParameter("sabun");
    	String name=request.getParameter("name");
    	String job=request.getParameter("job");
    	String dept=request.getParameter("dept");
    	String loc=request.getParameter("loc");
    	String pay=request.getParameter("pay");
    	SawonVO vo=new SawonVO();
    	vo.setSabun(Integer.parseInt(sabun));
    	vo.setPay(Integer.parseInt(pay));
    	vo.setName(name);
    	vo.setLoc(loc);
    	vo.setJob(job);
    	vo.setDept(dept);
    	
    	request.setAttribute("vo", vo);
        return "sawon/output";	
    }
    
    @RequestMapping("sawon/insert_ok2.do")
    public String swaon_insert_ok2(HttpServletRequest request,
    		SawonVO vo)
    {
    	
    	
    	request.setAttribute("vo", vo);
        return "sawon/output";	
    }
}
