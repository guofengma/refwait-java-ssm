package com.nature.hkail.refwait.dao;

import com.nature.hkail.refwait.model.Customer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author HuangKailie
 * @className CustomerDao
 * @date 2017-12-19 10:49:21
 * @description 顾客信息DAO事务处理接口
 */
@Repository("customerDao")
public interface CustomerDao {
	
	/**
	 * @date 2017-12-24 16:29:02
	 * @description 更新顾客手机号
	 * @param mobilePhone 顾客手机号
	 * @param id 顾客ID号
	 * @return int 成功更新信息的顾客数
	 */
	int updateCustomerSetPhoneById(@Param("mobilePhone") String mobilePhone, @Param("id") Long id);
	
	/**
	 * @date 2017-12-24 13:23:03
	 * @description 更新顾客性别
	 * @param sex 顾客性别，0:男, 1:女, 2:保密
	 * @param id 顾客ID
	 * @return int 成功更新信息的顾客数
	 */
	int updateCustomerSetSexById(@Param("sex") Integer sex, @Param("id") Long id);
	
    /**
     * @date 2017-12-21 17:26:46
     * @description 更新顾客姓名
     * @param name 顾客姓名
     * @param id 顾客ID
     * @return int 成功更新信息的顾客数
     */
    int updateCustomerSetNameById(@Param("name")String name, @Param("id") Long id);

    /**
     * @date 2017-12-24 16:46:45
     * @description 根据顾客手机号查询顾客信息数
     * @param mobilePhone 顾客手机号
     * @return int 顾客信息数量
     */
    int selectTotalOfCustomer(String mobilePhone);
    
    /**
     * @date 2017-12-19 16:43:18
     * @description 根据顾客ID查询顾客信息
     * @param id 顾客ID
     * @return Customer 顾客信息实体类
     */
    Customer selectCustomerById(Long id);

    /**
     * @date 2017-12-19 16:21:49
     * @description 根据顾客OPENID查询顾客信息
     * @param openid 顾客OPENID
     * @return Customer 顾客信息实体类
     */
    Customer selectCustomerByOpenid(String openid);

    /**
     * @date 2017-12-19 10:51:56
     * @description 查询所有顾客信息
     * @return List<Customer> 顾客信息列表
     */
    List<Customer> selectAllCustomer();

    /**
     * @date 2017-12-19 10:53:06
     * @description 插入新顾客
     * @param customer 顾客实体类对象
     * @return int 成功插入的条数
     */
    int insertNewCustomer(Customer customer);
}
