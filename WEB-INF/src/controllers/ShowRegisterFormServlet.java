package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import java.util.regex.*;
import models.*;

public class ShowRegisterFormServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		String nextPage = "register_form.jsp";

				

		request.getRequestDispatcher(nextPage).forward(request,response);
	}
}