package com.sekine.pairpro;
/*
import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class PairProServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
	}
}
*/

//import java.io.IOException;
//import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.util.*;
 
import javax.jdo.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class PairProServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    /*    HttpSession session = request.getSession();
        RequestDispatcher dispatcher = request.getRequestDispatcher("/top.jsp");
        dispatcher.forward(request, response);*/
        
        PersistenceManagerFactory factory = PMF.get();
        PersistenceManager manager = factory.getPersistenceManager();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        request.setCharacterEncoding("utf-8");
        String param1 = request.getParameter("id");
        PrintWriter out = response.getWriter();
        List<Data> list = null;
        if (param1 == null || param1 ==""){
            String query = "select from " + Data.class.getName();
            try {
                list = (List<Data>)manager.newQuery(query).execute();
            } catch(JDOObjectNotFoundException e){}
        } else {
            try {
                Data data = (Data)manager.getObjectById(Data.class,Long.parseLong(param1));
                list = new ArrayList();
                list.add(data);
            } catch(JDOObjectNotFoundException e){}
        }
        String res = "[";
        if (list != null){
            for(Data data:list){
                res += "{id:" + data.getId() + ",day:" + data.getDay() + ",time:'" + data.getTime() + "'},";
            }
        }
        res += "]";
        out.println(res);
        manager.close();
    }
    


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
