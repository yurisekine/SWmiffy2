//package com.sekine.pairpro;

//public class LoginServlet {

//}

package com.sekine.pairpro;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import model.Login;
//import model.LoginLogic;

//@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

  /*  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
        	
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }*/

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
        String fowardPath = null;
  //      String action = request.getParameter("action");
  //      if(action == null) {
   //         fowardPath = "/WEB-INF/jsp/login.jsp";
    //    } else if (action.equals("done")) {
            
           fowardPath = "/WEB-INF/jsp/loginOK.jsp";
  //      }
        RequestDispatcher dispatcher = request.getRequestDispatcher(fowardPath);
       dispatcher.forward(request, response);
        }
        
        //フォワード
       // RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
       // dispatcher.forward(request, response);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);

        //リクエストパラメータの取得
    /*    request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String userId = request.getParameter("userId");
        String pass = request.getParameter("pass");
    */    
 /*       //ログイン処理の実行
        Login login = new Login(name, userId, pass);
        LoginLogic bo = new LoginLogic();
        boolean result = bo.execute(login);
        
        //ログイン処理の成否のよって処理を分岐
        if(result) { //ログイン成功時
            
            //セッションスコープにユーザーIDを保存
            HttpSession session = request.getSession();
            session.setAttribute("userId", userId);
            session.setAttribute("name", name);
            session.setAttribute("login", login);
*/
            //フォワード        
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/loginOK.jsp");
            dispatcher.forward(request, response);
   /*     } else { //ログイン失敗時
            //リダイレクト
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/loginNG.jsp");
            dispatcher.forward(request, response);
            //response.sendRedirect("/salarymanagement/LoginServlet");
        }*/
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
