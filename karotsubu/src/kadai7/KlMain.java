/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kadai7;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Kl;
import model.PostKlLogic;
import model.User;

/**
 *
 * @author g14932nk
 */
//@WebServlet(name = "KlMain", urlPatterns = {"/KlMain"})
public class KlMain extends HttpServlet {

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
            out.println("<title>Servlet KlMain</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet KlMain at " + request.getContextPath() + "</h1>");
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
        request.setCharacterEncoding("UTF-8");

        String klS = request.getParameter("kl");
        int kl = Integer.parseInt(klS);
        //PreparedStatement pStmt = conn.prepareStatement(sql);
        //String id = request.getParameter("id");
        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute("loginUser");
        String id = loginUser.getId();
        //pStmt.setString(1,id);

        Kl kl2 = new Kl(id, kl);

        //LoginLogic loginLogic = new LoginLogic();
        //boolean isLogin = loginLogic.execute(user);
        //if(isLogin){
        session.setAttribute("klkl", kl2);

        PostKlLogic postKlLogic = new PostKlLogic();
        postKlLogic.execute(kl2);
        //} else {
        //  request.setAttribute("errorMsg","ユーザ登録エラー");
        //}

        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/main.jsp");

        dispatcher.forward(request, response);
        /*
            HttpSession session = request.getSession();
            session.setAttribute("klkl",kl2);
            
            PostKlLogic postKlLogic = new PostKlLogic();
            postKlLogic.execute(kl2);
        //} else {
          //  request.setAttribute("errorMsg","ユーザ登録エラー");
        //}
        
        RequestDispatcher dispatcher =request.getRequestDispatcher("/jsp/main.jsp");
        dispatcher.forward(request, response);*/
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
