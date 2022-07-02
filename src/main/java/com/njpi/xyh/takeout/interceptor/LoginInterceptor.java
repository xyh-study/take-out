package com.njpi.xyh.takeout.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.security.sasl.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
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

        Long employeeId = (Long) session.getAttribute("employeeId");
        if (employeeId == null) {
            log.info("当前请求： {} 被拦截",requestURI);
            throw  new AuthenticationException("认证失败");
        }
        log.info("当前请求： {} 被放行",requestURI);
        return true;
    }


}
