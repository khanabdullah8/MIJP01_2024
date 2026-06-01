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
ArrayList<Bean> al = new ViewDAO().userViewSendedImages(mid); %>
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
                                   <h2 style="color: white;">Embedded Image Process</h2>
                                   <%String status = request.getParameter("status"); 
                                        if(status!=null)
                                        {%>
                                        	<h2 style="color: white;"><%out.print(status); %></h2>
                                        <%}
                                        %>
                              </div>
                         </div>

                         <!-- CONTACT FORM -->
                         <form action="./LoginServlet" method="post" class="wow fadeInUp" id="contact-form" role="form" data-wow-delay="0.8s">

                              <div class="col-md-12 col-sm-12">
                              <%if(!al.isEmpty()){ %>
                             <table border="1">
                        <tr>
                        <td padding: 20px;" colspan="2">
                        <% int i = 0;
                        for(Bean b:al){
                        	i++;
                        	session.setAttribute(i + "img", b.getSecimage());
                        %>
                            <img src="image.jsp?val=<%=i %>" height="100" width="100" class="tm-service-img">
                          <%} %>
                           <h4 style="color: white;">Secret Image</h4>
                          </td>
                          <td padding: 20px; colspan="2">
                        <% int j = 0;
                        for(Bean b:al){
                        	j++;
                        	session.setAttribute(j + "img1", b.getEncimage());
                        %>
                            <img src="image1.jsp?val=<%=j %>" height="100" width="100" class="tm-service-img">
                          <%}%>
                          <h4 style="color: white;">Encrypted Secret Image</h4>
                          </td>
                          </tr>
                       	 <tr style="border-color: white;">
                       	 <td padding: 20px;>
                        <% int k = 0;
                        for(Bean b:al){
                        	k++;
                        	session.setAttribute(k + "img2", b.getImage1());
                        %>
                            <img src="image2.jsp?val=<%=k %>" height="100" width="100" class="tm-service-img">
                          <%}%>
                          <h4 style="color: white;">Share1</h4>
                          </td>
                        <td padding: 20px;>
                        <% int l = 0;
                        for(Bean b:al){
                        	l++;
                        	session.setAttribute(l + "img3", b.getImage2());
                        %>
                            <img src="image3.jsp?val=<%=l %>" height="100" width="100" class="tm-service-img">
                          <%} %>
                           <h4 style="color: white;">Share2</h4>
                          </td>
                          <td padding: 20px;>
                        <% int m = 0;
                        for(Bean b:al){
                        	m++;
                        	session.setAttribute(m + "img4", b.getImage3());
                        %>
                            <img src="image4.jsp?val=<%=m %>" height="100" width="100" class="tm-service-img">
                          <%}%>
                          <h4 style="color: white;">Share3</h4>
                          </td>
                          </tr>
                          <tr>
                          <td padding: 20px; colspan="3">
                        <% int n = 0;
                        for(Bean b:al){
                        	n++;
                        	session.setAttribute(n + "img5", b.getSharedimage());
                        %>
                            <img src="image5.jsp?val=<%=n %>" height="100" width="100" class="tm-service-img">
                          <%}%>
                          <h4 style="color: white;">Constructed Image</h4>
                          </td>
                          </tr>
                          </table>
                                  <%}else{ %>
                                  		<h2 style="color: white;">Some Internal Error</h2>
                                   <%} %>
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