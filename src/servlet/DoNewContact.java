package servlet;

import java.io.IOException;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import utils.*;
import model.*;

@WebServlet("/doNewContact")
public class DoNewContact extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DoNewContact() {
		super();
	}

	@Override
  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (MyUtils.getLoginedUser(request.getSession()) == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		
		String tipo = request.getParameter("tipo");
		String contato = request.getParameter("contato");
		
		Usuario usuario = MyUtils.getLoginedUser(request.getSession());
		
		Connection conn = MyUtils.getStoredConnection(request);
		
		UsuarioContato uc = null;
		
		try {
			uc = new UsuarioContato();
			uc.setUsuario(usuario);
			uc.setTipo(tipo);
			uc.setContato(contato);
			
			uc.setIdusuariocontato(DBUtils.insertUsuarioContato(conn, uc));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		response.sendRedirect(request.getContextPath() + "/profile");
	}
}