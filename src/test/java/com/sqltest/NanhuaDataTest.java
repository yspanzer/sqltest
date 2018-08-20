package com.sqltest;

import com.sqltest.controller.HelloController;
import com.sqltest.entity.nanhuadata.TFactory;
import com.sqltest.mapper.nanhuadata.TFactoryMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NanhuaDataTest {

    @Autowired
    private TFactoryMapper m_TFactoryMapper;

    @Test
    public void getFactorys() throws Exception {

        List<TFactory> _FactoryList = m_TFactoryMapper.selectAll();
        System.out.println("-------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("测试结果：");
/*

        for(int i=0;i<_FactoryList.size();i++){
            System.out.println("测试结果——企业编码："+_FactoryList.get(i).getCode() + "；  企业名称："+_FactoryList.get(i).getName());
        }
*/

        for (TFactory factory : _FactoryList) {
            System.out.println("企业编码："+factory.getCode() + "；  企业名称："+factory.getName());
        }

        System.out.println("-------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------");

    }

}
