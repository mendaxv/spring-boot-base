package com.example.springbootbase.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhouwei
 * @description: 测试日志打印
 * @date 2021/10/8 15:54
 */
@RestController
@RequestMapping("/log")
@Slf4j
public class LogController {

    @GetMapping("/print")
    public void log() {
        //日志级别（由高到底）：trace < debug < info < warn < error
        log.trace("-------------------trace-------------------");
        log.debug("-------------------debug-------------------");
        log.info("-------------------info-------------------");
        log.warn("-------------------warn-------------------");
        log.error("-------------------error-------------------");
    }

}
