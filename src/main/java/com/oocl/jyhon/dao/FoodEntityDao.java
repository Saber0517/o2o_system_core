package com.oocl.jyhon.dao;


import com.oocl.jyhon.entiy.FoodEntity;

import java.util.List;

/**
 * Created by ZHANGJA4 on 7/29/2015.
 */
public interface FoodEntityDao extends EntityDao<FoodEntity> {
    int updateFoodEntityPrice(Integer id, Double price);

    List<FoodEntity> groupByTypeId(int typeId);

    int deleteEntityByFoodId(Integer foodId, Integer userId);

    //以后的删除仅仅改变数据状态
    int updateEntityStatus(FoodEntity foodEntity);

    List<FoodEntity> searchFoodByFoodId(List<String> foodIdList);

}
