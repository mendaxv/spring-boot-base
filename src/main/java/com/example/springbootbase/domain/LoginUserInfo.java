package com.example.springbootbase.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhouwei
 * @description: 登录用户信息
 * @date 2022/5/7 9:40
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginUserInfo {

    private Integer userId;

    private String name;

}
