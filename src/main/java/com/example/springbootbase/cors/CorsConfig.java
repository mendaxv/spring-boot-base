package com.example.springbootbase.cors;

/**
 * @author zhouwei
 * @description: 跨域解决方案一：confif
 * @date 2021/8/2 15:35
 */
//@Configuration
//public class CorsConfig implements WebMvcConfigurer {
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                //允许所有来源访问
//                .allowedOrigins("*")
//                //允许访问的方式
//                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
//                //允许发送Cookie
//                .allowCredentials(true)
//                //指定本次预检请求的有效期，单位为秒，在此期间不用发出另一条预检请求
//                .maxAge(3600)
//                //允许所有响应首部
//                .allowedHeaders("*");
//    }
//
//}
