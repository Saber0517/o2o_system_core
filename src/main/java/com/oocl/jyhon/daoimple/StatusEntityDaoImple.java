package com.oocl.jyhon.daoimple;

import com.oocl.jyhon.dao.StatusEntityDao;
import com.oocl.jyhon.entiy.FoodEntity;
import com.oocl.jyhon.entiy.StatusEntity;
import com.oocl.jyhon.entiy.UserEntity;
import com.oocl.jyhon.util.DBConnectUtil;
import com.oocl.jyhon.util.DBTableNameUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ZHANGJA4 on 8/5/2015.
 */
public class StatusEntityDaoImple implements StatusEntityDao {
    private final static String tableName = (DBTableNameUtil.getTableNameMap()).get("StatusEntity");
    private Connection con = null;
    private PreparedStatement pst = null;

    @Override
    public int addEntity(StatusEntity Entity) {
        return 0;
    }

    @Override
    public int updateEntity(StatusEntity entity) {
        return 0;
    }

    @Override
    public int deleteEntity(StatusEntity entity) {
        return 0;
    }

    @Override
    public StatusEntity loadEntity(int id) {
        return null;
    }

    @Override
    public List<StatusEntity> findAll() {
        List<StatusEntity> statusEntityList = new LinkedList<StatusEntity>();
        String sql = "select * from " + tableName;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = DBConnectUtil.getConnection();
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                StatusEntity statusEntity = new StatusEntity();
                statusEntity.setStatusID(rs.getInt("STATUSID"));
                statusEntity.setStatusName(rs.getString("STATUSNAME"));
                statusEntityList.add(statusEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnectUtil.free(con, pst, rs);
        }
        return statusEntityList;
    }

    @Override
    public List<StatusEntity> findAll(int start, int len) {
        return null;
    }

    @Override
    public int[] addEntitys(List<StatusEntity> entitys) {
        return new int[0];
    }

    @Override
    public int deleteEntityByIndex(int i) {
        return 0;
    }

    @Override
    public int[] deleteEntityByIndexArray(int[] i) {
        return new int[0];
    }

    @Override
    public StatusEntity verify(StatusEntity c) {
        return null;
    }

}
