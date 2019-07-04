package com.imooc.one.dubbo.server.controller;

import com.imooc.one.dubbo.api.response.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by rabbit on 2019/6/1.
 */
@RestController
public class BaseController {

    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    private static final String prefix = "base";

    @RequestMapping(value = prefix + "/one", method = RequestMethod.GET)
    public BaseResponse baseRequestHandler(@RequestParam String param){
        return BaseResponse.createBySuccess(param);
    }
}
