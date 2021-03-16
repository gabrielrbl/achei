package servlet;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import utils.MyUtils;

@WebServlet("/addImovel")
public class AddImovel extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddImovel() {
    	super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (MyUtils.getLoginedUser(request.getSession()) == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}

    	RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/newImovel.jsp");

		dispatcher.forward(request, response);
	}
    
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
