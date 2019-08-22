package com.bjc.dao;

import com.bjc.entity.TblSysUser;

public interface TblSysUserDao {
    int deleteByPrimaryKey(Integer uId);

    int insert(TblSysUser record);

    int insertSelective(TblSysUser record);

    TblSysUser selectByPrimaryKey(Integer uId);

    int updateByPrimaryKeySelective(TblSysUser record);

    int updateByPrimaryKey(TblSysUser record);
}