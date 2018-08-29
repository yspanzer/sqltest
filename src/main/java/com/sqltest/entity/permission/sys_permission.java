package com.sqltest.entity.permission;

import javax.persistence.*;

@Table(name = "sys_permission")
public class sys_permission {
    @Id
    @Column(name = "uuid")
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "select uuid()")
    private String uuid;

    private String code;

    private String name;

    @Column(name = "parent_uuid")
    private String parentUuid;

    @Column(name = "parent_uuids")
    private String parentUuids;

    private String resourcetype;

    private String url;

    private Byte available;

    /**
     * @return uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * @param uuid
     */
    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    /**
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return parent_uuid
     */
    public String getParentUuid() {
        return parentUuid;
    }

    /**
     * @param parentUuid
     */
    public void setParentUuid(String parentUuid) {
        this.parentUuid = parentUuid == null ? null : parentUuid.trim();
    }

    /**
     * @return parent_uuids
     */
    public String getParentUuids() {
        return parentUuids;
    }

    /**
     * @param parentUuids
     */
    public void setParentUuids(String parentUuids) {
        this.parentUuids = parentUuids == null ? null : parentUuids.trim();
    }

    /**
     * @return resourcetype
     */
    public String getResourcetype() {
        return resourcetype;
    }

    /**
     * @param resourcetype
     */
    public void setResourcetype(String resourcetype) {
        this.resourcetype = resourcetype == null ? null : resourcetype.trim();
    }

    /**
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * @return available
     */
    public Byte getAvailable() {
        return available;
    }

    /**
     * @param available
     */
    public void setAvailable(Byte available) {
        this.available = available;
    }
}