/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kadai7;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DeleteKlLogic;
import model.GetKlListLogic;
import model.Kl;
import model.KlDay;
import model.PostKldayLogic;
import model.User;

/**
 *
 * @author g14932nk
 */
//@WebServlet(name = "GiveUp", urlPatterns = {"/GiveUp"})
public class GiveUp extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GiveUp</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GiveUp at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
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
        
        //for(int i = 0;0<klList.size();i++){

        //}
        processRequest(request, response);
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
        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute("loginUser");

        GetKlListLogic getKlListLogic = new GetKlListLogic();
        List<Kl> klList = getKlListLogic.execute(loginUser);

        int totalKl = 0;
        for (int i = 0; 0 < klList.size(); i++) {
            totalKl = totalKl + klList.get(i).getKl();
        }
        String userId = loginUser.getId();
        KlDay klday = new KlDay(userId, totalKl);
        System.out.println("◆1");
        DeleteKlLogic deleteKlLogic = new DeleteKlLogic();
        System.out.println("◆2");
        PostKldayLogic postKldayLogic = new PostKldayLogic();
        postKldayLogic.execute(klday);
        System.out.println("◆3");
        session.setAttribute("klDay", klday);
        System.out.println("◆4");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/giveUp.jsp");
        System.out.println("◆" + request);
        System.out.println("◆" + response);
        dispatcher.forward(request, response);
        
        //processRequest(request, response);
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
