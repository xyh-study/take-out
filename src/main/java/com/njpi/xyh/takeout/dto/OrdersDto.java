package com.njpi.xyh.takeout.dto;


import com.njpi.xyh.takeout.entity.OrderDetail;
import com.njpi.xyh.takeout.entity.Orders;
import lombok.Data;

import java.util.List;


@Data
public class OrdersDto extends Orders {

    private String userName;

    private String phone;

    private String address;

    private String consignee;

    private List<OrderDetail> orderDetails;
	
}
