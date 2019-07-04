package com.imooc.one.dubbo.api.service;

import com.imooc.one.dubbo.api.response.BaseResponse;

/**
 * Created by rabbit on 2019/6/1.
 */
public interface IDubboProductService {

    BaseResponse listProducts();

    BaseResponse listProductsByPage(Integer pageNum, Integer pageSize);

    BaseResponse listProductsByKeyword (Integer pageNum,Integer pageSize, String keyWord);
}
