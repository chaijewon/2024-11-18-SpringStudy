package com.sist.dao;

import org.springframework.stereotype.Component;

import lombok.Data;
// BasicDataSource
/*
 *   <bean id="ds" class="com.sist.dao.MyDataSource"
      p:driver="oracle.jdbc.driver.OracleDriver"
      p:url="jdbc:oracle:thin:@localhost:1521:XE"
      p:username="hr"
      p:password="happy"
    />
 */
@Data
@Component
public class MyDataSource {
   private String driver;
   private String url,username,password;
   public MyDataSource()
   {
	  setDriver("oracle.jdbc.driver.OracleDriver");
	  setUrl("jdbc:oracle:thin:@localhost:1521:XE");
	  setUsername("hr");
	  setPassword("happy");
   }
}
