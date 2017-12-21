package com.kunlun.api.mapper;

import com.github.pagehelper.Page;
import com.kunlun.entity.OrderLog;
import com.kunlun.entity.PointLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/21.
 */
@Mapper
public interface LogMapper {

    /**
     * 创建订单日志
     *
     * @param orderLog
     * @return
     */
    int addOrderLog(OrderLog orderLog);

    /**
     * 根据openid查询积分日志
     *
     * @param openid
     * @return
     */
    Page<PointLog> findPointLogByOpenId(@Param("openid") String openid);

}
