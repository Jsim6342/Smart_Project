package com.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.DTO.ReviewDTO;

public class ReviewDAO {

	//�������� ����
	//conn�� ��� static������ ����
	private PreparedStatement pst;
	private ResultSet rs;
	int cnt = 0;
		
	Connect dao = new Connect();
	
	//�ı� �ۼ�
	public int review_post(String nickname, String rev_title, String rev_contents) {
		
		
		try {
			
			//DB���� ���
			dao.getConn();
			
			String sql = "insert into review values(rev_seq.nextval,?,?,?)";
			
			pst = Connect.conn.prepareStatement(sql); //static���� Connect.conn ���
			
			pst.setString(1, nickname);
			pst.setString(2, rev_title);
			pst.setString(3, rev_contents);
			
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
	
	
	//�ı� �Խ��� ���
		public ArrayList<ReviewDTO> showReview() {
			
			ReviewDTO review = null;
			ArrayList<ReviewDTO> reviewList = new ArrayList<>();
			
			try {
				
				dao.getConn();
				
		         // --------------------- DB ����(������ ����)
		         
		         String sql = "select * from review";
		         pst = Connect.conn.prepareStatement(sql);
		         // --------------------- DB�� SQL�� ����غ�
		         rs = pst.executeQuery(); //select���� DB���� data�� ��ȯ�ޱ� ������ excuteQuery�Լ��� ���
		         // --------------------- SQL�� ����/ ���� �� ó��
		         
		         while(rs.next()) {
		        	 
		        	//��ü �ı� �����͸� ���
		        	 int rev_num = rs.getInt(1);
		        	 String nickname = rs.getString(2);
		        	 String rev_title = rs.getString(3);
		        	 String rev_contents = rs.getString(4);
		        	 

	 	        	 //ReviewDTO ��ü�� 1���� DB���� ���� ��, ArrayList�� reviewList�� ����
		        	 review = new ReviewDTO(rev_num, nickname, rev_title, rev_contents);
	 	        	 reviewList.add(review);
		         
		         }
		         
			} catch (Exception e) {
				e.printStackTrace();
			}finally { //finally�� ��������� �ǵ�, ������ ���� ������ ����Ǵ� �κ�.
				dao.close();
			}
			return reviewList;
		}
	
}
