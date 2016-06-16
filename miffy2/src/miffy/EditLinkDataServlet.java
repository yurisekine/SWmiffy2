package miffy;

import java.io.IOException;
import java.util.*;
 
import javax.jdo.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
 
public class EditLinkDataServlet extends HttpServlet {
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
        long id = Long.parseLong(req.getParameter("id"));
        String title = req.getParameter("title");
        String url = req.getParameter("url");
        String comment = req.getParameter("comment");
        String name = req.getParameter("name");
        String place = req.getParameter("place");
        String time = req.getParameter("time");
        
        javax.jdo.PersistenceManagerFactory factory = PMF.get();
        javax.jdo.PersistenceManager manager = factory.getPersistenceManager();
        //PersistenceManagerFactory factory = PMF.get();
        //PersistenceManager manager = factory.getPersistenceManager();
        LinkData data = (LinkData)manager.getObjectById(LinkData.class,id);
        data.setTitle(title);
        data.setUrl(url);
        data.setComment(comment);
        data.setName(name);
        data.setPlace(place);
        data.setTime(time);
        manager.close();
        resp.sendRedirect("/index.html");
    }
}