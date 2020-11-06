package com.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.C_ProfileDAO;
import com.DAO.ReservationDAO;
import com.DAO.ReviewDAO;

@WebServlet("/ReserveRequest")
public class ReserveRequest extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//�ѱ� ���ڵ�
		 request.setCharacterEncoding("UTF-8");
			
	     //Session������ �� ����
	     HttpSession session = request.getSession(); //Session������ ����ϱ� ���� ��ü����
	     String nickname = (String)session.getAttribute("nickname");
		 
		 //���ȸ�� ���� ��������
		 String res_date = request.getParameter("res_date");
		 String consultant = request.getParameter("consultant");
		 //�ִ� ���� �ο� ������Ʈ�� ���� ���� ��������
		 String pro_email = request.getParameter("pro_email");
		 int max_people = Integer.parseInt(request.getParameter("max_people"));
	   	 
		 System.out.println(nickname);
		 System.out.println(res_date);
		 System.out.println(consultant);
		 
		 System.out.println(max_people);
		 System.out.println(pro_email);
		   
		   //ReservationDAO ��ü����
		   ReservationDAO res_dao = new ReservationDAO();
		   int cnt = res_dao.reserve_insert(nickname, res_date, consultant); //review_post �޼ҵ�. ���� �� 1 ��ȯ
		   
		   //���� ��� ���� ��
		   if(cnt > 0) {
		
		   //�ִ� ���� ��Ȳ -1
		   C_ProfileDAO pro_dao = new C_ProfileDAO();
		   int update_people = pro_dao.update_people(pro_email, max_people);
			   
		   //�������� html�� ī��Ʈ �� ����
		   response.setContentType("text/html;charset=utf-8"); //������ ����
		   PrintWriter out = response.getWriter();
		   out.print(update_people);
		   
		   
		   }
		
		
	}

}
