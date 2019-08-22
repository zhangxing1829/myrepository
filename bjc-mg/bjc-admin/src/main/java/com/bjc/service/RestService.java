package com.bjc.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.bjc.entity.*;

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
public interface RestService {
    public List<Rest> selectByUId(Long  uid);

    public int insertAllColumn(Rest rest);

    List<RestOverTime> produceRest(Map<String,Object> map); //按部门查询

    List<Rest> listAll();

    List<Rest> produceRestNumber(Map<String,Object> map);  //按工号查询

}
