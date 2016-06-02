 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appli;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import appli.PMF;
import javax.servlet.http.*;
import model.Order;
import model.User;
import java.io.*;
import java.util.*;
import javax.jdo.*;
/**
 *
 * @author g13953ts
 */

public class Main extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    	
    	 PersistenceManagerFactory factory = PMF.get();
         PersistenceManager manager = factory.getPersistenceManager();
         resp.setCharacterEncoding("UTF-8");
         resp.setContentType("text/html");
         req.setCharacterEncoding("utf-8");
         String param1 = req.getParameter("clothes[]");
         PrintWriter out = resp.getWriter();
         List<Order> list = null;
         if (param1 == null || param1 ==""){
             String query = "select from " + Order.class.getName();
             try {
                 list = (List<Order>)manager.newQuery(query).execute();
                 req.setAttribute("list", list);
             } catch(JDOObjectNotFoundException e){}
         } else {
             try {
                 Order data = (Order)manager.getObjectById(Order.class,Long.parseLong(param1));
                 list = new ArrayList();
                 list.add(data);
             } catch(JDOObjectNotFoundException e){}
         }
         String res = "[";
         if (list != null){
        	 
             for(Order data:list){
                 res += "{id:" + data.getId() + "clothes:'" +data.getClothes()  + "'},";
             }
         }
         res += "]";
         out.println(res);
         manager.close();
     

    	
    	
    	//String query = "select from " + Order.class.getName();
    	   	
       // List<Order> orderList = getOrder.execute();
        

        HttpSession session = req.getSession();
        String userId = (String) session.getAttribute("userId");
        
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
            dispatcher.forward(req, resp);
        
        //processRequest(request, response);
    }


    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
      	 PersistenceManagerFactory factory = PMF.get();
         PersistenceManager manager = factory.getPersistenceManager();
    	req.setCharacterEncoding("UTF-8");
        String param1 = req.getParameter("clothes[]");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        

        /*if (clothes != null && clothes.length() != 0) {
            HttpSession session = req.getSession();
            String userId = (String) session.getAttribute("userId");
            Order order = new Order(userId, clothes);
            PostOrderLogic postOrderLogic = new PostOrderLogic();
            postOrderLogic.execute(order);
            GetOrderListLogic getOrderListLogic = new GetOrderListLogic();
            List<Order> orderList = getOrderListLogic.execute();
            req.setAttribute("orderList", orderList);
        } else {
            req.setAttribute("errorMsg", "注文が入力されていません。");
        }
        reqDispatcher dispatcher = req.getreqDispatcher("/WEB-INF/jsp/main2.jsp");
        dispatcher.forward(req, resp);*/
    	
 
     List<Order> list = null;
     if (param1 == null || param1 ==""){
         String query = "select from " + Order.class.getName();
         try {
             list = (List<Order>)manager.newQuery(query).execute();
             req.setAttribute("list", list);
         } catch(JDOObjectNotFoundException e){}
     } else {
         try {
             Order data = (Order)manager.getObjectById(Order.class,Long.parseLong(param1));
             list = new ArrayList();
             list.add(data);
         } catch(JDOObjectNotFoundException e){}
     }
     String res = "[";
     if (list != null){
         for(Order data:list){
             res += "{id:" + data.getId() + "clothes:'" +data.getClothes()  + "'},";
         }
     }
     res += "]";
     out.println(res);
     manager.close();
 

    HttpSession session = req.getSession();
    String userId = (String) session.getAttribute("userId");
    
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/main2.jsp");
        dispatcher.forward(req, resp);
        
     /*   request.setCharacterEncoding("UTF-8");
        String clothes = request.getParameter("clothes[]");

        if (clothes != null && clothes.length() != 0) {
            HttpSession session = request.getSession();
            String userId = (String) session.getAttribute("userId");
            Order order = new Order(userId, clothes);
            PostOrderLogic postOrderLogic = new PostOrderLogic();
            postOrderLogic.execute(order);
            GetOrderListLogic getOrderListLogic = new GetOrderListLogic();
            List<Order> orderList = getOrderListLogic.execute();
            request.setAttribute("orderList", orderList);
        } else {
            request.setAttribute("errorMsg", "注文が入力されていません。");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main2.jsp");
        dispatcher.forward(request, response);
        //processRequest(request, response);*/
    	/*  req.setCharacterEncoding("UTF-8");
          int id = Integer.parseInt(req.getParameter("id"));
          String name = req.getParameter("name");
          String clothes = req.getParameter("clothes");
          Date date = Calendar.getInstance().getTime();
          Order data = new Order(id,name,clothes);
          PersistenceManagerFactory factory = PMF.get();
          PersistenceManager manager = factory.getPersistenceManager();
          try {
              manager.makePersistent(data);
          } finally {
              manager.close();
          }
          resp.sendRedirect("/index.html");
      }
    	

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>*/
    }
}
