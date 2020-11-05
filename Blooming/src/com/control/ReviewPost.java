package com.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.MemberDAO;
import com.DAO.ReviewDAO;


@WebServlet("/ReviewPost")
public class ReviewPost extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 //�ѱ� ���ڵ�
		 request.setCharacterEncoding("UTF-8");
			
	     //Session������ �� ����
	     HttpSession session = request.getSession(); //Session������ ����ϱ� ���� ��ü����
	     String nickname = (String)session.getAttribute("nickname");
		 
		 //�ı� �ۼ� ������ ��������
		 String rev_title = request.getParameter("rev_title");
		 String rev_contents = request.getParameter("rev_contents");
	   	 
		 System.out.println(nickname);
		 System.out.println(rev_title);
		 System.out.println(rev_contents);
		   
		   
		   //reviewDAO ��ü����
		   ReviewDAO dao = new ReviewDAO();
		   int cnt = dao.review_post(nickname, rev_title, rev_contents); //review_post �޼ҵ�. ���� �� 1 ��ȯ
		   
		   //�ı� ��� ���� �� comments.jsp�� �̵�
		   if(cnt > 0) {
		   response.sendRedirect("comments.jsp");
		   }
		
	}

}
