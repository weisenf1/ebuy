package com.weisen.ebuy2.entity;

public class Admin {
	private int id;//�û�id,�Զ�����
	private String username;//�û���
	private String password;//����
	private String permission;//Ȩ�ޣ��Ƿ�������ɾ������Աadmin�˺�
	public Admin() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	
	
}
