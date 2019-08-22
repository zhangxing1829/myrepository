package com.bjc.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.bjc.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
  * user_role 用户角色关联表 Mapper 接口
 * </p>
 *
 * @author XiaoBingBy
 * @since 2017-09-23
 */
@Mapper
public interface UserRoleMapper extends BaseMapper<UserRole> {

}