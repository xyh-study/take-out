package com.njpi.xyh.takeout.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.njpi.xyh.takeout.dto.DishDTO;
import com.njpi.xyh.takeout.entity.Dish;
import com.njpi.xyh.takeout.result.Result;

import java.io.Serializable;

/**
 * 菜品管理(Dish)表服务接口
 *
 * @author xyh
 * @since 2022-07-02 18:54:51
 */
public interface DishService extends IService<Dish> {

    Result saveDishDTO(DishDTO dishDTO);

    Result getDishById(Serializable id);

    Result updateDishById(DishDTO dishDTO);
}

