package com.oocl.jyhon.daoimple;


import com.oocl.jyhon.dao.UserEntityDao;
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
public class UserEntityDaoImple implements UserEntityDao {
    private final static String tableName = (DBTableNameUtil.getTableNameMap()).get("UserEntity");
    private final static String packageIDSequence = "seq_userEntityId";
    private Connection con = null;
    private PreparedStatement pst = null;

    @Override
    public int addEntity(UserEntity Entity) {
        String sql = "INSERT INTO " + tableName + "(USERID,USERNAME,PASSWORD,idCard,License,tel,ROLE,STATUSID) VALUES (" + packageIDSequence + ".nextval" + ",?,?,?,?,?,?,?)";
        ResultSet rs = null;
        int result = 0;
        try {
            con = DBConnectUtil.getConnection();
            pst = con.prepareStatement(sql, new String[]{"USERID"});
            pst.setString(1, Entity.getUserName());
            pst.setString(2, Entity.getPassword());
            pst.setString(3, Entity.getIdCard());
            pst.setString(4, Entity.getLicense());
            pst.setString(5, Entity.getTel());
            pst.setString(6, Entity.getRole());
            pst.setInt(7, Entity.getStatusId());
            result = pst.executeUpdate();
            rs = pst.getGeneratedKeys();
            if (rs.next()) {
                result = rs.getInt(1);
            }
            con.commit();
        } catch (SQLException e) {
            DBConnectUtil.free(con, pst, rs);
            e.printStackTrace();
        }
        return result;
    }

    public int updateEntityStatus(UserEntity userEntity) {

        String sql = "UPDATE " + tableName + " SET STATUSID=? WHERE USERID=?";
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int result = 0;
        try {
            con = DBConnectUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, userEntity.getStatusId());
            pst.setInt(2, userEntity.getUserID());
            result = pst.executeUpdate();
        } catch (SQLException e) {
            DBConnectUtil.free(con, pst, rs);
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public List<UserEntity> getUserByRole(String role) {
        List<UserEntity> userEntityList = new LinkedList<UserEntity>();
        String sql = "SELECT * from " + tableName + "  WHERE ROLE=?";
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = DBConnectUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, role);
            rs = pst.executeQuery();
            while (rs.next()) {
                UserEntity userEntity = new UserEntity();
                userEntity.setUserID(rs.getInt("USERID"));
                userEntity.setUserName(rs.getString("USERNAME"));
                userEntity.setRole(rs.getString("ROLE"));
                userEntity.setIdCard(rs.getString("IDCARD"));
                userEntity.setTel(rs.getString("TEL"));
                userEntity.setStatusId(rs.getInt("STATUSID"));
                userEntity.setLicense(rs.getString("LICENSE"));
                userEntityList.add(userEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnectUtil.free(con, pst, rs);
        }
        return userEntityList;
    }

    /**
     * @param name
     * @return if name exist return 1, else 0.
     */
    @Override
    public int checkUserName(String name) {
        String sql = "SELECT USERNAME from " + tableName + "  WHERE USERNAME=?";
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = DBConnectUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, name);
            rs = pst.executeQuery();
            if (rs.next()) {
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnectUtil.free(con, pst, rs);
        }
        return 0;
    }

    /**
     * @param idCard
     * @return if idCard exist return 1, else 0.
     */
    @Override
    public int checkIdCard(String idCard) {
        String sql = "SELECT idCard from " + tableName + "  WHERE idCard=?";
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = DBConnectUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, idCard);
            rs = pst.executeQuery();
            if (rs.next()) {
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnectUtil.free(con, pst, rs);
        }
        return 0;
    }

    /**
     * @param telPhone
     * @return if telPhone exist return 1, else 0.
     */
    @Override
    public int checkTelPhone(String telPhone) {
        String sql = "SELECT Tel from " + tableName + "  WHERE Tel=?";
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = DBConnectUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, telPhone);
            rs = pst.executeQuery();
            if (rs.next()) {
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnectUtil.free(con, pst, rs);
        }
        return 0;
    }


    @Override
    public int updateEntity(UserEntity entity) {
        String sql = "UPDATE " + tableName + " SET USERNAME=?,PASSWORD=?,idCard=?,License=?,tel=?,ROLE=?,STATUSID=? WHERE USERID=" + entity.getUserID();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int result = 0;
        try {
            con = DBConnectUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, entity.getUserName());
            pst.setString(2, entity.getPassword());
            pst.setString(3, entity.getIdCard());
            pst.setString(4, entity.getLicense());
            pst.setString(5, entity.getTel());
            pst.setString(6, entity.getRole());
            pst.setInt(7, entity.getStatusId());
            result = pst.executeUpdate();
        } catch (SQLException e) {
            DBConnectUtil.free(con, pst, rs);
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public int deleteEntity(UserEntity entity) {
        return 0;
    }

    @Override
    public UserEntity loadEntity(int id) {
        return null;
    }

    @Override
    public List<UserEntity> findAll() {
        return null;
    }

    @Override
    public List<UserEntity> findAll(int start, int len) {
        return null;
    }

    @Override
    public int[] addEntitys(List<UserEntity> entitys) {
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
    public UserEntity verify(UserEntity userEntity) {
        String sql = "SELECT USERID,USERNAME,IDCARD,LICENSE,TEL,ROLE,STATUSID from " + tableName + " CT WHERE USERNAME=? AND PASSWORD=?";
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            con = DBConnectUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, userEntity.getUserName());
            pst.setString(2, userEntity.getPassword());
            rs = pst.executeQuery();
            if (rs.next()) {
                userEntity.setUserID(rs.getInt("USERID"));
                userEntity.setUserName(rs.getString("USERNAME"));
                userEntity.setRole(rs.getString("ROLE"));
                userEntity.setTel(rs.getString("TEL"));
                userEntity.setStatusId(rs.getInt("STATUSID"));
                userEntity.setLicense(rs.getString("LICENSE"));
                return userEntity;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnectUtil.free(con, pst, rs);
        }
        return null;
    }
}
