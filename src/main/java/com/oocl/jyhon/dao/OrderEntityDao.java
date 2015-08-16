package com.oocl.jyhon.dao;

import com.oocl.jyhon.entiy.OrderEntity;

import java.util.List;

/**
 * Created by WhiteSaber on 15/8/15.
 */
public interface OrderEntityDao extends EntityDao<OrderEntity> {
    public List<OrderEntity> findOrderByUserId(Integer userId);
}
