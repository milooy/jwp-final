package next.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import next.dao.QuestionDao;
import next.model.Question;
import core.mvc.Controller;

public class APIController implements Controller{

	public APIController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		QuestionDao questionDao = new QuestionDao();
		List<Question> questions;
		
		
		questions = questionDao.findAll();
		request.setAttribute("questions", questions);

		com.google.gson.Gson gson = new Gson();

		String jsonStr = gson.toJson(questions);
		PrintWriter out = response.getWriter();
		out.println("<html><body>" + jsonStr + "</body></html>"); 
		
		return "api";
	}

}
