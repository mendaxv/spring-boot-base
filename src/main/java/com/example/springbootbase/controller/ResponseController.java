package com.example.springbootbase.controller;

import com.example.springbootbase.common.response.ResponseData;
import com.example.springbootbase.common.response.ResponseDataUtil;
import com.example.springbootbase.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhouwei
 * @Description: 测试统一返回ResponseData<T>
 * @date 2021/7/1910:35
 */
@RestController
@RequestMapping("/response")
@Slf4j
public class ResponseController {

    @GetMapping("str")
    public ResponseData str() {
        return ResponseDataUtil.buildSuccess("Result String");
    }

    @GetMapping("data")
    public ResponseData data() {
        log.info("get user...");
        return ResponseDataUtil.buildSuccess(new User(1L,"小明"));
    }

}
