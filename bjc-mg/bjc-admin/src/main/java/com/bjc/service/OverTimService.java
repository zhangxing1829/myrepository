package com.bjc.service;


import com.bjc.entity.OverTim;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * permission 权限表 服务类
 * </p>
 *
 * @author XiaoBingBy
 * @since 2017-09-23
 */
public interface OverTimService {

    /**
     * 保存加班
     * @param overTim
     * @return
     */
    public int insertOverTim(OverTim overTim);

}
