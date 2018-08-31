package com.sqltest;

import com.sqltest.dao.UserInfoService;
import com.sqltest.entity.permission.user_info;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    UserInfoService m_UserInfoService;

    @Test
    public void getOneUserInfoRedis(){

        user_info userInfo = new user_info();
        userInfo.setCode("admin");

        user_info userInfoObj = m_UserInfoService.selectOne(userInfo);

        m_UserInfoService.selectByKey(userInfoObj.getUuid());

        System.out.println("不出现连接数据库————则为从缓存取出数据");
        System.out.println("用户信息user_info：");
        System.out.println("UUID："+userInfoObj.getUuid() + "—————用户帐号：" + userInfoObj.getCode() + "————用户名称：" + userInfoObj.getName() );
        System.out.println("密码：" + userInfoObj.getPassword() + "————加密密码：" + userInfoObj.getSalt() + "—————用户状态：" + userInfoObj.getState());
        System.out.println("-------------------------------------------------------------------");

    }

    @Test
    public void getAllUserInfoRedis(){

        System.out.println("不出现连接数据库————则为从缓存取出数据");

        //显示用户信息
        List<user_info> user_infoList = m_UserInfoService.selectAll();
        System.out.println("###################################################################");
        System.out.println("用户信息user_info：");
        for (user_info user_info : user_infoList) {
            System.out.println("UUID："+user_info.getUuid() + "—————用户帐号：" + user_info.getCode() + "————用户名称：" + user_info.getName() );
            System.out.println("密码：" + user_info.getPassword() + "————加密密码：" + user_info.getSalt() + "—————用户状态：" + user_info.getState());
            System.out.println("-------------------------------------------------------------------");
        }
        System.out.println("###################################################################");

    }

    /*只从缓存取出数据*/
    @Test
    public void getOneUserInfoRedisOnly(){

        user_info userInfoObj = m_UserInfoService.getRedisByKey("21f66a85-a680-11e8-bb2e-7ce9d3edbfa3");

        if (userInfoObj != null) {
            System.out.println("不出现连接数据库————则为从缓存取出数据");
            System.out.println("用户信息user_info：");
            System.out.println("UUID：" + userInfoObj.getUuid() + "—————用户帐号：" + userInfoObj.getCode() + "————用户名称：" + userInfoObj.getName());
            System.out.println("密码：" + userInfoObj.getPassword() + "————加密密码：" + userInfoObj.getSalt() + "—————用户状态：" + userInfoObj.getState());
            System.out.println("-------------------------------------------------------------------");
        }else System.out.println("缓存无数据！");

    }

    /*移除缓存*/
    @Test
    public void delOneUserInfoRedisOnly(){

        m_UserInfoService.delRedisByKey("21f66a85-a680-11e8-bb2e-7ce9d3edbfa3");

        System.out.println("移除 UUID：21f66a85-a680-11e8-bb2e-7ce9d3edbfa3 的缓存数据！");

    }



}
