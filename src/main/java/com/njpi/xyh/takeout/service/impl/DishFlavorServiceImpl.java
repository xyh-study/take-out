package com.njpi.xyh.takeout.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.njpi.xyh.takeout.dao.DishFlavorDao;
import com.njpi.xyh.takeout.entity.DishFlavor;
import com.njpi.xyh.takeout.service.DishFlavorService;
import org.springframework.stereotype.Service;

/**
 * 菜品口味关系表(DishFlavor)表服务实现类
 *
 * @author xyh
 * @since 2022-07-02 18:54:52
 */
@Service("dishFlavorService")
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorDao, DishFlavor> implements DishFlavorService {

}

