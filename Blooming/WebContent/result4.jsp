<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="utf-8"%>
<!-- 상단바, 하단바만 있는 페이지 -->
<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
   <meta name="description" content="">
   <meta name="author" content="">
   <title>Blooming - 진단결과</title>
   <!-- Bootstrap core CSS -->
   <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
   <!-- Fontawesome CSS -->
   <link href="css/all.css" rel="stylesheet">
   <!-- Custom styles for this template -->
   <link href="css/style.css" rel="stylesheet">
</head>
<body>

<% //스크립틀릿
 
 	//session값 email 가져오기
	String email = (String)session.getAttribute("email");
	System.out.println("현재 접속한 사람의 이메일: " + email);
	
	//session값 nickname 가져오기
	String nickname = (String)session.getAttribute("nickname");
	System.out.println("현재 접속한 사람의 닉네임: " + nickname);
	
 %>
    <!-- Navigation -->
    <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-light top-nav fixed-top">
        <div class="container">
            <a class="navbar-brand" href="index.jsp">
            <img src="images/marigold4.png" width="180px"; height="53px"; alt="logo" />
            </a>
            <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
				<span class="fas fa-bars"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
               <ul class="navbar-nav ml-auto">
                  <li class="nav-item"><a class="nav-link" href="diagnosis.jsp">진단하기</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="diary.jsp">일기작성</a>
					</li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdownBlog"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							집단상담 </a>
						<div class="dropdown-menu dropdown-menu-right"
							aria-labelledby="navbarDropdownBlog">
							<a class="dropdown-item" href="counsel.jsp">집단상담예약</a> <a
								class="dropdown-item" href="booking.jsp">집단상담 예약현황</a>
						</div></li>
					<li class="nav-item"><a class="nav-link" href="comments.jsp">극복후기</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="contact.jsp">센터찾기</a>
					</li>
					<%if(email==null&&nickname==null) {%>
					<li class="nav-item"><a class="nav-link" href="login.html">로그인</a>
					</li>
					<%}else { %>
					<li class="nav-item"><a class="nav-link" href="LogoutService">로그아웃</a>
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
         <h1 class="mt-4 mb-3">진단결과
            <small></small>
         </h1>
      </div>
   </div>
  
<!-- Page Content -->
    <div class="container">
      <div class="breadcrumb-main">
         <ol class="breadcrumb">
            <li class="breadcrumb-item">
               <a href="index.jsp">Home</a>
            </li>
            <li class="breadcrumb-item active">진단하기</li>
         </ol>
      </div>
      
      
    <div class="about-main">
			<div class="row">
				<div class="col-lg-6">
					<h2>당신은 현재 심각한 우울상태입니다.</h2>
					<p>'괜찮겠지'라고 계속 시간을 보내고 계신가요.<br>전문가와 이야기 해볼 필요가 있어보여요.</p>
					<h5>확인해보세요.</h5>
					<ul>
						<li>답답함과 우울함때문에 잠을 설치시나요.</li>
						<li>하고싶은 일이나 해야할 일에서 의욕이 없으신가요.</li>
						<li>하루에 대부분 우울한 기분이 지속되시나요.</li>
						<li>거의 매일 무기력하거나 피로하신가요.</li>
					</ul>
					<p>방치한다면 불안이나 공황장애, 신체적으로 다양한 영향을 받을 수 있어요.<br>심한 우울증은 약물치료와 더불어 장기적으로 심리치료도 필요합니다.<br>
					센터를 찾아가는게 겁이나신다면 모의상담으로라도 꼭 상담을 받아보세요.<br>그 후 저희가 제공하는 전문 상담센터를 꼭 확인하시고 방문해 보시는걸 권장드려요.
					</p>
				</div>
				<div class="col-lg-6">
					<img class="img-fluid rounded" src="images/result5.jpg" alt="" />
				</div>
			</div>
			<!-- /.row -->
		</div>
     <br>
     <div class="row mb-4">
				<div class="col-md-8"></div>
				<div class="col-md-4">
					<a class="btn btn-lg btn-secondary btn-block" href="counsel.jsp">집단상담받기</a>
				</div>
			</div>
     </div>
     	<div>
     	
     	</div>  
     </div>    
       
       
       
       
    <!-- /.container -->
    <!--footer starts from here-->
    <footer class="footer">
        <div class="container bottom_border">
            <div class="row">
               <!-- <div class="col-lg-3 col-md-6 col-sm-6 col">
					<h5 class="headin5_amrc col_white_amrc pt2">Find us</h5>
					headin5_amrc
					<p class="mb10">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s</p>
					<p><i class="fa fa-location-arrow"></i> 9878/25 sec 9 rohini 35 </p>
					<p><i class="fa fa-phone"></i> +91-9999878398 </p>
					<p><i class="fa fa fa-envelope"></i> info@example.com </p>
               </div>
               <div class="col-lg-3 col-md-6 col-sm-6 col">
					<h5 class="headin5_amrc col_white_amrc pt2">Follow us</h5>
					headin5_amrc ends here
					<ul class="footer_ul2_amrc">
						<li>
							<a href="#"><i class="fab fa-twitter fleft padding-right"></i> </a>
							<p>Lorem Ipsum is simply dummy printing...<a href="#">https://www.lipsum.com/</a></p>
						</li>
						<li>
							<a href="#"><i class="fab fa-twitter fleft padding-right"></i> </a>
							<p>Lorem Ipsum is simply dummy printing...<a href="#">https://www.lipsum.com/</a></p>
						</li>
						<li>
							<a href="#"><i class="fab fa-twitter fleft padding-right"></i> </a>
							<p>Lorem Ipsum is simply dummy printing...<a href="#">https://www.lipsum.com/</a></p>
						</li>
					</ul>
					footer_ul2_amrc ends here
				</div>
				<div class="col-lg-3 col-md-6 col-sm-6">
					<h5 class="headin5_amrc col_white_amrc pt2">Quick links</h5>
					headin5_amrc
					<ul class="footer_ul_amrc">
						<li><a href="#">Default Version</a></li>
						<li><a href="#">Boxed Version</a></li>
						<li><a href="#">Our Team </a></li>
						<li><a href="#">About Us</a></li>
						<li><a href="#">Our Services</a></li>
						<li><a href="#">Get In Touch</a></li>
					</ul>
					footer_ul_amrc ends here
				</div>
				<div class="col-lg-3 col-md-6 col-sm-6 ">
					<h5 class="headin5_amrc col_white_amrc pt2">Recent posts</h5>
					headin5_amrc
					<ul class="footer_ul_amrc">
						<li class="media">
							<div class="media-left">
								<img class="img-fluid" src="images/post-img-01.jpg" alt="" />
							</div>
							<div class="media-body">
								<p>How to find best dog food?</p>
								<span>22 Sep 2018</span>
							</div>
						</li>
						<li class="media">
							<div class="media-left">
								<img class="img-fluid" src="images/post-img-02.jpg" alt="" />
							</div>
							<div class="media-body">
								<p>How to find best dog food?</p>
								<span>34 Sep 2018</span>
							</div>
						</li>
						<li class="media">
							<div class="media-left">
								<img class="img-fluid" src="images/post-img-03.jpg" alt="" />
							</div>
							<div class="media-body">
								<p>How to find best dog food?</p>
								<span>30 Sep 2018</span>
							</div>
						</li>
					</ul>
					footer_ul_amrc ends here
				</div>
			</div>
		</div> -->
        <div class="container">
            <div class="footer-logo">
				<a href="#"><img src="images/marigold4.png" alt="" /></a>
			</div>
            <!--foote_bottom_ul_amrc ends here-->
            <p class="copyright text-center">All Rights Reserved. &copy; 2020 <a href="#">Blooming</a> Design By : SINOZO, 9uack
				<a href="https://html.design/">html design</a>
            </p>
            <!-- 맨 아래 footer SNS페이지 이동 ul태그 -->
            <!-- <ul class="social_footer_ul">
				<li><a href="#"><i class="fab fa-facebook-f"></i></a></li>
				<li><a href="#"><i class="fab fa-twitter"></i></a></li>
				<li><a href="#"><i class="fab fa-linkedin"></i></a></li>
				<li><a href="#"><i class="fab fa-instagram"></i></a></li>
            </ul> -->
            <!--social_footer_ul ends here-->
        </div>
    </footer>
	  
<!-- Bootstrap core JavaScript -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>