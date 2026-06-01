<!DOCTYPE html>
<html lang="en">
<head>

     <title>Login</title>
<!-- 

Eatery Cafe Template 

http://www.templatemo.com/tm-515-eatery

-->
     <meta charset="UTF-8">
     <meta http-equiv="X-UA-Compatible" content="IE=Edge">
     <meta name="description" content="">
     <meta name="keywords" content="">
     <meta name="author" content="">
     <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

     <link rel="stylesheet" href="css/bootstrap.min.css">
     <link rel="stylesheet" href="css/font-awesome.min.css">
     <link rel="stylesheet" href="css/animate.css">
     <link rel="stylesheet" href="css/owl.carousel.css">
     <link rel="stylesheet" href="css/owl.theme.default.min.css">
     <link rel="stylesheet" href="css/magnific-popup.css">

     <!-- MAIN CSS -->
     <link rel="stylesheet" href="css/templatemo-style.css">

</head>
<body class="body">

     <!-- PRE LOADER -->
     <section class="preloader">
          <div class="spinner">

               <span class="spinner-rotate"></span>
               
          </div>
     </section>


     <!-- MENU -->
     <section class="navbar custom-navbar navbar-fixed-top" role="navigation">
          <jsp:include page="menu.jsp"></jsp:include>
     </section>
     
     <!-- CONTACT -->
     
     <section id="contact" data-stellar-background-ratio="0.5" style="margin-left: 28%;margin-top:5%;  text-align: center;">
          <div class="container">
               <div class="row" style="">
                    <div class="col-md-6 col-sm-12">

                         <div class="col-md-12 col-sm-12">
                              <div class="section-title wow fadeInUp" data-wow-delay="0.1s">
                                   <h2 style="color: white;">Register Here</h2>
                                   <%String status = request.getParameter("status"); 
                                        if(status!=null)
                                        {%>
                                        	<h2 style="color: white;"><%out.print(status); %></h2>
                                        <%}
                                        %>
                              </div>
                         </div>

                         <!-- CONTACT FORM -->
                         <form action="./RegisterServlet" method="post" class="wow fadeInUp" id="contact-form" role="form" data-wow-delay="0.8s">
                              <div class="col-md-6 col-sm-6">
                                   <input type="text" class="form-control" id="cf-name" name="name" placeholder="Name" style="color: white;" required="">
                              </div>

                              <div class="col-md-6 col-sm-6">
                                   <input type="email" class="form-control" id="cf-email" name="email" placeholder="Email address" style="color: white;" required="">
                              </div>
                              
                              <div class="col-md-6 col-sm-6">
                                   <input type="password" class="form-control" id="cf-email" name="password" placeholder="Password" style="color: white;" required="">
                              </div>
                              
                              <div class="col-md-6 col-sm-6">
                                   <input type="tel" class="form-control" id="cf-email" name="mobile" placeholder="Enter Mobile" style="color: white;" maxlength="10" required="">
                              </div>

                              <div class="col-md-12 col-sm-12">
                              		<input type="date" class="form-control" id="cf-email" name="dob" placeholder="Email Mobile" style="color: white;" required="">

                                   <textarea class="form-control" rows="6" id="cf-message" name="address" placeholder="Address" style="color: white;" required=""></textarea>

                                   <button type="submit" class="form-control" id="cf-submit" name="submit">Register</button>
                              </div>
                         </form>
                    </div>

               </div>
          </div>
     </section>          

     <!-- SCRIPTS -->
     <script src="js/jquery.js"></script>
     <script src="js/bootstrap.min.js"></script>
     <script src="js/jquery.stellar.min.js"></script>
     <script src="js/wow.min.js"></script>
     <script src="js/owl.carousel.min.js"></script>
     <script src="js/jquery.magnific-popup.min.js"></script>
     <script src="js/smoothscroll.js"></script>
     <script src="js/custom.js"></script>

</body>
</html>