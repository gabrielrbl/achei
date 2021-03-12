package servlet;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import utils.MyUtils;
import model.Usuario;

@WebServlet(urlPatterns = {"/profile"})
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProfileServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    HttpSession session = request.getSession();

	    Usuario usuarioLogado = MyUtils.getLoginedUser(session);
	
		if (usuarioLogado == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
	    }
	
	    request.setAttribute("usuario", usuarioLogado);
	    
	    RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/profile.jsp");
	    dispatcher.forward(request, response);
	}

	@Override
  	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  	doGet(request, response);
  	}
}