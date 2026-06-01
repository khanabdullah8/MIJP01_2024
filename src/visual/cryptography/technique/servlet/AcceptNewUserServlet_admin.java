package visual.cryptography.technique.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import visual.cryptography.technique.dao.SecurityDAO;

@WebServlet("/AcceptNewUserServlet_admin")
public class AcceptNewUserServlet_admin extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int uid = Integer.parseInt(request.getParameter("uid"));
		if(uid!=0) 
		{
			try {
				 int i =  new SecurityDAO().adminAcceptNewUser(uid);
				 if(i!=0) 
				 {
					 RequestDispatcher rd= request.getRequestDispatcher("acceptUser_admin.jsp?status=Accepted Successfully");
					 rd.include(request, response);
				 }
				 else 
				 {
					 RequestDispatcher rd= request.getRequestDispatcher("acceptUser_admin.jsp?status=Faild to Accept");
					 rd.include(request, response);
				 }
			} catch (Exception e) {
				e.printStackTrace();
				RequestDispatcher rd= request.getRequestDispatcher("acceptUser_admin.jsp?status=Some Internal Error");
				 rd.include(request, response);
			}
		}
		else 
		{
			
		}
	}
}