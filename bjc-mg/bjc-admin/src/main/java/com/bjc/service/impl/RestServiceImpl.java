package com.bjc.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.bjc.entity.Rest;
import com.bjc.entity.RestOverTime;
import com.bjc.entity.User;
import com.bjc.mapper.RestMapper;
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
public class RestServiceImpl  implements RestService {
    @Override
    public List<Rest> produceRestNumber(Map<String, Object> map) {
        List<Rest> rest = restMapper.produceRestNumber(map);
        return rest;
    }

    @Autowired
    private RestMapper restMapper;

    @Override
    public List<Rest> selectByUId(Long uId) {
       List<Rest> rest= restMapper.restTime(uId);
        return rest;
    }

    @Override
    public int insertAllColumn(Rest rest) {

        int  re=restMapper.insertAllColumn(rest);
        return re;
    }

    @Override
    public List<Rest> listAll() {
        return restMapper.listAll();
}

    @Override
    public List<RestOverTime> produceRest(Map< String, Object > map) {

        List<RestOverTime> rest = restMapper.produceRest(map);
        return rest;
    }

}
