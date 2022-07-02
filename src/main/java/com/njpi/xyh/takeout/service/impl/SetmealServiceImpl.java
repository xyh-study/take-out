package com.njpi.xyh.takeout.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.njpi.xyh.takeout.dao.SetmealDao;
import com.njpi.xyh.takeout.entity.Setmeal;
import com.njpi.xyh.takeout.service.SetmealService;
import org.springframework.stereotype.Service;

/**
 * 套餐(Setmeal)表服务实现类
 *
 * @author xyh
 * @since 2022-07-02 18:54:58
 */
@Service("setmealService")
public class SetmealServiceImpl extends ServiceImpl<SetmealDao, Setmeal> implements SetmealService {

}

