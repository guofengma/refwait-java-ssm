package com.nature.hkail.refwait.controller;

import com.alibaba.fastjson.JSONObject;
import com.nature.hkail.refwait.model.Customer;
import com.nature.hkail.refwait.service.CustomerService;
import com.nature.hkail.refwait.util.CommonUtil;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author HuangKailie
 * @className CustomerController
 * @date 2017-12-19 13:59:23
 * @description 顾客信息控制类
 */
@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

	private Logger logger = Logger.getLogger(CustomerController.class);
	
    @Resource
    private CustomerService customerService;
    
    /**
     * @date 2017-12-24 16:32:34
     * @description 设置顾客手机号
     * @param phone 顾客手机号
     * @param id 顾客ID号
     * @return 设置成功返回"success"，设置失败返回"fail"
     */
    @RequestMapping(value = "/setCustomerMobilePhone", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody String setCustomerMobilePhone(@RequestParam String phone, @RequestParam Long id) {
    	int n = 0;
    	n = customerService.setCustomerPhoneById(phone, id);
    	if (n < 1)
    		return "fail";
    	return "success";
    }
    
	/**
	 * @date 2017-12-24 16:04:00
	 * @description 获取短信验证码
	 * @param phone 手机号
	 * @return String 成功返回6位数字验证码，失败返回"fail"，手机已被绑定返回"isExist"
	 */
	@RequestMapping(value = "/getVerificationCode", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public @ResponseBody String getVerificationCode(@RequestParam String phone) {
		String verificationCode = "";
		verificationCode = Integer.toString(CommonUtil.getVerificationCode());
		if ("".equals(verificationCode))
			return "fail";
		if (customerService.containsPhone(phone))
			return "isExist";
		logger.info("手机号为：" + phone + "的顾客获取验证码：" + verificationCode);
		return verificationCode;
	}
    
    /**
     * @date 2017-12-24 13:29:43
     * @description 设置顾客性别
     * @param sex 顾客性别
     * @param id 顾客ID号
     * @return 设置成功返回"success"，设置失败返回"fail"
     */
    @RequestMapping(value = "/setCustomerSex", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody String setCustomerSex(@RequestParam Integer sex, @RequestParam Long id) {
    	int n = 0;
    	n = customerService.setCustomerSexById(sex, id);
    	if (n < 1)
    		return "fail";
    	return "success";
    }
    
    /**
     * @date 2017-12-22 09:43:23
     * @description 设置顾客姓名
     * @param name 顾客姓名
     * @param id 顾客ID号
     * @return 设置成功返回"success"，设置失败返回"fail"
     */
    @RequestMapping(value = "/setCustomerName", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody String setCustomerName(@RequestParam String name, @RequestParam Long id) {
        int n = 0;
        n = customerService.setCustomerNameById(name, id);
        if (n < 1)
            return "fail";
        return "success";
    }

    /**
     * @date 2017-12-19 14:08:24
     * @description 登录并获取顾客信息
     * @param code 通过小程序端调用wx.login获取到的顾客登录凭证
     * @return String JSON格式的顾客信息
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public @ResponseBody String login(@RequestParam String code) {
        Customer customer = null;
        customer = customerService.login(code);
        if (customer == null) {
            System.out.println("获取顾客信息失败！");
            return "获取顾客信息失败！";
        }
        return JSONObject.toJSONString(customer);
    }

    @RequestMapping(value = "/customerTest")
    public @ResponseBody String customerTest() {
        System.out.println("Test");
        return "customerTest";
    }
}
