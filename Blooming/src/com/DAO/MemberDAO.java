package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DTO.MemberDTO;

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
	public boolean member_login(String email, String pw) {

		boolean check = true;
		
		try {
			
			//DB���� ���
			dao.getConn();
			
			String sql = "select * from member where email = ? and pw = ?";
			pst = Connect.conn.prepareStatement(sql); //static���� Connect.conn ���
			pst.setString(1, email);
			pst.setString(2, pw);
			
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

}
