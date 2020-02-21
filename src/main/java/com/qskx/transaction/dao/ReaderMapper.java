package com.qskx.transaction.dao;

import com.qskx.transaction.Reader;

public interface ReaderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Reader record);

    int insertSelective(Reader record);

    Reader selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Reader record);

    int updateByPrimaryKey(Reader record);
}