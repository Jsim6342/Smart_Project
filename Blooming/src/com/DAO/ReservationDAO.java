package com.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservationDAO {

	//�������� ����
	//conn�� ��� static������ ����
	private PreparedStatement pst;
	private ResultSet rs;
	int cnt = 0;
		
	Connect dao = new Connect();
	
	//���� �ϱ�
		public int reserve_insert(String nickname, String res_date, String consultant) {
			
			
			try {
				
				//DB���� ���
				dao.getConn();
				
				String sql = "insert into reservation values(res_seq.nextval,?,?,?)";
				
				pst = Connect.conn.prepareStatement(sql); //static���� Connect.conn ���
				
				pst.setString(1, nickname);
				pst.setString(2, res_date);
				pst.setString(3, consultant);
				
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
