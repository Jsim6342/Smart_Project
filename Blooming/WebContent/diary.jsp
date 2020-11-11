<%@page import="java.util.ArrayList"%>
<%@page import="com.DTO.DiaryDTO"%>
<%@page import="com.DAO.DiaryDAO"%>
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
<title>Blooming - �ϱ�</title>

<!-- �� �ڵ� �̹��� �ٲ� -->
<script type="text/javascript">
      var img = new Array();
      img[0] = new Image();
      img[0].src = "images/sun.png";
      img[1] = new Image();
      img[1].src = "images/sun_2.png";
      img[2] = new Image();
      img[2].src = "images/sun_3.png";
      var interval = 500;
      var n = 0;
      var imgs = new Array("images/sun.png",
            "images/sun_2.png",
            "images/sun_3.png");
      function rotate() {
         if (navigator.appName == "Netscape" && document.getElementById) {
            document.getElementById("slide").src = imgs[n];
         } else
            document.images.slide.src = imgs[n];
         (n == (imgs.length - 1)) ? n = 0 : n++;
         setTimeout("rotate()", interval);
      }
</script>
<!-- �� �ڵ� �̹��� �ٲ� -->


<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Fontawesome CSS -->
<link href="css/all.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="css/style.css" rel="stylesheet">

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['��¥', '����'],
          ['1����',  0],
          ['2����',  1],
          ['3����',  0],
          ['4����',  1]
        ]);

        var options = {
          title: '���� ���� �׷���',
          curveType: 'function',
          legend: { position: 'bottom' }
        
        };

        var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));

        chart.draw(data, options);
      }
    </script>

</head>
<body onload="rotate()">
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
               <li class="nav-item "><a class="nav-link active" href="diary.jsp">�ϱ��ۼ�</a>
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
               <li class="nav-item"><a class="nav-link" href="comments.jsp">�غ��ı�</a>
               </li>
               <li class="nav-item"><a class="nav-link" href="contact.jsp">����ã��</a>
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
            �ϱ� <small>diary</small>
         </h1>
      </div>
   </div>


   <!-- Page Content -->
   <div class="container">
      <div class="breadcrumb-main">
         <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
            <li class="breadcrumb-item active">�ϱ�</li>
         </ol>
      </div>
   </div>


<div class="container">
      <div class="about-main">
         
         
         <div class="row">
         
            <div class="col-lg-6">
            <h2 class="col-lg-6">���� ���� Ű���</h2>
         <h class="col-lg-6">����� �̾߱⸦ ����ּ���</h>
          <br> <img src="images/sun.png" id="slide"> 
               <img class="img-fluid rounded" src="images/tree1.png" alt="" />
            </div>
            <div class="col-lg-6">
                           <!-- <h2>���� ���� �׷���</h2>
            
                           <img class="img-fluid rounded" src="images/about.jpg" alt="" /> -->

               
               <h2>���� �̾߱�</h2>
               <p>�ӽŷ����� ����� �����м� �ý������� ����� �Ϸ��� ������ �м��ص帳�ϴ�.</p>
               
               <h>��¥ ���� : </h>
               <input type="date" name='start_date' value='2020-11-10'/>
               <h> ~ </h>
               <input type="date" name='end_date' value='2020-11-10'/>
               <h><button id="search_btn" class="btn btn-primary">��ȸ</button></h>
               <hr>
               <ul id="diarylist">
               <li>��ȸ�� �����ּ���.</li>
               
                  <!-- <li>Phasellus quis erat et enim laoreet posuere ac porttitor
                     ipsum.</li>
                  <li>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</li>
                  <li>Duis porttitor odio pellentesque mollis vulputate.</li>
                  <li>Quisque ac eros non ex hendrerit vehicula.</li>
                  <li>Duis porttitor odio pellentesque mollis vulputate.</li>
                  <li>Quisque ac eros non ex hendrerit vehicula.</li>
                  <li>Quisque ac eros non ex hendrerit vehicula.</li>
                  <li>Duis porttitor odio pellentesque mollis vulputate.</li>
                  <li>Quisque ac eros non ex hendrerit vehicula.</li>
                  <li>Duis porttitor odio pellentesque mollis vulputate.</li>
                  <li>Quisque ac eros non ex hendrerit vehicula.</li>
                  <li>Quisque ac eros non ex hendrerit vehicula.</li>
                  <li>Duis porttitor odio pellentesque mollis vulputate.</li>
                  <li>Quisque ac eros non ex hendrerit vehicula.</li> -->
                  
               </ul>
               <hr>
               <a href="diaryWrite.jsp" class="btn btn-primary">�ϱ� �ۼ��ϱ�</a>
            
            </div>

         </div>
         <!-- /.row -->
      </div>
      <br>
      <br>
         <body>
         <h6 style="text-align:center;">����� �� �ϱ��� ����, ���� ������ �м��Ͽ� �����ݴϴ�.</h6>
         <h6 style="text-align:center;">����� ������ Ű��������!</h6>
       <div id="curve_chart" style="width: 1300px; height: 400px;"></div>
  </body>
      </div>
      <br>

   <!-- /.container -->
   <!--footer starts from here-->
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
   <!-- Ajax�� ����ϱ� ���� Ajax import �κ�  -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
   
   <script type="text/javascript">
   
   $('#search_btn').on('click',function(){
      
      let start_date = $('input[name="start_date"]').val();
      let end_date = $('input[name="end_date"]').val();
      
      
       //Ajax�Լ�(�̻�� �κ�. ajax ���� �� �����)
         $.ajax({
            //ajax ��� ������� �����͸� ����
            type : "post", //������ � ������� ȣ���� ������. get or post
            url : "DiaryShow", //� ������������ �� ���� ���� ������
            data : {"start_date" : start_date , "end_date" : end_date}, //���� ������ ����
            dataType : "json",
            success : function(diaryList) { //������ ���� ���� ��
               
            console.log(diaryList);
            
            let html ="";
            
            for(let i=0; i<diaryList.length; i++) {
               let diaryTitle = diaryList[i].di_title; //�ϱ� ���� ����
               html += '<li>'+diaryTitle+'</li>';
            }
            
            $('#diarylist').html(html); //.html: �ش� �±׿� ���� ����
            
            },
            error : function() {
               alert("ajax ��� ����");
            }
         });
   });
   
   </script>
</body>
</html>