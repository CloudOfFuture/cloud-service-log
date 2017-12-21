package com.kunlun.api.service;

import com.kunlun.entity.OrderLog;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;

/**
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/21.
 */
public interface LogService {

    /**
     * 创建订单日志
     *
     * @param orderLog
     * @return
     */
    DataRet<String> addOrderLog(OrderLog orderLog);

    /**
     * 根据openid查询 积分日志列表
     *
     * @param pageNo
     * @param pageSize
     * @param wxCode
     * @return
     */
    PageResult findPointLogByOpenId(Integer pageNo, Integer pageSize, String wxCode);
}
