package visual.cryptography.technique.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import visual.cryptography.technique.dao.SecurityDAO;

@WebServlet("/AcceptUserMessageServlet_admin")
public class AcceptUserMessageServlet_admin extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int mid = Integer.parseInt(request.getParameter("mid"));
		if(mid!=0) 
		{
			try {
				int i = new SecurityDAO().adminAcceptUserMessage(mid);
				if(i!=0) 
				{
					RequestDispatcher rd= request.getRequestDispatcher("acceptSecretImage_admin.jsp?status=Successfully Accepted");
					rd.include(request, response);
				}
				else 
				{
					RequestDispatcher rd= request.getRequestDispatcher("acceptSecretImage_admin.jsp?status=Faild to Accept");
					rd.include(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
				RequestDispatcher rd= request.getRequestDispatcher("acceptSecretImage_admin.jsp?status=Some Internal Error");
				rd.include(request, response);
			}
		}
		else 
		{
			RequestDispatcher rd= request.getRequestDispatcher("acceptSecretImage_admin.jsp?status=Mid Faild");
			rd.include(request, response);
		}
	}
}