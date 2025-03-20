package com.sist.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// application-context.xml
// <context:component-scan base-package="com.sist.*"/>
@Configuration
@ComponentScan(basePackages = "com.sist.*")
public class EmpConfg {

}
