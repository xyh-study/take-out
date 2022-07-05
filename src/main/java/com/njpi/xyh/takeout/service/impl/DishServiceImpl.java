package com.njpi.xyh.takeout.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.databind.util.BeanUtil;
import com.njpi.xyh.takeout.dao.DishDao;
import com.njpi.xyh.takeout.dao.DishFlavorDao;
import com.njpi.xyh.takeout.dto.DishDTO;
import com.njpi.xyh.takeout.entity.Dish;
import com.njpi.xyh.takeout.entity.DishFlavor;
import com.njpi.xyh.takeout.result.Result;
import com.njpi.xyh.takeout.service.DishFlavorService;
import com.njpi.xyh.takeout.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 菜品管理(Dish)表服务实现类
 *
 * @author xyh
 * @since 2022-07-02 18:54:51
 */
@Service("dishService")
@Slf4j
public class DishServiceImpl extends ServiceImpl<DishDao, Dish> implements DishService {


    @Resource
    private DishFlavorDao dishFlavorDao;

    /**
     * 新增菜品
     *
     * @param dishDTO
     * @return
     */
    @Override
    @Transactional // 确保都能成功
    public Result saveDishDTO(DishDTO dishDTO) {

        // 保存菜品数据
        Dish dish = new Dish();
        BeanUtils.copyProperties(dishDTO,dish);
        baseMapper.insert(dish);// insert之后这个dish就是一个完成的数据


        // 保存口味 设置当前菜品的id
        List<DishFlavor> flavors = dishDTO.getFlavors();
        log.debug("{}",flavors.toString());
        Long dishId= dish.getId();
        flavors.forEach(s->{
            s.setDishId(dishId);
            dishFlavorDao.insert(s);
        });



        return Result.success("添加成功");
    }

    @Override
    public Result getDishById(Serializable id) {
        //1. 查询菜品口味
        List<DishFlavor> dish_id = dishFlavorDao.selectList(new QueryWrapper<DishFlavor>().eq("dish_id", id));
        //2. 查询菜品
        Dish dish = baseMapper.selectById(id);
        //3. dishDTO
        DishDTO dishDTO = new DishDTO();
        BeanUtils.copyProperties(dish,dishDTO);
        dishDTO.setFlavors(dish_id);
        return Result.success(dishDTO);
    }

    @Override
    public Result updateDishById(DishDTO dishDTO) {
        // todo 校验数据
        //1.修改菜品
        Dish dish = new Dish();
        BeanUtils.copyProperties(dishDTO,dish);
        baseMapper.updateById(dish);
        //2.修改口味
        List<DishFlavor> flavors = dishDTO.getFlavors();
        if(!flavors.isEmpty()){
            flavors.forEach(s->{
                    dishFlavorDao.updateById(s);
            });
        }
        //3. 修改照片 会调用独立的接口
        //4. 返回数据
        return Result.success("修改成功");
    }
}

