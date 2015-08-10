package com.oocl.jyhon.dao;

import com.oocl.jyhon.entiy.FoodEntity;
import com.oocl.jyhon.entiy.UserEntity;

import java.util.List;

/**
 * Created by ZHANGJA4 on 8/6/2015.
 */
public interface EntityDao<T> {
    public int addEntity(T Entity);

    public int updateEntity(T entity);

    public int deleteEntity(T entity);

    public T loadEntity(int id);

    public List<T> findAll();

    public List<T> findAll(int start, int len);

    public int[] addEntitys(List<T> entitys);

    public int deleteEntityByIndex(int i);

    public int[] deleteEntityByIndexArray(int[] i);

    public T verify(T c);


}
