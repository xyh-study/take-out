package com.njpi.xyh.takeout.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.njpi.xyh.takeout.dto.SetmealDto;
import com.njpi.xyh.takeout.entity.Setmeal;
import com.njpi.xyh.takeout.result.Result;

/**
 * 套餐(Setmeal)表服务接口
 *
 * @author xyh
 * @since 2022-07-02 18:54:58
 */
public interface SetmealService extends IService<Setmeal> {

    Result saveStemeal(SetmealDto setmealDto);


}

