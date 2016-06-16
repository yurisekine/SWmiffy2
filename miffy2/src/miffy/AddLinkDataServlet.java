package miffy;

import java.io.IOException;
import java.net.URL;
import java.util.*;
 
import javax.jdo.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
 
public class AddLinkDataServlet extends HttpServlet {
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
        req.setCharacterEncoding("UTF-8");
        String title = req.getParameter("title");
        String url = req.getParameter("url");
        String comment = req.getParameter("comment");
        Date date = Calendar.getInstance().getTime();
        String name = req.getParameter("name");
        String place = req.getParameter("place");
        String time = req.getParameter("time");
        LinkData data = new LinkData(title,url,comment,date,name,place,time);
        
        //PersistenceManagerFactory factory = PMF.get();
        javax.jdo.PersistenceManagerFactory factory = PMF.get();
        javax.jdo.PersistenceManager manager = factory.getPersistenceManager();
        //PersistenceManager manager = factory.getPersistenceManager();
        
        try {
            manager.makePersistent(data);
        } finally {
            manager.close();
        }
        resp.sendRedirect("/index.html");
    }
}