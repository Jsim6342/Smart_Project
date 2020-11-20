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
import com.DAO.MemberDAO;
import com.DAO.ReservationDAO;

@WebServlet("/Delete_Con")
public class Delete_Con extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 //�ѱ� ���ڵ�
	      request.setCharacterEncoding("UTF-8");
	      
	      //����ڰ� �Է��� ���� ��������
	      String incode_email = request.getParameter("email");
		  String email = java.net.URLDecoder.decode(incode_email,"UTF-8");
	            
		  System.out.println("�Է��̸���"+email);
		  
		  
		  
		  //email�� ��ġ�ϴ� ��㳻�� ����
		  ReservationDAO dao_res = new ReservationDAO();
		  int check1 = dao_res.complete_Reservation(email);
		  System.out.println("��㳻�� ������ 1 ���: "+check1);
				  
		  //email�� ��ġ�ϴ� ��������� ����
		  C_ProfileDAO dao_pro = new C_ProfileDAO();
		  int check2 = dao_pro.profile_complete(email);
		  System.out.println("��� ������ ������ 1 ���: "+check2);
		  
		  //consultant table ��ȸ �� email�� ��ġ�ϴ� ȸ�� �� ����
		  ConsultantDAO dao_con = new ConsultantDAO();
		  int check3 = dao_con.delete_Consultant(email);
		  System.out.println("���� ȸ�� ������ 1���: "+check3);
		  
		  //session�� �����
			//���� ��ü ����
			HttpSession session = request.getSession();
			//���� �� ����
			session.removeAttribute("email");

	      
	      if(check3>0) { //�� �� ������Ʈ ���� ��
	    	  response.sendRedirect("index.jsp"); //��й�ȣ ������Ʈ ������
	      }
		
		
	}

}
