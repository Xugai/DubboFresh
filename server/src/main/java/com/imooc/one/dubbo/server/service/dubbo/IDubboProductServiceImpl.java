package com.imooc.one.dubbo.server.service.dubbo;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imooc.one.dubbo.api.response.BaseResponse;
import com.imooc.one.dubbo.api.service.IDubboProductService;
import com.imooc.one.dubbo.module.entity.Product;
import com.imooc.one.dubbo.module.mapper.ProductMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.util.List;

/**
 * Created by rabbit on 2019/6/1.
 */
@Service(protocol = {"dubbo", "rest"}, validation = "true", version = "1.0", timeout = 3000)
@Path("baseDubbo")
public class IDubboProductServiceImpl implements IDubboProductService {

    private static final Logger logger = LoggerFactory.getLogger(IDubboProductServiceImpl.class);

    @Autowired
    private ProductMapper productMapper;

    /**
     * 商品列表信息服务——返回商品列表信息
     * @return
     */
    @Path("product/list")
    public BaseResponse listProducts() {
        List<Product> productList = productMapper.selectAll();
        logger.info("查询到的商品列表信息： {}", productList);
        return BaseResponse.createBySuccess(productList);
    }

    @Override
    @Path("product/list/page")
    public BaseResponse listProductsByPage(@QueryParam("pageNum") Integer pageNum,
                                           @QueryParam("pageSize") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Product> pageInfo = new PageInfo<Product>(productMapper.selectAll());
        pageInfo.setList(productMapper.selectAll());
        logger.info("当前pageNum为 {}，pageSize为 {}", pageNum, pageSize);
        return BaseResponse.createBySuccess(pageInfo);
    }

    @Override
    @Path("product/list/keyword")
    public BaseResponse listProductsByKeyword(@QueryParam("pageNum") Integer pageNum,
                                              @QueryParam("pageSize") Integer pageSize,
                                              @QueryParam("keyWord") String keyWord){
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Product> pageInfo = new PageInfo<Product>(productMapper.selectByKeyWord("%" + keyWord + "%"));
        pageInfo.setList(productMapper.selectByKeyWord("%" + keyWord + "%"));
        logger.info("当前pageNum为 {}，pageSize为 {}，keyWord为 {}", pageNum, pageSize, keyWord);
        return BaseResponse.createBySuccess(pageInfo);
    }
}
