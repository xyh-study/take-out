package com.njpi.xyh.takeout.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.njpi.xyh.takeout.dao.DishDao;
import com.njpi.xyh.takeout.entity.Dish;
import com.njpi.xyh.takeout.service.DishService;
import org.springframework.stereotype.Service;

/**
 * 菜品管理(Dish)表服务实现类
 *
 * @author xyh
 * @since 2022-07-02 18:54:51
 */
@Service("dishService")
public class DishServiceImpl extends ServiceImpl<DishDao, Dish> implements DishService {

}

