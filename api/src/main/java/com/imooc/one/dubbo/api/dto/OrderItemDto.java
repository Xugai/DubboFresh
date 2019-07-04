package com.imooc.one.dubbo.api.dto;

import lombok.*;

import java.io.Serializable;

/**
 * Created by rabbit on 2019/7/3.
 */
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDto implements Serializable{

    private Integer productId;

    private Integer quantity;

    private Integer userId;
}
