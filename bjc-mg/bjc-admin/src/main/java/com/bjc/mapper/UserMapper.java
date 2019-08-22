package com.bjc.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.bjc.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
  * user 用户表 Mapper 接口
 * </p>
 *
 * @author XiaoBingBy
 * @since 2017-09-23
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    //查询返回页面，并导出查询

    List<User> selectUsers();

    // 导入user表中
    void addUser(User user);
}