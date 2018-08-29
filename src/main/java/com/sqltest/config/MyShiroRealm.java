package com.sqltest.config;

import com.sqltest.entity.permission.*;
import com.sqltest.mapper.permission.*;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.annotation.Resource;
import java.util.List;

public class MyShiroRealm extends AuthorizingRealm {
    //@Resource
    //private UserInfoService userInfoService;

    @Autowired
    private user_infoMapper m_user_infoMapper;

    @Autowired
    private sys_roleMapper m_sys_roleMapper;

    @Autowired
    private sys_user_roleMapper m_sys_user_roleMapper;

    @Autowired
    private sys_role_permissionMapper m_sys_role_permissionMapper;

    @Autowired
    private sys_permissionMapper m_sys_permissionMapper;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        user_info userInfo  = (user_info)principals.getPrimaryPrincipal();

        System.out.println("从页面获取的用户信息：");
        System.out.println("UUID："+userInfo.getUuid() + "—————用户帐号：" + userInfo.getCode() + "————用户名称：" + userInfo.getName() );
        System.out.println("密码：" + userInfo.getPassword() + "————加密密码：" + userInfo.getSalt() + "—————用户状态：" + userInfo.getState());
        System.out.println("-------------------------------------------------------------------");

        /*根据登陆信息获取用户实体*/
        user_info myuserInfo = m_user_infoMapper.selectOne(userInfo);

        System.out.println("查询获得的用户信息：");
        System.out.println("UUID："+myuserInfo.getUuid() + "—————用户帐号：" + myuserInfo.getCode() + "————用户名称：" + myuserInfo.getName() );
        System.out.println("密码：" + myuserInfo.getPassword() + "————加密密码：" + myuserInfo.getSalt() + "—————用户状态：" + myuserInfo.getState());
        System.out.println("-------------------------------------------------------------------");


        /*获取用户对应的所有角色实体*/

/*
        for(SysRole role:userInfo.getRoleList()){
            authorizationInfo.addRole(role.getRole());
            for(SysPermission p:role.getPermissions()){
                authorizationInfo.addStringPermission(p.getPermission());
            }
        }
*/
        /*原语句需要改造*/
        /*1、先获取用户对应的所有角色*/
        /*1.1 把角色code添加到authorizationInfo.addRole*/
        /*2、再获取角色对应的所有权限*/
        /*2.1 把权限字符串code添加到authorizationInfo.addStringPermission*/

        /*1、获取用户对应角色信息*/
        sys_user_role user_role = new sys_user_role();
        user_role.setUserUuid(myuserInfo.getUuid());
        List<sys_user_role> userroleList = m_sys_user_roleMapper.select(user_role);

        /*循环获取的用户角色信息*/
        for (sys_user_role userroleobj:userroleList){

            System.out.println("用户角色信息sys_user_role：");
            System.out.println("角色UUID："+userroleobj.getRoleUuid() + "—————用户UUID：" + userroleobj.getUserUuid() );
            System.out.println("-------------------------------------------------------------------");

            /*根据UUID获取角色*/
            sys_role role =  m_sys_roleMapper.selectByPrimaryKey(userroleobj.getRoleUuid());
            /*1.1 把角色code添加到authorizationInfo.addRole*/
            authorizationInfo.addRole(role.getCode());

            /*2、获取角色对应权限*/
            sys_role_permission role_permission = new sys_role_permission();
            role_permission.setRoleUuid(role.getUuid());
            List<sys_role_permission> role_permissionList = m_sys_role_permissionMapper.select(role_permission);

            /*循环获取的角色对应权限信息*/
            for (sys_role_permission role_permissionobj:role_permissionList){

                System.out.println("角色权限信息sys_role_permission：");
                System.out.println("权限UUID："+role_permissionobj.getPermissionUuid() + "—————角色UUID：" + role_permissionobj.getRoleUuid() );
                System.out.println("-------------------------------------------------------------------");

                /*根据UUID获取权限*/
                sys_permission permission = m_sys_permissionMapper.selectByPrimaryKey(role_permissionobj.getPermissionUuid());
                /*2.1 把权限字符串code添加到authorizationInfo.addStringPermission*/
                authorizationInfo.addStringPermission(permission.getCode());

            }


        }

        //sys_user_role

        return authorizationInfo;
    }

    /*主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        System.out.println("MyShiroRealm.doGetAuthenticationInfo()");
        //获取用户的输入的账号.
        String username = (String)token.getPrincipal();
        System.out.println(token.getCredentials());
        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法

        user_info user_infoobj = new user_info();
        user_infoobj.setCode(username);

        user_info userInfo = m_user_infoMapper.selectOne(user_infoobj);

        //System.out.println("----->>userInfo="+userInfo);
        System.out.println("----->>用户信息userInfo=：");
        System.out.println("UUID："+userInfo.getUuid() + "—————用户帐号：" + userInfo.getCode() + "————用户名称：" + userInfo.getName() );
        System.out.println("密码：" + userInfo.getPassword() + "————加密密码：" + userInfo.getSalt() + "—————用户状态：" + userInfo.getState());
        System.out.println("-------------------------------------------------------------------");


        if(userInfo == null){
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userInfo, //用户名
                userInfo.getPassword(), //密码
                ByteSource.Util.bytes(userInfo.getCode() + userInfo.getSalt()),//salt=username+salt
                getName()  //realm name
        );
        return authenticationInfo;
    }

}

