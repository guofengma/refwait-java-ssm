package com.nature.hkail.refwait.model;

import java.io.Serializable;

/**
 * @author HuangKailie
 * @className Customer
 * @date 2017-12-19 10:36:37
 * @description 顾客信息实体类
 */
public class Customer implements Serializable {

	// 序列化ID号
	private static final long serialVersionUID = -2638240123282266944L;
	// 顾客ID号
    private Long id;
    // 微信OPENID号
    private String openid;
    // 顾客姓名
    private String name;
    // 顾客性别（0:男, 1:女）
    private Integer sex;
    // 手机号
    private String mobilePhone;
    // 创建时间
    private String gmtCreate;
    // 修改时间
    private String gmtModified;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", openid='" + openid + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", gmtCreate='" + gmtCreate + '\'' +
                ", gmtModified='" + gmtModified + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate.substring(0, gmtCreate.indexOf('.'));
    }

    public String getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(String gmtModified) {
        this.gmtModified = gmtModified.substring(0, gmtModified.indexOf('.'));
    }
}
