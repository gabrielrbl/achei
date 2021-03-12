package servlet;

import java.io.IOException;
import jakarta.servlet.*;
import java.util.*;
import model.Imovel;
import java.sql.*;
import utils.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet(urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HomeServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    Connection conn = MyUtils.getStoredConnection(request);
	    
	    String errorString = null;
		List<Imovel> list = null;

	    try {
	    	list = DBUtils.queryImoveis(conn);
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    	errorString = e.getMessage();
	    }

	    request.setAttribute("errorString", errorString);
	    request.setAttribute("imovelList", list);

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/home.jsp");

		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}