package com.bjc.service.impl;

import com.bjc.entity.OverTim;
import com.bjc.entity.Rest;
import com.bjc.mapper.OverTimMapper;
import com.bjc.mapper.RestMapper;
import com.bjc.service.OverTimService;
import com.bjc.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**
 * <p>
 * permission 权限表 服务实现类
 * </p>
 *
 * @author XiaoBingBy
 * @since 2017-09-23
 */
@Service
public class OverTimServiceImpl implements OverTimService {




    @Autowired
    private OverTimMapper restMapper;


    @Override
    public int insertOverTim(OverTim overTim) {

        int  re=restMapper.insertOverTim(overTim);
        return re;
    }


}
