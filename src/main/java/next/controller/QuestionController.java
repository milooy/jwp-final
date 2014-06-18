package next.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import next.dao.AnswerDao;
import next.dao.QuestionDao;
import next.model.Answer;
import next.model.Question;
import core.mvc.Controller;

public class QuestionController implements Controller {

	public QuestionController()  {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		QuestionDao questionDao = new QuestionDao();
		AnswerDao answerDao = new AnswerDao();
		String writer = request.getParameter("writer");
		String content = request.getParameter("contents");
		long questionId = Long.parseLong(request.getParameter("questionId"));

		Answer answer = new Answer(writer, content, questionId);
		System.out.println(answer);
		answerDao.insert(answer);
//		Question question = questionDao.findById(questionId);
//		long countOfComment = question.getCountOfComment();
//		questionDao.countOfCommentPlus(questionId, countOfComment);
		return "api";
	}

}
