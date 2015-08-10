package com.oocl.jyhon.dao;

import com.oocl.jyhon.entiy.StatusEntity;
import com.oocl.jyhon.entiy.UserEntity;

import java.util.List;

/**
 * Created by ZHANGJA4 on 8/5/2015.
 */
public interface UserEntityDao extends EntityDao<UserEntity>{
    public int updateEntityStatus(UserEntity entity) ;
    public List<UserEntity> getUserByRole(String role);
}
