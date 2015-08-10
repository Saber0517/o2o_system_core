package com.oocl.jyhon.daoimple;

import com.oocl.jyhon.dao.PackageEntityDao;
import com.oocl.jyhon.entiy.PackageEntity;
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
 * Created by ZHANGJA4 on 8/6/2015.
 */
public class PackageEntityDaoImple implements PackageEntityDao {
    private final static String tableName = (DBTableNameUtil.getTableNameMap()).get("PackageEntity");
    private final static String packageIDSequence = "seq_packageId";
    private Connection con = null;
    private PreparedStatement pst = null;

    @Override
    public int addEntity(PackageEntity Entity) {
        String sql = "INSERT INTO " + tableName + "(PACKAGEID,PACKAGENAME,PRICE,STATUSID,USERID) VALUES (" + packageIDSequence + ".nextval" + ",?,?,?,?)";
        ResultSet rs = null;
        int result = 0;
        con = DBConnectUtil.getConnection();
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, Entity.getPackageName());
            pst.setDouble(2, Entity.getPrice());
            pst.setInt(3, Entity.getStatusID());
            pst.setInt(4, Entity.getUserID());
            result = pst.executeUpdate();
            con.commit();
        } catch (SQLException e) {
            DBConnectUtil.free(con, pst, rs);
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int updateEntity(PackageEntity entity) {
        String sql = "UPDATE " + tableName + " SET PACKAGENAME=?,PRICE=?,STATUSID=?,USERID=? WHERE PACKAGEID=" + entity.getPackageID();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int result = 0;
        try {
            con = DBConnectUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, entity.getPackageName());
            pst.setDouble(2, entity.getPrice());
            pst.setInt(3, entity.getStatusID());
            pst.setInt(4, entity.getUserID());
            result = pst.executeUpdate();
        } catch (SQLException e) {
            DBConnectUtil.free(con, pst, rs);
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public int deleteEntity(PackageEntity entity) {
        return 0;
    }

    @Override
    public PackageEntity loadEntity(int id) {
        return null;
    }

    @Override
    public List<PackageEntity> findAll() {
        List<PackageEntity> packageEntityLinkedList = new LinkedList<PackageEntity>();
        String sql = "select * from " + tableName;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = DBConnectUtil.getConnection();
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                PackageEntity packageEntity = new PackageEntity();
                packageEntity.setPackageID(rs.getInt("PACKAGEID"));
                packageEntity.setPackageName(rs.getString("PACKAGENAME"));
                packageEntity.setUserID(rs.getInt("USERID"));
                packageEntity.setStatusID(rs.getInt("STATUSID"));
                packageEntity.setPrice(rs.getDouble("PRICE"));
                packageEntityLinkedList.add(packageEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnectUtil.free(con, pst, rs);
        }

        return packageEntityLinkedList;
    }

    @Override
    public List<PackageEntity> findAll(int start, int len) {
        return null;
    }

    @Override
    public int[] addEntitys(List<PackageEntity> entitys) {
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
    public PackageEntity verify(PackageEntity c) {
        return null;
    }


}
