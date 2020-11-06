<%@page import="com.DTO.ReservationDTO"%>
<%@page import="com.DAO.ReservationDAO"%>
<%@page import="com.DTO.C_ProfileDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.DAO.C_ProfileDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<!-- ��ܹ�, �ϴܹٸ� �ִ� ������ -->
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Blooming - ���ܻ�� ������Ȳ</title>
<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Fontawesome CSS -->
<link href="css/all.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="css/style.css" rel="stylesheet">

<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/style.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<% //��ũ��Ʋ��
 
 	//session�� email ��������
	String email = (String)session.getAttribute("email");
	System.out.println("���� ������ ����� �̸���: " + email);
	
	//session�� nickname ��������
	String nickname = (String)session.getAttribute("nickname");
	System.out.println("���� ������ ����� �г���: " + nickname);
	
 %>
	<!-- Navigation -->
	<nav
		class="navbar fixed-top navbar-expand-lg navbar-dark bg-light top-nav fixed-top">
		<div class="container">
			<a class="navbar-brand" href="index.jsp"> <img
				src="images/marigold4.png" width="180px" ; height="53px"
				; alt="logo" />
			</a>
			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-toggle="collapse" data-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="fas fa-bars"></span>
			</button>

		</div>
	</nav>

	<!-- full Title -->
	<div class="full-title">
		<div class="container">
			<!-- Page Heading/Breadcrumbs -->
			<h1 class="mt-4 mb-3">
				���� Ȯ���ϱ� <small>booking</small>
			</h1>
		</div>
	</div>

	<!-- Page Content -->
	<div class="container">
		<div class="breadcrumb-main">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
				<li class="breadcrumb-item active">���ܻ�� ������Ȳ</li>
			</ol>
		</div>
	</div>

	<div class="container row">
		<div class="page-hearder col-md-offset-3" style="padding-bottom: 20px">
		</div>
		<div class="col-sm-offset-9"></div>
		<div class="col-md-10 col-md-offset-2">
		
		<table class="table table-striped ">
				<tr class="text-center">
					<th>����</th>
					<th>���� �̸���</th>
					<th>�������</th>
					<th>�����ο�</th>
					
					<th><br></th>
				</tr>
		
		<!--������Ȳ ���̺� ���  -->
		<%
		C_ProfileDAO pro_dao = new C_ProfileDAO();
		ReservationDAO res_dao = new ReservationDAO();
		ReservationDTO reservation = new ReservationDTO();
		ArrayList<ReservationDTO> reservationList = res_dao.return_consultant(nickname);
		ArrayList<C_ProfileDTO> profileList = pro_dao.res_ShowProfile(reservationList);
		
	    
		%>
		
		<% 
		for(int i = 0;i<profileList.size();i++) {
			
			 out.print("<tr>");
	         out.println("<td>"+profileList.get(i).getPro_name()+"</td>");
	         out.println("<td>"+profileList.get(i).getPro_email()+"</td>");
	         out.println("<td>"+profileList.get(i).getPro_date()+"</td>"); 
	         out.println("<td>"+profileList.get(i).getMax_people()+"</td>"); 
	         out.print("<td>");
	         
	         %>
	         <script>
						function next() {
							if (confirm("����� ����Ͻðڽ��ϱ�?")) {
								alert('����� ����ϼ̽��ϴ�. ���ܻ�� ���� �������� �̵��մϴ�.');
								location.href = "ReserveDelete?date="<%=profileList.get(i).getPro_date()%>;
							} else {
							}
						}
			</script> 
	         <%
	         out.print("<a onclick='next()' href='#' class='btn btn-primary'>������</a>");
	         out.print("</td>");
	         out.print("<tr>");
	         
				/* <tr>
					<td>������</td>
					<td>email@naver.com</td>
					<td>���� ������ 7��</td>
					<td>20</td>
					<td>
					<script>
						function next() {
							if (confirm("����� ����Ͻðڽ��ϱ�?")) {
								alert('����� ����ϼ̽��ϴ�. ���ܻ�� ���� �������� �̵��մϴ�.');
								location.href = "http://localhost:8085/Blooming/counsel.jsp";
							} else {
							}
						}
					</script> <a onclick="next()" href="#" class="btn btn-primary">������</a></td>
				</tr> */
				} %>
			</table>
		</div>
	</div>

	<!-- /.container -->
	<!--footer starts from here-->
	<footer class="footer">
		<div class="container bottom_border">
			<div class="row">
				<div class="container">
					<div class="footer-logo">
						<a href="#"><img src="images/marigold4.png" alt="" /></a>
					</div>
					<!--foote_bottom_ul_amrc ends here-->
					<p class="copyright text-center">
						All Rights Reserved. &copy; 2020 <a href="#">Blooming</a> Design
						By : SINOZO, 9uack <a href="https://html.design/">html design</a>
					</p>
				</div>
	</footer>

	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>