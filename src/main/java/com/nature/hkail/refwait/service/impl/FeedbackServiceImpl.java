package com.nature.hkail.refwait.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.nature.hkail.refwait.dao.FeedbackDao;
import com.nature.hkail.refwait.model.Feedback;
import com.nature.hkail.refwait.service.FeedbackService;
/**
 * @author HuangKailie
 * @className FeedbackServiceImpl
 * @date 2017-12-24 17:59:05
 * @description 意见反馈信息业务处理接口实现类
 */
@Service("feedbackService")
public class FeedbackServiceImpl implements FeedbackService {

	private Logger logger = Logger.getLogger(FeedbackServiceImpl.class);
	
	@Resource
	private FeedbackDao feedbackDao;
	
	public boolean addNewFeedback(Feedback feedback) {
		boolean flag = false;
		int n = 0;
		String feedbacker;
		n = feedbackDao.insertNewFeedback(feedback);
		if (n > 0) {
			flag = true;
			feedbacker = feedback.getFeedbackerType() == 0 ? "顾客" : "商家";
			logger.info(feedbacker + "ID：" + feedback.getFeedbackerId() + "成功添加意见反馈信息。");
		}
		return flag;
	}

}
