package database;

import java.io.IOException;
import java.net.URL;
import java.util.*;
 
import javax.jdo.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class Mutter extends HttpServlet {

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
    	System.out.println("a");
        req.setCharacterEncoding("UTF-8");
        String title = req.getParameter("title");
        String url = req.getParameter("url");
        String comment = req.getParameter("comment");
        Date date = Calendar.getInstance().getTime();
        MutterData mutterdata = new MutterData(title,url,comment,date);
        PersistenceManagerFactory factory = PMF.get();
        PersistenceManager manager = factory.getPersistenceManager();
        try {
            manager.makePersistent(mutterdata);
        } finally {
            manager.close();
        }
        resp.sendRedirect("/talk.jsp");
    }
	
}
