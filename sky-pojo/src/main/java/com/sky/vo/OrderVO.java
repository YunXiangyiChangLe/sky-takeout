package com.sky.vo;

import com.sky.entity.OrderDetail;
import com.sky.entity.Orders;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderVO extends Orders implements Serializable {

    //订单菜品信息
    private String orderDishes;

    //地址
    private String address;

    //地址id
    private Long addressBookId;

    //实收金额
    private BigDecimal amount;

    //订单取消原因
    private String cancelReason;

    //订单取消时间
    private LocalDateTime cancelTime;

    //结账时间
    private LocalDateTime checkoutTime;

    //收货人
    private String consignee;

    //配送状态  1立即送出  0选择具体时间
    private Integer deliveryStatus;

    //送达时间
    private LocalDateTime deliveryTime;

    //预计送达时间
    private LocalDateTime estimatedDeliveryTime;

    private Long id;

    //订单号
    private String number;

    //订单详情
    private List<OrderDetail> orderDetailList;

}
