package com.njpi.xyh.takeout.interceptor;

import com.njpi.xyh.takeout.entity.Employee;
import com.njpi.xyh.takeout.exception.AuthenticationException;
import com.njpi.xyh.takeout.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *  拦截没有请求 判断是否登录
 *  将没有登录的请求重定向到 请求界面
 * @author: xyh
 * @create: 2022/6/26 19:47
 */
@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String requestURI = request.getRequestURI();

        Employee employee = (Employee) session.getAttribute("employee");

        if (employee == null) {
            log.info("当前请求： {} 被拦截", requestURI);
            // 抛出跳转到登录界面的异常
            // 在前端的拦截器中 错误信息 如果返回的是NOTLOGIN 就会跳转带首页
            throw new AuthenticationException(Result.error("NOTLOGIN"));
        }

        log.info("当前请求： {} 被放行", requestURI);
        return true;
    }


}
