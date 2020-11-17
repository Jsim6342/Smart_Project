package com.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.C_ProfileDAO;
import com.DAO.ConsultantDAO;
import com.DAO.DiaryDAO;
import com.DAO.MemberDAO;
import com.DAO.ReservationDAO;
import com.DAO.ReviewDAO;
import com.DTO.ReservationDTO;

@WebServlet("/Delete_Mem")
public class Delete_Mem extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 //�ѱ� ���ڵ�
	      request.setCharacterEncoding("UTF-8");
	      
	      //����ڰ� �Է��� ���� ��������
	      String incode_nickname = request.getParameter("nickname");
		  String nickname = java.net.URLDecoder.decode(incode_nickname,"UTF-8");
		  
	            
		  System.out.println("�Է��̸���"+nickname);   
		  	  
  
		  //Member nickname�� ��ġ�ϴ� �ϱ� �����
		  DiaryDAO dao_di = new DiaryDAO();
		  int check1 = dao_di.delete_diary(nickname);
		  System.out.println("1��½� �ϱ� ����� ����: "+check1);
		  
		  //Member nickname�� ��ġ�ϴ� ������Ȳ �����
		  //������ ������Ȳ ���� ������ ������Ȳ�� ����� ���� �̸��ϰ� �������� -> ������Ȳ +1�ϱ� ����
		  ReservationDAO dao_res = new ReservationDAO();
		  ArrayList<ReservationDTO> reservationList = new ArrayList<>();
		  reservationList = dao_res.delete_mem_Reservation(nickname);
		  
		  //Member nickname�� ��ġ�ϴ� ������Ȳ +1
		  C_ProfileDAO dao_pro = new C_ProfileDAO();
		  if(reservationList!=null) {
		  for(int i=0; i<reservationList.size(); i++) {
			  //���� ����Ʈ�� �ִ� ���� �̸��� ���� ������ ����  �����ʿ��� max_people�� ��������
			  String pro_email = reservationList.get(i).getPro_email();
			  int max_people = dao_pro.return_maxpeople(pro_email);
			  //���� �̸��� ���� ������ max_people���� ������ ������Ȳ +1
			  int check2 = dao_pro.up_people(pro_email, max_people);
			  System.out.println("������Ȳ+1");
		  }
		  }
		  
		  //Member nickname�� ��ġ�ϴ� �ı� �����
		  ReviewDAO dao_rev = new ReviewDAO();
		  int check3 = dao_rev.delete_mem_review(nickname);
		  System.out.println("1��½� �ı� ����� ����: "+check3);
		  
		  //Member table ��ȸ �� nickname�� ��ġ�ϴ� ȸ�� �� ����
		  MemberDAO dao_mem = new MemberDAO();
		  int check = dao_mem.delete_Member(nickname);
		  System.out.println("1��½� ��� ����� ����: "+check1);
		  
		  //session�� �����
			//���� ��ü ����
			HttpSession session = request.getSession();
			//���� �� ����
			session.removeAttribute("nickname");
	      
	      if(check>0) { //����� ���� �� ������������ �̵�
	    	  response.sendRedirect("index.jsp"); //��й�ȣ ������Ʈ ������
	      }
		
	}

}
