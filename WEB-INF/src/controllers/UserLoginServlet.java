package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import java.util.regex.*;
import models.*;

public class UserLoginServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		String nextPage = "login.jsp";

		String email = request.getParameter("email").trim();
		String password = request.getParameter("password").trim();

		//Validation:
		boolean flag = true;
		String errMsg = "";

		Pattern p = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$");
		Matcher m = p.matcher(email);

		if(!m.matches()){
			flag = false;
			errMsg += "Email is incorrect...<br />";
		}

		
		int len = password.length();
		if(len<6||len>12){
			flag = false;
			errMsg += "Invalid Password...<br />";
		}

		if(flag){
			User user = new User(email,password); 
			if(user.loginUser()){
				nextPage = "index.jsp";
				session.setAttribute("user",user);
			}else{
				errMsg = "Either Email or Password is incorrect...";
				request.setAttribute("err_msg",errMsg);
			}
		}else{
			request.setAttribute("err_msg",errMsg);
		}

		request.getRequestDispatcher(nextPage).forward(request,response);
	}
}