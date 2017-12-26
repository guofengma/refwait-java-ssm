package com.nature.hkail.refwait.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nature.hkail.refwait.model.Feedback;
import com.nature.hkail.refwait.service.FeedbackService;
/**
 * @author HuangKailie
 * @className FeedbackController
 * @date 2017-12-24 18:06:45
 * @description 意见反馈信息控制类
 */
@Controller
@RequestMapping(value = "/feedback")
public class FeedbackController {

	@Resource
	private FeedbackService feedbackService;
	
	/**
	 * @date 2017-12-24 18:11:04
	 * @description 添加新意见反馈信息
	 * @param content 反馈信息内容
	 * @param feedbackerType 反馈者类型，0:顾客, 1:商家
	 * @param feedbackerId 反馈者ID号
	 * @return 成功返回"success"，失败返回"fail"
	 */
	@RequestMapping(value = "/addNewFeedback", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public @ResponseBody String addNewFeedback(@RequestParam String content, @RequestParam Integer feedbackerType, @RequestParam Long feedbackerId) {
		Feedback feedback = new Feedback();
		feedback.setContent(content);
		feedback.setFeedbackerType(feedbackerType);
		feedback.setFeedbackerId(feedbackerId);
		if (feedbackService.addNewFeedback(feedback)) {
			return "success";
		}
		return "fail";
	}
}
