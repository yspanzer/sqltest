package com.sqltest.dao;

import com.sqltest.entity.permission.user_info;
import com.sqltest.mapper.permission.user_infoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames="UserInfoCache") // 本类内方法指定使用缓存时，默认的名称就是UserInfoCache

public class UserInfoService {

    @Autowired
    private user_infoMapper m_user_infoMapper;

    public user_info selectOne(user_info pUserInfo) {
        //System.out.println("连接数据库：根据实体里的code=" + pUserInfo.getCode() + "————查询出用户信息user_info：");
        return this.m_user_infoMapper.selectOne(pUserInfo);
    }

    @Cacheable(key = "#p0") // @Cacheable 会先查询缓存，如果缓存中存在，则不执行方法
    public user_info selectByKey(String pUuid) {

        System.out.println("连接数据库：根据实体里的code=" + pUuid + "————查询出用户信息user_info：");
        return this.m_user_infoMapper.selectByPrimaryKey(pUuid);
    }

    /*不连接数据库，只从缓存取*/
    @Cacheable(key = "#p0") // @Cacheable 会先查询缓存，如果缓存中存在，则不执行方法
    public user_info getRedisByKey(String pUuid) {

        System.out.println("无缓存数据：——————————————————————");
        return null;
    }


    //@Cacheable(key="#p0.uuid") // @Cacheable 会先查询缓存，如果缓存中存在，则不执行方法
    public List<user_info> selectAll() {
        System.out.println("连接数据库：查询出所有用户信息user_info：");
        return this.m_user_infoMapper.selectAll();
    }

    /*移出缓存*/

    @CacheEvict(key = "#p0")  //删除缓存名称为userCache,key等于指定的id对应的缓存
    public void delRedisByKey(String pUuid) {
        System.out.println("移出缓存：——————————————————————");
    }

}