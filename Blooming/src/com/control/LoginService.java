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
import com.google.gson.Gson;

@WebServlet("/LoginService")
public class LoginService extends HttpServlet {

   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      //�ѱ� ���ڵ�
      request.setCharacterEncoding("UTF-8");
      
      //����ڰ� �Է��� ���� ��������
      String incode_email = request.getParameter("email");
	  String email = java.net.URLDecoder.decode(incode_email,"UTF-8");
	  String incode_pw = request.getParameter("pw");
	  String pw = java.net.URLDecoder.decode(incode_pw,"UTF-8");
      
            
      //���Ȯ��
     System.out.println(email);
      System.out.println(pw);
            
      //DB�� �����ؼ� ����ڰ� �Է��� email���� pw�� Ȯ��
      //member table ��ȸ
      MemberDTO member = new MemberDTO();
      MemberDAO dao_mem = new MemberDAO();
      member = dao_mem.member_login(email, pw);
      //consultant table ��ȸ
      ConsultantDTO consultant = new ConsultantDTO();
      ConsultantDAO dao_con = new ConsultantDAO();
      consultant = dao_con.consultant_login(email, pw);
      
      
      //�α��� ����/���� ���� �� ������ �̵�
      if(consultant != null && !consultant.equals(null)) { //�����϶� �α���
                         
      //Session������ �� ����
       HttpSession session = request.getSession(); //Session������ ����ϱ� ���� ��ü����
       session.setAttribute("email", consultant.getCon_email()); //Session������ email�̸�ǥ�� �α��ο� ������ ����� email�� ����
                     
      //�������� �̵�        
       response.sendRedirect("index.jsp");
       
       }else if(member != null && !member.equals(null)){ //ȸ���϶� �α���
          
      //Session������ �� ����
      HttpSession session = request.getSession(); //Session������ ����ϱ� ���� ��ü����
      session.setAttribute("nickname", member.getNickname()); //Session������ email�̸�ǥ�� �α��ο� ������ ����� email�� ����
         
      //�������� �̵�
      response.sendRedirect("index.jsp");
          
    
       }else { //�α��� ����
             System.out.println("�̸��ϰ� ��й�ȣ�� Ȯ�����ּ���.");
             String check = "False";
    		 PrintWriter out = response.getWriter();
    		 out.print(check);
       }
      
   
                  
               
            
            
            
            
            
      
   }

}