package com.kunlun.api.service;

import com.kunlun.api.mapper.GoodLogMapper;
import com.kunlun.entity.GoodLog;
import com.kunlun.result.DataRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author by hmy
 * @version <0.1>
 * @created on 2017-12-22.
 */
@Service
public class GoodLogServiceImpl implements GoodLogService {

    @Autowired
    private GoodLogMapper goodLogMapper;

    /**
     * 新增商品日志
     *
     * @param goodName
     * @param action
     * @param id
     * @return
     */
    @Override
    public DataRet<String> saveGoodLog(String goodName, String action, Long id) {
        GoodLog goodLog = new GoodLog();
        goodLog.setGoodName(goodName);
        goodLog.setAction(action);
        goodLog.setGoodId(id);
        Integer result = goodLogMapper.add(goodLog);
        if (result == 0) {
            return new DataRet<>("ERROR","商品日志写入失败");
        }
        return new DataRet<>("商品日志写入成功");
    }
}
