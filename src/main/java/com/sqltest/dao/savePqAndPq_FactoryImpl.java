package com.sqltest.dao;

import com.sqltest.entity.nhtest.Pq_Factory;
import com.sqltest.entity.nhtest.TestFactory;
import com.sqltest.entity.nhtest.TestPq;
import com.sqltest.mapper.nhtest.Pq_FactoryMapper;
import com.sqltest.mapper.nhtest.TestPqMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
public class savePqAndPq_FactoryImpl{

    @SuppressWarnings("all")
    @Autowired
    private TestPqMapper m_TestPqMapper;

    @SuppressWarnings("all")
    @Autowired
    private Pq_FactoryMapper m_Pq_FactoryMapper;

    @Transactional(value="TwoTkTransactionManager")
    public void savePqAndPq_FactoryRuntimeException(TestPq pTestPq, List<TestFactory> pTestFactoryList) {

        m_TestPqMapper.insert(pTestPq);
        System.out.println("插入片区code：" + pTestPq.getCode()
                        + "--片区name：" + pTestPq.getName()
        );

        for (TestFactory factory : pTestFactoryList){

            while(factory.getCode().equals("GX03")) {

                //手手工设置故障，故障类型RuntimeException
                System.out.println("手工设置RuntimeException：中断退出");
                throw new RuntimeException("手工设置RuntimeException：发生异常了..");
                //int a = 1/0; //抛出ArithmeticException异常
            }


            Pq_Factory _Pq_Factory = new Pq_Factory();
            _Pq_Factory.setPqcode(pTestPq.getCode());
            _Pq_Factory.setFactorycode(factory.getCode());

            m_Pq_FactoryMapper.insert(_Pq_Factory);

            System.out.println("插入记录的GUID：" + _Pq_Factory.getGuid()
                    + "--片区code：" + _Pq_Factory.getPqcode()
                    + "--企业code：" + _Pq_Factory.getFactorycode()
            );


        }


    }

    @Transactional(value="TwoTkTransactionManager",rollbackFor = Exception.class)
    public void savePqAndPq_FactorySQLException(TestPq pTestPq, List<TestFactory> pTestFactoryList) throws SQLException {

        m_TestPqMapper.insert(pTestPq);
        System.out.println("插入片区code：" + pTestPq.getCode()
                + "--片区name：" + pTestPq.getName()
        );

        for (TestFactory factory : pTestFactoryList){

            //while(factory.getCode().equals("GX03")) {

                //手手工设置故障，故障类型 SQLException
                //System.out.println("手工设置SQLException：中断退出");

                //throw new SQLException("手工设置SQLException：发生异常了..");
                //int a = 1/0;//抛出ArithmeticException异常

            //}


            Pq_Factory _Pq_Factory = new Pq_Factory();
            _Pq_Factory.setPqcode(pTestPq.getCode());
            _Pq_Factory.setFactorycode(factory.getCode());

            m_Pq_FactoryMapper.insert(_Pq_Factory);

            System.out.println("插入记录的GUID：" + _Pq_Factory.getGuid()
                    + "--片区code：" + _Pq_Factory.getPqcode()
                    + "--企业code：" + _Pq_Factory.getFactorycode()
            );


        }


    }


}
