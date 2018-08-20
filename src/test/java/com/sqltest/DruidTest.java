package com.sqltest;

import com.sqltest.mapper.nanhuadata.TFactoryMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DruidTest {

    @Autowired
    private TFactoryMapper m_TFactoryMapper;

    @Resource(name = "OneTkDataSource")
    private DataSource dataSource;

    @Test
    public void testConnection() throws Exception {

        m_TFactoryMapper.selectAll();

        System.out.println("连接池情况："+this.dataSource);
        //System.out.println("无：");

    }
}
