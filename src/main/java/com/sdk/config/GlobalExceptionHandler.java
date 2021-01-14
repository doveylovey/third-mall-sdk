package com.sdk.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理
 *
 * @author Administrator
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 处理参数校验不通过异常
     *
     * @param response
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object globalException(HttpServletResponse response, NullPointerException e) {
        log.error("【全局异常处理】响应码：{}，异常信息：{}", response.getStatus(), e.getMessage());
        return e.getMessage();
    }

    /**
     * 处理其他异常
     *
     * @param response
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Object exceptionHandler(HttpServletResponse response, Exception e) {
        log.error("【全局异常处理】响应码：{}，异常信息：{}", response.getStatus(), e.getMessage());
        return e.getMessage();
    }
}
