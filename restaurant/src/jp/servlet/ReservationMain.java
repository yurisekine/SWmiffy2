/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LinkData;
import model.PMF;
import model.Account;
import model.PostReserveLogic;
import model.Reserve;

/**
 *
 * @author g14940nm
 */
//@WebServlet(name = "ReservationMain", urlPatterns = {"/ReservationMain"})
@SuppressWarnings("serial")
public class ReservationMain extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

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
        // フォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher(
                "/reservation.jsp");
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
                   
          
        // リクエストパラメータの取得
        request.setCharacterEncoding("UTF-8");
        String month = request.getParameter("month");
        String date = request.getParameter("date");
        String reserveDate = month+"-"+date;
        //セッションスコープから値を取り出す
        /*HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        String mail = account.getMail();
        String name = account.getName();*/
        String mail = "aaaa@gmail";
        String name = "やまだ";

        //予約処理の実行
        /*Reserve reserve = new Reserve(mail, reserveDate, name);
        PostReserveLogic prl = new PostReserveLogic();
        boolean result = prl.execute(reserve);

        // 予約処理の成否によって処理を分岐
        /*if (result) { // 予約成功時

            //セッションスコープに予約情報を保存
            session.setAttribute("reserve", reserve);

            // フォワード
            RequestDispatcher dispatcher =
                    request.getRequestDispatcher("/reservationOK.jsp");
            dispatcher.forward(request, response);
        } else { // ログイン失敗時
            RequestDispatcher dispatcher =
                    request.getRequestDispatcher("/reservation.jsp");
            dispatcher.forward(request, response);
        }*/
        
        LinkData data = new LinkData(name,mail,reserveDate);
        PersistenceManagerFactory factory = PMF.get();
        PersistenceManager manager = factory.getPersistenceManager();

        try {
            manager.makePersistent(data);
        } finally {
            manager.close();
        }
        response.sendRedirect("/reservationOK.jsp");

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
