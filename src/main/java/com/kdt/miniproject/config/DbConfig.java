package com.kdt.miniproject.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;


 @Configuration
@MapperScan(basePackages = "com.kdt.miniproject.mapper" )
public class DbConfig {
 @Bean
 public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
  SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
  
  factory.setDataSource(dataSource);
  PathMatchingResourcePatternResolver resolver 
  = new PathMatchingResourcePatternResolver();
  factory.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
  return factory.getObject();
 }

 @Bean
 public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception{
  return new SqlSessionTemplate(sqlSessionFactory);
 }
}
