package com.sqltest.common;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.github.pagehelper.PageHelper;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;


@Configuration
public class OneTkConfig {
/*
    @Bean(name = "OneTkDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource OneTkDataSource() {
        return DataSourceBuilder.create().build();
    }
    */

    //改造DataSource，以装配Druid
    @Bean(name = "OneTkDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.one.druid")
    @Primary
    public DataSource OneTkDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        return dataSource;
    }

    //装配Druid
    @Bean
    public ServletRegistrationBean druidStatViewServlet() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        registrationBean.addInitParameter("allow", "127.0.0.1"); // IP白名单 (没有配置或者为空，则允许所有访问)
        registrationBean.addInitParameter("deny", ""); // IP黑名单 (存在共同时，deny优先于allow)
        registrationBean.addInitParameter("loginUsername", "admin");
        registrationBean.addInitParameter("loginPassword", "admin");
        registrationBean.addInitParameter("resetEnable", "false");
        return registrationBean;
    }

    //装配Druid
    @Bean
    public FilterRegistrationBean druidWebStatViewFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new WebStatFilter());
        registrationBean.addInitParameter("urlPatterns", "/*");
        registrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*");
        return registrationBean;
    }


    @Bean(name = "OneTkSqlSessionFactory")
    @Primary
    public SqlSessionFactory OneTkSqlSessionFactory(@Qualifier("OneTkDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);

        //配置分页插件，详情请查阅官方文档
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

        //添加分页插件
        bean.setPlugins(new Interceptor[]{pageHelper});

        //添加XML目录
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/nanhuadata/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "OneTkSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate OneTkSqlSessionTemplate(@Qualifier("OneTkSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    //增加事务
    @Bean(name = "OneTkTransactionManager")
    @Primary
    public DataSourceTransactionManager OneTkTransactionManager(@Qualifier("OneTkDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }


}

