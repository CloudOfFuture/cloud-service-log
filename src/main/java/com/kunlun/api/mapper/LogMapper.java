package com.kunlun.api.mapper;

import com.github.pagehelper.Page;
import com.kunlun.entity.GoodLog;
import com.kunlun.entity.OrderLog;
import com.kunlun.entity.PointLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
     * 根据订单id查询日志列表
     *
     * @param orderId
     * @return
     */
    List<OrderLog> findByOrderId(@Param("orderId") Long orderId);


    /**
     * 创建积分日志
     *
     * @param pointLog
     * @return
     */
    int addPointLog(PointLog pointLog);


    /**
     * 根据openid查询积分日志
     *
     * @param openid
     * @return
     */
    Page<PointLog> findPointLogByOpenId(@Param("openid") String openid);

    /**
     * 创建商品积分
     *
     * @param goodLog
     * @return
     */
    Integer addGoodLog(GoodLog goodLog);
}
