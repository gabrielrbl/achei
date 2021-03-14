package servlet;

import java.io.IOException;
import java.sql.*;
import java.util.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import utils.*;

@WebServlet("/SearchImovel")
public class SearchImovel extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SearchImovel() {
    	super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String tipoNegocio = request.getParameter("tipoNegocio");
	    String tipoImovel = request.getParameter("tipoImovel");

		List<Object> imovel = new ArrayList<Object>();
		
		Connection conn = MyUtils.getStoredConnection(request);
		
		try {
	    	imovel = DBUtils.queryImoveisLocacaoVenda(conn, tipoNegocio, tipoImovel);
		} catch (SQLException e) {
			e.printStackTrace();
			e.getMessage();
		}

		request.setAttribute("imovelList", imovel);
	
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/imoveis.jsp");
		dispatcher.forward(request, response);
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doGet(request, response);
	}
}
