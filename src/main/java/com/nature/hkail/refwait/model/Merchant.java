package com.nature.hkail.refwait.model;

import java.io.Serializable;

/**
 * @author HuangKailie
 * @className Merchant
 * @date 2017-12-26 11:07:31
 * @description 商家信息实体类
 */
public class Merchant implements Serializable {

    // 序列化ID号
    private static final long serialVersionUID = -1597047666938181754L;
    // 商家ID号
    private Long id;
    // 商家微信OPENID
    private String openid;
    // 商家名称
    private String name;
    // 商家电话号码
    private String telephone;
    // 商家手机号
    private String mobilePhone;
    // 商家地址
    private String address;
    // 位置经度
    private Double longitude;
    // 位置纬度
    private Double latitude;
    // 商家状态，0：休息，1：营业
    private Integer status;
    // 商家公告
    private String notice;
    // 图标URL地址
    private String iconUrl;
    // 热度
    private Integer heatValue;
    // 是否合格，0：不合格，1：合格，3：审核中
    private Integer qualified;
    // 创建时间
    private String gmtCreate;
    // 修改时间
    private String gmtModified;

    @Override
    public String toString() {
        return "Merchant{" +
                "id=" + id +
                ", openid='" + openid + '\'' +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", address='" + address + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", status=" + status +
                ", notice='" + notice + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                ", heatValue=" + heatValue +
                ", qualified=" + qualified +
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public Integer getHeatValue() {
        return heatValue;
    }

    public void setHeatValue(Integer heatValue) {
        this.heatValue = heatValue;
    }

    public Integer getQualified() {
        return qualified;
    }

    public void setQualified(Integer qualified) {
        this.qualified = qualified;
    }

    public String getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(String gmtModified) {
        this.gmtModified = gmtModified;
    }
}
