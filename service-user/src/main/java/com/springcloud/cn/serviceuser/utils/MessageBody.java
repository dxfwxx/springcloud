package com.springcloud.cn.serviceuser.utils;

import lombok.Data;

import java.io.Serializable;

/**
 * @author dxf@choicesoft.com.cn
 * @data
 */
@Data
public class MessageBody implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String code;
	private Boolean success;
	private int errorCode;
	private String errorInfo;
	private Object data;
	private String message;
	private String stackTrace;
	
	public static MessageBody getMessageBody(boolean success, Object data) {
		MessageBody body = new MessageBody();
		body.setCode("200");
		body.setData(data);
		body.setSuccess(success);
		return body;
	}
	
	public static MessageBody getMessageBody(boolean success, Object data, String message) {
		MessageBody body = new MessageBody();
		body.setCode("200");
		body.setData(data);
		body.setMessage(message);
		body.setSuccess(success);
		return body;
	}
	
	public static MessageBody getInfoMessageBody(boolean success, String message) {
		return getMessageBody(success,null,message);
	}
	
	public static MessageBody getErrorMessageBody(String errorInfo) {
		MessageBody body = getMessageBody(false);
		body.setErrorInfo(errorInfo);
		body.setMessage(errorInfo);
		return body;
	}
	
	public static MessageBody getErrorMessageBody(String errorInfo, int errorCode) {
		MessageBody body = getMessageBody(false);
		body.setErrorInfo(errorInfo);
		body.setErrorCode(errorCode);
		return body;
	}
	public static MessageBody getMessageBody(boolean success) {
		MessageBody body = new MessageBody();
		body.setCode("200");
		body.setSuccess(Boolean.valueOf(success));
		return body;
	}
}
