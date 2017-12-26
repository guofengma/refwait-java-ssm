package com.nature.hkail.refwait.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nature.hkail.refwait.util.CommonUtil;
/**
 * @author HuangKailie
 * @className CommonController
 * @date 2017-12-24 15:56:28
 * @description 公共控制类
 */
@Controller
@RequestMapping(value = "/common")
public class CommonController {

	private Logger logger = Logger.getLogger(CommonController.class);
	
	/**
	 * @date 2017-12-24 16:04:00
	 * @description 获取短信验证码
	 * @param phone 手机号
	 * @return String 成功返回6位数字验证码，失败返回"fail"
	 */
	@RequestMapping(value = "/getVerificationCode", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public @ResponseBody String getVerificationCode(@RequestParam String phone) {
		String verificationCode = "";
		verificationCode = Integer.toString(CommonUtil.getVerificationCode());
		if ("".equals(verificationCode))
			return "fail";
		logger.info("手机号为：" + phone + "的顾客获取验证码：" + verificationCode);
		return verificationCode;
	}
}
