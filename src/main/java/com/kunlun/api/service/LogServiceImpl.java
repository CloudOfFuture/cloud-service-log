package com.kunlun.api.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kunlun.api.mapper.LogMapper;
import com.kunlun.entity.GoodLog;
import com.kunlun.entity.OrderLog;
import com.kunlun.entity.PointLog;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import com.kunlun.utils.WxUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/21.
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;

    /**
     * 根据订单id查询日志列表
     *
     * @param orderId Long
     * @return DataRet
     */
    @Override
    public DataRet<List<OrderLog>> findByOrderId(Long orderId) {
        List<OrderLog> orderLogs = logMapper.findByOrderId(orderId);
        return new DataRet<>(orderLogs);
    }


    /**
     * 根据openid查询 积分日志列表
     *
     * @param pageNo   Integer
     * @param pageSize Integer
     * @param wxCode   String
     * @return PageResult
     */
    @Override
    public PageResult findPointLogByOpenId(Integer pageNo, Integer pageSize, String wxCode) {
        String openid = WxUtil.getOpenId(wxCode);
        PageHelper.startPage(pageNo, pageSize);
        Page<PointLog> page = logMapper.findPointLogByOpenId(openid);
        return new PageResult<>(page);
    }

    /**
     * 创建订单日志
     *
     * @param orderLog OrderLog
     * @return DataRet
     */
    @Override
    public DataRet<String> addOrderLog(OrderLog orderLog) {
        logMapper.addOrderLog(orderLog);
        return new DataRet<>("创建订单日志成功");
    }

    /**
     * 创建积分日志
     *
     * @param pointLog PointLog
     * @return DataRet
     */
    @Override
    public DataRet<String> addPointLog(PointLog pointLog) {
        int result = logMapper.addPointLog(pointLog);
        if (result > 0) {
            return new DataRet<>("创建积分日志成功");
        }
        return new DataRet<>("ERROR", "积分日志写入失败");
    }

    /**
     * 创建商品日志
     *
     * @param goodLog GoodLog
     * @return DataRet
     */
    @Override
    public DataRet<String> addGoodLog(GoodLog goodLog) {
        int result = logMapper.addGoodLog(goodLog);
        if (result > 0) {
            return new DataRet<>("商品日志写入成功");
        }
        return new DataRet<>("ERROR", "商品日志写入失败");
    }

    /**
     * 批量创建商品日志
     *
     * @param goodLogs goodLogs
     * @return DataRet
     */
    @Override
    public DataRet<String> addGoodLogs(List<GoodLog> goodLogs) {
        int result = logMapper.addGoodLogList(goodLogs);
        if (result > 0) {
            return new DataRet<>("商品日志写入成功");
        }
        return new DataRet<>("ERROR", "日志日入失败");
    }

    /**
     * 积分日志列表写入
     *
     * @param pointLogs List
     * @return DataRet
     */
    @Override
    public DataRet<String> addPointLogList(List<PointLog> pointLogs) {
        int result = logMapper.addPointLogList(pointLogs);
        if (result > 0) {
            return new DataRet<>("积分日志写入成功");
        }
        return new DataRet<>("ERROR", "日志日入失败");
    }
}
