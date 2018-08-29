package com.sqltest;

import com.sqltest.entity.permission.*;
import com.sqltest.mapper.permission.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PermissionTest {

    @Autowired
    private user_infoMapper m_user_infoMapper;

    @Autowired
    private sys_permissionMapper m_sys_permissionMapper;

    @Autowired
    private sys_role_permissionMapper m_sys_role_permissionMapper;

    @Autowired
    private sys_roleMapper m_sys_roleMapper;

    @Autowired
    private sys_user_roleMapper m_sys_user_roleMapper;

    @Test
    public void PermissionText(){

        //显示用户信息
        List<user_info> user_infoList = m_user_infoMapper.selectAll();
        System.out.println("###################################################################");
        System.out.println("用户信息user_info：");
        for (user_info user_info : user_infoList) {
            System.out.println("UUID："+user_info.getUuid() + "—————用户帐号：" + user_info.getCode() + "————用户名称：" + user_info.getName() );
            System.out.println("密码：" + user_info.getPassword() + "————加密密码：" + user_info.getSalt() + "—————用户状态：" + user_info.getState());
            System.out.println("-------------------------------------------------------------------");
        }
        System.out.println("###################################################################");

        //显示角色信息
        List<sys_role> sys_roleList = m_sys_roleMapper.selectAll();
        System.out.println("");
        System.out.println("###################################################################");
        System.out.println("角色信息user_info：");
        for (sys_role sys_role:sys_roleList){
            System.out.println("UUID："+sys_role.getUuid() + "—————角色号：" + sys_role.getCode() + "————角色名称：" + sys_role.getName() );
            System.out.println("是否可用：" + sys_role.getAvailable());
            System.out.println("-------------------------------------------------------------------");
        }
        System.out.println("###################################################################");

        //显示权限信息
        List<sys_permission> sys_permissionList = m_sys_permissionMapper.selectAll();
        System.out.println("");
        System.out.println("###################################################################");
        System.out.println("权限信息sys_permission：");
        for (sys_permission sys_permission:sys_permissionList){
            System.out.println("UUID："+sys_permission.getUuid() + "—————权限字符串：" + sys_permission.getCode() + "————权限名称：" + sys_permission.getName() );
            System.out.println("父编号：" + sys_permission.getParentUuid() + "————父编号列表：" + sys_permission.getParentUuids() + "————资源类型：" + sys_permission.getResourcetype());
            System.out.println("资源路径：" + sys_permission.getUrl() + "————是否可用：" + sys_permission.getAvailable());

            System.out.println("-------------------------------------------------------------------");
        }
        System.out.println("###################################################################");

        //显示用户角色信息
        List<sys_user_role> sys_user_roleList = m_sys_user_roleMapper.selectAll();
        System.out.println("");
        System.out.println("###################################################################");
        System.out.println("用户角色信息sys_user_role：");
        for (sys_user_role sys_user_role:sys_user_roleList){
            System.out.println("角色UUID："+sys_user_role.getRoleUuid() + "—————用户UUID：" + sys_user_role.getUserUuid() );
            System.out.println("-------------------------------------------------------------------");
        }
        System.out.println("###################################################################");

        //显示角色权限信息
        List<sys_role_permission> sys_role_permissionList = m_sys_role_permissionMapper.selectAll();
        System.out.println("");
        System.out.println("###################################################################");
        System.out.println("角色权限信息sys_role_permission：");
        for (sys_role_permission sys_role_permission:sys_role_permissionList){
            System.out.println("权限UUID："+sys_role_permission.getPermissionUuid() + "—————角色UUID：" + sys_role_permission.getRoleUuid() );
            System.out.println("-------------------------------------------------------------------");
        }
        System.out.println("###################################################################");



    }


}
