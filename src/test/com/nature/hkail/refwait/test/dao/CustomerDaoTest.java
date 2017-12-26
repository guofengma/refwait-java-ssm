package com.nature.hkail.refwait.test.dao;

import com.nature.hkail.refwait.dao.CustomerDao;
import com.nature.hkail.refwait.model.Customer;
import com.nature.hkail.refwait.test.BaseTest;
import org.apache.log4j.Logger;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author HuangKailie
 * @className CustomerDaoTest
 * @date 2017-12-22 09:34:45
 * @description 顾客DAO事务处理测试类
 */
public class CustomerDaoTest extends BaseTest {

    Logger logger = Logger.getLogger(CustomerDaoTest.class);

    @Resource
    private CustomerDao customerDao;

    @Test
    public void testSelectTotalOfCustomer() {
    	int n = customerDao.selectTotalOfCustomer("13333333333");
    	System.out.println(n);
    }
    
    @Test
    public void updateCustomerSetNameById() {
        int a = customerDao.updateCustomerSetNameById("小明", 1L);
        System.out.println(a);
    }

    @Test
    public void getCustomerByOpenid() {
        Customer customer = null;
        customer = customerDao.selectCustomerByOpenid("aaaa");
        if (customer == null) {
            System.out.println("获取不到");
        } else
            System.out.println(customer.toString());
    }

    @Test
    public void showAllCustomer() {
        List<Customer> customers = customerDao.selectAllCustomer();
        for (Customer customer : customers) {
            System.out.println(customer.toString());
        }
    }

    @Test
    public void addCustomer() {
        Customer customer = new Customer();
        customer.setOpenid("abcabc");
        customerDao.insertNewCustomer(customer);
        System.out.println(customer.getId());
    }
}
