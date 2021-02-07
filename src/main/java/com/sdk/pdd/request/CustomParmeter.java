package com.sdk.pdd.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public  class CustomParmeter {
	/**
	 * 用户编号
	 */
	private String uid;
	/**
	 * 应用编号
	 */
	private String sessionId;
}
