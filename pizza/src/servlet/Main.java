/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import model.LoginLogic;
import select.OrderLogic;
import select.OrderModel;

/**
 *
 * @author g14950tk
 */
@WebServlet(name = "Main", urlPatterns = {"/Main"})
public class Main extends HttpServlet {

    private static final long serialVersionUID = 1L;

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
        RequestDispatcher dispatcher = request.getRequestDispatcher(
                "/WEB-INF/jsp/main.jsp");
        dispatcher.forward(request, response);
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
        request.setCharacterEncoding("UTF-8");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
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

        request.setCharacterEncoding("UTF-8");
        String pizza = request.getParameter("pizza");
        /*String price1 = request.getParameter("price");
        int price = Integer.parseInt(price1);*/
        int price = 0;
        
        if(pizza.equals("1")){ pizza = "マルゲリータ S"; price = 1500;}
        if(pizza.equals("2")){ pizza = "マルゲリータ M"; price = 1800; }
        if(pizza.equals("3")){ pizza = "マルゲリータ L"; price = 2100;}
        if(pizza.equals("4")){ pizza = "クワトロ S"; price = 1800;}
        if(pizza.equals("5")){ pizza = "クワトロ M"; price = 2200;}
        if(pizza.equals("6")){ pizza = "クワトロ L"; price = 2900;}
        if(pizza.equals("7")){ pizza = "シーフード S"; price = 1600;}
        if(pizza.equals("8")){ pizza = "シーフード M"; price = 2000;}
        if(pizza.equals("9")){ pizza = "シーフード L"; price = 2500;}
        if(pizza.equals("10")){ pizza = "照り焼き S"; price = 1750;}
        if(pizza.equals("11")){ pizza = "照り焼き M"; price = 2400;}
        if(pizza.equals("12")){ pizza = "照り焼き L"; price = 2900;}
        if(pizza.equals("13")){ pizza = "四種のチーズ S"; price = 1800;}
        if(pizza.equals("14")){ pizza = "四種のチーズ M"; price = 2100;}
        if(pizza.equals("15")){ pizza = "四種のチーズ L"; price = 2500;}
        
        OrderModel ordermodel = new OrderModel(pizza,price);
        OrderLogic ol = new OrderLogic();
        boolean result = ol.execute(ordermodel);

        if (result) {
            HttpSession session = request.getSession();
            session.setAttribute("pizza", pizza);
            session.setAttribute("price", price);
            

            RequestDispatcher dispatcher =
                    request.getRequestDispatcher(
                    "/WEB-INF/jsp/decision.jsp");
            dispatcher.forward(request, response);

        } else {
            //HttpSession session = request.getSession();
            //session.setAttribute("pizza", pizza);
            //session.setAttribute("price", price);
            
            
            RequestDispatcher dispatcher =
                    request.getRequestDispatcher(
                    "/WEB-INF/jsp/main.jsp");
            dispatcher.forward(request, response);
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
