package com.njpi.xyh.takeout.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.njpi.xyh.takeout.entity.DishFlavor;
import com.njpi.xyh.takeout.service.DishFlavorService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 菜品口味关系表(DishFlavor)表控制层
 *
 * @author xyh
 * @since 2022-07-02 18:54:51
 */
@RestController
@RequestMapping("dishFlavor")
public class DishFlavorController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private DishFlavorService dishFlavorService;

    /**
     * 分页查询所有数据
     *
     * @param page       分页对象
     * @param dishFlavor 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<DishFlavor> page, DishFlavor dishFlavor) {
        return success(this.dishFlavorService.page(page, new QueryWrapper<>(dishFlavor)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.dishFlavorService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param dishFlavor 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody DishFlavor dishFlavor) {
        return success(this.dishFlavorService.save(dishFlavor));
    }

    /**
     * 修改数据
     *
     * @param dishFlavor 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody DishFlavor dishFlavor) {
        return success(this.dishFlavorService.updateById(dishFlavor));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.dishFlavorService.removeByIds(idList));
    }
}

