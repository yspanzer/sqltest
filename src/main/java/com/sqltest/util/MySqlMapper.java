package com.sqltest.util;

import tk.mybatis.mapper.common.Mapper;



public interface MySqlMapper<T>
        extends
        Mapper<T>
        , tk.mybatis.mapper.common.MySqlMapper<T>
{
}
