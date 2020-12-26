package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import java.util.regex.*;
import models.*;

public class AdminTopicsServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession(false);

		String nextPage = "admin_welcome.jsp";
		
		if(session!=null){
				

			nextPage = "admin_topics.jsp";
		}		

		request.getRequestDispatcher(nextPage).forward(request,response);
	}
}