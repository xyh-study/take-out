package com.njpi.xyh.takeout.entity;


import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 套餐菜品关系(SetmealDish)表实体类
 *
 * @author xyh
 * @since 2022-07-02 18:54:58
 */
@SuppressWarnings("serial")
@TableName("setmeal_dish")
@Data
public class SetmealDish extends Model<SetmealDish> {
    /**
     * 主键
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 套餐id
     */
    @TableField(value = "setmeal_id")
    private Long setmealId;

    /**
     * 菜品id
     */
    @TableField(value = "dish_id")
    private Long dishId;

    /**
     * 菜品名称 （冗余字段）
     */
    @TableField(value = "name")
    private String name;

    /**
     * 菜品原价（冗余字段）
     */
    @TableField(value = "price")
    private Double price;

    /**
     * 份数
     */
    @TableField(value = "copies")
    private Integer copies;

    /**
     * 排序
     */
    @TableField(value = "sort")
    private Integer sort;

    /**
     * 创建时间
     */
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /**
     * 创建人
     */
    @TableField(value = "create_user",fill = FieldFill.INSERT)
    private Long createUser;

    /**
     * 修改人
     */
    @TableField(value = "update_user",fill = FieldFill.INSERT_UPDATE)
    private Long updateUser;

    /**
     * 是否删除
     */
    @TableField(value = "is_deleted")
    @TableLogic(value = "0")
   private Integer isDeleted;




}

