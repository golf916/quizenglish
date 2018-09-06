package com.weiqi.mapper;

import com.weiqi.model.MyFavourite;
import org.springframework.stereotype.Repository;

/**
 * MyFavouriteDAO继承基类
 */
@Repository
public interface MyFavouriteDAO extends MyBatisBaseDao<MyFavourite, Integer> {
}