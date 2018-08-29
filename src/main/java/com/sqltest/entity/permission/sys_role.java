package com.sqltest.entity.permission;

import javax.persistence.*;

@Table(name = "sys_role")
public class sys_role {
    @Id
    @Column(name = "uuid")
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "select uuid()")
    private String uuid;

    private String code;

    private String name;

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