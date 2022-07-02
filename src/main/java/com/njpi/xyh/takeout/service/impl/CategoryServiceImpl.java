package com.njpi.xyh.takeout.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.njpi.xyh.takeout.dao.CategoryDao;
import com.njpi.xyh.takeout.entity.Category;
import com.njpi.xyh.takeout.service.CategoryService;
import org.springframework.stereotype.Service;

/**
 * 菜品及套餐分类(Category)表服务实现类
 *
 * @author xyh
 * @since 2022-07-02 18:54:51
 */
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, Category> implements CategoryService {

}

