package com.example.springbootbase.common.validator;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * @author zhouwei
 * @description: 校验器配置
 * @date 2021/8/4 16:07
 */
@Configuration
public class ValidatorConfig {

    @Bean
    public Validator validator() {
        ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
                .configure()
                // 快速失败,如果有多个参数的情况下，只要校验出一个参数有误就返回错误而不再继续校验
                .failFast(true)
                .buildValidatorFactory();
        return validatorFactory.getValidator();
    }

}
