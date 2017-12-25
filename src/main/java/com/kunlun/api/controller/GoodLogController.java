package com.kunlun.api.controller;

import com.kunlun.api.service.GoodLogService;
import com.kunlun.entity.GoodLog;
import com.kunlun.result.DataRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author by hmy
 * @version <0.1>
 * @created on 2017-12-22.
 */
@RestController
@RequestMapping("/backstage/goodLog")
public class GoodLogController {


    @Autowired
    private GoodLogService goodLogService;


    /**
     * 商品日志写入
     *
     * @param goodName
     * @param action
     * @param id
     * @return
     */
    @PostMapping("/saveGoodLog")
    public DataRet<String> saveGoodLog(@RequestParam("good_name") String goodName,
                                       @RequestParam("action") String action,
                                       @RequestParam("good_id") Long goodId){
        return goodLogService.saveGoodLog(goodName,action,goodId);
    }

    @GetMapping("/list")
    public DataRet<GoodLog> list(){
        return goodLogService.list();
    }
}
