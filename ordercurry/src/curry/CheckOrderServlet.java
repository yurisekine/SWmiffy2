package curry;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
 
import javax.jdo.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings({ "serial", "unused" })
public class CheckOrderServlet extends HttpServlet {
	public String hour, minute;
    public ArrayList<OrderData> orderList = new ArrayList<OrderData>();
    public ArrayList<String> pid = new ArrayList<String>();
    public ArrayList<String> q = new ArrayList<String>();
	
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String[] product = request.getParameterValues("product");
        String[] quantity = new String[11];
        hour = request.getParameter("hour");
        minute = request.getParameter("minute");
        
        for (int i = 0; i < 11; i++) {
            if (!"".equals(request.getParameter("q"+i)) || !"0".equals(request.getParameter("q"+i))) {
                quantity[i] = request.getParameter("q"+i);
            }
        }
        int count = 0;
        q.clear();
        orderList.clear();
        for (int i = 0; i < 11; i++) {
            if (quantity[i] != "") {
                count++;
                q.add(quantity[i]);
            }
        }

        	
		for (int i = 0; i < product.length; i++) {
			System.out.println(product[i] + q.get(i) + hour+":"+minute);
			pid.add(product[i]);
			Date date = Calendar.getInstance().getTime();
			OrderData data = new OrderData(product[i], q.get(i), hour + ":" + minute, date);
			PersistenceManagerFactory factory = PMF.get();
			PersistenceManager manager = factory.getPersistenceManager();

			try {
				manager.makePersistent(data);
			} finally {
				manager.close();
			}

		}

		/*
		 * for (int i = 0; i < 11; i++) { String[] productId =
		 * request.getParameterValues("product"); String quantity =
		 * request.getParameter("q" + i); String deliverytime =
		 * request.getParameter("hour"); Date date =
		 * Calendar.getInstance().getTime(); OrderData data = new
		 * OrderData(productId[i], quantity, deliverytime, date);
		 * 
		 * PersistenceManagerFactory factory = PMF.get(); PersistenceManager
		 * manager = factory.getPersistenceManager();
		 * 
		 * try { manager.makePersistent(data); } finally { manager.close(); } }
		 */
		response.sendRedirect("/showOrder.html");
	}
}
