package com.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class C_ProfileDAO {

	//�������� ����
	//conn�� ��� static������ ����
	private PreparedStatement pst;
	private ResultSet rs;
	int cnt = 0;
			
	Connect dao = new Connect();
	
	
	//������ ��� ���
	public int profile_join(String pro_email, String pro_name, String pro_location, String background, String introduce) {
		
		
		try {
			
			//DB���� ���
			dao.getConn();
			
			String sql = "insert into c_profile values(?,?,?,?,?)";
			
			pst = Connect.conn.prepareStatement(sql); //static���� Connect.conn ���
			
			pst.setString(1, pro_email);
			pst.setString(2, pro_name);
			pst.setString(3, pro_location);
			pst.setString(4, background);
			pst.setString(5, introduce);
			
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
	
}
