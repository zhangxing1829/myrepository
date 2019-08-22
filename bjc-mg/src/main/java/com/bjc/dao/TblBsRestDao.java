package com.bjc.dao;

import com.bjc.entity.TblBsRest;

public interface TblBsRestDao {
    int deleteByPrimaryKey(Integer restId);

    int insert(TblBsRest record);

    int insertSelective(TblBsRest record);

    TblBsRest selectByPrimaryKey(Integer restId);

    int updateByPrimaryKeySelective(TblBsRest record);

    int updateByPrimaryKeyWithBLOBs(TblBsRest record);

    int updateByPrimaryKey(TblBsRest record);
}