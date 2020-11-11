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
		 
		 //������ ���� ������ �ʿ��� �� �޾ƿ���
	     //Session������ �� ����
	     HttpSession session = request.getSession(); //Session������ ����ϱ� ���� ��ü����
	     String nickname = (String)session.getAttribute("nickname");
	     String incode_pro_email = request.getParameter("pro_email");
	     String pro_email = java.net.URLDecoder.decode(incode_pro_email,"UTF-8");
	     //���� ������ ���� ��¥ ��������
	     String date = request.getParameter("res_date");
	     String res_date = java.net.URLDecoder.decode(date,"UTF-8");
	     //�����Ȳ ������Ʈ�� �ʿ��� ���� �߰��� ��������
	     int max_people = Integer.parseInt(request.getParameter("max_people"));
		 

		 System.out.println(nickname);
		 System.out.println(res_date);
		   
		 //nickname ���� ��ġ�ϴ� ��㳻�� �����
		 ReservationDAO dao = new ReservationDAO();
		 int cnt = dao.delete_Reservation(nickname, res_date, pro_email);
		 
		 
		 

		 //���� ���� ���� �� booking.jsp�� �̵�
		 if(cnt > 0) {
		
		 //�ִ� ���� ��Ȳ -1
		 C_ProfileDAO pro_dao = new C_ProfileDAO();
		 int update_people = pro_dao.up_people(pro_email, max_people);
		 
		 response.sendRedirect("booking.jsp");
		 }
		
	}

}
