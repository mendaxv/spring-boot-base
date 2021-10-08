package com.example.springbootbase.common.exception;

import com.example.springbootbase.common.response.ResponseData;
import com.example.springbootbase.common.response.ResponseDataUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author zhouwei
 * @Description: 统一异常捕获
 * @date 2021/7/1910:54
 */
@RestControllerAdvice
@Slf4j
public class DefaultGlobalExceptionHandle {

    //-------------------------------------校验异常统一异常处理-------------------------------------//

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ResponseData validateErrorHandler(BindException e) {
        ObjectError error = e.getAllErrors().get(0);
        return ResponseDataUtil.buildError(error.getDefaultMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseData validateErrorHandler(MethodArgumentNotValidException e) {
        ObjectError error = e.getBindingResult().getAllErrors().get(0);
        return ResponseDataUtil.buildError(error.getDefaultMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseData handle(Exception e) {
        if (e instanceof SystemErrorException) {
            //高级生产异常
            SystemErrorException systemErrorException = (SystemErrorException) e;
            log.error("系统严重异常！ 发生异常类: 【" + systemErrorException.getClass() + "】, 异常信息： " + e.getCause());
            //创建异步线程，交由异常处理类处理
            //ThreadPoolUtils.getSimpleThreadPool().execute(() -> MsgUtls.push2MSG4SystemError(systemErrorException));
        } else if (e instanceof SystemWarnException) {
            SystemWarnException systemWarnException = (SystemWarnException) e;
            log.error("系统异常！ 发生异常类: 【" + systemWarnException.getCause() + "】, 异常信息： " + e.getCause());
        } else {
            log.error("一般异常！ 发生异常类: 【" + e.getCause() + "】, 异常信息： " + e.getCause());
        }
        return ResponseDataUtil.buildError(e.getMessage());
    }

}
