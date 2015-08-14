package com.oocl.jyhon.dao;

import com.oocl.jyhon.entiy.UserEntity;

/**
 * Created by ZHANGJA4 on 8/5/2015.
 */
public interface UserEntityDao extends EntityDao<UserEntity> {
    public int updateEntityStatus(UserEntity entity) ;
    public int checkUserName(String name);
    public int checkIdCard(String idCard);
    public int checkTelPhone(String telPhone);

}
