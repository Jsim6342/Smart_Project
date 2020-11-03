package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DTO.ConsultantDTO;

public class ConsultantDAO {

	//�ַ� ���� ���������� ����ϴ� �͵��� ��������� �����´�. 
		PreparedStatement pst = null;
		ResultSet rs = null;
	
	Connect dao = new Connect();
	
	
	public int consultant_join(String email, String pw, String name, String tel, String license, String location) {
		int cnt = 0;
		
		try { 
			
			//DB���� ���
			dao.getConn();
			
			String sql = "insert into consultant values(?,?,?,?,?,?)";
			pst = Connect.conn.prepareStatement(sql); //static���� Connect.conn ���
			pst.setString(1, email);
			pst.setString(2, pw);
			pst.setString(3, name);
			pst.setString(4, tel);
			pst.setString(5, license);
			pst.setString(6, location);
			cnt = pst.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//DB���� ����
			dao.close();
		}
		return cnt;
	}


	public boolean consultant_login(String email, String pw) {
		
		boolean check = true;
		
		
		try {
			
			//DB���� ���
			dao.getConn();
			
			String sql = "select * from consultant where email = ? and pw = ?";
			pst = Connect.conn.prepareStatement(sql); //static���� Connect.conn ���
			pst.setString(1, email);
			pst.setString(2, pw);
			
			rs = pst.executeQuery();
			
			if(rs.next()) { //rs.next() �Լ��� 1�྿ �����͸� Ȯ���ϸ� ���� ������ True, ������ False�� ��ȯ 
	        	 check = true;
	         }else {
	        	 check = false;
	         }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//DB���� ����
			dao.close();
		}
		return check;
	}
	
}
