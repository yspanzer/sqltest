package com.sqltest.controller;

import com.sqltest.dao.savePqAndPq_FactoryImpl;
import com.sqltest.entity.nhtest.TestFactory;
import com.sqltest.entity.nhtest.TestPq;
import com.sqltest.mapper.nhtest.TestFactoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class NhTestController {

    @Autowired
    private TestFactoryMapper m_TestFactoryMapper;

    @Resource
    private savePqAndPq_FactoryImpl m_savePqAndPq_FactoryImpl;

    @RequestMapping("/testfactory")
    public TestFactory testfactory() throws Exception {

        System.out.println("进入NhTest测试,获得一个实体");

        TestFactory _TestFactory = m_TestFactoryMapper.selectByPrimaryKey("GX04");

        return (_TestFactory) ;

    }

    @RequestMapping("/testfactorylist")
    public List<TestFactory> testfactorylist(){

        System.out.println("进入NhTest测试，获得全部实体列表");

        return m_TestFactoryMapper.selectAll();
    }

    @RequestMapping("/TestRuntimeException")
    public String savePqAndPq_FactoryRuntimeException() throws Exception{

        TestPq _TestPq = new TestPq();
        _TestPq.setCode("CS1");
        _TestPq.setName("测试片区1");

        List<TestFactory> _TestFactoryList = m_TestFactoryMapper.selectAll();


        try {
            m_savePqAndPq_FactoryImpl.savePqAndPq_FactoryRuntimeException(_TestPq, _TestFactoryList);
        } catch (Exception e) {
            //return "发生异常了：手工设置RuntimeException：中断退出";
            e.printStackTrace();
        }

        return "正常执行！";
    }

}
