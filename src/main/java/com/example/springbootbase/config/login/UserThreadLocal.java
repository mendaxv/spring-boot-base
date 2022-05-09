package com.example.springbootbase.config.login;

import com.example.springbootbase.common.exception.BusinessErrorMsg;
import com.example.springbootbase.common.exception.SystemErrorException;
import com.example.springbootbase.domain.LoginUserInfo;

import java.util.Optional;

/**
 * @author zhouwei
 * @description:
 * @date 2022/5/7 9:51
 */
public class UserThreadLocal {

    private static final ThreadLocal<LoginUserInfo> USER_LOCAL = new ThreadLocal<>();

    public UserThreadLocal() {
    }

    /**
     * 保存当前用户登录信息
     * @param userInfo
     */
    public static void put(LoginUserInfo userInfo){
        USER_LOCAL.set(userInfo);
    }

    /**
     * 获取当前用户登录信息
     * @return
     */
    public static LoginUserInfo getCurrentUser(){
        return Optional.ofNullable(USER_LOCAL.get()).orElseThrow(() -> new SystemErrorException(BusinessErrorMsg.UN_LOGIN));
    }

    /**
     * 防止内存泄漏
     */
    public static void remove(){
        USER_LOCAL.remove();
    }

}
