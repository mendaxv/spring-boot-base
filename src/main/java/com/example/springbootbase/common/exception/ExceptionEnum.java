package com.example.springbootbase.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zhouwei
 * @description: 异常枚举
 * @date 2021/8/27 13:13
 */
@Getter
@AllArgsConstructor
public enum ExceptionEnum {

    SYS_ERROR("500", "系统异常"),
    PARAMETERS_ERROR("400", "参数异常"),
    ;

    private String code;
    private String msg;

    public static ExceptionEnum fromCode(String code) {
        for (ExceptionEnum ec : ExceptionEnum.values()) {
            if (code.equals(ec.getCode())) {
                return ec;
            }
        }
        return null;
    }

}
