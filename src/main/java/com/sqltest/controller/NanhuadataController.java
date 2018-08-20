package com.sqltest.controller;

import com.sqltest.entity.nanhuadata.TFactory;

import com.sqltest.mapper.nanhuadata.TFactoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NanhuadataController {

    @Autowired
    private TFactoryMapper m_TFactoryMapper;

    @RequestMapping("/tfactory")
    public TFactory tfactory() throws Exception {

        System.out.println("进入TEST测试");

        TFactory _TFactory = m_TFactoryMapper.selectByPrimaryKey("GX01");

        return (_TFactory) ;

    }

    @RequestMapping("/getstring")
    public String getString(String code){


        return m_TFactoryMapper.getString(code);
    }

    @RequestMapping(value = "/getentitylist", method = RequestMethod.GET )
    public List<TFactory> getEntiyList(){


        return m_TFactoryMapper.getEntiyList();

    }


}
