package com.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.MemberDAO;
import com.DTO.MemberDTO;

@WebServlet("/MemberSignup")
public class MemberSignup extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	   //ȸ������ ���������� �� �޾ƿ���
	   String email = request.getParameter("email");
	   String pw = request.getParameter("pw");
	   String tel = request.getParameter("tel");
	   String nickname = request.getParameter("nickname");
	   
	   //member DTO ��ü����
	   MemberDTO member = new MemberDTO(email, pw, tel, nickname);
	   
	   //member DAO ��ü����
	   MemberDAO dao = new MemberDAO();
	   int cnt = dao.member_join(member); //member_join �޼ҵ�. ���� �� 1 ��ȯ
	   
	   //ȸ������ ���� �� login.html�� �̵�
	   if(cnt > 0) {
	   response.sendRedirect("login.html");
	   }

	}

}
