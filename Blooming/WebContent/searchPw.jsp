<%@ page language="java" contentType="text/html; charset=utf-8"
   pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
   <title>Blooming - PW 찾기</title>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <!-- Bootstrap core CSS -->
   <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
   <!-- Fontawesome CSS -->
   <link href="css/all.css" rel="stylesheet">
   <!-- Custom styles for this template -->
   <link href="css/style.css" rel="stylesheet">
<!--===============================================================================================-->   
   <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
   <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
   <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
   <link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
   <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->   
   <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
   <link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
   <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->   
   <link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
   <link rel="stylesheet" type="text/css" href="css/util.css">
   <link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
</head>
<body>
   
   <div class="limiter">
      <div class="container-login100">
         <div class="wrap-login100 p-t-0 p-b-0">
            <form class="login100-form validate-form">
               <span class="login100-form-title p-b-100">
                  PW 찾기
               </span>
               <a class="login100-form-avatar" href="index.jsp">
                  <img src="images/marigold.png"  alt="AVATAR">
               </a>

               <div class="wrap-input100 validate-input m-t-85 m-b-35" data-validate = "Enter email">
                  <input class="input100" type="email" name="pw_email" placeholder= "가입하신 Email을 입력해주세요.">
                  <!-- <span class="focus-input100" data-placeholder="Username"></span> -->
               </div>

               <div class="wrap-input100 validate-input m-b-50" data-validate="Enter Tel">
                  <input class="input100" type="password" name="pw_tel" placeholder= "가입하신 전화번호를 입력해주세요.">
                  <!-- <span class="focus-input100" data-placeholder="Password"></span> -->
               </div>

               <div class="container-login100-form-btn">
                  <input id="search_pw" type="button" value = "비밀번호 찾기" class="login100-form-btn">
               </div>

               <ul class="login-more p-t-60">
                  <ul class="login-more p-t-60">
						<li class="m-b-8">
							

							<a href="searchEmail.jsp" class="txt2">
								아이디 찾기 / 
							</a>
							<a href="searchPw.jsp" class="txt2">
								비밀번호 찾기
							</a>
						</li>

                  <li>
                     <!-- <span class="txt1">
                        회원이 아니신가요?
                     </span> -->
                     
                     <a href="signup.html" class="txt2">
                        일반 회원가입 / 
                     </a>
                     <a href="c_signup.html" class="txt2">
                        전문가 회원가입
                     </a>
                  </li>
               </ul>
            </form>
         </div>
      </div>
   </div>
   

   <div id="dropDownSelect1"></div>
   
<!--===============================================================================================-->
   <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
   <script src="vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
   <script src="vendor/bootstrap/js/popper.js"></script>
   <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
   <script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
   <script src="vendor/daterangepicker/moment.min.js"></script>
   <script src="vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
   <script src="vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
   <script src="js/main.js"></script>

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
<script type="text/javascript">

$('#search_pw').on('click',function(){
    
	   var check = "";
	   let email = $('input[name="pw_email"]').val();
	   let tel = $('input[name="pw_tel"]').val();
	   
	   if(email==="") {
		   alert("이메일을 입력해주세요.");
	   }else if(tel===""){
		   alert("전화번호를 입력해주세요.");
	   }else{
		   
		 //Ajax함수
		    $.ajax({
		         //ajax 통신 방식으로 데이터를 전송
		         type : "post", //서버로 어떤 방식으로 호출할 것인지. get or post
		         url : "SearchPw", //어떤 서버페이지로 이 값을 보낼 것인지
		         data : {"email" : email, "tel" : tel}, //보낼 데이터 지정
		         dataType : "text",
		         success : function(data) { //서버로 부터 받은 값
		         
		         check = data;
		         	if(check==="False") {
		         		alert("일치하는 회원정보가 존재하지 않습니다.");
		         	}else {
		         	    location.href = "SearchPw?email="+encodeURIComponent(encodeURIComponent(email),"UTF-8")+"&tel="+encodeURIComponent(encodeURIComponent(tel),"UTF-8");
		         	}
		         },
		         error : function() {
		            alert("ajax 통신 실패");
		         }
		      });
		   
	   }
   
    
});

</script>
</body>
</html>