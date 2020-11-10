package com.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.DTO.DiaryDTO;

public class DiaryDAO {

	//�������� ����
	//conn�� ��� static������ ����
	private PreparedStatement pst;
	private ResultSet rs;
	int cnt = 0;
	
	Connect dao = new Connect();
	
	//�ϱ� �ۼ�(�����ʿ�. ������ �κ�, ������ �κа� �׿� ���� �Ű����� ���� �κ�)
	public int insertDiary(String nickname, String di_date,String di_title, String di_contents) {
		
		int cnt = 0;
		
		try {
	        
	         dao.getConn();
	         // --------------------- DB ����(������ ����)
	         
	         String sql = "insert into diary values(DI_SEQ.nextval,?,?,?,?,1)"; //sysdate�� SQL���� ������ �ִ� �Լ�
	         pst = Connect.conn.prepareStatement(sql);
	         
	         pst.setString(1, nickname);
	         pst.setString(2, di_date);
	         pst.setString(3, di_title);
	         pst.setString(4, di_contents);
	         
	         
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
	
	//�ϱ� ��� ���
	public ArrayList<DiaryDTO> show_diaryList(String nickname, String strat_date, String end_date) {
		
		DiaryDTO diary = null;
		ArrayList<DiaryDTO> diaryList = new ArrayList<>();
		
		try {
			
			dao.getConn();
			
	         // --------------------- DB ����(������ ����)
	         
	         String sql = "select * from diary where nickname=? and di_date between ? and ?";
	         pst = Connect.conn.prepareStatement(sql);
	         pst.setString(1, nickname);
	         pst.setString(2, strat_date);
	         pst.setString(3, end_date);
	         
	        
	         // --------------------- DB�� SQL�� ����غ�
	         rs = pst.executeQuery(); //select���� DB���� data�� ��ȯ�ޱ� ������ excuteQuery�Լ��� ���
	         // --------------------- SQL�� ����/ ���� �� ó��
	         
	         while(rs.next()) {
	        	 
	        	//��ü �ϱ� �����͸� ���
	        	 int di_num = rs.getInt(1);
	        	 String di_nickname = rs.getString(2);
	        	 String di_date = rs.getString(3);
	        	 String di_title = rs.getString(4);
	        	 String di_contents = rs.getString(5);
	        	 double di_score = rs.getDouble(6);
 	        	 

 	        	 //VO(DTO): ��Ⳣ�� �����͸� ��/������ �� ����ϴ� ���ο� ������ Ÿ��
	        	 diary = new DiaryDTO(di_num, di_nickname, di_date, di_title, di_contents,di_score);
	        	 diaryList.add(diary);
	         
	         }
	         
		} catch (Exception e) {
			e.printStackTrace();
		}finally { //finally�� ��������� �ǵ�, ������ ���� ������ ����Ǵ� �κ�.
			dao.close();
		}
		return diaryList;
	}
	
	
}
