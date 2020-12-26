package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;


import models.*;

public class ShowQuestionFormServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		
		User user = (User)session.getAttribute("user");

		String nextPage = "login.jsp";
		
		if(user!=null){
			nextPage = "question_form.jsp";
		}				

		request.getRequestDispatcher(nextPage).forward(request,response);
	}
}