package com.njpi.xyh.takeout.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.njpi.xyh.takeout.entity.Employee;
import com.njpi.xyh.takeout.result.Result;

/**
 * 员工信息(Employee)表服务接口
 *
 * @author xyh
 * @since 2022-07-02 18:54:56
 */
public interface EmployeeService extends IService<Employee> {


    Result<Employee> login(Employee employee);

    Result logout();

}

