package com.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.DiaryDAO;
import com.DAO.ReviewDAO;


@WebServlet("/DiaryPost")
public class DiaryPost extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 //�ѱ� ���ڵ�
		 request.setCharacterEncoding("UTF-8");
			
	     //Session������ �� ����
	     HttpSession session = request.getSession(); //Session������ ����ϱ� ���� ��ü����
	     String nickname = (String)session.getAttribute("nickname");
		 
		 //�ϱ� �ۼ� ������ ��������
	     String DI_DATE = request.getParameter("DI_DATE");
		 String DI_TITLE = request.getParameter("DI_TITLE");
		 String DI_CONTENTS = request.getParameter("DI_CONTENTS");
		 int DI_SCORE = Integer.parseInt(request.getParameter("DI_SCORE"));
		 
	   	 
		 System.out.println(DI_DATE);
		 System.out.println(DI_TITLE);
		 System.out.println(DI_CONTENTS);
		 System.out.println(DI_SCORE); 
		   
		   //DiaryDAO ��ü����
		   DiaryDAO dao = new DiaryDAO();
		   int cnt = dao.insertDiary(nickname, DI_DATE, DI_TITLE, DI_CONTENTS, DI_SCORE); //insertDiary�޼ҵ�. ���� �� 1 ��ȯ
		   
		   //�ı� ��� ���� �� diary.jsp�� �̵�
		   if(cnt > 0) {
			 response.sendRedirect("diary.jsp");  
		   //response.sendRedirect("http://127.0.0.1:5000/DiaryPost1?DI_TITLE="+DI_TITLE+"&DI_CONTENTS="+DI_CONTENTS);
		   }
		
		
	}

}
