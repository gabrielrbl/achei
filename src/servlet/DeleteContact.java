package servlet;

import java.io.IOException;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import utils.*;

@WebServlet("/DeleteContato")
public class DeleteContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteContact() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer idUsuarioContato = Integer.parseInt(request.getParameter("idUsuarioContato"));

		Connection conn = MyUtils.getStoredConnection(request);
		
		try {
	    	DBUtils.deleteUsuarioContato(conn, idUsuarioContato);
		} catch (SQLException e) {
			e.printStackTrace();
			e.getMessage();
		}
		
		response.sendRedirect(request.getContextPath() + "/profile");
    }
}
