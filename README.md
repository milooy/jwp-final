

   * 8080접근 web.xml에선 welcome-file로 index.jsp보냄
   * index.jsp에서 “/list.next”로 리다이렉트됨
   * web.xml에선 *.next는 FrontController서블릿으로 보냄
   * RequestMapping을 선언하고 거기에 sevletContext를 넣어둠
   * frontControllerservlet에서 redirect로 온것 알아채고
   * url을 urlExceptParameter로 잘라 알아내서 
   * 그 잘라낸 url 의 이름과 같은 파일로 req, resp와 함께 보낸다(list.jsp)
   * list.jsp에 가서 listController에서 보낸 question을 받아
   * 각각의 questions들의 Question.java라는 모델에서 questionId, createdDate, writer를 받아와서 보여줌.
   * listController에선 questions를 보냄
   * showController에선 question, answers 보냄
