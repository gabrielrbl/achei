package servlet;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import utils.MyUtils;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

  	public RegisterServlet() {
  		super();
  	}

  	@Override
  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (MyUtils.getLoginedUser(request.getSession()) != null) {
			response.sendRedirect(request.getContextPath() + "/home");
			return;
		}

		request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);
  	}

  	@Override
  	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  	doGet(request, response);
  	}
}