package com.sqltest.entity.permission;

import javax.persistence.*;

@Table(name = "sys_role_permission")
public class sys_role_permission {

    @Id
    @Column(name = "permission_uuid")
    private String permissionUuid;

    @Column(name = "role_uuid")
    private String roleUuid;

    /**
     * @return permission_uuid
     */
    public String getPermissionUuid() {
        return permissionUuid;
    }

    /**
     * @param permissionUuid
     */
    public void setPermissionUuid(String permissionUuid) {
        this.permissionUuid = permissionUuid == null ? null : permissionUuid.trim();
    }

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
}