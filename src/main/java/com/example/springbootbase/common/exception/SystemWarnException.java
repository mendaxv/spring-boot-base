package com.example.springbootbase.common.exception;

/**
 * @author zhouwei
 * @Description: 系统warn级错误
 * @date 2021/7/1911:00
 */
public class SystemWarnException extends BaseSystemException{

    public SystemWarnException(String errorCode, String errorMsg, String complementary) {
        super(errorCode, errorMsg, complementary);
    }

    public SystemWarnException(String message, Throwable cause, String errorCode, String errorMsg, String complementary) {
        super(message, cause, errorCode, errorMsg, complementary);
    }

}
