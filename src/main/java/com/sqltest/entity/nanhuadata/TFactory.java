package com.sqltest.entity.nanhuadata;

import javax.persistence.*;

@Table(name = "TFactory")
public class TFactory {
    @Id
    @Column(name = "Code")
    private String code;

    @Column(name = "Name")
    private String name;

    @Column(name = "AllName")
    private String allname;

    @Column(name = "Sort")
    private Integer sort;

    private String pq;

    /**
     * @return Code
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
     * @return Name
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
     * @return AllName
     */
    public String getAllname() {
        return allname;
    }

    /**
     * @param allname
     */
    public void setAllname(String allname) {
        this.allname = allname == null ? null : allname.trim();
    }

    /**
     * @return Sort
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * @param sort
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * @return pq
     */
    public String getPq() {
        return pq;
    }

    /**
     * @param pq
     */
    public void setPq(String pq) {
        this.pq = pq == null ? null : pq.trim();
    }
}