package com.bjc.mapper;

import com.bjc.entity.OverTim;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OverTimMapper {
    /**
     * 保存
     * @param overTim
     * @return
     */
    int   insertOverTim(OverTim overTim);
}
