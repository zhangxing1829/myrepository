package com.bjc.mapper;


import com.baomidou.mybatisplus.plugins.Page;
import com.bjc.entity.Rest;
import com.bjc.entity.RestOverTime;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface RestMapper {
    /**
     * 查询该用户剩余的调休天数
     * @param u_id
     */
        List<Rest> restTime(Long u_id);

        int   insertAllColumn(Rest rest);

        List<RestOverTime> produceRest(Map<String,Object> map);
        List<Rest> listAll();

        List<Rest> produceRestNumber(Map<String,Object> map);

}
