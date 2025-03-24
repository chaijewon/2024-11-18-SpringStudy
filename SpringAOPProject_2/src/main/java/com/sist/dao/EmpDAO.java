package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;

public class EmpDAO {
   private MyDataSource ds;
   private Connection conn;
   private PreparedStatement ps;
   
   
   public EmpDAO(MyDataSource ds)
   {
	   this.ds=ds;
	   try
	   {
		   Class.forName(ds.getDriver());
	   }catch(Exception ex) {}
   }
   
   public void getConnection()
   {
	   try
	   {
		   conn=DriverManager.getConnection(ds.getUrl(),
				   ds.getUsername(),ds.getPassword());
	   }catch(Exception ex) {}
   }
   public void disConnection()
   {
	   try
	   {
		   if(ps!=null) ps.close();
		   if(conn!=null) conn.close();
	   }catch(Exception ex) {}
   }
   
   // 기능 설정 
   // => 목록 출력 => Around  => 호출된 메소드 / 수행 시간  
   public List<EmpVO> empListData()	
   {
	   List<EmpVO> list=new ArrayList<EmpVO>();
	   // before => getConnection
	   try
	   {
		   String sql="SELECT empno,ename,job,sal,TO_CHAR(hiredate,'YYYY-MM-DD') "
		              +"FROM emp";
		   ps=conn.prepareStatement(sql);
		   ResultSet rs=ps.executeQuery();
		   while(rs.next())
		   {
			   EmpVO vo=new EmpVO();
			   vo.setEmpno(rs.getInt(1));
			   vo.setEname(rs.getString(2));
			   vo.setJob(rs.getString(3));
			   vo.setSal(rs.getInt(4));
			   vo.setDbday(rs.getString(5));
			   list.add(vo);
		   }
		   rs.close();   
	   }catch(Exception ex){}
	   return list;
   }
   // => 상세보기  => Around
   public EmpVO empDetailData(int empno)
   {
	   EmpVO vo=new EmpVO();
	   // getConnection() => before
	   try
	   {
		   String sql="SELECT empno,ename,job,sal,TO_CHAR(hiredate,'YYYY-MM-DD') "
		              +"FROM emp "
				      +"WHERE empno="+empno;
		   ps=conn.prepareStatement(sql);
		   ResultSet rs=ps.executeQuery();
		   rs.next();
		   vo.setEmpno(rs.getInt(1));
		   vo.setEname(rs.getString(2));
		   vo.setJob(rs.getString(3));
		   vo.setSal(rs.getInt(4));
		   vo.setDbday(rs.getString(5));
		   rs.close();
	   }catch(Exception ex) {}
	   // disConnection  => after 
	   return  vo;
   }
   // => 리턴형 처리 / 에러 처리 / 
   
}
