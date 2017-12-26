package com.nature.hkail.refwait.service;

import com.nature.hkail.refwait.model.Customer;

import java.util.List;

/**
 * @author HuangKailie
 * @className CustomerService
 * @date 2017-12-19 11:38:26
 * @description 顾客信息业务处理接口
 */
public interface CustomerService {

	/**
	 * @date 2017-12-24 16:54:04
	 * @description 判断手机号是否存在
	 * @param mobilePhone 手机号
	 * @return boolean 存在返回true，不存在返回false
	 */
	boolean containsPhone(String mobilePhone);
	
	/**
	 * @date 2017-12-24 16:30:01
	 * @description 通过顾客ID设置顾客手机号
	 * @param mobilePhone 顾客手机号
	 * @param id 顾客ID号
	 * @return int 成功设置的顾客数
	 */
	int setCustomerPhoneById(String mobilePhone, Long id);
	
	/**
	 * @date 2017-12-24 13:25:11
	 * @description 通过顾客ID设置顾客性别
	 * @param sex 性别
	 * @param id 顾客ID号
	 * @return int 成功设置的顾客数
	 */
	int setCustomerSexById(Integer sex, Long id);
	
    /**
     * @date 2017-12-22 09:35:59
     * @description 通过顾客ID设置顾客姓名
     * @param name 姓名
     * @param id 顾客ID号
     * @return int 成功设置的顾客数
     */
    int setCustomerNameById(String name, Long id);

    /**
     * @date 2017-12-19 15:50:56
     * @description 顾客登录获取顾客ID号
     * @param code 顾客微信登录凭证
     * @return Customer 顾客信息对象
     */
    Customer login(String code);

    /**
     * @date 2017-12-19 11:40:30
     * @description 添加新顾客
     * @param customer 顾客实体类对象
     * @return Long 该新用户的ID号
     */
    Long addNewCustomer(Customer customer);

    /**
     * @date 2017-12-19 11:41:33
     * @description 获取所有顾客信息
     * @return List<Customer> 顾客信息列表
     */
    List<Customer> listAllCustomer();
}
