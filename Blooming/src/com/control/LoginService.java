package com.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.ConsultantDAO;
import com.DAO.MemberDAO;

@WebServlet("/LoginService")
public class LoginService extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//�ѱ� ���ڵ�
		request.setCharacterEncoding("UTF-8");
		
		//����ڰ� �Է��� ���� ��������
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
				
		//���Ȯ��
//		System.out.println(email);
//		System.out.println(pw);
				
		//DB�� �����ؼ� ����ڰ� �Է��� email���� pw�� Ȯ��
		//member table ��ȸ
		MemberDAO dao_mem = new MemberDAO();
		boolean check_mem = dao_mem.member_login(email, pw);
		//consultant table ��ȸ
		ConsultantDAO dao_con = new ConsultantDAO();
		boolean check_con = dao_con.consultant_login(email, pw);
			 
		if(check_mem || check_con) { //rs.next() �Լ��� 1�྿ �����͸� Ȯ���ϸ� ���� ������ True, ������ False�� ��ȯ 
			        	 	 
		//Session������ �� ����
		 HttpSession session = request.getSession(); //Session������ ����ϱ� ���� ��ü����
		 session.setAttribute("email", email); //Session������ email�̸�ǥ�� �α��ο� ������ ����� email�� ����
			        	 
			         
		 response.sendRedirect("index.html");
		 }else {
	     System.out.println("�̸��ϰ� ��й�ȣ�� Ȯ�����ּ���.");
		 }
			         
			      
			   
				
				
				
				//3. �α��� ����/���� ���� �� ������ �̵�
		
	}

}
