package com.bjc.dao;

import com.bjc.entity.TblSysRole;

public interface TblSysRoleDao {
    int deleteByPrimaryKey(Integer roleId);

    int insert(TblSysRole record);

    int insertSelective(TblSysRole record);

    TblSysRole selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(TblSysRole record);

    int updateByPrimaryKey(TblSysRole record);
}