package com.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.C_ProfileDAO;
import com.DAO.DiaryDAO;
import com.DAO.ReservationDAO;
import com.DTO.DiaryDTO;
import com.google.gson.Gson;


@WebServlet("/DiaryShow")
public class DiaryShow extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//�ѱ� ���ڵ�
		 request.setCharacterEncoding("UTF-8");
		 response.setCharacterEncoding("UTF-8");	
		 
	     //Session������ �� ����
	     HttpSession session = request.getSession(); //Session������ ����ϱ� ���� ��ü����
	     String nickname = (String)session.getAttribute("nickname");
		 
		 //��¥�� ��������
	     String start_date = request.getParameter("start_date");
	     String end_date = request.getParameter("end_date");
	     
		 System.out.println(nickname);
		 System.out.println(start_date);
		 System.out.println(end_date);
		 
		 //�г���, ��¥�� �´� �ϱ� �� ��ȸ, ����
		 DiaryDAO di_dao = new DiaryDAO();
		 DiaryDTO diary = new DiaryDTO();
		 ArrayList<DiaryDTO> diaryList = di_dao.show_diaryList(nickname, start_date, end_date);
		    
		 //JSON ������ ��ȯ
		 Gson gson = new Gson();
		 
		 PrintWriter out = response.getWriter();
		 
		 String jsonArr = gson.toJson(diaryList);
		 out.print(jsonArr);
		 
		 
//		 response.sendRedirect("counsel.jsp");
		   
		 
	}

}
