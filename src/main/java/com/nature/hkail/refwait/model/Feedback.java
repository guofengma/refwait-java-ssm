package com.nature.hkail.refwait.model;

import java.io.Serializable;

/**
 * @author HuangKailie
 * @className Feedback
 * @date 2017-12-24 17:25:21
 * @description 意见反馈实体类
 */
public class Feedback implements Serializable {

	// 序列化ID号
	private static final long serialVersionUID = -6403369815209112726L;
	// 意见反馈ID号
	private Long id;
	// 反馈内容
	private String content;
	// 反馈者类型，0:顾客, 1:商家
	private Integer feedbackerType;
	// 反馈者ID号
	private Long feedbackerId;
	// 是否已阅
	private boolean read;
	// 创建时间
	private String gmtCreate;
	// 修改时间
	private String gmtModified;
	
	@Override
	public String toString() {
		return "Feedback [id=" + id + ", content=" + content + ", feedbackerType=" + feedbackerType + ", feedbackerId="
				+ feedbackerId + ", read=" + read + ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + "]";
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Integer getFeedbackerType() {
		return feedbackerType;
	}
	
	public void setFeedbackerType(Integer feedbackerType) {
		this.feedbackerType = feedbackerType;
	}
	
	public Long getFeedbackerId() {
		return feedbackerId;
	}
	
	public void setFeedbackerId(Long feedbackerId) {
		this.feedbackerId = feedbackerId;
	}
	
	public boolean isRead() {
		return read;
	}
	
	public void setRead(boolean read) {
		this.read = read;
	}
	
	public String getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(String gmtCreate) {
		this.gmtCreate = gmtCreate.substring(0, gmtCreate.indexOf('.'));
	}

	public String getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(String gmtModified) {
		this.gmtModified = gmtModified.substring(0, gmtModified.indexOf('.'));
	}
}
