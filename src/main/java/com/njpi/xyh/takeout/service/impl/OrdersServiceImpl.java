package com.njpi.xyh.takeout.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.njpi.xyh.takeout.dao.OrdersDao;
import com.njpi.xyh.takeout.entity.Orders;
import com.njpi.xyh.takeout.service.OrdersService;
import org.springframework.stereotype.Service;

/**
 * 订单表(Orders)表服务实现类
 *
 * @author xyh
 * @since 2022-07-02 18:54:58
 */
@Service("ordersService")
public class OrdersServiceImpl extends ServiceImpl<OrdersDao, Orders> implements OrdersService {

}

