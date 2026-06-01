<!DOCTYPE html>
<%@page import="visual.cryptography.technique.bean.Bean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="visual.cryptography.technique.dao.ViewDAO"%>
<html lang="en">
<head>

     <title>Image Processing</title>
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
     
     <style type="text/css">
    #pro
{
	display: none;
	width: 100%;
	background-color: #ddd;
}

#progress
{
	width: 0.5%;
	height: 30px;
	background-color: #4CAF50;
	color: red;
}
</style>

</head>
<body class="body">
<%
session  = request.getSession();
int uid = (Integer)session.getAttribute("uid");%>

<p>User id is <%=uid %></p>
<%

ArrayList<Bean> al = new ViewDAO().userSelectUser(uid); 

System.out.println("the users"+al.toString());
%>
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
     
     <section id="contact" data-stellar-background-ratio="0.5" style="margin-left: 28%;margin-top:5%;">
          <div class="container">
               <div class="row" style="">
                    <div class="col-md-6 col-sm-12">

                         <div class="col-md-12 col-sm-12">
                              <div class="section-title wow fadeInUp" data-wow-delay="0.1s">
                                   <h2 style="color: white;text-align: center;">Send Message</h2>
                                   <%String status = request.getParameter("status"); 
                                        if(status!=null)
                                        {%>
                                        	<h2 style="color: white;"><%out.print(status); %></h2>
                                        <%}
                                        %>
                              </div>
                         </div>

                         <!-- CONTACT FORM -->
                         <form action="./SendMessageServlet_user" method="post" class="wow fadeInUp" id="contact-form" role="form" data-wow-delay="0.8s" enctype="multipart/form-data">

                              <div class="col-md-6 col-sm-6">
                              <h4 style="color: white;">Select User</h4>
                              <select class="form-control" style="color: orange;" name="user" required="">
                              	<option value="">Select User</option>
                              	<%for(Bean b:al){ %>
                              		<option value="<%=b.getUid()%>,<%=b.getUname()%>"><%=b.getUname() %></option>
                              	<%} %>
                              </select>
                              </div>
                              <div class="col-md-6 col-sm-6">
                              <h4 style="color: white;">choose cover image 1</h4>
                              <input type="file" class="form-control" id="cf-subject" name="image1" placeholder="Enter Email" accept="image/*" style="color: white;" required="">
                              </div>
                              <div class="col-sm-6 col-sm-6">
                              <h4 style="color: white;">choose cover image 2</h4>
                              <input type="file" class="form-control" id="cf-subject" name="image2" placeholder="Enter Password" accept="image/*"  style="color: white;" required="">
                              </div>
                              <div class="col-md-6 col-sm-6">
                              <h4 style="color: white;">choose cover image 3</h4>
                              <input type="file" class="form-control" id="cf-subject" name="image3" placeholder="Enter Password" accept="image/*"  style="color: white;" required="">
                              </div>
                              <div class="col-sm-12 col-sm-12">
                              <h4 style="color: white;">choose Medical Image</h4>
                              <input type="file" class="form-control" id="cf-subject" name="simage" placeholder="Enter Password" accept="image/*" style="color: white;" required="">
                              </div>
                                   <button type="submit" class="form-control" id="cf-submit" name="submit" onclick="onc();">Submit</button>
                                   <div id="pro" class="form-group">
										<div id="progress"></div>
									</div>                              
                         </form>
                    </div>
                    <script type="text/javascript">
	function onc()
	{
		 document.getElementById("pro").style.display = "block";
		var val =  document.getElementById("progress");
		var width = 1;
		var id = setInterval(frame,60);
		
		function frame()
		{
			
			if(width>=0 && width<=19)
			{
				val.innerHTML="wait";
			}
			if(width>=20 && width<=60)
				{
					val.innerHTML="Embedding under Procedure";
				}
				if(width>=61 && width<=100)
				{
					val.innerHTML="Encrypt Using CSR Algorithm";
				}
			if(width>=100)
			{
				clearInterval(id);
			}
			else
			{
				width++;
				val.style.width = width + "%";
			}
		}
		
	}
	</script>
	
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