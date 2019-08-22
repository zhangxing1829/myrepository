package com.bjc.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.bjc.entity.UserRole;
import com.bjc.mapper.UserRoleMapper;
import com.bjc.service.IUserRoleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * user_role 用户角色关联表 服务实现类
 * </p>
 *
 * @author XiaoBingBy
 * @since 2017-09-23
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {
	
}
