package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import java.util.regex.*;
import models.*;

public class RegisterServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		String nextPage = "register_form.jsp";
		
		String userName = request.getParameter("user_name").trim();
		String email = request.getParameter("email").trim();
		String password = request.getParameter("password").trim();
		String rePassword = request.getParameter("repassword").trim();

		//Validation:
		boolean flag = true;
		String errMsg = "";

		if(userName.equals("")){
			flag = false;
			errMsg += "Invalid User Name...<br />";
		}

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

		if(!password.equals(rePassword)){
			flag = false;
			errMsg += "Password & Re-Password must match... <br />";
		}

		if(flag){
			User user = new User(userName,email,password); 
			if(user.registerUser()){
				nextPage = "login.jsp";
			}else{
				errMsg = "An account with same email already exists...";
				request.setAttribute("err_msg",errMsg);
			}
		}else{
			request.setAttribute("err_msg",errMsg);
		}

		request.getRequestDispatcher(nextPage).forward(request,response);
	}
}