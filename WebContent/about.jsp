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
     
     <section id="contact" data-stellar-background-ratio="0.5" style="margin-left: 28%;margin-top:5%;  text-align: justify;">
          <div class="container">
               <div class="row" style="">
                    <div class="col-md-6 col-sm-12">

                         <div class="col-md-12 col-sm-12">
                              <div class="section-title wow fadeInUp" data-wow-delay="0.1s">
                                   <h2 style="color: white;">About Us</h2>
                                   <%String status = request.getParameter("status"); 
                                        if(status!=null)
                                        {%>
                                        	<h2><%out.print(status); %></h2>
                                        <%}
                                        %>
                              </div>
                         </div>

                         <!-- CONTACT FORM -->

                              <div class="col-md-12 col-sm-12">
                              	<font color="white" style="font-size: 15px;">The well-known compressed sensing reconstruction (CSR) 
                              	uses the sparse characteristics of the signal to obtain discrete amples with the compression 
                              	(i.e. measurement) algorithm, and then perfectly reconstructs the signal through the reconstruction algorithm.
                              	 Beneﬁting from the storage savings, the CSR has been widely used in the ﬁeld of large-scale image processing. 
                              	 However, the reconstruction process is computationally overloaded for resource-constrained clients. Therefore, 
                              	 designing a cloud-aided CSR algorithm becomes a hot topic. In this paper, we investigate the existing secure 
                              	 CSR algorithms within a cloud environment and propose a new privacy-enhanced and veriﬁable CSR outsourcing 
                              	 algorithm for online medical image processing services.</font> 
                              </div>
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