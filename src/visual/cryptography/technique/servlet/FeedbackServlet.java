package visual.cryptography.technique.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import visual.cryptography.technique.bean.Bean;
import visual.cryptography.technique.dao.SecurityDAO;

@WebServlet("/FeedbackServlet")
public class FeedbackServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Bean b = new Bean();
		b.setUname(request.getParameter("name"));
		b.setEmail(request.getParameter("email"));
		b.setMobile(request.getParameter("message"));
		
		try {
			int i = new SecurityDAO().feedback(b);
			if(i!=0) 
			{
				RequestDispatcher rd = request.getRequestDispatcher("contact.jsp?status=Successfully Submited");
				rd.include(request, response);
			}
			else 
			{
				RequestDispatcher rd = request.getRequestDispatcher("contact.jsp?status=Faild to Submit");
				rd.include(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("contact.jsp?status=Some Internal Error");
			rd.include(request, response);
		}
	}
}