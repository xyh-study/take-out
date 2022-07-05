package com.njpi.xyh.takeout.dto;

import com.njpi.xyh.takeout.entity.Dish;
import com.njpi.xyh.takeout.entity.DishFlavor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xyh
 * @create: 2022/7/5 10:35
 */
@Data
public class DishDTO extends Dish {
    // 接收菜品口味
    private List<DishFlavor> flavors = new ArrayList<>();
    // 分类名称
    private String categoryName;
    //
    private Integer copies;
}
