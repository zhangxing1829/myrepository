package com.bjc.dao;

import com.bjc.entity.TblSysPermission;

public interface TblSysPermissionDao {
    int deleteByPrimaryKey(Integer pId);

    int insert(TblSysPermission record);

    int insertSelective(TblSysPermission record);

    TblSysPermission selectByPrimaryKey(Integer pId);

    int updateByPrimaryKeySelective(TblSysPermission record);

    int updateByPrimaryKey(TblSysPermission record);
}