package com.njpi.xyh.takeout.dto;


import com.njpi.xyh.takeout.entity.Setmeal;
import com.njpi.xyh.takeout.entity.SetmealDish;
import lombok.Data;

import java.util.List;


@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
