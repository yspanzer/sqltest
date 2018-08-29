package com.sqltest.common;

import com.sqltest.util.ProjectConstant;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import java.util.Properties;

@Configuration
@AutoConfigureAfter(ThreeTkConfig.class)
public class ThreeTkMapperScanConfig {

    @Bean(name = "ThreeTkMapperScannerConfigurer")
    public MapperScannerConfigurer ThreeTkMapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();

        //注意这里的sqlSessionFactory就是Config里面的sqlSessionFactoryBean方法，注解bean的名字
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("ThreeTkSqlSessionFactory");
        //接口路径，通过这些接口调用sql的配置，操作数据库
        mapperScannerConfigurer.setBasePackage(ProjectConstant.MAPPER_PACKAGE_PERMISSION);

        //配置通用Mapper，详情请查阅官方文档
        Properties properties = new Properties();
        properties.setProperty("mappers", ProjectConstant.MAPPER_INTERFACE_REFERENCE_MYSQL);
        properties.setProperty("notEmpty", "false");
        //properties.setProperty("IDENTITY", "MYSQL");//配置数据库方言
        //properties.setProperty("IDENTITY", "SQLSERVER");//配置数据库方言
        //properties.setProperty("IDENTITY", "SELECT REPLACE(newid(),'-','')");//配置数据库方言 IDENTITY 用 SQLSERVER 语句取代
        properties.setProperty("ORDER","BEFORE");

        mapperScannerConfigurer.setProperties(properties);

        return mapperScannerConfigurer;

    }


}



