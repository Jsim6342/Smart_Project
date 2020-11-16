package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.DTO.MemberDTO;
import com.DTO.ReservationDTO;

public class MemberDAO {

	//�������� ����
	//conn�� ��� static������ ����
	private PreparedStatement pst;
	private ResultSet rs;
	int cnt = 0;
	
	Connect dao = new Connect();
	
	//ȸ�����Ա��
	public int member_join(String email, String pw, String tel, String nickname) {
		
		
		try {
			
			//DB���� ���
			dao.getConn();
			
			String sql = "insert into member values(?,?,?,?)";
			
			pst = Connect.conn.prepareStatement(sql); //static���� Connect.conn ���
			
			pst.setString(1, email);
			pst.setString(2, pw);
			pst.setString(3, tel);
			pst.setString(4, nickname);
			
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
	
	//�α��� ���
	public MemberDTO member_login(String email, String pw) {
		
		
		MemberDTO member = new MemberDTO();
		
		try {
			
			//DB���� ���
			dao.getConn();
			
			String sql = "select * from member where email = ? and pw = ?";
			pst = Connect.conn.prepareStatement(sql); //static���� Connect.conn ���
			pst.setString(1, email);
			pst.setString(2, pw);
			
			rs = pst.executeQuery();
			
			if(rs.next()) { //rs.next() �Լ��� 1�྿ �����͸� Ȯ���ϸ� ���� ������ True, ������ False�� ��ȯ 
				member = new MemberDTO(rs.getNString(1), rs.getNString(2), rs.getNString(3), rs.getNString(4));
			}else {
				member = null;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//DB���� ����
			dao.close();
		}
		
		return member;
	}
	
	//�г��ӿ� �´� ȸ�� ���� ���
	public MemberDTO return_member(String nickname) {
		
		MemberDTO member = null;
		
		
		try {
			
			dao.getConn();
			
	         // --------------------- DB ����(������ ����)
	         
	         String sql = "select * from member where nickname=?";
	         pst = Connect.conn.prepareStatement(sql);
	         
	         pst.setString(1, nickname);
	         
	         // --------------------- DB�� SQL�� ����غ�
	         rs = pst.executeQuery(); //select���� DB���� data�� ��ȯ�ޱ� ������ excuteQuery�Լ��� ���
	         // --------------------- SQL�� ����/ ���� �� ó��
	         
	         if(rs.next()) {
	        	 
	        	//��ü �ɹ� �����͸� ���
	        	 String nicknames = rs.getString(1);
	        	 String email = rs.getString(2);
	        	 String pw = rs.getString(3);
	        	 String tel = rs.getString(4);

 	        	 //MemberDTO ��ü�� 1���� DB���� ���� ��, ArrayList�� reviewList�� ����
	        	 member = new MemberDTO(nicknames, email, pw, tel);
	        	 
	         
	         }
	         
		} catch (Exception e) {
			e.printStackTrace();
		}finally { //finally�� ��������� �ǵ�, ������ ���� ������ ����Ǵ� �κ�.
			dao.close();
		}
		return member;
	}

	public boolean email_check(String email) {
		
		
		boolean check = false;
		
		try {
			
			//DB���� ���
			dao.getConn();
			
			String sql = "select * from member where email = ?";
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


	public boolean nickname_check(String nickname) {
		
		
		boolean check = false;
		
		try {
			
			//DB���� ���
			dao.getConn();
			
			String sql = "select * from member where nickname = ?";
			pst = Connect.conn.prepareStatement(sql); //static���� Connect.conn ���
			pst.setString(1, nickname);
			
			
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

	//���̵� ã�� ���
	public MemberDTO search_email(String tel) {
		
		MemberDTO member = new MemberDTO();
		
		try {
			
			//DB���� ���
			dao.getConn();
			
			String sql = "select * from member where tel = ?";
			pst = Connect.conn.prepareStatement(sql); //static���� Connect.conn ���
			pst.setString(1, tel);
			
			
			rs = pst.executeQuery();
			
			if(rs.next()) { //rs.next() �Լ��� 1�྿ �����͸� Ȯ���ϸ� ���� ������ True, ������ False�� ��ȯ 
				//��ü �ɹ� �����͸� ���
	        	 String nicknames = rs.getString(1);
	        	 String email = rs.getString(2);
	        	 String pw = rs.getString(3);
	        	 String get_tel = rs.getString(4);
	        	 
	        	 member = new MemberDTO(nicknames, email, pw, get_tel); 
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//DB���� ����
			dao.close();
		}
		
		return member;
	}
	
	
	//��й�ȣ ã�� ���
	public MemberDTO search_pw(String email, String tel) {
		
		MemberDTO member = new MemberDTO();
		
		try {
			
			//DB���� ���
			dao.getConn();
			
			String sql = "select * from member where email = ? and tel = ?";
			pst = Connect.conn.prepareStatement(sql); //static���� Connect.conn ���
			pst.setString(1, email);
			pst.setString(2, tel);
			
			
			rs = pst.executeQuery();
			
			if(rs.next()) { //rs.next() �Լ��� 1�྿ �����͸� Ȯ���ϸ� ���� ������ True, ������ False�� ��ȯ 
				//��ü �ɹ� �����͸� ���
	        	 String nicknames = rs.getString(1);
	        	 String get_email = rs.getString(2);
	        	 String pw = rs.getString(3);
	        	 String get_tel = rs.getString(4);
	        	 
	        	 member = new MemberDTO(nicknames, get_email, pw, get_tel); 
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//DB���� ����
			dao.close();
		}
		
		return member;
	}
	
}
