package com.bjc.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.bjc.entity.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
  * permission 权限表 Mapper 接口
 * </p>
 *
 * @author XiaoBingBy
 * @since 2017-09-23
 */
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {

    /**
     * 查询父菜单
     * @param uid 用户ID
     * @return
     */
    List<Permission> findParentMenu(Long uid);

    /**
     * 查询子菜单
     * @param uid 用户ID
     * @param pid 父ID
     * @return
     */
    List<Permission> findSubMenu(@Param("uid") Long uid, @Param("pid") Long pid);

    /**
     * 查询用户拥有那些权限
     * @param uid
     * @return
     */
    List<Permission> findUserPermission(Long uid);

}