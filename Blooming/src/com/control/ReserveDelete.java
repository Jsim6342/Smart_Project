package com.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.C_ProfileDAO;
import com.DAO.ConsultantDAO;
import com.DAO.ReservationDAO;
import com.DTO.ConsultantDTO;

@WebServlet("/ReserveDelete")
public class ReserveDelete extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//�ѱ� ���ڵ�
		 request.setCharacterEncoding("UTF-8");
			
	     //Session������ �� ����
	     HttpSession session = request.getSession(); //Session������ ����ϱ� ���� ��ü����
	     String nickname = (String)session.getAttribute("nickname");
		 
		 //���� ������ ���� ��¥ ��������
	     
	     String date = request.getParameter("res_date");
	     String res_date = java.net.URLDecoder.decode(date,"UTF-8");
		 
	   	 
		 System.out.println(nickname);
		 System.out.println(res_date);
		   
		 //nickname ���� ��ġ�ϴ� ��㳻�� �����
		 ReservationDAO dao = new ReservationDAO();
		 int cnt = dao.delete_Reservation(nickname, res_date);
		 

		 //���� ���� ���� �� booking.jsp�� �̵�
		 if(cnt > 0) {
		 response.sendRedirect("booking.jsp");
		 }
		
	}

}
