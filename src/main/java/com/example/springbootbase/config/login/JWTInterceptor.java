package com.example.springbootbase.config.login;

import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.springbootbase.common.exception.BusinessErrorMsg;
import com.example.springbootbase.common.exception.SystemErrorException;
import com.example.springbootbase.domain.LoginUserInfo;
import com.example.springbootbase.util.JWTUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhouwei
 * @description: 登录拦截
 * @date 2022/5/9 10:02
 */
public class JWTInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = request.getHeader("Authorization");
        if (StrUtil.isBlank(token)) {
            throw new SystemErrorException(BusinessErrorMsg.UN_LOGIN);
        }
        try {
            // 1.校验JWT字符串
            DecodedJWT decode = JWTUtils.decode(token);
            // 2.保留登录用户信息
            Claim userId = decode.getClaim("userId");
            Claim userName = decode.getClaim("userName");
            LoginUserInfo userInfo = new LoginUserInfo();
            userInfo.setUserId(userId.asInt());
            userInfo.setName(userName.asString());
            UserThreadLocal.put(userInfo);
            return true;
        }catch (SignatureVerificationException e){
            throw new SystemErrorException("无效签名");
        }catch (TokenExpiredException e){
            throw new SystemErrorException("token已经过期");
        }catch (AlgorithmMismatchException e){
            throw new SystemErrorException("算法不一致");
        }catch (Exception e){
            throw new SystemErrorException("token无效");
        }
    }

    /**
     * 避免内存泄露
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        UserThreadLocal.remove();
    }
}

