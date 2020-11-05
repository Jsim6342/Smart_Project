package com.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	   	 
		 System.out.println(nickname);
		 System.out.println(res_date);
		 System.out.println(consultant);
		   
		   
		   //ReservationDAO ��ü����
		   ReservationDAO dao = new ReservationDAO();
		   int cnt = dao.reserve_insert(nickname, res_date, consultant); //review_post �޼ҵ�. ���� �� 1 ��ȯ
		   
		   //���� ��� ���� �� counsel.jsp�� �̵�
		   if(cnt > 0) {
		   response.sendRedirect("counsel.jsp");
		   }
		
		
	}

}
