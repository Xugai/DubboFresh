package com.imooc.one.dubbo.server.service.dubbo;

import com.alibaba.dubbo.config.annotation.Service;
import com.imooc.one.dubbo.api.dto.OrderItemDto;
import com.imooc.one.dubbo.api.enums.ResponseCode;
import com.imooc.one.dubbo.api.response.BaseResponse;
import com.imooc.one.dubbo.api.service.IDubboOrderService;
import com.imooc.one.dubbo.module.entity.OrderItem;
import com.imooc.one.dubbo.module.entity.Product;
import com.imooc.one.dubbo.module.mapper.OrderItemMapper;
import com.imooc.one.dubbo.module.mapper.ProductMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by rabbit on 2019/7/3.
 */
@Service(protocol = {"dubbo", "rest"}, validation = "true", version = "1.0", timeout = 3000)
@Path("order")
public class IDubboOrderServiceImpl implements IDubboOrderService {

    private static final Logger logger = LoggerFactory.getLogger(IDubboOrderServiceImpl.class);

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Override
    @Path("commit")
    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public BaseResponse orderCommit(OrderItemDto orderItemDto) {
        if(orderItemDto.getUserId() == null || orderItemDto.getProductId() == null || orderItemDto.getQuantity() == null){
            return BaseResponse.createByErrorCodeAndErrorMessage(ResponseCode.INVALID_PARAM.getCode(), ResponseCode.INVALID_PARAM.getMsg());
        }
        try{
            //todo if product exist validation
            Product product = productMapper.selectByPrimaryKey(orderItemDto.getProductId());
            if(product == null){
                return BaseResponse.createByErrorCodeAndErrorMessage(ResponseCode.NOT_FOUND.getCode(), "Can not find specified product in database!!!");
            }
            //todo if product stock is enough validation
            if(product.getStock() < orderItemDto.getQuantity()){
                return BaseResponse.createByErrorCodeAndErrorMessage(ResponseCode.NON_ENOUGH_STOCK.getCode(), ResponseCode.NON_ENOUGH_STOCK.getMsg());
            }
            OrderItem orderItem = new OrderItem();
            BeanUtils.copyProperties(orderItemDto, orderItem);
            orderItemMapper.insertSelective(orderItem);
            return BaseResponse.createBySuccess(orderItem.getId());
        }catch(Exception ex){
            return BaseResponse.createByErrorCodeAndErrorMessage(ResponseCode.ERROR.getCode(), ex.getMessage());
        }
    }
}
