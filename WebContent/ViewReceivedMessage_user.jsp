<!DOCTYPE html>
<%@page import="visual.cryptography.technique.bean.Bean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="visual.cryptography.technique.dao.ViewDAO"%>
<html lang="en">
<head>

     <title>accept</title>
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
<%
int mid = Integer.parseInt(request.getParameter("mid"));
byte[] decimage = new ViewDAO().userViewReceivedImages(mid); %>
     <!-- PRE LOADER -->
     <section class="preloader">
          <div class="spinner">

               <span class="spinner-rotate"></span>
               
          </div>
     </section>


     <!-- MENU -->
     <section class="navbar custom-navbar navbar-fixed-top" role="navigation">
          <jsp:include page="userMenu.jsp"></jsp:include>
     </section>
     
     <!-- CONTACT -->
     
     <section id="contact" data-stellar-background-ratio="0.5" style="margin-left: 28%;margin-top:5%;  text-align: center;">
          <div class="container">
               <div class="row" style="">
                    <div class="col-md-6 col-sm-12">

                         <div class="col-md-12 col-sm-12">
                              <div class="section-title wow fadeInUp" data-wow-delay="0.1s">
                                   <h2 style="color: white;">Recovered Secret Image</h2>
                                   <%String status = request.getParameter("status"); 
                                        if(status!=null)
                                        {%>
                                        	<h2 style="color: white;"><%out.print(status); %></h2>
                                        <%}
                                        %>
                              </div>
                         </div>

                         <!-- CONTACT FORM -->

                              <div class="col-md-12 col-sm-12" style="margin-left: 30%;margin-top: 5%;">
                              <%if(decimage!=null){ %>
                             <table border="1">
                        <tr>
                        <td padding: 20px;" colspan="2">
                        <% int i = 0;
                        	i++;
                        	session.setAttribute(i + "img", decimage);
                        %>
                            <img src="image.jsp?val=<%=i %>" height="100" width="100" class="tm-service-img">
                           <h4 style="color: white;">Secret Image</h4>
                          </td>
                          </tr>
                          </table>
                                  <%}else{ %>
                                  		<h2 style="color: white;">Some Internal Error</h2>
                                   <%} %>
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