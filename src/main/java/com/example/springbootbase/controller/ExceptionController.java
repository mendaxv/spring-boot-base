package com.example.springbootbase.controller;

import com.example.springbootbase.common.exception.SystemErrorException;
import com.example.springbootbase.common.response.ResponseData;
import com.example.springbootbase.common.response.ResponseDataUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhouwei
 * @Description: 测试统一异常处理
 * @date 2021/7/1910:52
 */
@RestController
@RequestMapping("/exception")
public class ExceptionController {

    @GetMapping("str")
    public ResponseData str() {
        ServiveImpl service = new ServiveImpl();
        List<String> list= service.retSomething();
        return ResponseDataUtil.buildSuccess(list);
    }

    class ServiveImpl {
        public List<String> retSomething() {
            throw new SystemErrorException("1001", "Collect错误", "测试补充错误");
        }
    }

}
