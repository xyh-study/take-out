package com.njpi.xyh.takeout.config;

import com.njpi.xyh.takeout.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: xyh
 * @create: 2022/6/26 19:50
 */
@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {

    @Resource
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(loginInterceptor).excludePathPatterns(
//                "/employee/login", // 登录接口
//                "/employee/logout", // 退出接口
//                "/user/**", // 用户登录接口
//                "/employee/isLogin", // 是否登录
//                "/backend/**", // 放行管理界面所有静态资源
//                "/front/**" // 放行用户界面所有静态资源
//        );
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        // 创建消息转换器
        MappingJackson2HttpMessageConverter messageConverter  = new MappingJackson2HttpMessageConverter();
        // 设置对象转换器  顶层使用jackson 将java对象转成json
        messageConverter.setObjectMapper(new JacksonObjectMapper());
        // 将消息转换器添加到mvc框架集合中
        converters.add(0,messageConverter);
    }
}
