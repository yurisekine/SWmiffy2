package com.pair.paircourse;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TimetableServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/plain");
        resp.getWriter().println("no url...");
	}
	
	protected void doPost(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        long id = Long.parseLong(req.getParameter("id"));
        PersistenceManagerFactory factory = PMF.get();
        PersistenceManager manager = factory.getPersistenceManager();
        Student data = (Student) manager.getObjectById(Student.class,id);
        //Lesson data = (Lesson)manager.getObjectById(Lesson.class,id);
        try{
        	manager.makePersistent(data);
        }finally{
        	manager.close();
        }
        resp.sendRedirect("/timetable.jsp");
    }
}
