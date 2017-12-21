package com.kunlun.api.controller;

import com.kunlun.result.DataRet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/21.
 */
@RestController
public class IndexController {

    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @GetMapping("/test")
    public DataRet<String> test(@RequestParam("order_id") Long orderId) {
        LOGGER.info("订单服务传递过来的值: {}", orderId);
        return new DataRet<>("成功接收");
    }

}
