package com.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.ReviewDAO;
import com.DTO.ReviewDTO;
import com.google.gson.Gson;

@WebServlet("/ReviewFix")
public class ReviewFix extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 //�ѱ� ���ڵ�
		 request.setCharacterEncoding("UTF-8");
			
	     //Session������ �� ����
	     HttpSession session = request.getSession(); //Session������ ����ϱ� ���� ��ü����
	     String nickname = (String)session.getAttribute("nickname");
		 
	     //�ı� number ��������
	     int rev_num = Integer.parseInt(request.getParameter("rev_num"));
		 //�ı� �ۼ� ������ ��������
		 String rev_title = request.getParameter("rev_title");
		 String rev_contents = request.getParameter("rev_contents");
	   	 
		 System.out.println(rev_num);
		 System.out.println(rev_title);
		 System.out.println(rev_contents);
		   
		   
		   //reviewDAO ��ü����
		   ReviewDAO dao = new ReviewDAO();
		   int cnt = dao.update_review(rev_num, rev_title, rev_contents); //review_post �޼ҵ�. ���� �� 1 ��ȯ
		   
		   //�ı� ���� ���� �� comments.jsp�� �̵�
		   if(cnt > 0) {
		   response.sendRedirect("comments.jsp");
		   }
		
		
	}

}
