package servlet;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import utils.MyUtils;
import model.Usuario;

@WebServlet(urlPatterns = {"/userInfo"})
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserInfoServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    HttpSession session = request.getSession();

	    // Check User has logged on
	    Usuario usuarioLogado = MyUtils.getLoginedUser(session);
	
	    // Not logged in
		if (usuarioLogado == null) {
	      // Redirect to login page.
			response.sendRedirect(request.getContextPath() + "/login");
			return;
	    }
	
	    // Store info in request attribute
	    request.setAttribute("usuario", usuarioLogado);
	
	    // Logined, forward to /WEB-INF/views/userInfoView.jsp
	    RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/userInfoView.jsp");
	    dispatcher.forward(request, response);
	}

	@Override
  	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  	doGet(request, response);
  	}
}