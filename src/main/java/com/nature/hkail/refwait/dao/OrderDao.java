package com.nature.hkail.refwait.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author HuangKailie
 * @date 2017-12-30 19:23:00
 * @description 订单DAO事务处理类
 * @className OrderDao
 */
@Repository("orderDao")
public interface OrderDao {

    /**
     * @date 2017年12月30日19:37:38
     * @description 根据商家ID号以及订单状态查询订单数量
     * @param merchantId 商家ID号
     * @param status 订单状态
     * @return Integer 订单数量
     */
    Integer selectNumberOfOrdersByMerchantIdAndStatus(@Param("merchantId") Long merchantId, @Param("status") Integer status);
}
