package com.sqltest.common;

import com.sqltest.util.ProjectConstant;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;


import java.util.Properties;


@Configuration
@AutoConfigureAfter(OneTkConfig.class)
public class OneTkMapperScanConfig {

    @Bean(name = "OneTkMapperScannerConfigurer")
    public MapperScannerConfigurer OneTkMapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();

        //注意这里的sqlSessionFactory就是Config里面的sqlSessionFactoryBean方法，注解bean的名字
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("OneTkSqlSessionFactory");
        //接口路径，通过这些接口调用sql的配置，操作数据库
        mapperScannerConfigurer.setBasePackage(ProjectConstant.MAPPER_PACKAGE_NANHUADATA);

        //配置通用Mapper，详情请查阅官方文档
        Properties properties = new Properties();
        properties.setProperty("mappers", ProjectConstant.MAPPER_INTERFACE_REFERENCE);
        properties.setProperty("notEmpty", "false");
        //properties.setProperty("IDENTITY", "MYSQL");//配置数据库方言
        //properties.setProperty("IDENTITY", "SQLSERVER");//配置数据库方言

        mapperScannerConfigurer.setProperties(properties);

        return mapperScannerConfigurer;

    }


    /**
     * 配置mybatis的分页插件pageHelper
     */
/*
    @Bean(name = "OneTkPageHelper")
    public PageHelper OneTkPageHelper(){
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();

        //properties.setProperty("pageSizeZero", "true");//分页尺寸为0时查询所有纪录不再执行分页

        properties.setProperty("supportMethodsArguments", "true");//支持通过 Mapper 接口参数来传递分页参数


        //设置为true时，会将RowBounds第一个参数offset当成pageNum页码使用
        properties.setProperty("offsetAsPageNum","true");
        //置为true时，使用RowBounds分页会进行count查询
        properties.setProperty("rowBoundsWithCount","true");
        //合理化查询,启用合理化时，
        //如果pageNum<1会查询第一页，如果pageNum>pages会查询最后一页
        //未开启时如果pageNum<1或pageNum>pages会返回空数据
        properties.setProperty("reasonable","true");    //页码<=0 查询第一页，页码>=总页数查询最后一页
        //配置mysql数据库的方言
        properties.setProperty("dialect","sqlserver");
        pageHelper.setProperties(properties);
        return pageHelper;
    }
*/


}

