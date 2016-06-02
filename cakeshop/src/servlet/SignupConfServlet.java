package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Cart;
import model.GetAccountListLogic;
import model.GetCartListLogic;
import model.PostAccountLogic;

public class SignupConfServlet extends HttpServlet {

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
            out.println("<title>Servlet SignupConfServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SignupConfServlet at " + request.getContextPath() + "</h1>");
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
        GetAccountListLogic getAccountListLogic =
                new GetAccountListLogic();
        List<Account> accountList = getAccountListLogic.execute();
        request.setAttribute("accountList", accountList);
         //登録完了画面にフォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signupConf.jsp");
        dispatcher.forward(request,response);
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
        //リクエストパラメータの取得
        request.setCharacterEncoding("UTF-8");
        String name =request.getParameter("name");
        String userId =request.getParameter("userId");
        String pass =request.getParameter("pass");
        String mail =request.getParameter("mail");
        String tell =request.getParameter("tell");
        String address =request.getParameter("address");
        
        if(userId != null && userId.length() != 0){
            //セッションスコープに保存されたユーザー情報を取得
            HttpSession session = request.getSession();
            session.setAttribute("name", name);
            session.setAttribute("userId", userId);
            session.setAttribute("pass", pass);
            session.setAttribute("mail", mail);
            session.setAttribute("tell", tell);
            session.setAttribute("address", address);
            Account Account = (Account) session.getAttribute("Account"); 
            
            Account account = new Account(name, userId, pass, mail, tell, address);
            PostAccountLogic PostAccountLogic = new PostAccountLogic();
            PostAccountLogic.execute(account);
            
            //リクエストスコープに保存
            GetAccountListLogic getAccountListLogic = new GetAccountListLogic();
            List<Account> accountList = getAccountListLogic.execute();
            request.setAttribute("accountList", accountList);
        }
        //登録完了画面にフォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signupConf.jsp");
        dispatcher.forward(request,response);
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
