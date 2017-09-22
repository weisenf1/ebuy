package com.weisen.ebuy2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.Iterator;
import java.util.List;

import com.weisen.ebuy2.entity.Admin;
import com.weisen.ebuy2.util.DBUtils;

/**
 * ��Ȩ��(permission)Ϊy�ĳ�������Ա�����ܶԿ�ebuy�б�admin���в���
 * @author weisen
 * alt shift j
 */
public class AdminDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Admin admin2=new Admin();
//		admin2.setUsername("chengcl");
//		admin2.setPassword("chengcl");
//		admin2.setPermission("n");;
//		new AdminDao().adminInsert(admin2);
//		Admin admin2=new Admin();
//		admin2.setUsername("weisen");
//		admin2.setPassword("weisen");
//		admin2.setPermission("y");;
//		new AdminDao().adminDelete(admin2);
//		Admin admin2=new Admin();
//		admin2.setUsername("chengcl");
//		admin2.setPassword("qwert");
//		admin2.setPermission("n");;
//		new AdminDao().adminUpdate(admin2);
//		List<Admin> adminList=new AdminDao().adminQuery();
//		Iterator<Admin> it=adminList.iterator();
//		while(it.hasNext()) {
//			Admin admin=it.next();
//			System.out.println(admin.getUsername()+""+admin.getPassword());
//		}
		
	}
	/**
	 * �޸Ĺ���Ա�˺ŵ�����
	 * @param admin
	 */
	public void adminUpdate(Admin admin) {
		Connection conn=DBUtils.getConnection();
		String sql="update admin set password=? where username=?";
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			 pst=conn.prepareStatement(sql);
			 pst.setString(1, admin.getPassword());
			 pst.setString(2, admin.getUsername());
			 int i=pst.executeUpdate();
			 System.out.println(i+"�����ݱ�Ӱ�죬��Ӱ����Ϊ��admin,Ȩ��Ϊ"+admin.getPermission());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.free(rs, pst);
		}
	}
	/**
	 * ɾ������Ա�˺�
	 * @param admin
	 */
	public void adminDelete(Admin admin) {
		Connection conn=DBUtils.getConnection();
		String sql="delete from admin where username=?";
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			 pst=conn.prepareStatement(sql);
			 pst.setString(1, admin.getUsername());
			 int i=pst.executeUpdate();
			 System.out.println(i+"�����ݱ�Ӱ�죬��Ӱ����Ϊ��admin,Ȩ��Ϊ"+admin.getPermission());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.free(rs, pst);
		}
	}
	/**
	 * �������Ա�˺�  /** �س�
	 * @param admin
	 */
	public void adminInsert(Admin admin) {
		Connection conn=DBUtils.getConnection();
		String sql="insert into admin(username,password,permission) values (?,?,?)";
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			 pst=conn.prepareStatement(sql);
			 pst.setString(1, admin.getUsername());
			 pst.setString(2, admin.getPassword());
			 pst.setString(3, admin.getPermission());
			 int i=pst.executeUpdate();
			 System.out.println(i+"�����ݱ�Ӱ�죬��Ӱ����Ϊ��admin,Ȩ��Ϊ"+admin.getPermission());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.free(rs, pst);
		}
	}
	/**
	 * ��ѯ����Ա�˺�
	 * @return List<Admin>
	 */
	public List<Admin> adminQuery() {
		Connection conn=DBUtils.getConnection();
		String sql="select * from admin";
		PreparedStatement pst=null;
		ResultSet rs=null;
		List<Admin> adminList=new ArrayList<Admin>();
		try {
			 pst=conn.prepareStatement(sql);
			 rs=pst.executeQuery();
			while(rs.next()) {
				Admin admin=new Admin();
				admin.setId(rs.getInt("id"));
				admin.setUsername(rs.getString("username"));
				admin.setPassword(rs.getString("password"));
				admin.setPermission(rs.getString("permission"));
				adminList.add(admin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.free(rs, pst);
		}
		return adminList;
	}

}
