package com.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.ConsultantDAO;
import com.DTO.ConsultantDTO;

@WebServlet("/ConsultantSignup")
public class ConsultantSignup extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//ȸ������ ���������� �� �޾ƿ���
	   String con_email = request.getParameter("con_email");
	   String con_pw = request.getParameter("con_pw");
	   String con_name = request.getParameter("con_name");
	   String con_tel = request.getParameter("con_tel");
	   String license = request.getParameter("license");
	   String location = request.getParameter("location");

	   //Consultant DTO ��ü����
	   ConsultantDTO consultant = new ConsultantDTO(con_email, con_pw, con_name, con_tel, license, location);
	   
	   //Consultant DAO ��ü����
	   ConsultantDAO dao = new ConsultantDAO();
	   int cnt = dao.consultant_join(consultant);

	   //ȸ������ ���� �� login.html�� �̵�
	   if(cnt > 0) {
	   response.sendRedirect("login.html");
	   }
		
	}

}
