package com.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.ConsultantDAO;
import com.DAO.MemberDAO;
import com.DTO.ConsultantDTO;
import com.DTO.MemberDTO;

@WebServlet("/SearchEmail")
public class SearchEmail extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	      //�ѱ� ���ڵ�
	      request.setCharacterEncoding("UTF-8");
	      
	      //����ڰ� �Է��� ���� ��������
	      String incode_tel = request.getParameter("tel");
		  String tel = java.net.URLDecoder.decode(incode_tel,"UTF-8");
	      
	            
	      System.out.println(tel);
	      
	      
	      String email = "";
	      String con_email = "";
	      
	      //tel�� ���� ���̵� ã�� ���
	      //DB�� �����ؼ� ����ڰ� �Է��� tel���� �´� email�� Ȯ��
		  //member table ��ȸ
		   MemberDAO dao_mem = new MemberDAO();
		   email = dao_mem.search_email(tel);
		      
		  //consultant table ��ȸ
		   ConsultantDAO dao_con = new ConsultantDAO();
		   con_email = dao_con.search_email(tel);
		    
		   System.out.println(email);
		   System.out.println(con_email);
		   
		   if(email.equals("")&&con_email.equals("")) { //��ȭ��ȣ�� ��ġ�ϴ� ���̵� ���� ���
			   System.out.println("��ȭ��ȣ�� Ȯ�����ּ���.");
	             String check = "False";
	    		 PrintWriter out = response.getWriter();
	    		 out.print(check);
		   }else if(!email.equals("")) { //ȸ���� ���   
			   response.sendRedirect("showEmail.jsp?email="+email); //���̵� ��� ������	   
		   }else if(!con_email.equals("")) {// ������ ���   
			   response.sendRedirect("showEmail.jsp?email="+con_email); //���̵� ��� ������
		   }else {
			   System.out.println("�����Դϴ�.");
		      }
			   
			   

	                  
		
		
		
	}

}
