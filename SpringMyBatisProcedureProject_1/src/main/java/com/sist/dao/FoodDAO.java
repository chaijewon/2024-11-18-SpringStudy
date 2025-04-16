package com.sist.dao;

import org.springframework.stereotype.Repository;
import java.util.*;
import java.sql.*;
import com.sist.vo.*;

import lombok.Setter;
import oracle.jdbc.OracleTypes;
/*
 *    class A
 *    
 *    map.put("a",new A()) => spring default singleton
 *    <bean ==> <context:component-scan>
 */
public class FoodDAO {
   private Connection conn;
   private CallableStatement cs;
   // => Default : PreparedStatement
   // @Options(statementType=StatementType.CALLABLE>
   @Setter
   private String url;
   @Setter
   private String username;
   @Setter
   private String password;
   
   public FoodDAO(String driver)
   {
	   try
	   {
		   Class.forName(driver);
	   }catch(Exception ex){}
   }
   
   public void getConnection()
   {
	   try
	   {
		   conn=DriverManager.getConnection(url,username,password);
	   }catch(Exception ex) {}
   }
   
   public void disConnection()
   {
	   try
	   {
		   if(cs!=null) cs.close();
		   if(conn!=null) conn.close();
	   }catch(Exception ex) {}
   }
   //////////////////// MyBatis는 자동 설정 
   public List<FoodVO> foodListData(int page)
   {
	   List<FoodVO> list=
			   new ArrayList<FoodVO>();
	   try
	   {
		   getConnection();
		   int rowSize=12;
		   int start=(rowSize*page)-(rowSize-1);
		   int end=rowSize*page;
		   /*
		    *  CREATE OR REPLACE PROCEDURE foodListData(
			   pStart NUMBER,
			   pEnd NUMBER,
			   pResult OUT SYS_REFCURSOR
			 )
			 IS
			 BEGIN
			   OPEN pResult FOR
			    SELECT fno,poster,name,num
			    FROM (SELECT fno,poster,name,rownum as num
			    FROM (SELECT fno,poster,name 
			    FROM project_food ORDER BY fno ASC))
			    WHERE num BETWEEN pStart AND pEnd;
			END;
			/
		    */
		   String sql="{CALL foodListData(?,?,?)}";
		   /*
		    *  @Select(value="{CALL foodListData(pStart,mode=IN,javaType=java.lang.Integer...}
		    */
		   cs=conn.prepareCall(sql);
		   cs.setInt(1, start);
		   cs.setInt(2, end);
		   cs.registerOutParameter(3, OracleTypes.CURSOR);
		   // ? 값 채우기 
		   cs.executeQuery();
		   ResultSet rs=(ResultSet)cs.getObject(3);
		   while(rs.next())
		   {
			   FoodVO vo=new FoodVO();
			   vo.setFno(rs.getInt(1));
			   vo.setPoster(rs.getString(2));
			   vo.setName(rs.getString(3));
			   list.add(vo);
		   }
		   rs.close();
		   // 모든 값이 => Map
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
   /*
    *    CREATE OR REPLACE PROCEDURE foodTotalPage(
		   pTotal OUT NUMBER
		)
		IS
		BEGIN
		  SELECT CEIL(COUNT(*)/12.0) INTO pTotal
		  FROM project_food;
		END;
		/
    */
   public int foodTotalPage()
   {
	   int total=0;
	   try
	   {
		   getConnection();
		   String sql="{CALL foodTotalPage(?)}";
		   cs=conn.prepareCall(sql);
		   cs.registerOutParameter(1, OracleTypes.INTEGER);
		   cs.executeQuery();
		   total=cs.getInt(1);
		   cs.close();
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
}
