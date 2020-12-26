package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import com.google.gson.Gson;
import models.*;
import java.util.ArrayList;

public class CollectTopicsServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
				
		ArrayList<Topic> topics = Topic.collectTopics();

		String topicsStr = new Gson().toJson(topics);

		response.getWriter().write(topicsStr);			
	}
}