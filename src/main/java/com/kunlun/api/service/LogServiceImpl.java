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
     * 创建订单日志
     *
     * @param orderLog
     * @return
     */
    @Override
    public DataRet<String> addOrderLog(OrderLog orderLog) {
        logMapper.addOrderLog(orderLog);
        return new DataRet<>("创建订单日志成功");
    }

    /**
     * 根据订单id查询日志列表
     *
     * @param orderId
     * @return
     */
    @Override
    public DataRet<List<OrderLog>> findByOrderId(Long orderId) {
        List<OrderLog> orderLogs = logMapper.findByOrderId(orderId);
        return new DataRet<>(orderLogs);
    }

    /**
     * 创建积分日志
     *
     * @param pointLog
     * @return
     */
    @Override
    public DataRet<String> addPointLog(PointLog pointLog) {
        logMapper.addPointLog(pointLog);
        return new DataRet<>("创建积分日志成功");
    }

    /**
     * 根据openid查询 积分日志列表
     *
     * @param pageNo
     * @param pageSize
     * @param wxCode
     * @return
     */
    @Override
    public PageResult findPointLogByOpenId(Integer pageNo, Integer pageSize, String wxCode) {
        String openid = WxUtil.getOpenId(wxCode);
        PageHelper.startPage(pageNo, pageSize);
        Page<PointLog> page = logMapper.findPointLogByOpenId(openid);
        return new PageResult(page);
    }


    /**
     * 创建商品日志
     *
     * @param goodLog
     * @return
     */
    @Override
    public DataRet<String> addGoodLog(GoodLog goodLog) {
        Integer result = logMapper.addGoodLog(goodLog);
        if (result == 0) {
            return new DataRet<>("ERROR","商品日志写入失败");
        }
        return new DataRet<>("商品日志写入成功");
    }

}
