package com.njpi.xyh.takeout.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.njpi.xyh.takeout.entity.Employee;
import com.njpi.xyh.takeout.result.Result;
import com.njpi.xyh.takeout.service.EmployeeService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 员工信息(Employee)表控制层
 *
 * @author xyh
 * @since 2022-07-02 18:54:52
 */
@RestController
@RequestMapping("employee")
public class EmployeeController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private EmployeeService employeeService;


    @PostMapping("login")
    public Result<Employee> login(@Validated @RequestBody Employee employee) {
        return employeeService.login(employee);
    }

    @PostMapping("logout")
    public Result logout() {
        return employeeService.logout();
    }

    @PostMapping("isLogin")
    public Result isLogin() {
        return employeeService.isLogin();
    }

    @GetMapping("page")
    public Result<Page<Employee>> employeePage(Integer page, Integer pageSize, @RequestParam(required = false) String name) {
        return employeeService.findPage(page,pageSize,name);
    }



    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public Result<Employee> selectOne(@PathVariable Serializable id) {
        return Result.success(this.employeeService.getById(id));
    }


    /**
     * 新增数据
     *
     * @param employee 实体对象
     * @return 新增结果
     */
    @PostMapping
    public Result insert(@Validated @RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    /**
     * 修改数据
     *
     * @param employee 实体对象
     * @return 修改结果
     */
    @PutMapping
    public Result update(@RequestBody Employee employee) {

        return employeeService.updateEmployeeById(employee);
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.employeeService.removeByIds(idList));
    }


}

