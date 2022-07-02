package com.njpi.xyh.takeout.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.njpi.xyh.takeout.entity.OrderDetail;

/**
 * 订单明细表(OrderDetail)表数据库访问层
 *
 * @author xyh
 * @since 2022-07-02 18:54:57
 */
public interface OrderDetailDao extends BaseMapper<OrderDetail> {

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<OrderDetail> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<OrderDetail> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<OrderDetail> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<OrderDetail> entities);

}

