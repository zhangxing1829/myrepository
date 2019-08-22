package com.bjc.service.impl;

import com.bjc.entity.OverTim;
import com.bjc.entity.Rest;
import com.bjc.mapper.SelectMapper;
import com.bjc.service.SelectOverTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SelectOverTimeServiceimpl implements SelectOverTimeService {

    @Autowired
    private SelectMapper selectmapper;


    @Override
    public List<OverTim> selectOverTime(OverTim overtime) {
        return selectmapper.selectOverTime(overtime);
    }

    @Override
    public List<Rest> selectRest(Rest rest) {
        return  selectmapper.selectRest(rest);
    }


}
