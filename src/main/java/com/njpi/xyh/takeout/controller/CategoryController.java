package com.njpi.xyh.takeout.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.njpi.xyh.takeout.entity.Category;
import com.njpi.xyh.takeout.entity.Employee;
import com.njpi.xyh.takeout.result.Result;
import com.njpi.xyh.takeout.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 菜品及套餐分类(Category)表控制层
 *
 * @author xyh
 * @since 2022-07-02 18:54:51
 */
@RestController
@RequestMapping("category")
public class CategoryController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private CategoryService categoryService;


    /**
     * 根据type 获取分类下的数据
     *
     * @param type 分类
     * @return
     */
    @GetMapping("list")
    public Result<List<Category>> categoryList(Integer type) {
        List<Category> categoryList = categoryService.list(new QueryWrapper<Category>().eq("type", type));
        return Result.success(categoryList);

    }


    /**
     * 分页查询
     *
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("page")
    public Result<Page<Category>> categoryPage(Integer page, Integer pageSize) {
        return categoryService.findPage(page, pageSize);
    }


    /**
     * 分页查询所有数据
     *
     * @param page     分页对象
     * @param category 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Category> page, Category category) {
        return success(this.categoryService.page(page, new QueryWrapper<>(category)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.categoryService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param category 实体对象
     * @return 新增结果
     */
    @PostMapping
    public Result insert(@RequestBody Category category) {
        return Result.success(categoryService.save(category));
    }

    /**
     * 修改数据
     *
     * @param category 实体对象
     * @return 修改结果
     */
    @PutMapping
    public Result update(@RequestBody Category category) {
        return Result.success(this.categoryService.updateById(category));
    }

    /**
     * 删除数据
     *
     * @return 删除结果
     */
    @DeleteMapping
    public Result delete(@RequestParam("ids") Long id) {
        return categoryService.dropById(id);
    }
}

