package next.controller;

import java.util.List;

import next.model.Answer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import next.dao.AnswerDao;
import next.dao.QuestionDao;
import next.model.Answer;
import next.model.Question;
import core.mvc.Controller;

public class ShowController implements Controller {
//	private QuestionDao questionDao = new QuestionDao();
//	private AnswerDao answerDao = new AnswerDao();
//	private Question question;
//	private List<Answer> answers;
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		QuestionDao questionDao = new QuestionDao();
		AnswerDao answerDao = new AnswerDao();
		Question question;
		List<Answer> answers;
		
		long questionId = Long.parseLong(request.getParameter("questionId"));
		question = questionDao.findById(questionId);
		answers = answerDao.findAllByQuestionId(questionId);
		
		
		request.setAttribute("question", question);
		request.setAttribute("answers", answers);
		return "show.jsp";
	}
}
