<%@page import="com.DAO.ReviewDAO"%>
<%@page import="com.DTO.ReviewDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Blooming - �غ��ı�</title>
<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Fontawesome CSS -->
<link href="css/all.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="css/style.css" rel="stylesheet">
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
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link" href="diagnosis.jsp">�����ϱ�</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="diary.jsp">�ϱ��ۼ�</a>
					</li>
					<!-- <li class="nav-item">
                     <a class="nav-link" href="counsel.jsp">���ܻ��</a>
                  </li> -->
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdownBlog"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							���ܻ�� </a>
						<div class="dropdown-menu dropdown-menu-right"
							aria-labelledby="navbarDropdownBlog">
							<a class="dropdown-item" href="counsel.jsp">���ܻ�㿹��</a> <a
								class="dropdown-item" href="booking.jsp">���ܻ�� ������Ȳ</a>
						</div></li>
					<li class="nav-item "><a class="nav-link active" href="comments.jsp">�غ��ı�</a>
					</li>
					<li class="nav-item "><a class="nav-link" href="contact.jsp">����ã��</a>
					</li>
					<%if(email==null&&nickname==null) {%>
					<li class="nav-item"><a class="nav-link" href="login.html">�α���</a>
					</li>
					<%}else { %>
					
					<li class="nav-item"><a class="nav-link" href="LogoutService">�α׾ƿ�</a>
					</li>
					<%} %>

				</ul>
			</div>
		</div>
	</nav>

	<!-- full Title -->
	<div class="full-title">
		<div class="container">
			<!-- Page Heading/Breadcrumbs -->
			<h1 class="mt-4 mb-3">
				�غ��ı� <small>post-overcoming review</small>
			</h1>
		</div>
	</div>

	<!-- Page Content -->
	<div class="container">
		<div class="breadcrumb-main">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
				<a href="comments.jsp" class="breadcrumb-item active">�غ��ı� �Խ�������
					���ư���</a>
			</ol>
		</div>

		<div class="row">
			<!-- Post Content Column -->
			<div class="col-lg-20">

<%
//rev_num �޾ƿ���
int rev_num = Integer.parseInt(request.getParameter("rev_num").trim());

//rev_num�� �´� �ı� �ҷ�����
ReviewDTO review = new ReviewDTO();
ReviewDAO dao = new ReviewDAO();
review = dao.showReview(rev_num);
%>

				
				<div class="col-lg-6">
					

			</div>
				<!-- Preview Image -->
				<img class="img-fluid rounded" src="images/aa.jpg" alt="" />
				<hr>
				<!-- Date/Time -->
				<blockquote class="blockquote">
				<h3>���� : <%=review.getRev_title()%></h3>
				<blockquote class="blockquote">
				<h5>�г���: <%=review.getNickname()%></h5>
				</blockquote>
				<hr>
				<!-- Post Content -->
				<blockquote class="blockquote">
				<p class="lead"><%=review.getRev_contents()%></p>
				</blockquote>
				<hr>

				

				<div class="blog-right-side">
					<div class="row mb-4">
									<div class="col-md-8"></div>
									<%if(dao.check_Review(rev_num, nickname)) { %>
									<div class="col-md-4">
										<a class="btn btn-lg btn-secondary btn-block"
											href="signup.html">�ı� �����ϱ�</a>
									</div>
									<%}%>
								</div>
							</form>
				</div>
	</div>
	<!-- /.row -->

	</div>
	<!-- /.container -->
</div>
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