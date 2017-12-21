package com.kunlun.api.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kunlun.api.mapper.LogMapper;
import com.kunlun.entity.OrderLog;
import com.kunlun.entity.PointLog;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import com.kunlun.wxentity.wxUtils.WxUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
