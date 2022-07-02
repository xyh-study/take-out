package com.njpi.xyh.takeout.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.njpi.xyh.takeout.dao.EmployeeDao;
import com.njpi.xyh.takeout.entity.Employee;
import com.njpi.xyh.takeout.exception.AuthenticationException;
import com.njpi.xyh.takeout.result.Result;
import com.njpi.xyh.takeout.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.nio.charset.StandardCharsets;

/**
 * 员工信息(Employee)表服务实现类
 *
 * @author xyh
 * @since 2022-07-02 18:54:56
 */
@Service("employeeService")
@Slf4j
public class EmployeeServiceImpl extends ServiceImpl<EmployeeDao, Employee> implements EmployeeService {

    @Resource
    private HttpSession session;


    @Override
    public Result<Employee> login(Employee employee) {
        String username = employee.getUsername();
        String password = employee.getPassword();
        // 密码加密
        password = DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));

        // 1.数据格式校验 使用validate 校验数据
        // 2.根据用户名查询用户
        Employee employeeDB = baseMapper.selectOne(new QueryWrapper<Employee>().eq("username", username));
        // 3.不存在当前登录用户 抛出异常
        if (employeeDB == null) {
            log.debug("当前登录的员工----> {}", "用户名或密码错误");
            throw new AuthenticationException(Result.error("用户名或密码错误"));
        }
        // 4.比对密码
        if (!employeeDB.getPassword().equals(password)) {
            log.debug("当前登录的员工----> {}", "用户名或密码错误");
            // 5.密码错误 抛出异常
            throw new AuthenticationException(Result.error("用户名或密码错误"));
        }
        // 判断状态
        if (employeeDB.getStatus() == 0) {
            throw new AuthenticationException(Result.error("账号被禁用"));
        }

        log.debug("当前登录的员工用户为 ------> {}", employeeDB.getUsername());
        // 6.将用户保存到session中
        session.setAttribute("employee", employeeDB);
        // 7.返回结果
        // 将返回的密码去掉
        employeeDB.setPassword("");
        return Result.success(employeeDB);
    }


    @Override
    public Result logout() {
        session.setAttribute("employee" , "");
        return Result.success("退出成功");
    }
}

