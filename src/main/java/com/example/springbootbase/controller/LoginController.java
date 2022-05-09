package com.example.springbootbase.controller;

import com.example.springbootbase.common.exception.BusinessErrorMsg;
import com.example.springbootbase.common.exception.SystemErrorException;
import com.example.springbootbase.common.response.ResponseData;
import com.example.springbootbase.common.response.ResponseDataUtil;
import com.example.springbootbase.config.login.UserThreadLocal;
import com.example.springbootbase.domain.LoginUserInfo;
import com.example.springbootbase.util.JWTUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhouwei
 * @description: 登录
 * @date 2022/5/7 9:37
 */
@RestController
public class LoginController {

    @GetMapping("/login")
    public ResponseData login(@RequestParam String username, @RequestParam String password) {
        LoginUserInfo userInfo = this.checkLogin(username, password);
        UserThreadLocal.put(userInfo);
        String token = JWTUtils.getToken(userInfo.getUserId(), userInfo.getName());
        return ResponseDataUtil.buildSuccess("token:"+token);
    }

    @RequestMapping("/logout")
    public ResponseData logout() {
        return ResponseDataUtil.buildSuccess();
    }

    @GetMapping("/login/name")
    public ResponseData getLoginUsername() {
        String name = UserThreadLocal.getCurrentUser().getName();
        return ResponseDataUtil.buildSuccess(name);
    }

    /**
     * 模拟用户名密码登录，此处写死root/root
     * @param username
     * @param password
     * @return
     */
    private LoginUserInfo checkLogin(String username, String password) {
        if ("root".equalsIgnoreCase(username) && "root".equalsIgnoreCase(password)) {
            LoginUserInfo userInfo = new LoginUserInfo();
            userInfo.setUserId(1);
            userInfo.setName("root");
            return userInfo;
        }
        throw new SystemErrorException(BusinessErrorMsg.LOGIN_ERROR);
    }

}
