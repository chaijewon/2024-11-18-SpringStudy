package com.sist.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
// XML 대신 사용 
/*
 *   <aop:aspectj-autoproxy/>
 *   <context:component-scan base-package="com.sist.*"/>
 *   <bean id="viewReolver"
        class="org.springframework.web.servlet.view.InternalResourceViewResolver"
        p:prefix="/"
        p:suffix=".jsp" 
     />
 */
@Configuration  // 자동 메모리 할당 
// <aop:aspectj-autoproxy/>
@EnableAspectJAutoProxy
//<context:component-scan base-package="com.sist.*"/>
@ComponentScan(basePackages = {"com.sist.*"})
/*
 *   <mybatis-spring:scan base-package="com.sist.mapper"
      factory-ref="ssf"
    />
 */
@MapperScan(basePackages = {"com.sist.mapper"})
// <tx:annotation-driven/>
@EnableTransactionManagement
@EnableWebMvc
// xml / 자바 => xml+자바 
public class MvcConfig implements WebMvcConfigurer{

	// HandlerMapping,HandlerAdapter 초기화 
	/*
	 *   요청 (*.do) === DispatcherServlet === HandlerMapping 
	 *                                            | @GetMapping(URI)
	 *                                              @PostMapping(URI)
	 *                          Model(@Controller,@RestController) <=> DAO
	 *                                            | request/model
	 *                                       DispatcherServlet
	 *                                            | JSP를 역할 
	 *                                              => return "main/main"
	 *                                        ViewResolver
	 *                                            | request
	 *                                           JSP 
	 */
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	/*
	 *   <bean id="viewReolver"
	        class="org.springframework.web.servlet.view.
	        InternalResourceViewResolver"
	        p:prefix="/"
	        p:suffix=".jsp" 
	     />
	 */
	@Bean("viewResolver")
	public ViewResolver viewResolver()
	{
		InternalResourceViewResolver ir=
				new InternalResourceViewResolver();
		ir.setPrefix("/");
		ir.setSuffix(".jsp");
		return ir;
	}
	
	/*
	 *   <bean  id="ds" class="org.apache.commons.dbcp.BasicDataSource"
       p:driverClassName="#{db['driver']}"
       p:url="#{db['url']}"
       p:username="#{db['username']}"
       p:password="#{db['password']}"
    />
    <!-- 
       maxActive 8
       maxIdle   8
       maxWait   10000
     -->
    <!-- 
         @Transactional => AOP를 이용해서 처리
     -->
    <!-- MyBatis로 전송 : SqlSessionFactoryBean -->
    <bean 
       id="ssf"
       class="org.mybatis.spring.SqlSessionFactoryBean"
       p:dataSource-ref="ds"
    />
    <!-- SqlSessionFactoryBean을 이용해서 Mapper구현 
         모든 Mapper를 한번에 처리 <mybatis-spring>
         Mapper를 한개씩 처리 <bean..>
     -->
    <mybatis-spring:scan base-package="com.sist.mapper"
      factory-ref="ssf"
    />
	 */
	// BasicDataSource 
	@Bean("ds")
	public DataSource dataSource()
	{
		BasicDataSource ds=
				new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		ds.setUsername("hr");
		ds.setPassword("happy");
		return ds;
	}
	// SqlSessionFactory 
	@Bean("ssf")
	public SqlSessionFactory sqlSessionFactory()
	throws Exception
	{
		SqlSessionFactoryBean ssf=
				new SqlSessionFactoryBean();
		ssf.setDataSource(dataSource());
		return ssf.getObject();
	}
	/*
	 *   <bean id="transactionManager"
         class="org.springframework.jdbc.datasource.DataSourceTransactionManager"
          p:dataSource-ref="ds"
         />
	 */
	// Transaction 
	@Bean("transactionManager")
	public PlatformTransactionManager transactionManager()
	{
		DataSourceTransactionManager tx=
				new DataSourceTransactionManager();
		tx.setDataSource(dataSource());
		return tx;
	}
	// Mapper구현
  
}
