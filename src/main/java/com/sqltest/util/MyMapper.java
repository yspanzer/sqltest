package com.sqltest.util;


import tk.mybatis.mapper.common.Mapper;

import tk.mybatis.mapper.common.SqlServerMapper;

public interface MyMapper<T>
        extends
        Mapper<T>
        //,SqlServerMapper<T>
{
}
