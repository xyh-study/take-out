package com.njpi.xyh.takeout.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.njpi.xyh.takeout.dao.SetmealDao;
import com.njpi.xyh.takeout.dto.SetmealDto;
import com.njpi.xyh.takeout.entity.Setmeal;
import com.njpi.xyh.takeout.entity.SetmealDish;
import com.njpi.xyh.takeout.result.Result;
import com.njpi.xyh.takeout.service.SetmealDishService;
import com.njpi.xyh.takeout.service.SetmealService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 套餐(Setmeal)表服务实现类
 *
 * @author xyh
 * @since 2022-07-02 18:54:58
 */
@Service("setmealService")
public class SetmealServiceImpl extends ServiceImpl<SetmealDao, Setmeal> implements SetmealService {


    @Resource
    private SetmealDishService setmealDishService;

    /**
     * @param setmealDto
     * @return
     */
    @Override
    public Result saveStemeal(SetmealDto setmealDto) {
        // 保存套餐
        Setmeal setmeal = new Setmeal();
        BeanUtils.copyProperties(setmealDto,setmeal);
        baseMapper.insert(setmeal);

        // 保存
        List<SetmealDish> setmealDishes = setmealDto.getSetmealDishes();

        // 在上套餐id
        setmealDishes.forEach(s->{
            s.setSetmealId(setmeal.getId());
        });

        setmealDishService.saveBatch(setmealDishes);
        return Result.success("新增菜单");
    }
}

