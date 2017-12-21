package com.kunlun.api.controller;

import com.kunlun.api.service.LogService;
import com.kunlun.entity.OrderLog;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/21.
 */
@RestController
@RequestMapping("log")
public class LogController {

    @Autowired
    private LogService logService;

    /**
     * 创建订单日志
     *
     * @param orderLog
     * @return
     */
    @PostMapping("/add/orderLog")
    public DataRet<String> addOrderLog(@RequestBody OrderLog orderLog) {
        return logService.addOrderLog(orderLog);
    }

    /**
     * 查询积分日志
     *
     * @return
     */
    @GetMapping("/findPointLogByOpenId")
    public PageResult findPointLogByOpenId(@RequestParam(value = "page_no") Integer pageNo,
                                           @RequestParam(value = "page_size") Integer pageSize,
                                           @RequestParam(value = "wx_code") String wxCode) {
        return logService.findPointLogByOpenId(pageNo, pageSize, wxCode);
    }
}
