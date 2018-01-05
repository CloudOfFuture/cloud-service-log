package com.kunlun.api.service;

import com.kunlun.entity.GoodLog;
import com.kunlun.entity.OrderLog;
import com.kunlun.entity.PointLog;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;

import java.util.List;

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
     * 根据订单id查询日志列表
     *
     * @param orderId
     * @return
     */
    DataRet<List<OrderLog>> findByOrderId(Long orderId);

    /**
     * 创建积分日志
     *
     * @param pointLog
     * @return
     */
    DataRet<String> addPointLog(PointLog pointLog);

    /**
     * 根据openid查询 积分日志列表
     *
     * @param pageNo
     * @param pageSize
     * @param wxCode
     * @return
     */
    PageResult findPointLogByOpenId(Integer pageNo, Integer pageSize, String wxCode);


    /**
     * 创建商品日志
     *
     * @param goodLog
     * @return
     */
    DataRet<String> addGoodLog(GoodLog goodLog);

    /**
     * 创建商品日志
     *
     * @param goodLogs
     * @return
     */
    DataRet<String> addGoodLogs(List<GoodLog> goodLogs);

    /**
     * 创建积分日志
     *
     * @param pointLogs
     * @return
     */
    DataRet<String> addPointLogList(List<PointLog> pointLogs);
}
