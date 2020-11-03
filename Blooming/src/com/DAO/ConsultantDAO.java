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
		
		//DB���� ���
		dao.getConn();
		
		
		try {  
			String sql = "insert into consultant values(?,?,?,?,?,?)";
			pst = Connect.conn.prepareStatement(sql);
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


	public ConsultantDTO consultant_login(String email, String pw) {
		
		ConsultantDTO consultant = null;
		//DB���� ���
		dao.getConn();
		
		
		try {
			String sql = "select * from consultant Where email = ? and pw = ?";
			pst = Connect.conn.prepareStatement(sql);
			pst.setString(1, email);
			pst.setString(2, pw);
			
			rs = pst.executeQuery();
			
			if(rs.next()) {
				consultant = new ConsultantDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
				
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
