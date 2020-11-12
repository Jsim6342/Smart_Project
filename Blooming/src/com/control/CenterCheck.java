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

import com.DAO.DiaryDAO;
import com.DTO.CenterDTO;
import com.DTO.DiaryDTO;
import com.google.gson.Gson;

@WebServlet("/CenterCheck")
public class CenterCheck extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//�ѱ� ���ڵ�
		 request.setCharacterEncoding("UTF-8");
		 response.setCharacterEncoding("UTF-8");	
		 
		 //��㼾�͸� ��������
	     String center_name = request.getParameter("center_name");

	  	 System.out.println("���� �����̸�: "+center_name);

		 
		 //�������� �Է�
		 CenterDTO diary = new CenterDTO();
		 CenterDTO center1 = new CenterDTO("�ɸ��ǰ�������","���� ���� ������ 734 103�� 206ȣ","062-512-0039","pimang95@naver.com","��������");
		 CenterDTO center2 = new CenterDTO("���ɿ��սɸ���㼾��","���� �ϱ� �ϰ����152���� 3-2 1��","062-470-4774","ph07pen@gmail.com","�����ð� ��~�� 10:00 ~ 18:00");
		 CenterDTO center3 = new CenterDTO("�ھ��� �ӻ�ɸ�Ŭ����","���� �ϱ� ���ϴ�� 113-2 2��","062-514-8800","jung9386@hanmail.net","��������");
		 CenterDTO center4 = new CenterDTO("�ֿ��� ������㼾��","���� �ϱ� ������� 111","062-263-7942","��������","��������");
		 
		 ArrayList<CenterDTO> centerList = new ArrayList<CenterDTO>();
		 centerList.add(center1);
		 centerList.add(center2);
		 centerList.add(center3);
		 centerList.add(center4);
		 
		 for(int i=0;i<centerList.size();i++) {
			 if(center_name.equals(centerList.get(i).getCenter_name())) {
				   
				 CenterDTO center = centerList.get(i);
				 
				 //JSON ������ ��ȯ
				 Gson gson = new Gson();
				 
				 PrintWriter out = response.getWriter();
				 
				 String jsonArr = gson.toJson(center);
				 
				 //center�� ����
				 out.print(jsonArr);
				 
	
			 }
		 }	
		
	}

}
