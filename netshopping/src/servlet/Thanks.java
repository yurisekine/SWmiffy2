package servlet;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.GetMutterListLogic;
import model.Mutter;
import model.PostMutterLogic;
import model.User;

/**
 *
 * @author g14931mh
 */


//@WebServlet(name = "Thanks", urlPatterns = {"/Thanks"})
public class Thanks extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // つぶやきリストを取得して、リクエストスコープに保存
        GetMutterListLogic getMutterListLogic = new GetMutterListLogic();
        List<Mutter> mutterList = getMutterListLogic.execute();
        request.setAttribute("mutterList", mutterList);

        /*
         // つぶやきリストをアプリケーションスコープから取得
         ServletContext application = this.getServletContext();
         List<Mutter> mutterList = (List<Mutter>) application.getAttribute("mutterList");
         // 取得できなかった場合は、つぶやきリストを新規作成して
         // アプリケーションスコープに保存
         if (mutterList == null) {
         mutterList = new ArrayList<Mutter>();
         application.setAttribute("mutterList", mutterList);
         }
         */


        // ログインしているか確認するため
        // セッションスコープからユーザー情報を取得
        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute("loginUser");

        if (loginUser == null) { // ログインしていない場合
            // リダイレクト
            response.sendRedirect("/docoTsubu/");
        } else {  // ログイン済みの場合
            // フォワード
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/thanks.jsp");
            dispatcher.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // リクエストパラメータの取得
        request.setCharacterEncoding("UTF-8");
        String text = request.getParameter("text");

        // 入力値チェック
        if (text != null && text.length() != 0) {

            // セッションスコープに保存されたユーザー情報を取得
            HttpSession session = request.getSession();
            User loginUser = (User) session.getAttribute("loginUser");

            // つぶやきをつぶやきリストに追加
            Mutter mutter = new Mutter(loginUser.getName(),text);
            PostMutterLogic postMutterLogic = new PostMutterLogic();
            postMutterLogic.execute(mutter);

        } else {
            // エラーメッセージをリクエストスコープに保存
            request.setAttribute("errorMsg", "入力できません");
        }
        // つぶやきリストを取得して、リクエストスコープに保存
        GetMutterListLogic getMutterListLogic = new GetMutterListLogic();
        List<Mutter> mutterList = getMutterListLogic.execute();
        request.setAttribute("mutterList", mutterList);

        // フォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/thanks.jsp");
        dispatcher.forward(request, response);
    }
}