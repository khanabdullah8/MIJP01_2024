<%@ page isELIgnored="false" %>
<%@page import="java.io.OutputStream"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
try
{

 int i=Integer.parseInt(request.getParameter("val"));
 
byte[] img=(byte[])session.getAttribute(i+"img3");
System.out.println("size--------"+img.length);
					OutputStream oImage;
			        response.setContentType("image3/gif");
			        oImage=response.getOutputStream();
			        oImage.write(img);			        
 	        oImage.flush();
 	       oImage.close();
		     
		    
}
catch(Exception e)
{
e.printStackTrace();	
}
			        
			        
			        
			        
			        
					%> 
					