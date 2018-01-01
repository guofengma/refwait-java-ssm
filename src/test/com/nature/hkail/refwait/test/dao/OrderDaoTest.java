package com.nature.hkail.refwait.test.dao;

import com.nature.hkail.refwait.dao.OrderDao;
import com.nature.hkail.refwait.test.BaseTest;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author HuangKailie
 * @date 2017-12-30 19:55:00
 * @description 订单信息DAO事务处理测试类
 * @className OrderDaoTest
 */
public class OrderDaoTest extends BaseTest {

    @Resource
    private OrderDao orderDao;

    @Test
    public void testSelectNumberOfOrderByMerchantIdAndStatus() {
        int n = orderDao.selectNumberOfOrdersByMerchantIdAndStatus(1L, 1);
        System.out.println(n);
    }
}
