package com.njpi.xyh.takeout.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.njpi.xyh.takeout.dto.SetmealDto;
import com.njpi.xyh.takeout.entity.Setmeal;
import com.njpi.xyh.takeout.result.Result;
import com.njpi.xyh.takeout.service.SetmealService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 套餐(Setmeal)表控制层
 *
 * @author xyh
 * @since 2022-07-02 18:54:58
 */
@RestController
@RequestMapping("setmeal")
public class SetmealController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private SetmealService setmealService;


    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @return 所有数据
     */
    @GetMapping("page")
    public Result selectAll(Integer page, Integer pageSize, @RequestParam(required = false) String name) {

        Page<Setmeal> setmealPage = null;
        if (name == null) {
             setmealPage = setmealService.page(new Page<>(page, pageSize));
        } else {
            setmealPage = setmealService.page(new Page<>(page, pageSize),new QueryWrapper<Setmeal>().like("name",name));
        }
        return Result.success(setmealPage);

    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.setmealService.getById(id));
    }


    /**
     * 新增数据
     *
     * @param
     * @return 新增结果
     */
    @PostMapping
    public Result insert(@RequestBody SetmealDto setmealDto) {
        return setmealService.saveStemeal(setmealDto);
    }


    /**
     * 修改数据
     *
     * @param setmeal 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Setmeal setmeal) {
        return success(this.setmealService.updateById(setmeal));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.setmealService.removeByIds(idList));
    }


}

