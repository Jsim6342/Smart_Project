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
		public ArrayList<ReviewDTO> showReviewList() {
			
			ReviewDTO review = null;
			ArrayList<ReviewDTO> reviewList = new ArrayList<>();
			
			try {
				
				dao.getConn();
				
		         // --------------------- DB ����(������ ����)
		         
		         String sql = "select * from review order by rev_num desc";
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
	
		//�ı� ���
		public ReviewDTO showReview(int rev_num) {
			
			ReviewDTO review = null;
			
			try {
				
				dao.getConn();
				
		         // --------------------- DB ����(������ ����)
		         
		         String sql = "select * from review where rev_num = ?";
		         pst = Connect.conn.prepareStatement(sql);
		         
		         pst.setInt(1, rev_num);
		         
		         // --------------------- DB�� SQL�� ����غ�
		         rs = pst.executeQuery(); //select���� DB���� data�� ��ȯ�ޱ� ������ excuteQuery�Լ��� ���
		         // --------------------- SQL�� ����/ ���� �� ó��
		         
		         if(rs.next()) {
		        	 
		        	//��ü �ı� �����͸� ���
		        	 int rev_nums = rs.getInt(1);
		        	 String nickname = rs.getString(2);
		        	 String rev_title = rs.getString(3);
		        	 String rev_contents = rs.getString(4);
		        	 

	 	        	 //ReviewDTO ��ü�� 1���� DB���� ���� ��, ArrayList�� reviewList�� ����
		        	 review = new ReviewDTO(rev_nums, nickname, rev_title, rev_contents);
	 	        	 
		         }
		         
			} catch (Exception e) {
				e.printStackTrace();
			}finally { //finally�� ��������� �ǵ�, ������ ���� ������ ����Ǵ� �κ�.
				dao.close();
			}
			return review;
		}
		
		//�ı��ȣ�� �г��ӿ� �ش�Ǵ� �Խñ��� ��� true��ȯ.
		public boolean check_Review(int rev_num, String nickname) {
			
			boolean check = false;
			
			try {
				
				dao.getConn();
				
		         // --------------------- DB ����(������ ����)
		         
		         String sql = "select * from review where rev_num = ? and nickname = ?";
		         pst = Connect.conn.prepareStatement(sql);
		         
		         pst.setInt(1, rev_num);
		         pst.setString(2, nickname);
		         
		         // --------------------- DB�� SQL�� ����غ�
		         rs = pst.executeQuery(); //select���� DB���� data�� ��ȯ�ޱ� ������ excuteQuery�Լ��� ���
		         // --------------------- SQL�� ����/ ���� �� ó��
		         
		         if(rs.next()) {
		        	check = true;	 
		         }else {
		            check = false;
		         }
		         
			} catch (Exception e) {
				e.printStackTrace();
			}finally { //finally�� ��������� �ǵ�, ������ ���� ������ ����Ǵ� �κ�.
				dao.close();
			}
			return check;
		}
		
		//��ü ���� ���� ��ȯ
		public int count_Review() {
			
			int result = 0;
			
			
			try {
				
				dao.getConn();
				
		         // --------------------- DB ����(������ ����)
		         
		         String sql = "select count(*) from review";
		         pst = Connect.conn.prepareStatement(sql);
		         // --------------------- DB�� SQL�� ����غ�
		         rs = pst.executeQuery(); //select���� DB���� data�� ��ȯ�ޱ� ������ excuteQuery�Լ��� ���
		         // --------------------- SQL�� ����/ ���� �� ó��
		         
		         if(rs.next()) {
		        	 
		        	 result = rs.getInt(1);
		         
		         }
		         
			} catch (Exception e) {
				e.printStackTrace();
			}finally { //finally�� ��������� �ǵ�, ������ ���� ������ ����Ǵ� �κ�.
				dao.close();
			}
			return result;
		}
		
		//�ı� �Խ��� ���(����¡)
		public ArrayList<ReviewDTO> selectReviewList(int start, int pageCnt) {
			
			ReviewDTO review = null;
			ArrayList<ReviewDTO> reviewList = new ArrayList<>();
			
			try {
				
				dao.getConn();
				
		         // --------------------- DB ����(������ ����)
		         
		         String sql = "SELECT * FROM (SELECT a.*,ROW_NUMBER() OVER(ORDER BY rev_num DESC) AS rnum FROM review a) WHERE rnum >? and rnum<=?";
		         pst = Connect.conn.prepareStatement(sql);
		         pst.setInt(1, start);
		         pst.setInt(2, pageCnt);
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
		
		
		//nickname�� ��ġ�ϴ� �ı� �����(ȸ��Ż�� ��)
		public int delete_mem_review(String nickname) {
			
			
			try {
		        
		         dao.getConn();
		         // --------------------- DB ����(������ ����)
		         
		         String sql = "delete from review where nickname=?";
		         pst = Connect.conn.prepareStatement(sql);
		         
		         pst.setString(1, nickname);

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
		
		
		//�ı� ���� ��, �ڽ��� �ı� ���
		public ReviewDTO showMyReview(int rev_num) {
			
			ReviewDTO review = null;
			
			try {
				
				dao.getConn();
				
		         // --------------------- DB ����(������ ����)
		         
		         String sql = "select * from review where rev_num = ?";
		         pst = Connect.conn.prepareStatement(sql);
		         
		         pst.setInt(1, rev_num);
		         
		         // --------------------- DB�� SQL�� ����غ�
		         rs = pst.executeQuery(); //select���� DB���� data�� ��ȯ�ޱ� ������ excuteQuery�Լ��� ���
		         // --------------------- SQL�� ����/ ���� �� ó��
		         
		         if(rs.next()) {
		        	 
		        	//��ü �ı� �����͸� ���
		        	 int rev_nums = rs.getInt(1);
		        	 String nickname = rs.getString(2);
		        	 String rev_title = rs.getString(3);
		        	 String rev_contents = rs.getString(4);
		        	 

	 	        	 //ReviewDTO ��ü�� 1���� DB���� ���� ��, ArrayList�� reviewList�� ����
		        	 review = new ReviewDTO(rev_nums, nickname, rev_title, rev_contents);
	 	        	 
		         }
		         
			} catch (Exception e) {
				e.printStackTrace();
			}finally { //finally�� ��������� �ǵ�, ������ ���� ������ ����Ǵ� �κ�.
				dao.close();
			}
			return review;
		}
		
		//�ı� ����
		public int update_review(int rev_num, String title, String content) {

			
			try {
				
				 dao.getConn();
				 
		         // --------------------- DB ����(������ ����)
		         
		         String sql = "update review set rev_title=?, rev_contents=? where rev_num = ?"; 
		         pst = Connect.conn.prepareStatement(sql);
		         
		         pst.setString(1, title);
		         pst.setString(2, content);
		         pst.setInt(3, rev_num);

		         cnt = pst.executeUpdate(); //���� �� 1�� ��ȯ
		      // --------------------- SQL�� ����/ ���� �� ó��
		         
		      // --------------------- DB�� SQL�� ����غ�	
			} catch (Exception e) {
				e.printStackTrace();
			}finally { //finally�� ��������� �ǵ�, ������ ���� ������ ����Ǵ� �κ�.
				dao.close();
			}
			return cnt;
		}
		
}
