package com.sqltest.entity.nhtest;

import javax.persistence.*;

@Table(name = "Pq_Factory")
public class Pq_Factory {
    @Id
    @Column(name = "GUID")
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "select newid()")
    private String guid;

    private String pqcode;

    private String factorycode;

    /**
     * @return GUID
     */
    public String getGuid() {
        return guid;
    }

    /**
     * @param guid
     */
    public void setGuid(String guid) {
        this.guid = guid == null ? null : guid.trim();
    }

    /**
     * @return pqcode
     */
    public String getPqcode() {
        return pqcode;
    }

    /**
     * @param pqcode
     */
    public void setPqcode(String pqcode) {
        this.pqcode = pqcode == null ? null : pqcode.trim();
    }

    /**
     * @return factorycode
     */
    public String getFactorycode() {
        return factorycode;
    }

    /**
     * @param factorycode
     */
    public void setFactorycode(String factorycode) {
        this.factorycode = factorycode == null ? null : factorycode.trim();
    }
}