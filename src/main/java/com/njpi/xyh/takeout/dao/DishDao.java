package com.njpi.xyh.takeout.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.njpi.xyh.takeout.entity.Dish;

/**
 * 菜品管理(Dish)表数据库访问层
 *
 * @author xyh
 * @since 2022-07-02 18:54:51
 */
public interface DishDao extends BaseMapper<Dish> {

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Dish> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Dish> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Dish> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Dish> entities);

}

