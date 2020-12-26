package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;


import models.*;

public class PostQuestionServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		
		User user = (User)session.getAttribute("user");
		
		String nextPage = "login.jsp";

		if(user!=null){
			String questionTitle = request.getParameter("qtitle");
			String questionStr = request.getParameter("question");
			Integer topicId = Integer.parseInt(request.getParameter("topic_id"));

			Question question = new Question();
			
			question.setUser(user);
			question.setPostType(PostType.QUESTION);
			question.setPost(questionStr);
			question.setTitle(questionTitle);
			question.setTopic(new Topic(topicId));

			if(question.saveQuestion()){
				nextPage = "topic_questions.do";
			}else{
				nextPage = "question_form.jsp";
			}
		}		

		request.getRequestDispatcher(nextPage).forward(request,response);
	}
}