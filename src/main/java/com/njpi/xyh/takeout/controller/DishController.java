package com.njpi.xyh.takeout.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.njpi.xyh.takeout.dto.DishDTO;
import com.njpi.xyh.takeout.entity.Category;
import com.njpi.xyh.takeout.entity.Dish;
import com.njpi.xyh.takeout.result.Result;
import com.njpi.xyh.takeout.service.CategoryService;
import com.njpi.xyh.takeout.service.DishService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 菜品管理(Dish)表控制层
 *
 * @author xyh
 * @since 2022-07-02 18:54:51
 */
@RestController
@RequestMapping("dish")
public class DishController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private DishService dishService;

    @Resource
    private CategoryService categoryService;

    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @param name
     * @return
     */
    @GetMapping("page")
    public Result selectAll(Integer page, Integer pageSize, @RequestParam(required = false) String name) {

        Page<Dish> pageList = null;
        Page<DishDTO> dishDTOPage = new Page<>();
        if (!StringUtils.hasText(name)) {
             pageList =dishService.page(new Page<>(page,pageSize));
        }else{
            pageList =dishService.page(new Page<>(page,pageSize),new QueryWrapper<Dish>().like("name",name));
        }

        // 将 dish-----> dishDTO
        List<DishDTO> collect = pageList.getRecords().stream().map(s -> {
            DishDTO dishDTO = new DishDTO();
            //1. 将对象copy成dishDTO
            BeanUtils.copyProperties(s, dishDTO);
            //2. 根据id 查询categoryName
            Category category = categoryService.getById(s.getCategoryId());
            String categoryName = category.getName();
            dishDTO.setCategoryName(categoryName);
            return dishDTO;
        }).collect(Collectors.toList());


        BeanUtils.copyProperties(pageList,dishDTOPage);

        dishDTOPage.setRecords(collect);
        return Result.success(dishDTOPage);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public Result selectOne(@PathVariable Serializable id) {
        return dishService.getDishById(id);
    }

    /**
     * 新增数据
     *
     * @return 新增结果
     */
    @PostMapping
    public Result insert(@RequestBody DishDTO dishDTO) {
        return  dishService.saveDishDTO(dishDTO);
    }

    /**
     * 修改数据
     *
     * @param dish 实体对象
     * @return 修改结果
     */
    @PutMapping
    public Result update(@RequestBody DishDTO dishDTO) {
        return dishService.updateDishById(dishDTO);
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public Result delete(@RequestParam("ids") List<Long> idList) {
        return Result.success(dishService.removeByIds(idList));
    }


    /**
     *  是否停用和启用
     *
     *flag  0 :停售  1: 起售
     * @param idList 主键结合
     * @return 删除结果
     */
    @PostMapping("status/{flag}")
    public Result statusStop(@PathVariable("flag") Integer flag , @RequestParam("ids") List<Long> idList) {
            if(idList.isEmpty()){
                return Result.error("id不能为空");
            }

            idList.forEach(s->{
                //1. 现根据id 获取到菜品
                Dish dish = dishService.getById(s);
                //2. 修改菜品状态
                dish.setStatus(flag);
                //3. 保存修改
                dishService.updateById(dish);
            });

        return Result.success("修改成功");
    }


    /**
     * 根据分类id 获取菜品
     * @param
     * @return
     */
    @GetMapping("list")
    public Result list(BigInteger categoryId){
        List<Dish> dishList = dishService.list(new QueryWrapper<Dish>().eq("category_id", categoryId));
        return Result.success(dishList);
    }


}

