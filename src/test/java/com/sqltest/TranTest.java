package com.sqltest;

import com.sqltest.dao.savePqAndPq_FactoryImpl;
import com.sqltest.entity.nhtest.TestFactory;
import com.sqltest.entity.nhtest.TestPq;
import com.sqltest.mapper.nhtest.TestFactoryMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TranTest {

    @Resource
    private savePqAndPq_FactoryImpl m_savePqAndPq_FactoryImpl;

    //@Autowired
    //private savePqAndPq_FactoryImpl m_savePqAndPq_FactoryImpl;

    @Autowired
    private TestFactoryMapper m_TestFactoryMapper;

    @Test
    public void savePqAndPq_FactoryRuntimeException() throws Exception{

        TestPq _TestPq = new TestPq();
        _TestPq.setCode("CS1");
        _TestPq.setName("测试片区1");

        List<TestFactory> _TestFactoryList = m_TestFactoryMapper.selectAll();

        //m_savePqAndPq_FactoryImpl.savePqAndPq_FactoryRuntimeException(_TestPq, _TestFactoryList);

        try {
            m_savePqAndPq_FactoryImpl.savePqAndPq_FactoryRuntimeException(_TestPq, _TestFactoryList);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Test
    public void savePqAndPq_FactorySQLException() throws Exception{

        TestPq _TestPq = new TestPq();
        _TestPq.setCode("CS2");
        _TestPq.setName("测试片区2");

        List<TestFactory> _TestFactoryList = m_TestFactoryMapper.selectAll();

        //m_savePqAndPq_FactoryImpl.savePqAndPq_FactoryRuntimeException(_TestPq, _TestFactoryList);

        try {
            m_savePqAndPq_FactoryImpl.savePqAndPq_FactorySQLException(_TestPq, _TestFactoryList);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
