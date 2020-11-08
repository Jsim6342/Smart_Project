package com.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.DTO.C_ProfileDTO;
import com.DTO.ReservationDTO;
import com.DTO.ReviewDTO;

public class C_ProfileDAO {

	//�������� ����
	//conn�� ��� static������ ����
	private PreparedStatement pst;
	private ResultSet rs;
	int cnt = 0;
			
	Connect dao = new Connect();
	
	
	//������ ��� ���
	public int profile_join(String pro_email, String pro_name, String pro_location, String background, String introduce, int max_people) {
		
		
		try {
			
			//DB���� ���
			dao.getConn();
			
			String sql = "insert into c_profile values(?,?,?,?,?,?)";
			
			pst = Connect.conn.prepareStatement(sql); //static���� Connect.conn ���
			
			pst.setString(1, pro_email);
			pst.setString(2, pro_name);
			pst.setString(3, pro_location);
			pst.setString(4, background);
			pst.setString(5, introduce);
			pst.setInt(6, max_people);
			
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
	
	//���� ������ ���
	public ArrayList<C_ProfileDTO> showProfile() {
		
		C_ProfileDTO profile = null;
		ArrayList<C_ProfileDTO> profileList = new ArrayList<>();
		
		try {
			
			dao.getConn();
			
	         // --------------------- DB ����(������ ����)
	         
	         String sql = "select * from c_profile";
	         pst = Connect.conn.prepareStatement(sql);
	         // --------------------- DB�� SQL�� ����غ�
	         rs = pst.executeQuery(); //select���� DB���� data�� ��ȯ�ޱ� ������ excuteQuery�Լ��� ���
	         // --------------------- SQL�� ����/ ���� �� ó��
	         
	         while(rs.next()) {
	        	 
	        	//��ü �ı� �����͸� ���
	        	 String pro_email = rs.getString(1);
	        	 String pro_name = rs.getString(2);
	        	 String pro_date = rs.getString(3);
	        	 String background = rs.getString(4);
	        	 String introduce = rs.getString(5);
	        	 int max_people = rs.getInt(6);

 	        	 //ReviewDTO ��ü�� 1���� DB���� ���� ��, ArrayList�� reviewList�� ����
	        	 profile = new C_ProfileDTO(pro_email, pro_name, pro_date, background, introduce, max_people);
	        	 profileList.add(profile);
	         
	         }
	         
		} catch (Exception e) {
			e.printStackTrace();
		}finally { //finally�� ��������� �ǵ�, ������ ���� ������ ����Ǵ� �κ�.
			dao.close();
		}
		return profileList;
	}
	
	//�ִ��ο� -1 ���(��㿹���)
	public int down_people(String pro_email, int max_people) {

		int update = max_people-1;
		
		try {
			
			 dao.getConn();
			 
	         // --------------------- DB ����(������ ����)
	         
	         String sql = "update c_profile set max_people=? where pro_email = ?"; 
	         pst = Connect.conn.prepareStatement(sql);
	         
	         pst.setInt(1, update);
	         pst.setString(2, pro_email);

	         cnt = pst.executeUpdate(); //���� �� 1�� ��ȯ
	      // --------------------- SQL�� ����/ ���� �� ó��
	         
	      // --------------------- DB�� SQL�� ����غ�	
		} catch (Exception e) {
			e.printStackTrace();
		}finally { //finally�� ��������� �ǵ�, ������ ���� ������ ����Ǵ� �κ�.
			dao.close();
		}
		return update;
	}
	
	//�ִ��ο� +1 ���(��㿹���)
		public int up_people(String pro_email, int max_people) {

			int update = max_people+1;
			
			try {
				
				 dao.getConn();
				 
		         // --------------------- DB ����(������ ����)
		         
		         String sql = "update c_profile set max_people=? where pro_email = ?"; 
		         pst = Connect.conn.prepareStatement(sql);
		         
		         pst.setInt(1, update);
		         pst.setString(2, pro_email);

		         cnt = pst.executeUpdate(); //���� �� 1�� ��ȯ
		      // --------------------- SQL�� ����/ ���� �� ó��
		         
		      // --------------------- DB�� SQL�� ����غ�	
			} catch (Exception e) {
				e.printStackTrace();
			}finally { //finally�� ��������� �ǵ�, ������ ���� ������ ����Ǵ� �κ�.
				dao.close();
			}
			return update;
		}
	
	//������ ���� ������ ���
	public ArrayList<C_ProfileDTO> res_ShowProfile(ArrayList<ReservationDTO> reservationList) {
		
		C_ProfileDTO profile = null;
		ArrayList<C_ProfileDTO> profileList = new ArrayList<>();
		
		    try {
			
		    	
			dao.getConn();
			
			for(int i = 0;i<reservationList.size();i++) {
			String consultant = reservationList.get(i).getConsultant();
			
	         // --------------------- DB ����(������ ����)
	         
	         String sql = "select * from c_profile where pro_name = ?";
	         pst = Connect.conn.prepareStatement(sql);
	         
	         pst.setString(1, consultant);
	         // --------------------- DB�� SQL�� ����غ�
	         rs = pst.executeQuery(); //select���� DB���� data�� ��ȯ�ޱ� ������ excuteQuery�Լ��� ���
	         // --------------------- SQL�� ����/ ���� �� ó��
	         
	         if(rs.next()) {
	        	 
	        	//��ü �ı� �����͸� ���
	        	 String pro_email = rs.getString(1);
	        	 String pro_name = rs.getString(2);
	        	 String pro_date = rs.getString(3);
	        	 String background = rs.getString(4);
	        	 String introduce = rs.getString(5);
	        	 int max_people = rs.getInt(6);

 	        	 //ReviewDTO ��ü�� 1���� DB���� ���� ��, ArrayList�� reviewList�� ����
	        	 profile = new C_ProfileDTO(pro_email, pro_name, pro_date, background, introduce, max_people);
	        	 profileList.add(profile);
	         
	         }
		    }
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally { //finally�� ��������� �ǵ�, ������ ���� ������ ����Ǵ� �κ�.
			dao.close();
		}
		return profileList;
		
	}
	
	
}
