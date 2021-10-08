package com.example.springbootbase.common.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author zhouwei
 * @Description: 返回结果封装
 * @date 2021/7/1910:22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseData<T> implements Serializable {

    private String code;
    private String msg;
    private T data;

    public ResponseData(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseData(ResultEnums enums) {
        this.code = enums.getCode();
        this.msg = enums.getMsg();
    }

    public ResponseData(ResultEnums enums, T data) {
        this.code = enums.getCode();
        this.msg = enums.getMsg();
        this.data = data;
    }
}
