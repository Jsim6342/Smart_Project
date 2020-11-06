package com.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.DTO.C_ProfileDTO;
import com.DTO.ReservationDTO;

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
		
		
		//���� ��Ȳ ���
		public ArrayList<ReservationDTO> showProfile() {
			
			ReservationDTO reservation = null;
			ArrayList<ReservationDTO> reservationList = new ArrayList<>();
			
			try {
				
				dao.getConn();
				
		         // --------------------- DB ����(������ ����)
		         
		         String sql = "select * from reservation";
		         pst = Connect.conn.prepareStatement(sql);
		         // --------------------- DB�� SQL�� ����غ�
		         rs = pst.executeQuery(); //select���� DB���� data�� ��ȯ�ޱ� ������ excuteQuery�Լ��� ���
		         // --------------------- SQL�� ����/ ���� �� ó��
		         
		         while(rs.next()) {
		        	 
		        	//��ü �ı� �����͸� ���
		        	 int res_num = rs.getInt(1);
		        	 String nickname = rs.getString(2);
		        	 String res_date = rs.getString(3);
		        	 String consultant = rs.getString(4);

	 	        	 //ReviewDTO ��ü�� 1���� DB���� ���� ��, ArrayList�� reviewList�� ����
		        	 reservation = new ReservationDTO(res_num, nickname, res_date, consultant);
		        	 reservationList.add(reservation);
		         
		         }
		         
			} catch (Exception e) {
				e.printStackTrace();
			}finally { //finally�� ��������� �ǵ�, ������ ���� ������ ����Ǵ� �κ�.
				dao.close();
			}
			return reservationList;
		}
	
		//���� ��Ȳ �����
		public int delete_Reservation(String nickname, String res_date) {
			
			
			try {
		        
		         dao.getConn();
		         // --------------------- DB ����(������ ����)
		         
		         String sql = "delete from reservation where nickname = ?, res_date = ?"; //sysdate�� SQL���� ������ �ִ� �Լ�
		         pst = Connect.conn.prepareStatement(sql);
		         
		         pst.setString(1, nickname);
		         pst.setString(2, res_date);
		      
		      // --------------------- DB�� SQL�� ����غ�
		         
		         cnt = pst.executeUpdate(); //���� �� 1�� ��ȯ
		      // --------------------- SQL�� ����/ ���� �� ó��
			
		        
		} catch (Exception e) {
			e.printStackTrace();
		}finally { //finally�� ��������� �ǵ�, ������ ���� ������ ����Ǵ� �κ�.
			dao.close();
		}
		 return cnt;
		}
		
		//������ ��� ��ȸ ��� (nickname������ ��ġ�ϴ� ���� ��ȸ )
		public ArrayList<ReservationDTO> return_consultant(String nickname) {
			
			ReservationDTO reservation = null;
			ArrayList<ReservationDTO> reservationList = new ArrayList<>();
			
			try {
				
				dao.getConn();
				
		         // --------------------- DB ����(������ ����)
		         
		         String sql = "select * from reservation where nickname=?";
		         pst = Connect.conn.prepareStatement(sql);
		         
		         pst.setString(1, nickname);
		         
		         // --------------------- DB�� SQL�� ����غ�
		         rs = pst.executeQuery(); //select���� DB���� data�� ��ȯ�ޱ� ������ excuteQuery�Լ��� ���
		         // --------------------- SQL�� ����/ ���� �� ó��
		         
		         while(rs.next()) {
		        	 
		        	//��ü �ı� �����͸� ���
		        	 int res_num = rs.getInt(1);
		        	 String nicknames = rs.getString(2);
		        	 String res_date = rs.getString(3);
		        	 String consultant = rs.getString(4);

	 	        	 //ReviewDTO ��ü�� 1���� DB���� ���� ��, ArrayList�� reviewList�� ����
		        	 reservation = new ReservationDTO(res_num, nicknames, res_date, consultant);
		        	 reservationList.add(reservation);
		         
		         }
		         
			} catch (Exception e) {
				e.printStackTrace();
			}finally { //finally�� ��������� �ǵ�, ������ ���� ������ ����Ǵ� �κ�.
				dao.close();
			}
			return reservationList;
		}
}
