package com.njpi.xyh.takeout.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.njpi.xyh.takeout.dao.OrderDetailDao;
import com.njpi.xyh.takeout.entity.OrderDetail;
import com.njpi.xyh.takeout.service.OrderDetailService;
import org.springframework.stereotype.Service;

/**
 * 订单明细表(OrderDetail)表服务实现类
 *
 * @author xyh
 * @since 2022-07-02 18:54:57
 */
@Service("orderDetailService")
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailDao, OrderDetail> implements OrderDetailService {

}

