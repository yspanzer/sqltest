package com.sqltest.entity.permission;

import javax.persistence.*;

@Table(name = "sys_user_role")
public class sys_user_role {

    @Id
    @Column(name = "role_uuid")
    private String roleUuid;

    @Column(name = "user_uuid")
    private String userUuid;

    /**
     * @return role_uuid
     */
    public String getRoleUuid() {
        return roleUuid;
    }

    /**
     * @param roleUuid
     */
    public void setRoleUuid(String roleUuid) {
        this.roleUuid = roleUuid == null ? null : roleUuid.trim();
    }

    /**
     * @return user_uuid
     */
    public String getUserUuid() {
        return userUuid;
    }

    /**
     * @param userUuid
     */
    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid == null ? null : userUuid.trim();
    }
}