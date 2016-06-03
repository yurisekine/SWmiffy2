package com.sekine.pairpro;

import java.io.IOException;
import java.net.URL;
import java.util.*;
 
import javax.jdo.*;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class AttendServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	 
	    @Override
	    protected void doGet(HttpServletRequest req,
	            HttpServletResponse resp)
	            throws ServletException, IOException {
	        resp.setContentType("text/plain");
	        resp.getWriter().println("no url...");
	    }
	 
	    @Override
	    protected void doPost(HttpServletRequest req,
	            HttpServletResponse resp)
	            throws ServletException, IOException {
	    	resp.setCharacterEncoding("UTF-8");
			resp.setContentType("text/html");
	        req.setCharacterEncoding("UTF-8");
	        String day = req.getParameter("day");
	        double time = Double.parseDouble(req.getParameter("time"));
	        //Date date = Calendar.getInstance().getTime();
	     /*   ServletContext application = this.getServletContext();
			application.setAttribute("day", day);
			application.setAttribute("time", time);
			*/
	        Data data = new Data(day, time);
	        PersistenceManagerFactory factory = PMF.get();
	        PersistenceManager manager = factory.getPersistenceManager();
	        
	        try {
	            manager.makePersistent(data);
	        } finally {
	            manager.close();
	        }
	        resp.sendRedirect("/index.html");
	        		//attendOK.jsp");
	    }
 /*   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    @Override
doGet   
        //リストを取得して、リクエストスコープに保存
        GetMutterListLogic getMutterListLogic = new GetMutterListLogic();
        List<Mutter> mutterList = getMutterListLogic.execute();
        request.setAttribute("mutterList", mutterList);
        
                //リストをアプリケーションスコープから取得
        ServletContext application = this.getServletContext();
        //List<Mutter> mutterList = (List<Mutter>) application.getAttribute("mutterList");
        //取得できなかった場合は、リストを新規作成して
        //アプリケーションスコープに保存
        if(mutterList == null) {
            mutterList = new ArrayList<Mutter>();
            application.setAttribute("mutterList",mutterList);
        }    
        //ログインしているか確認するため
        //セッションスコープからユーザー情報を取得
        HttpSession session = request.getSession();
        String loginUser = (String) session.getAttribute("name");
        
        if(loginUser == null) { //ログインしていない場合
            //リダイレクト
            response.sendRedirect("/salarymanagement/");
        } else { //ログイン済みの場合
            //フォワード
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/attend.jsp");
            dispatcher.forward(request, response);        
        } 
    }

doPost 
        //リクエストパラメータの取得
        request.setCharacterEncoding("UTF-8");
        String day = request.getParameter("day");
        double time = Double.parseDouble(request.getParameter("time"));
       
        //入力値チェック
        if(day != null && day.length() != 0) {
            
            //セッションスコープに保存されたユーザー情報を取得
            HttpSession session = request.getSession();
            String loginUser = (String) session.getAttribute("name");
            
            //入力をリストに追加
            Mutter mutter = new Mutter(loginUser, day, time);
            PostMutterLogic postMutterLogic = new PostMutterLogic();
            postMutterLogic.execute(mutter);
                
            //リストを取得して、リクエストスコープの保存
            GetMutterListLogic getMutterListLogic = new GetMutterListLogic();
            List<Mutter> mutterList = getMutterListLogic.execute();
            request.setAttribute("mutterList", mutterList);
            
            //アプリケーションスコープにつぶやきリストを保存
            //application.setAttribute("mutterList", mutterList);
        } else {
            //エラーメッセージをリクエストスコープに保存
            request.setAttribute("errorMsg" , "エラー");
        }
        
       //フォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/attendOK.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>*/
	
}
