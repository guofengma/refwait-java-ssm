package com.nature.hkail.refwait.dao;

import org.springframework.stereotype.Repository;

import com.nature.hkail.refwait.model.Feedback;
/**
 * @author HuangKailie
 * @className FeedbackDao
 * @date 2017-12-24 17:33:50
 * @description 意见反馈信息DAO事务处理接口
 */
@Repository("feedbackDao")
public interface FeedbackDao {

	/**
	 * @date 2017-12-24 17:35:27
	 * @description 插入新反馈信息
	 * @param feedback 意见反馈对象
	 * @return int 成功插入信息数
	 */
	int insertNewFeedback(Feedback feedback);
}
