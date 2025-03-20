package com.sist.main;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.service.*;
import com.sist.vo.*;
@Component
public class MainClass {
	@Autowired
    private EmpDeptService service;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // XML => 전송 => 관리 
		ApplicationContext app=
				new ClassPathXmlApplicationContext("application-*.xml");
		MainClass mc=(MainClass)app.getBean("mainClass");
		List<EmpVO> eList=mc.service.empListData();
		System.out.println("=========== 사원 목록 =========");
		for(EmpVO vo:eList)
		{
			System.out.println(vo.getEmpno()+" "
					+vo.getEname()+" "
					+vo.getJob()+" "
					+vo.getDbday()+" "
					+vo.getSal());
		}
		System.out.println("=========== 부서 정보 =========");
		List<DeptVO> dList=mc.service.deptListData();
		for(DeptVO vo:dList)
		{
			System.out.println(vo.getDeptno()+" "
					+vo.getDname()+" "
					+vo.getLoc());
		}
		System.out.println("=========== Join Data =======");
		List<EmpVO> jList=mc.service.empJoinData();
		for(EmpVO vo:jList)
		{
			System.out.println(vo.getEmpno()+" "
					+vo.getEname()+" "
					+vo.getJob()+" "
					+vo.getDvo().getDname()+" "
					+vo.getDvo().getLoc()+" "
					+vo.getSal());
		}
		System.out.println("======== 사원 개인 정보 ========");
		Scanner scan=new Scanner(System.in);
		System.out.print("사번 입력:");
		int empno=scan.nextInt();
		EmpVO vo=mc.service.empDetailData(empno);
		System.out.println("사번:"+vo.getEmpno());
		System.out.println("이름:"+vo.getEname());
		System.out.println("직위:"+vo.getJob());
	}

}
