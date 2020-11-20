package com.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.ConsultantDAO;
import com.DAO.MemberDAO;
import com.DTO.ConsultantDTO;
import com.DTO.MemberDTO;


@WebServlet("/SearchPw")
public class SearchPw extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		 //�ѱ� ���ڵ�
	      request.setCharacterEncoding("UTF-8");
	      
	      //����ڰ� �Է��� ���� ��������
	      String incode_email = request.getParameter("email");
		  String email = java.net.URLDecoder.decode(incode_email,"UTF-8");
	      String incode_tel = request.getParameter("tel");
		  String tel = java.net.URLDecoder.decode(incode_tel,"UTF-8");
	      
	      
		  System.out.println(email);   
	      System.out.println(tel);
	      
	      String mem_email = "";
	      String con_email = "";
	      
	      if(!tel.equals(null)&&!email.equals(null)) {
	    	//DB�� �����ؼ� ����ڰ� �Է���  email,tel���� �´� pw�� Ȯ��
		      //member table ��ȸ
		      MemberDAO dao_mem = new MemberDAO();
		      mem_email  = dao_mem.search_pw(email, tel);
		      
		    //consultant table ��ȸ
		      ConsultantDAO dao_con = new ConsultantDAO();
		      con_email = dao_con.search_pw(email, tel);
	      }
	      
	      
	      if(mem_email.equals("")&&con_email.equals("")) { //��ġ�ϴ� ���̵� ���� ���
	    	  System.out.println("�Է� ������ �ٽ� Ȯ�����ּ���.");
	             String check = "False";
	    		 PrintWriter out = response.getWriter();
	    		 out.print(check);
	      }else if(!mem_email.equals("")) { //ȸ���� ���
	    	  response.sendRedirect("updatePw.jsp?email="+mem_email); //��й�ȣ ������Ʈ ������
	    	  
	      }else if(!con_email.equals("")) {// ������ ���
	    	  response.sendRedirect("updatePw.jsp?email="+con_email); //��й�ȣ ������Ʈ ������ 
	      }else {
	    	  System.out.println("�����Դϴ�.");
	      }
		
		
	}

}
