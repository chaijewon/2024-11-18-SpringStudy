package com.sist.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.sql.*;
import com.sist.vo.*;
@Repository
//@Scope("prototype")
public class BoardDAO {
   private Connection conn;
   private PreparedStatement ps;
   private final String URL="jdbc:oracle:thin:@localhost:1521:xe";
   
   public BoardDAO()
   {
	   try
	   {
		   Class.forName("oracle.jdbc.driver.OracleDriver");
	   }catch(Exception ex){}
   }
   
   public void getConnection()
   {
	   try
	   {
		   conn=DriverManager.getConnection(URL,"hr","happy");
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
   /////////////////// => SqlSessionFactory
   public List<BoardVO> boardListData(int page)
   {
	   List<BoardVO> list=
			   new ArrayList<BoardVO>();
	   // => MyBatis : SQL , ? , 어떤 VO
	   try
	   {
		   // SELECT no,subject,name,hit,regdate FROM board
		   // LIMIT 11,10
		  getConnection();
		  String sql="SELECT no,subject,name,hit,regdate,num "
				    +"FROM (SELECT no,subject,name,hit,regdate,rownum as num "
				    +"FROM (SELECT no,subject,name,hit,regdate "
				    +"FROM springReplyBoard ORDER BY no DESC)) "
				    +"WHERE num BETWEEN ? AND ?";
		  ps=conn.prepareStatement(sql);
		  int rowSize=10;
		  int start=(rowSize*page)-(rowSize-1);
		  int end=rowSize*page;
		  
		  
		  ps.setInt(1, start);
		  ps.setInt(2, end);
		  
		  ResultSet rs=ps.executeQuery();
		  while(rs.next())
		  {
			  BoardVO vo=new BoardVO();
			  vo.setNo(rs.getInt(1));
			  vo.setSubject(rs.getString(2));
			  vo.setName(rs.getString(3));
			  vo.setHit(rs.getInt(4));
			  vo.setRegdate(rs.getDate(5));
			  list.add(vo);
		  }
		  
		  
	   }catch(Exception ex)
	   {
		  ex.printStackTrace();   
	   }
	   finally
	   {
		  disConnection();   
	   }
	   return list;
   }
   // insert / update / detail
   // reply / delete => 트랜잭션 
   
}
