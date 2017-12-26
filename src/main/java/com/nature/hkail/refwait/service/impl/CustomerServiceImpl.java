package com.nature.hkail.refwait.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.nature.hkail.refwait.dao.CustomerDao;
import com.nature.hkail.refwait.model.Customer;
import com.nature.hkail.refwait.service.CustomerService;
import com.nature.hkail.refwait.util.NetUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author HuangKailie
 * @className CustomerServiceImpl
 * @date 2017-12-19 13:56:30
 * @description 顾客信息业务处理接口实现类
 */
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

    private Logger logger = Logger.getLogger(CustomerServiceImpl.class);

    // 小程序拥有者APPID
    @Value("#{configProperties['wechat.appid']}")
    private String appid;

    // 小程序拥有者SECRET
    @Value("#{configProperties['wechat.secret']}")
    private String secret;

    @Resource
    private CustomerDao customerDao;
    
    public boolean containsPhone(String mobilePhone) {
    	boolean flag = false;
    	int n = customerDao.selectTotalOfCustomer(mobilePhone);
    	System.out.println(n);
    	if (n > 0) {
    		flag = true;
    		logger.info("手机号：" + mobilePhone + "已被其他顾客绑定");
		}
    	return flag;
    }
    
    public int setCustomerPhoneById(String mobilePhone, Long id) {
    	int n = 0;
    	n = customerDao.updateCustomerSetPhoneById(mobilePhone, id);
    	if (n < 1) {
			logger.info("设置顾客手机号失败！");
		} else {
			logger.info("顾客：" + id + "，成功设置手机号：" + mobilePhone);
		}
    	return n;
    }
    
    public int setCustomerSexById(Integer sex, Long id) {
    	int n = 0;
    	n = customerDao.updateCustomerSetSexById(sex, id);
    	if (n < 1) {
			logger.info("设置顾客性别失败！");
		} else {
			logger.info("顾客：" + id + "，成功设置性别：" + sex);
		}
    	return n;
    }

    public int setCustomerNameById(String name, Long id) {
        int n = 0;
        n = customerDao.updateCustomerSetNameById(name, id);
        if (n < 1) {
            System.out.println("设置顾客姓名失败！");
            logger.info("设置顾客姓名失败！");
        } else {
            System.out.println("顾客：" + id + "，成功设置姓名：" + name);
            logger.info("顾客：" + id + "，成功设置姓名：" + name);
        }
        return n;
    }

    public Customer login(String code) {
        Customer customer = null;
        // 请求URL地址
        String requestUrl = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";
        // 更改URL地址中的参数
        requestUrl = requestUrl.replace("APPID", appid).replace("SECRET", secret).replace("JSCODE", code);
        // 发起HTTPS请求，获取返回JSON数据
        JSONObject result = NetUtil.httpsRequest(requestUrl, "GET", null);
        System.out.println(result.toJSONString());
        // 判断是否成功获取到顾客OPENID
        if (result.containsKey("openid")) {
            String openid = result.getString("openid");
            // 根据顾客OPENID查询并获取顾客信息
            customer = customerDao.selectCustomerByOpenid(openid);
            // 如果顾客对象为null
            if (customer == null) {
                customer = new Customer();
                customer.setOpenid(openid);
                customer.setSex(2);
                customer.setName("unset");
                customer.setMobilePhone("unset");
                // 添加新顾客
                addNewCustomer(customer);
            }
        } else {
            System.out.println("获取顾客OPENID失败！");
            logger.info("获取顾客OPENID失败！");
        }
        return customer;
    }

    public Long addNewCustomer(Customer customer) {
        customerDao.insertNewCustomer(customer);
        if (customer.getId() < 1) {
            System.out.println("添加失败");
            logger.info("添加失败");
        } else {
            System.out.println("成功添加新顾客，ID为：" + customer.getId());
            logger.info("成功添加新顾客，ID为：" + customer.getId());
        }
        return customer.getId();
    }

    public List<Customer> listAllCustomer() {
        List<Customer> customers = null;
        customers = customerDao.selectAllCustomer();
        if (customers == null) {
            System.out.println("获取不到顾客列表");
            logger.info("获取不到顾客列表");
        }
        return customers;
    }
}
