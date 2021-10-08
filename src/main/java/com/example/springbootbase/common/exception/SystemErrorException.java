package com.example.springbootbase.common.exception;

/**
 * @author zhouwei
 * @Description: 系统错误！严重错误！
 * @date 2021/7/1910:57
 */
public class SystemErrorException extends BaseSystemException{

    public SystemErrorException(String errorCode, String errorMsg, String complementary) {
        super(errorCode, errorMsg, complementary);
    }

    public SystemErrorException(String message, Throwable cause, String errorCode, String errorMsg, String complementary) {
        super(message, cause, errorCode, errorMsg, complementary);
    }

    public SystemErrorException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum);
    }

    public SystemErrorException(String errMsg) {
        super(errMsg);
    }

}
