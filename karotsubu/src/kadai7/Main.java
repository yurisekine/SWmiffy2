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
import model.GetMutterListLogic;
import model.Kl;
import model.Mutter;
import model.PostMutterLogic;
import model.User;

/**
 *
 * @author g14932nk
 */
//@WebServlet(name = "Main", urlPatterns = {"/Main"})
public class Main extends HttpServlet {

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
            out.println("<title>Servlet Main</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Main at " + request.getContextPath() + "</h1>");
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
        GetMutterListLogic getMutterListLogic = new GetMutterListLogic();
        List<Mutter> mutterList = getMutterListLogic.execute();
        request.setAttribute("mutterList",mutterList);
        
        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute("loginUser");
        
        if(loginUser == null){
            response.sendRedirect("/Kadai7/");
        }else{
            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/main.jsp");
            dispatcher.forward(request, response);
        }
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
        String text = request.getParameter("text");
        
        if(text != null && text.length() != 0){
            HttpSession session = request.getSession();
            User loginUser = (User)session.getAttribute("loginUser");
            Kl klkl = (Kl)session.getAttribute("klkl");
            System.out.println("****************main 0");
            //String id,String userName,int kl,String text
            
            Mutter mutter = new Mutter(loginUser.getId(),klkl.getKl(),text);
            System.err.println("*****************Main.java"+klkl.getKl());
            System.out.println();
            //Mutter mutter = new Mutter("a","a",1,"a");
            PostMutterLogic postMutterLogic = new PostMutterLogic();
            postMutterLogic.execute(mutter);
        }else{
            request.setAttribute("errorMsg", "つぶやきが入力されていません");
        }
        GetMutterListLogic getMutterListLogic = new GetMutterListLogic();
        List<Mutter> mutterList = getMutterListLogic.execute();
            System.out.println("!!!!!!!!!!!!mutterList"+mutterList.get(0));
        request.setAttribute("mutterList",mutterList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/main.jsp");
        //System.out.println(request);
        System.out.println(response);
        dispatcher.forward(request, response);
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
