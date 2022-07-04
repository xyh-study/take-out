package com.njpi.xyh.takeout.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.njpi.xyh.takeout.entity.Category;
import com.njpi.xyh.takeout.result.Result;

/**
 * 菜品及套餐分类(Category)表服务接口
 *
 * @author xyh
 * @since 2022-07-02 18:54:51
 */
public interface CategoryService extends IService<Category> {

    Result<Page<Category>> findPage(Integer page, Integer pageSize);

    Result dropById(Long id);

}

