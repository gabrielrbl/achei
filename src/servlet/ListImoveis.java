package servlet;

import java.io.IOException;
import jakarta.servlet.*;
import java.util.*;

import java.sql.*;
import utils.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/userImoveis")
public class ListImoveis extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListImoveis() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (MyUtils.getLoginedUser(request.getSession()) == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}

	    Connection conn = MyUtils.getStoredConnection(request);

	    String errorString = null;
		List<Object> imovel = null;

	    try {
	    	imovel = DBUtils.queryFindImoveisUsuario(conn, MyUtils.getLoginedUser(request.getSession()));
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    	errorString = e.getMessage();
	    }

	    request.setAttribute("errorString", errorString);
	    request.setAttribute("imovelList", imovel);

	  	RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/userImoveis.jsp");

	  	dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}