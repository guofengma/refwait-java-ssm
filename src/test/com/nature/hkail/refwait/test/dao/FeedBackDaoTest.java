package com.nature.hkail.refwait.test.dao;

import javax.annotation.Resource;

import org.junit.Test;

import com.nature.hkail.refwait.dao.FeedbackDao;
import com.nature.hkail.refwait.model.Feedback;
import com.nature.hkail.refwait.test.BaseTest;

public class FeedBackDaoTest extends BaseTest {

	@Resource
	private FeedbackDao feedbackDao;
	
	@Test
	public void testInsertNewFeedback() {
		Feedback feedback = new Feedback();
		feedback.setContent("内容");
		feedback.setFeedbackerId(1L);
		feedback.setFeedbackerType(1);
		int n = feedbackDao.insertNewFeedback(feedback);
		System.out.println(n);
	}
}
