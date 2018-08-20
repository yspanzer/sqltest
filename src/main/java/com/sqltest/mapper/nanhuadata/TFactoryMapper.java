package com.sqltest.mapper.nanhuadata;

import com.sqltest.entity.nanhuadata.TFactory;
import com.sqltest.util.MyMapper;

import java.util.List;

public interface TFactoryMapper extends MyMapper<TFactory> {

    String getString(String code);
    List<TFactory> getEntiyList();

}