package com.kunlun.api.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kunlun.api.service.LogService;
import com.kunlun.entity.GoodLog;
import com.kunlun.entity.OrderLog;
import com.kunlun.entity.PointLog;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
     * 根据订单id查询订单日志列表
     *
     * @param orderId
     * @return
     */
    @GetMapping("/findByOrderId")
    public DataRet<List<OrderLog>> findByOrderId(@RequestParam(value = "order_id") Long orderId) {
        return logService.findByOrderId(orderId);
    }


    /**
     * 创建积分日志
     *
     * @param pointLog
     * @return
     */
    @PostMapping("/add/pointLog")
    public DataRet<String> addPointLog(@RequestBody PointLog pointLog) {
        return logService.addPointLog(pointLog);
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


    /**
     * 创建商品日志
     *
     * @param goodLog
     * @return
     */
    @PostMapping("/add/goodLog")
    public DataRet<String> saveGoodLog(@RequestBody GoodLog goodLog){
        return logService.addGoodLog(goodLog);
    }

    /**
     * 创建商品日志
     *
     * @param jsonArray
     * @return
     */
    @PostMapping("/add/goodLogs")
    public DataRet<String> saveGoodLogs(@RequestBody JSONArray jsonArray) {
        List<GoodLog> goodLogs = jsonArray.toJavaList(GoodLog.class);
        return logService.addGoodLogs(goodLogs);
    }

}
