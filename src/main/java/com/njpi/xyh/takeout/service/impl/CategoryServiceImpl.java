package com.njpi.xyh.takeout.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.njpi.xyh.takeout.dao.CategoryDao;
import com.njpi.xyh.takeout.entity.Category;
import com.njpi.xyh.takeout.entity.Dish;
import com.njpi.xyh.takeout.entity.Setmeal;
import com.njpi.xyh.takeout.result.Result;
import com.njpi.xyh.takeout.service.CategoryService;
import com.njpi.xyh.takeout.service.DishService;
import com.njpi.xyh.takeout.service.SetmealService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 菜品及套餐分类(Category)表服务实现类
 *
 * @author xyh
 * @since 2022-07-02 18:54:51
 */
@Service("categoryService")
@Slf4j
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, Category> implements CategoryService {

    @Resource
    private DishService dishService; // 菜品

    @Resource
    private SetmealService setmealService; // 套餐


    @Override
    public Result<Page<Category>> findPage(Integer page, Integer pageSize) {
        Page<Category> categoryPage = baseMapper.selectPage(new Page<>(page, pageSize), null);
        return Result.success(categoryPage);
    }


    @Override
    public Result dropById(Long id) {
        // 1. 有没有菜品在使用当前分类
        List<Dish> dishList = dishService.list(new QueryWrapper<Dish>().eq("category_id", id));
        log.debug("dishList ---> {}",dishList);
        if (!dishList.isEmpty()) {
            return Result.error("当前分类正在被使用");
        }
        // 2. 有没有套餐在使用当亲分类
        List<Setmeal> setmeals = setmealService.list(new QueryWrapper<Setmeal>().eq("category_id", id));
        log.debug("setmeals ---> {}",setmeals);
        if (!setmeals.isEmpty()) {
            return Result.error("当前分类正在被使用");
        }
        return Result.success("删除成功");
    }
}

