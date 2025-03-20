package com.sist.config;
// application-datasource.xml

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*
 *    <bean id="ds" class="org.apache.commons.dbcp.BasicDataSource"
       p:driverClassName="oracle.jdbc.driver.OracleDriver"
       p:url="jdbc:oracle:thin:@localhost:1521:XE"
       p:username="hr"
       p:password="happy"
    />
    <!-- MyBatis연동 : SqlSessionFactory : 오라클 연결/해제 -->
    <bean id="ssf" class="org.mybatis.spring.SqlSessionFactoryBean"
      p:dataSource-ref="ds"
    />
    <!-- Mapper구현 MapperFactoryBean : SQL문장을 읽어서 전송 / 결과값 -->
    <mybatis-spring:scan base-package="com.sist.mapper" factory-ref="ssf"/>
 */
// <mybatis-spring:scan base-package="com.sist.mapper" factory-ref="ssf"/>
@Configuration
@MapperScan(basePackages = "com.sist.mapper")
public class DatabaseConfig {
   /*
    * <bean id="ds" class="org.apache.commons.dbcp.BasicDataSource"
       p:driverClassName="oracle.jdbc.driver.OracleDriver"
       p:url="jdbc:oracle:thin:@localhost:1521:XE"
       p:username="hr"
       p:password="happy"
    />
    */
	@Bean("ds")
	public DataSource dataSource() 
	{
	    BasicDataSource ds=new BasicDataSource();
	    ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	    ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
	    ds.setUsername("hr");
	    ds.setPassword("happy");
	    return ds;
	}
	/*
	 *  <bean id="ssf" class="org.mybatis.spring.SqlSessionFactoryBean"
      p:dataSource-ref="ds"
    />
	 */
	@Bean("ssf")
	public SqlSessionFactory sqlSessionFactory() throws Exception
	{
		SqlSessionFactoryBean ssf=
				new SqlSessionFactoryBean();
		ssf.setDataSource(dataSource());
	    
		return ssf.getObject();
	}
}







