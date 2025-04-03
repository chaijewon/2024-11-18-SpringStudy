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
   // 총페이지 
   public int boardRowCount()
   {
	   int total=0;
	   try
	   {
		   getConnection();
		   String sql="SELECT COUNT(*) FROM springReplyBoard";
		   ps=conn.prepareStatement(sql);
		   ResultSet rs=ps.executeQuery();
		   rs.next();
		   total=rs.getInt(1);
		   rs.close();
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();   
	   }
	   finally
	   {
		   disConnection();
	   }
	   return total;
   }
   // insert / update / detail
   public void boardInsert(BoardVO vo)
   {
	   try
	   {
		   getConnection();
		   String sql="INSERT INTO springReplyBoard("
				     +"no,name,subject,content,pwd,group_id) "
				     +"VALUES(srb_no_seq.nextval,?,?,?,?,"
				     +"(SELECT NVL(MAX(group_id)+1,1) FROM springReplyBoard))";
		   ps=conn.prepareStatement(sql);
		   ps.setString(1, vo.getName());
		   ps.setString(2, vo.getSubject());
		   ps.setString(3, vo.getContent());
		   ps.setString(4, vo.getPwd());
		   ps.executeUpdate();
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();   
	   }
	   finally
	   {
		   disConnection();
	   }
   }
   /*
    *   @Aspect
    *   public class Transactional
    *   {
    *      @Around()
    *      public void around(JoinPoint jp)
    *      {
    *          ---------- setAutoCommit(false)
    *          소스 코딩
    *          ---------- commit
    *      }
    *      @AfterThrowable()
    *      public void afterThrowing(Exception e)
    *      {
    *         // catch
    *         rollback()
    *      }
    *      @After()
    *      public void after()
    *      {
    *         // finally
    *         setAutoCommit(true)
    *      }
    *   } 
    */
   public BoardVO boardDetailData(int no)
   {
	   BoardVO vo=new BoardVO();
	   try
	   {
		   getConnection();
		    
		   // around start
		   conn.setAutoCommit(false);
		   
		   String sql="UPDATE springReplyBoard SET "
				     +"hit=hit+1 "
				     +"WHERE no="+no;
		   ps=conn.prepareStatement(sql);
		   ps.executeUpdate(); // commit
		   
		   sql="SELECT no,name,subject,content,hit,regdate "
			   +"FROM springReplyBoard "
			   +"WHERE no="+no;
		   ps=conn.prepareStatement(sql);
		   ResultSet rs=ps.executeQuery();
		   rs.next();
		   vo.setNo(rs.getInt(1));
		   vo.setName(rs.getString(2));
		   vo.setSubject(rs.getString(3));
		   vo.setContent(rs.getString(4));
		   vo.setHit(rs.getInt(5));
		   vo.setRegdate(rs.getDate(6));
		   
		   rs.close();
		   // around end
		   conn.commit();
		   
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
		   // jdbc => mybatis => jpa 
		   // ajax = vue = react
		   // after-throwing 
		   try
		   {
			   conn.rollback();
		   }catch(Exception e) {}
	   }
	   finally
	   {
		   try
		   {
			   conn.setAutoCommit(true); // after 
		   }catch(Exception ex) {}
		   disConnection();
	   }
	   return vo;
   }
   public BoardVO boardUpdateData(int no)
   {
	   BoardVO vo=new BoardVO();
	   try
	   {
		   getConnection();
		    
		 
		   String sql="SELECT no,name,subject,content,hit,regdate "
			   +"FROM springReplyBoard "
			   +"WHERE no="+no;
		   ps=conn.prepareStatement(sql);
		   ResultSet rs=ps.executeQuery();
		   rs.next();
		   vo.setNo(rs.getInt(1));
		   vo.setName(rs.getString(2));
		   vo.setSubject(rs.getString(3));
		   vo.setContent(rs.getString(4));
		   vo.setHit(rs.getInt(5));
		   vo.setRegdate(rs.getDate(6));
		   
		   rs.close();
		 
		   
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
		  
	   }
	   finally
	   {
		  
		   disConnection();
	   }
	   return vo;
   }
   // reply / delete => 트랜잭션 
   
}
