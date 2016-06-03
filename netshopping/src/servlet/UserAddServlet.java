/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.AccountLogic;
import model.Login;

/**
 *
 * @author HANANO
 */
//@WebServlet(name = "UserAddServlet", urlPatterns = {"/UserAddServlet"})
public class UserAddServlet extends HttpServlet {


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    RequestDispatcher dispatcher = request.getRequestDispatcher(
        "/WEB-INF/jsp/useradd.jsp");
    dispatcher.forward(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
    // リクエストパラメータの取得
    request.setCharacterEncoding("UTF-8");
    String userId = request.getParameter("userId");
    String pass = request.getParameter("pass");
    String mail= request.getParameter("mail");
    String name = request.getParameter("name");
    int age = Integer.parseInt(request.getParameter("age"));
  

    Account account = new Account(userId, pass, mail,name,age);
    AccountLogic al = new AccountLogic();
    boolean result = al.addUser(account);

    // ログイン処理の成否によって処理を分岐
    if (result) { // ログイン成功時

      // セッションスコープにユーザーIDを保存
      HttpSession session = request.getSession();
      session.setAttribute("userId", userId);

      // フォワード
      RequestDispatcher dispatcher =
          request.getRequestDispatcher("/WEB-INF/jsp/useraddOK.jsp");
      dispatcher.forward(request, response);
      
    } else { // ログイン失敗時
        HttpSession session = request.getSession();
        session.setAttribute("userId", null);
 
         // リダイレクト
      response.sendRedirect("/15ad14hint/UserAddServlet");
    }
    }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
