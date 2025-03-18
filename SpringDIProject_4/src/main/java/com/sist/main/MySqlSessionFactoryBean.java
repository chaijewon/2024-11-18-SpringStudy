package com.sist.main;

import org.mybatis.spring.SqlSessionFactoryBean;
/*
 *  <bean id="ssf" class="org.mybatis.spring.SqlSessionFactoryBean"
          p:dataSource-ref="ds"
     />
 */
public class MySqlSessionFactoryBean extends SqlSessionFactoryBean{
   public MySqlSessionFactoryBean()
   {
	   setDataSource(new MyBasicDataSource());
   }
}
