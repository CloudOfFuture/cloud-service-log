package com.kunlun.api.mapper;

import com.kunlun.entity.GoodLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author by hmy
 * @version <0.1>
 * @created on 2017-12-22.
 */
@Mapper
public interface GoodLogMapper {

    /**
     * 新增商品日志
     *
     * @param goodLog
     * @return
     */
    Integer add(GoodLog goodLog);
}
