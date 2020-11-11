package com.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.C_ProfileDAO;
import com.DAO.ReservationDAO;


@WebServlet("/DeleteCounsel")
public class DeleteCounsel extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//�ѱ� ���ڵ�
		 request.setCharacterEncoding("UTF-8");
			
		//���õ� ���� ������ �̸��� �� ��������		 
	     String incode_pro_email = request.getParameter("pro_email");
	     String pro_email = java.net.URLDecoder.decode(incode_pro_email,"UTF-8");

		 System.out.println(pro_email);
		   
		 //C_Profile�� pro_email�� ��ġ�ϴ� �� delete
		  C_ProfileDAO pro_dao = new C_ProfileDAO();
		  int cnt1 = pro_dao.profile_complete(pro_email);
		 
		  //Reservation�� pro_email�� ��ġ�ϴ� �� ��� delete
		   //ReservationDAO ��ü����
		   ReservationDAO res_dao = new ReservationDAO();
		   int cnt2 = res_dao.complete_Reservation(pro_email); //review_post �޼ҵ�. ���� �� 1 ��ȯ
		   
		   //���� ��� ���� ��
		   if(cnt1>0) {
	
			   response.sendRedirect("counsel.jsp");

		   }
		
		
		
	}

}
