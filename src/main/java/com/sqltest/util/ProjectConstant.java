package com.sqltest.util;

public class ProjectConstant {

    public static final String BASE_PACKAGE = "com.sqltest";	//项目基础包名称，根据自己公司的项目修改

    public static final String MODEL_PACKAGE = BASE_PACKAGE + ".entity";	//实体Model或entity所在包
    //#########多数据源实体按照数据库名称分目录
    public static final String MODEL_PACKAGE_NANHUADATA = MODEL_PACKAGE + ".nanhuadata";	//按照数据库名称分目录
    //第二个数据库
    public static final String MODEL_PACKAGE_NHTEST = MODEL_PACKAGE + ".nhtest";	//按照数据库名称分目录


    public static final String MAPPER_PACKAGE = BASE_PACKAGE + ".mapper";	//Mapper所在包
    //#########多数据源Mapper接口按照数据库名称分目录
    public static final String MAPPER_PACKAGE_NANHUADATA = MAPPER_PACKAGE + ".nanhuadata";	////按照数据库名称分目录
    //第二个数据库
    public static final String MAPPER_PACKAGE_NHTEST = MAPPER_PACKAGE + ".nhtest";	////按照数据库名称分目录


    public static final String SERVICE_PACKAGE = BASE_PACKAGE + ".service";	//Service所在包
    public static final String SERVICE_IMPL_PACKAGE = SERVICE_PACKAGE + ".impl";	//ServiceImpl所在包
    public static final String CONTROLLER_PACKAGE = BASE_PACKAGE + ".controller";	//Controller所在包

    public static final String MAPPER_INTERFACE_REFERENCE = BASE_PACKAGE + ".util.MyMapper";	//Mapper插件基础接口的完全限定名

}

