package com.nature.hkail.refwait.model;

import java.io.Serializable;

/**
 * @author HuangKailie
 * @date 2017-12-30 19:14:00
 * @description 订单信息实体类
 * @className Order
 */
public class Order implements Serializable {

    // 序列化ID号
    private static final long serialVersionUID = 747697052079299704L;
    // 订单ID号
    private Long id;
    // 顾客ID号
    private Long customerId;
    // 商家ID号
    private Long merchantId;
    // 订单详情（食物id1*数量1,食物id2*数量2...）
    private String details;
    // 备注
    private String remark;
    // 订单状态（0:未付款,1:未接单,2:配餐中,3:配餐完毕,4:已完成,5:已取消）
    private Integer status;
    // 折扣（0~9.9，0表示不打折）
    private Double discount;
    // 用餐人数
    private Integer numberOfPeople;
    // 配餐费
    private Double cateringPrice;
    // 桌位信息（由商家自行描述）
    private String tablesInfo;
    // 总价
    private Double totalPrice;
    // 是否已评价（0：否，1：是）
    private Integer evaluation;
    // 创建时间
    private String gmtCreate;
    // 修改时间
    private String gmtModified;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", merchantId=" + merchantId +
                ", details='" + details + '\'' +
                ", remark='" + remark + '\'' +
                ", status=" + status +
                ", discount=" + discount +
                ", numberOfPeople=" + numberOfPeople +
                ", cateringPrice=" + cateringPrice +
                ", tablesInfo='" + tablesInfo + '\'' +
                ", totalPrice=" + totalPrice +
                ", evaluation=" + evaluation +
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

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Integer getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(Integer numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public Double getCateringPrice() {
        return cateringPrice;
    }

    public void setCateringPrice(Double cateringPrice) {
        this.cateringPrice = cateringPrice;
    }

    public String getTablesInfo() {
        return tablesInfo;
    }

    public void setTablesInfo(String tablesInfo) {
        this.tablesInfo = tablesInfo;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Integer evaluation) {
        this.evaluation = evaluation;
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
