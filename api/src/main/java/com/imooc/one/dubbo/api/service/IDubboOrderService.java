package com.imooc.one.dubbo.api.service;

import com.imooc.one.dubbo.api.dto.OrderItemDto;
import com.imooc.one.dubbo.api.response.BaseResponse;

/**
 * Created by rabbit on 2019/7/3.
 */
public interface IDubboOrderService {
    BaseResponse orderCommit(OrderItemDto orderItemDto);
}
