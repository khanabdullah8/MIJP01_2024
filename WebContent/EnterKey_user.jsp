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
<script type="text/javascript">
        function valid() {
        	var key = document.forms["validate"]["key"].value;
        	var ekey = document.forms["validate"]["ekey"].value;
        	if(key!=ekey)
        	{
        		alert("Key Not Matched Plese Enter Correct Key");
        		return false;
        	}
		}
</script>

<style type="text/css">
    #pro
{
	display: none;
	width: 100%;
	background-color: #ddd;
}

#progress
{
	/*width: 0.5%;*/
	height: 30px;
	background-color: #4CAF50;
	color: red;
}
</style>
</head>
<body class="body">
<%int mid = Integer.parseInt(request.getParameter("mid"));
int key = Integer.parseInt(request.getParameter("key"));
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
     
     <section id="contact" data-stellar-background-ratio="0.5" style="margin-left: 28%;margin-top:5%;  text-align: center;">
          <div class="container">
               <div class="row" style="">
                    <div class="col-md-6 col-sm-12">

                         <div class="col-md-12 col-sm-12">
                              <div class="section-title wow fadeInUp" data-wow-delay="0.1s">
                                   <h2 style="color: white;">Enter Key</h2>
                                   <%String status = request.getParameter("status"); 
                                        if(status!=null)
                                        {%>
                                        	<h2 style="color: white;"><%out.print(status); %></h2>
                                        <%}
                                        %>
                              </div>
                         </div>

                         <!-- CONTACT FORM -->
                         <div class="col-md-12">
                            <div class="contact-form">
                                <form action="./ViewReceivedMessage_user.jsp" name="validate" onsubmit="return valid()" method="post">
                                    <div class="form-row">
                                        <div class="form-group col-md-6" style="margin-left: 25%;" align="center">
                                        	<input type="hidden" class="form-control" name="key" value="<%=key %>" required="required" />
                                        	<input type="hidden" class="form-control" name="mid" value="<%=mid %>" required="required" />
                                            <input type="text" class="form-control" name="ekey" style="color: white;" placeholder="Enter Key" required="required" />
                                        </div>
                                    </div>
                                    <div><input type="submit" class="btn" type="submit" value="Submit" onclick="onc()"></div>
                                </form>
                                <div id="pro" class="form-group" style="margin-top: 5%;">
										<div id="progress"></div>
									</div>
                            </div>
                        </div>
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
					val.innerHTML="Extraction or Reconstruct";
				}
				if(width>=61 && width<=100)
				{
					val.innerHTML="Decrypt RES Using CSD Algorithm";
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