package com.bjc.mapper;

import com.bjc.entity.OverTim;
import com.bjc.entity.Rest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SelectMapper {

    public List<OverTim> selectOverTime(OverTim overtime);
    public List<Rest> selectRest(Rest rest);

}
