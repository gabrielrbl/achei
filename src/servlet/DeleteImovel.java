package servlet;

import java.io.IOException;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import utils.*;

@WebServlet("/DeleteImovel")
public class DeleteImovel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteImovel() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer idImovel = Integer.parseInt(request.getParameter("idImovel"));

		Connection conn = MyUtils.getStoredConnection(request);
		
		try {
	    	DBUtils.deleteImovel(conn, idImovel);
		} catch (SQLException e) {
			e.printStackTrace();
			e.getMessage();
		}

		response.sendRedirect(request.getContextPath() + "/userImoveis");
    }
}
