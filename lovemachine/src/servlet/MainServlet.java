package servlet;

//import java.io.IOException;
import java.io.*;
import java.util.*;
import javax.jdo.*;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletContext;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import model.GetMutterListLogic;
//import model.Login;
import database.MutterData;
import database.PMF;
//import model.PostMutterLogic;
//import model.UserId;

//@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})

@SuppressWarnings("serial")

public class MainServlet extends HttpServlet {

	
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    		//throws IOException {
        
		PersistenceManagerFactory factory = PMF.get();
        PersistenceManager manager = factory.getPersistenceManager();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        request.setCharacterEncoding("utf-8");
        String param1 = request.getParameter("id");
        PrintWriter out = response.getWriter();
        List<MutterData> list = null;
        if (param1 == null || param1 ==""){
            String query = "select from " + MutterData.class.getName();
            try {
                list = (List<MutterData>)manager.newQuery(query).execute();
            } catch(JDOObjectNotFoundException e){}
        } else {
            try {
                MutterData data = (MutterData)manager.getObjectById(MutterData.class,Long.parseLong(param1));
                list = new ArrayList();
                list.add(data);
            } catch(JDOObjectNotFoundException e){}
        }
        String res = "[";
        if (list != null){
            for(MutterData data:list){
                res += "{id:" + data.getId() + ",url:'" + data.getUrl() + "',title:'" +
                    data.getTitle() + "',date:'" + data.getDatetime() +
                    "',comment:'" + data.getComment() + "'},";
            }
        }
        res += "]";
        out.println(res);
        manager.close();
		
        //GetMutterListLogic getMutterListLogic = new GetMutterListLogic();
        //List<Mutter> mutterList = getMutterListLogic.execute();
        //request.setAttribute("mutterList", mutterList);

        //HttpSession session = request.getSession();
        
        //Login log = (Login) session.getAttribute("id");
        
       /* RequestDispatcher dispatcher = request.getRequestDispatcher("/talk.jsp");
        dispatcher.forward(request, response);*/
    }

	//@Override
    /*protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
        String title = request.getParameter("title");
        String url = request.getParameter("url");
        String comment = request.getParameter("comment");
        Date date = Calendar.getInstance().getTime();
        MutterData data = new MutterData(title,url,comment,date);
        PersistenceManagerFactory factory = PMF.get();
        PersistenceManager manager = factory.getPersistenceManager();
        try {
            manager.makePersistent(data);
        } finally {
            manager.close();
        }
        response.sendRedirect("/index.html");
	}
        
        request.setCharacterEncoding("UTF-8");
        String text = request.getParameter("text");

        if (text != null && text.length() != 0) {
            ServletContext application = this.getServletContext();
            List<Mutter> mutterList = (List<Mutter>) application.getAttribute("mutterList");

            HttpSession session = request.getSession();
            //UserId loginUser = (UserId) session.getAttribute("loginUser");
            //Login userId = (Login) session.getAttribute("userId");
            //String user = (String) session.getAttribute("id");
            Login login = (Login) session.getAttribute("id");
            
            Mutter mutter = new Mutter(login.getId(), text);
            //Mutter mutter = new Mutter(user, text);
            PostMutterLogic postMutterLogic = new PostMutterLogic();
            postMutterLogic.execute(mutter);

        } else {  
        	request.setAttribute("errorMsg", "つぶやきが入力されていません");
        }
        
        GetMutterListLogic getMutterListLogic = new GetMutterListLogic();
        List<Mutter> mutterList = getMutterListLogic.execute();
        request.setAttribute("mutterList", mutterList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/talk.jsp");
        dispatcher.forward(request, response); 
	}*/
	
	 @Override
	    public String getServletInfo() {
	        return "Short description";
	    }// </editor-fold>
	 
}
