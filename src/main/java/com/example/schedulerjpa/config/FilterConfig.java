//package com.example.schedulerjpa.config;
//
//import com.example.schedulerjpa.filter.AuthFilter;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class FilterConfig {
//
//    @Bean
//    public FilterRegistrationBean<AuthFilter> authFilter() {
//        FilterRegistrationBean<AuthFilter> registrationBean = new FilterRegistrationBean<>();
//        registrationBean.setFilter(new AuthFilter());
//        registrationBean.addUrlPatterns("/*"); // 모든 요청에 필터 적용
//        return registrationBean;
//    }
//}
