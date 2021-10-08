package com.example.springbootbase.common.exception;

import lombok.Data;
import org.apache.logging.log4j.util.Strings;

/**
 * @author zhouwei
 * @Description: 异常基类，定义异常内容
 * @date 2021/7/1910:56
 */
@Data
public class BaseSystemException extends RuntimeException {

    /**
     * 错误编码
     */
    private String errorCode;
    /**
     * 错误信息
     */
    private String errorMsg;
    /**
     * 补充内容
     */
    private String complementary;

    public BaseSystemException(String errorCode, String errorMsg, String complementary) {
        super("errorCode： 【" + errorMsg + "】 errorMsg： 【" + errorMsg + "】 complementary： 【" + complementary + "】");
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.complementary = complementary;
    }

    public BaseSystemException(String message, Throwable cause, String errorCode, String errorMsg, String complementary) {
        super("errorCode： 【" + errorMsg + "】 errorMsg： 【" + errorMsg + "】 complementary： 【" + complementary + "】", cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.complementary = complementary;
    }

    public BaseSystemException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMsg());
        this.errorCode = exceptionEnum.getCode();
        this.errorMsg = exceptionEnum.getMsg();
        this.complementary = Strings.EMPTY;
    }

    public BaseSystemException(String errMsg) {
        super(errMsg);
        this.errorCode = ExceptionEnum.SYS_ERROR.getCode();
        this.errorMsg = errMsg;
        this.complementary = Strings.EMPTY;
    }

}
