package com.example.springbootbase.controller;

import com.example.springbootbase.common.response.ResponseData;
import com.example.springbootbase.common.response.ResponseDataUtil;
import com.example.springbootbase.common.validator.UpdateGroup;
import com.example.springbootbase.domain.vo.StudentVo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.groups.Default;

/**
 * @author zhouwei
 * @description: 测试参数校验
 * @date 2021/8/4 16:09
 */
@RestController
@RequestMapping("/valid")
public class ValidatorController {

    @PostMapping("/create")
    public ResponseData<StudentVo> create(@RequestBody @Validated StudentVo student) {
        System.out.println(student.toString());
        return ResponseDataUtil.buildSuccess(student);
    }

    /**
     * 更新操作，分组校验
     * @param student
     * @return
     */
    @PutMapping("/update")
    public ResponseData<StudentVo> update(@RequestBody @Validated({UpdateGroup.class, Default.class}) StudentVo student) {
        System.out.println(student.toString());
        return ResponseDataUtil.buildSuccess(student);
    }

}
