package com.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.DTO.DiaryDTO;
import com.DTO.ReviewDTO;

public class DiaryDAO {

	//�������� ����
	//conn�� ��� static������ ����
	private PreparedStatement pst;
	private ResultSet rs;
	int cnt = 0;
	
	Connect dao = new Connect();
	
	//�ϱ� �ۼ�(�����ʿ�. ������ �κ�, ������ �κа� �׿� ���� �Ű����� ���� �κ�)
	public int insertDiary(String nickname, String di_date,String di_title, String di_contents, int di_score) {
		
		int cnt = 0;
		
		try {
	        
	         dao.getConn();
	         // --------------------- DB ����(������ ����)
	         
	         String sql = "insert into diary values(DI_SEQ.nextval,?,TO_DATE(?,'YY-MM-DD'),?,?,?)"; //sysdate�� SQL���� ������ �ִ� �Լ�

	         pst = Connect.conn.prepareStatement(sql);
	         
	         pst.setString(1, nickname);
	         pst.setString(2, di_date);
	         pst.setString(3, di_title);
	         pst.setString(4, di_contents);
	         pst.setInt(5, di_score);
	         
	         
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
	        	 int di_score = rs.getInt(6);
 	        	 

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
	
	//�ش� �ϱ� 1���� ���� �������� �Լ�(�ϱ� Ŭ���ϸ� �ϱ� �����ִ� ������ ���°�)
	public DiaryDTO showDiary(int di_num) {
		
		DiaryDTO diaryshow = null;
		
		try {
			
			dao.getConn();
			
	         // --------------------- DB ����(������ ����)
	         
	         String sql = "select di_num,nickname,TO_CHAR(di_date,'YYYY-MM-DD'),di_title,di_contents,di_score from diary where di_num = ?";
	         pst = Connect.conn.prepareStatement(sql);
	         
	         pst.setInt(1, di_num);
	         
	         // --------------------- DB�� SQL�� ����غ�
	         rs = pst.executeQuery(); //select���� DB���� data�� ��ȯ�ޱ� ������ excuteQuery�Լ��� ���
	         // --------------------- SQL�� ����/ ���� �� ó��
	         
	         if(rs.next()) {
	        	 
	        	//��ü �ı� �����͸� ���
	        	 int di_nums = rs.getInt(1);
	        	 String nickname = rs.getString(2);
	        	 String di_date = rs.getString(3);
	        	 String di_title = rs.getString(4);
	        	 String di_contents = rs.getString(5);
	        	 int di_score = rs.getInt(6);
	        	 

 	        	 //ReviewDTO ��ü�� 1���� DB���� ���� ��, ArrayList�� reviewList�� ����
	        	 diaryshow = new DiaryDTO(di_nums, nickname, di_date, di_title, di_contents, di_score);
 	        	 
	         }
	         
		} catch (Exception e) {
			e.printStackTrace();
		}finally { //finally�� ��������� �ǵ�, ������ ���� ������ ����Ǵ� �κ�.
			dao.close();
		}
		return diaryshow;
	}

	//�ϱ� ��/���� ������ ���ϴ� �Լ�
	public int diaryScore(String nickname) {
		
		
		int sum = 0; // ��/���� ������ �հ踦 ���� ����
		
		try {
			
			dao.getConn();
			
	         // --------------------- DB ����(������ ����)
	         
	         String sql = "select * from diary where nickname=?";
	         pst = Connect.conn.prepareStatement(sql);
	         pst.setString(1, nickname);
	         
	        
	         // --------------------- DB�� SQL�� ����غ�
	         rs = pst.executeQuery(); //select���� DB���� data�� ��ȯ�ޱ� ������ excuteQuery�Լ��� ���
	         // --------------------- SQL�� ����/ ���� �� ó��
	         
	         while(rs.next()) {
	        	 
	        	//
	        	 
	        	 int di_score = rs.getInt(6);
	        	 
	        	 if(sum==-1 && di_score < 0) {
	        		 sum = -1;
	        	 }else {
	        	 sum = sum + di_score;
	        	 }

	         }
	         
		} catch (Exception e) {
			e.printStackTrace();
		}finally { //finally�� ��������� �ǵ�, ������ ���� ������ ����Ǵ� �κ�.
			dao.close();
		}
		return sum;
	}

	//�ϱ� �׷����� �׸��� ���� �Լ�
	public ArrayList<DiaryDTO> showDiaryDateScore(String nickname) {
		
		DiaryDTO diary = null;
		ArrayList<DiaryDTO> diaryList = new ArrayList<>();
		
		try {
			
			dao.getConn();
			
	         // --------------------- DB ����(������ ����)
	         
	         String sql = "select di_num,nickname,TO_CHAR(di_date,'YY-MM-DD'),di_title,di_contents,di_score from diary where nickname=? order by di_date";
	         pst = Connect.conn.prepareStatement(sql);
	         pst.setString(1, nickname);
	         
	        
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
	        	 int di_score = rs.getInt(6);
 	        	 

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

