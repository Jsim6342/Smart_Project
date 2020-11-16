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
import com.DTO.ConsultantDTO;
import com.DTO.MemberDTO;

@WebServlet("/SearchEmail")
public class SearchEmail extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	      //�ѱ� ���ڵ�
	      request.setCharacterEncoding("UTF-8");
	      
	      //����ڰ� �Է��� ���� ��������
	      String tel = request.getParameter("tel");
	      String email = request.getParameter("email");
	      
	            
	      System.out.println(tel);
	      System.out.println(email);
	      
	      MemberDTO member = new MemberDTO();
	      ConsultantDTO consultant = new ConsultantDTO();
	      
	      
	      if(!tel.equals(null)&&email.equals(null)) { //tel�� ���� ���̵� ã�� ���
	    	//DB�� �����ؼ� ����ڰ� �Է��� tel���� �´� email�� Ȯ��
		      //member table ��ȸ
		      MemberDAO dao_mem = new MemberDAO();
		      member = dao_mem.search_email(tel);
		      
		    //consultant table ��ȸ
		      ConsultantDAO dao_con = new ConsultantDAO();
		      consultant = dao_con.search_email(tel);
		      
		      
	      }
	      
	      
	      if(!tel.equals(null)&&!email.equals(null)) {
	    	//DB�� �����ؼ� ����ڰ� �Է���  email,tel���� �´� pw�� Ȯ��
		      //member table ��ȸ
		      MemberDAO dao_mem = new MemberDAO();
		      member = dao_mem.search_pw(email, tel);
		      
		    //consultant table ��ȸ
		      ConsultantDAO dao_con = new ConsultantDAO();
		      consultant = dao_con.search_pw(email, tel);
	      }
	      
	      
	      if(member==null&&consultant==null) { //��ġ�ϴ� ���̵� ���� ���
	    	  
	      }else if(member!=null) { //ȸ���� ���
	    	  if(email.equals(null)) { //���̵� ã��
	    		  
	    	  }else { //��й�ȣ ã��
	    		  
	    	  }
	      }else if(consultant!=null) {// ������ ���
	    	  
	      }else {
	    	  if(email.equals(null)) { //���̵� ã��
	    		  
	    	  }else { //��й�ȣ ã��
	    		  
	    	  }  
	      }
	      
	      
	      
	      //�α��� ����/���� ���� �� ������ �̵�
	      if(consultant != null && !consultant.equals(null)) {
	                         
	      //Session������ �� ����
	       HttpSession session = request.getSession(); //Session������ ����ϱ� ���� ��ü����
	       session.setAttribute("email", consultant.getCon_email()); //Session������ email�̸�ǥ�� �α��ο� ������ ����� email�� ����
	                     
	      //�������� �̵�        
	       response.sendRedirect("index.jsp");
	       }else if(member != null && !member.equals(null)){
	          
	      //Session������ �� ����
	      HttpSession session = request.getSession(); //Session������ ����ϱ� ���� ��ü����
	      session.setAttribute("nickname", member.getNickname()); //Session������ email�̸�ǥ�� �α��ο� ������ ����� email�� ����
	         
	      //�������� �̵�
	      response.sendRedirect("index.jsp");
	          
	    
	       }else {
	             System.out.println("�̸��ϰ� ��й�ȣ�� Ȯ�����ּ���."); 
	       }
	      
	   
	                  
		
		
		
	}

}
