package com.kunlun.api.service;

import com.kunlun.result.DataRet;

/**
 * @author by hmy
 * @version <0.1>
 * @created on 2017-12-22.
 */
public interface GoodLogService {

    /**
     *新增商品日志
     *
     * @param goodName
     * @param action
     * @param goodId
     * @return
     */
    DataRet<String> saveGoodLog(String goodName, String action, Long goodId);
}
