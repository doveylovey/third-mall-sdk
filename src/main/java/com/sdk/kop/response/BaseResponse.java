package com.sdk.kop.response;

import lombok.Data;

import java.io.Serializable;

/**
 * 考拉海购公用响应结果
 *
 * @author Administrator
 */
@Data
public class BaseResponse<R> implements Serializable {
    private static final long serialVersionUID = -899281945370376206L;

    /**
     * 返回码：200-正常
     */
    private Integer code;

    /**
     * 描述。例如：SUCCESS
     */
    private String msg;

    /**
     * 具体内容
     */
    private R data;
}
