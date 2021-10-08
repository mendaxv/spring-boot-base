package com.example.springbootbase.domain.vo;

import com.example.springbootbase.common.validator.UpdateGroup;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author zhouwei
 * @description:
 * @date 2021/8/4 16:10
 */
@Data
public class StudentVo {

    @NotNull(groups = UpdateGroup.class, message = "id不能为空")
    private Integer id;

    @NotBlank(message = "姓名不能为空")
    @Length(max = 20, message = "姓名长度需在20以内")
    private String name;

    @NotBlank(message = "邮箱地址不能为空")
    @Email(message = "邮箱地址不正确")
    private String email;

    private Integer age;

}
