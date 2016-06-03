/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.GetMutterListLogic;
import model.Login;
import model.Money;
import model.Mutter;

/**
 *
 * @author g14944sy
 */
@WebServlet(name = "MoneyServlet", urlPatterns = {"/MoneyServlet"})
public class MoneyServlet extends HttpServlet {


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
            out.println("<title>Servlet MoneyServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MoneyServlet at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        String loginUser = (String) session.getAttribute("name");
        if (loginUser == null) { //ログインしていない場合
            //リダイレクト
            response.sendRedirect("/salarymanagement/");
        } else { //ログイン済みの場合



            Login login = (Login) session.getAttribute("login");
            //processRequest(request, response);   
            //リクエストパラメータの取得
            request.setCharacterEncoding("UTF-8");
            GetMutterListLogic bo = new GetMutterListLogic();
            List<Mutter> mutterList = bo.execute();
            double time = 0;

            for (Mutter mutter : mutterList) {
                if ((login.getName()).equals(mutter.getName())) {
                    time = time + mutter.getTime();
                }
            }

            session.setAttribute("time", time);

            AccountDAO dao = new AccountDAO();
            Account account = dao.findByLogin(login);
            session.setAttribute("salary", account.getSalary());
            double allmoney = 0;
            allmoney = time * account.getSalary();
            session.setAttribute("allmoney", allmoney);

        

            //フォワード
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/money.jsp");
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
