/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appli;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.GetRegisterLogic;
import model.RegisterUserLogic;
import model.User;

/**
 *
 * @author g13953ts
 */
public class RegisterUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //フォワード先
        String forwardPath = null;

        //サーブレットクラスの動作を決定する「action」の値をリクエストパラメターから取得
        String action = request.getParameter("action");

        //「登録の開始」をリクエストされたときの処理
        if (action == null) {
            forwardPath = "/WEB-INF/jsp/registerForm.jsp";
        } else if (action.equals("done")) { //登録確認画面から「登録実行」をリクエストされたときの登録ユーザーを取得
            HttpSession session = request.getSession();
            User register = (User) session.getAttribute("registerUser");
            User registerUser = new User(register.getUserId(), register.getPass(), register.getMail(), register.getName());
            RegisterUserLogic registerUserLogic = new RegisterUserLogic();
            registerUserLogic.execute(registerUser);

            GetRegisterLogic getRegisterLogic = new GetRegisterLogic();
            List<User> userList = getRegisterLogic.execute();
            request.setAttribute("userList", userList);

            //登録後のフォワード先の設定
            forwardPath = "/WEB-INF/jsp/registerDone.jsp";
        }
        //設定されたフォワード先にフォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
        dispatcher.forward(request, response);
        //processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //リクエストパラメタの取得
        request.setCharacterEncoding("UTF-8");
        String userId = request.getParameter("userId");
        String pass = request.getParameter("pass");
        String mail = request.getParameter("mail");
        String name = request.getParameter("name");

        //登録するユーザーの情報を設定
        User registerUser = new User(userId, pass, mail, name);

        //セッションスコープに登録ユーザーを保存
        HttpSession session = request.getSession();
        session.setAttribute("registerUser", registerUser);

        //フォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registerConfirm.jsp");
        dispatcher.forward(request, response);
        //processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
