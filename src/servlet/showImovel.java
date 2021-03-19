package servlet;

import java.io.IOException;
import java.sql.*;
import java.util.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import utils.*;
import model.*;

public class showImovel extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public showImovel() {
        super();
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pathInfo = request.getPathInfo();
		String[] pathParts = pathInfo.split("/");
		Integer idimovel = Integer.parseInt(pathParts[1]);
		
		Object imovel = null;
		List<UsuarioContato> responsavelContatos = null;

		Connection conn = MyUtils.getStoredConnection(request);
		
		try {
			imovel = DBUtils.queryImovel(conn, DBUtils.queryFindImovelId(conn, idimovel));
			responsavelContatos = DBUtils.queryFindUsuarioContatosIdImovel(conn, idimovel);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("imovel", imovel);
		request.setAttribute("responsavelContatos", responsavelContatos);
		
	    RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/showImovel.jsp");
	    
	    dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
