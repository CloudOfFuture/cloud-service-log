package com.kunlun.api.controller;

import com.kunlun.api.service.GoodLogService;
import com.kunlun.result.DataRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by hmy
 * @version <0.1>
 * @created on 2017-12-22.
 */
@RestController
@RequestMapping("goodLog")
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
    @GetMapping("/saveGoodLog")
    public DataRet<String> saveGoodLog(@RequestParam("good_name") String goodName,
                                       @RequestParam("action") String action,
                                       @RequestParam("id") Long id){
        return goodLogService.saveGoodLog(goodName,action,id);
    }
}
