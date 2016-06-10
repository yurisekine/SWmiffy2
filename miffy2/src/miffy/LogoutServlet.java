package miffy;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class LogoutServlet extends HttpServlet{
	@Override
	  public void doGet(HttpServletRequest req, HttpServletResponse resp)
	        throws IOException {
		 UserService userService = UserServiceFactory.getUserService();

		    String thisUrl = req.getRequestURI();
		    if (req.getUserPrincipal() != null) {
	      resp.getWriter().println("<p>Hello, "
	          + req.getUserPrincipal().getName()
	          + "!  You can <a href=\""
	          + userService.createLogoutURL(thisUrl)
	          + "\">sign out</a>.</p>");  //ログアウトサーブレット作成して、中に書く
		    } else {
		    	resp.sendRedirect("login");
		    }
	}
}
