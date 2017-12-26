package com.nature.hkail.refwait.service;

import com.nature.hkail.refwait.model.Feedback;

/**
 * @author HuangKailie
 * @className FeedbackService
 * @date 2017-12-24 17:53:12
 * @description 意见反馈信息业务处理接口
 */
public interface FeedbackService {

	/**
	 * @date 2017-12-24 17:54:03
	 * @description 添加新意见反馈信息
	 * @param feedback 意见反馈信息对象
	 * @return boolean 是否添加成功，成功为true，失败为false
	 */
	boolean addNewFeedback(Feedback feedback);
}
