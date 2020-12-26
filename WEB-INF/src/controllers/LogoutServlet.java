package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;


import models.*;

public class LogoutServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		
		User user = (User)session.getAttribute("user");

		String nextPage = null;
		if(user!=null&&user.getUserType().getUserTypeId()==1){
			nextPage = "admin_welcome.jsp";
		}else{
			nextPage = "index.jsp";
		}		

		session.invalidate();			

		request.getRequestDispatcher(nextPage).forward(request,response);
	}
}