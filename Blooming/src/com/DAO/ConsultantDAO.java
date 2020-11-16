package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DTO.ConsultantDTO;
import com.DTO.MemberDTO;

public class ConsultantDAO {

	//�ַ� ���� ���������� ����ϴ� �͵��� ��������� �����´�. 
		PreparedStatement pst = null;
		ResultSet rs = null;
	
	Connect dao = new Connect();
	
	//���� ����
	public int consultant_join(String con_email, String con_pw, String con_name, String con_tel, String license, String location) {
		int cnt = 0;
		
		try { 
			
			//DB���� ���
			dao.getConn();
			
			String sql = "insert into consultant values(?,?,?,?,?,?)";
			pst = Connect.conn.prepareStatement(sql); //static���� Connect.conn ���
			pst.setString(1, con_email);
			pst.setString(2, con_pw);
			pst.setString(3, con_name);
			pst.setString(4, con_tel);
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

	//���� �α��� ���
	public ConsultantDTO consultant_login(String con_email, String con_pw) {
		
		ConsultantDTO consultant = new ConsultantDTO();
		
		
		try {
			
			//DB���� ���
			dao.getConn();
			
			String sql = "select * from consultant where con_email = ? and con_pw = ?";
			pst = Connect.conn.prepareStatement(sql); //static���� Connect.conn ���
			pst.setString(1, con_email);
			pst.setString(2, con_pw);
			
			rs = pst.executeQuery();
			
			if(rs.next()) { //rs.next() �Լ��� 1�྿ �����͸� Ȯ���ϸ� ���� ������ True, ������ False�� ��ȯ 
				consultant = new ConsultantDTO(rs.getNString(1), rs.getNString(2), rs.getNString(3), rs.getNString(4), rs.getNString(5),rs.getNString(6));
	         }else {
	        	consultant = null;
	         }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//DB���� ����
			dao.close();
		}
		return consultant;
	}
	
	//���� ��ü ��ȯ ���(���� ������ ��Ͽ� ���)
	public ConsultantDTO return_name_location(String con_email) {
		
		ConsultantDTO consultant = new ConsultantDTO();
		
		
		try {
			
			//DB���� ���
			dao.getConn();
			
			String sql = "select * from consultant where con_email = ?";
			pst = Connect.conn.prepareStatement(sql); //static���� Connect.conn ���
			pst.setString(1, con_email);
			
			rs = pst.executeQuery();
			
			if(rs.next()) { //rs.next() �Լ��� 1�྿ �����͸� Ȯ���ϸ� ���� ������ True, ������ False�� ��ȯ 
				consultant = new ConsultantDTO(rs.getNString(1), rs.getNString(2), rs.getNString(3), rs.getNString(4), rs.getNString(5),rs.getNString(6));
	         }else {
	        	consultant = null;
	         }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//DB���� ����
			dao.close();
		}
		return consultant;
	}

	public boolean consultant_email_check(String email) {
		
		
		boolean check = false;
		
		try {
			
			//DB���� ���
			dao.getConn();
			
			String sql = "select * from consultant where con_email = ?";
			pst = Connect.conn.prepareStatement(sql); //static���� Connect.conn ���
			pst.setString(1, email);
			
			
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
	
	//���� �̸��� ã��
	public ConsultantDTO search_email(String tel) {
		
		
		ConsultantDTO consultant = new ConsultantDTO();
		
		try {
			
			//DB���� ���
			dao.getConn();
			
			String sql = "select * from consultant where con_tel = ?";
			pst = Connect.conn.prepareStatement(sql); //static���� Connect.conn ���
			pst.setString(1, tel);
			
			
			rs = pst.executeQuery();
			
			if(rs.next()) { //rs.next() �Լ��� 1�྿ �����͸� Ȯ���ϸ� ���� ������ True, ������ False�� ��ȯ 
				String con_email = rs.getString(1);
	        	String con_pw = rs.getString(2);
	        	String con_name = rs.getString(3);
	        	String con_tel = rs.getString(4);
	        	String license = rs.getString(5);
	        	String location = rs.getString(6);
	        	 
	        	consultant = new ConsultantDTO(con_email, con_pw, con_name, con_tel, license, location); 
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//DB���� ����
			dao.close();
		}
		
		return consultant;
	}
	
	//���� ��й�ȣ ã��
	public ConsultantDTO search_pw(String email, String tel) {
		
		
		ConsultantDTO consultant = new ConsultantDTO();
		
		try {
			
			//DB���� ���
			dao.getConn();
			
			String sql = "select * from consultant where con_email = ? and con_tel = ?";
			pst = Connect.conn.prepareStatement(sql); //static���� Connect.conn ���
			pst.setString(1, email);
			pst.setString(2, tel);
			
			
			rs = pst.executeQuery();
			
			if(rs.next()) { //rs.next() �Լ��� 1�྿ �����͸� Ȯ���ϸ� ���� ������ True, ������ False�� ��ȯ 
				String con_email = rs.getString(1);
	        	String con_pw = rs.getString(2);
	        	String con_name = rs.getString(3);
	        	String con_tel = rs.getString(4);
	        	String license = rs.getString(5);
	        	String location = rs.getString(6);
	        	 
	        	consultant = new ConsultantDTO(con_email, con_pw, con_name, con_tel, license, location); 
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//DB���� ����
			dao.close();
		}
		
		return consultant;
	}
	
	
}
