package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import utils.*;
import model.*;
import java.util.*;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProfileServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (MyUtils.getLoginedUser(request.getSession()) == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		
		List<UsuarioContato> usuarioContatoList = new ArrayList<UsuarioContato>();
		List<Object> imoveisUsuario = new ArrayList<Object>();

		Connection conn = MyUtils.getStoredConnection(request);
		
		try {
			usuarioContatoList = DBUtils.queryFindUsuarioContato(conn, MyUtils.getLoginedUser(request.getSession()));
			imoveisUsuario = DBUtils.queryFindImoveisUsuario(conn, MyUtils.getLoginedUser(request.getSession()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("usuarioContatoList", usuarioContatoList);
		request.setAttribute("imoveisUsuario", imoveisUsuario);

		request.getRequestDispatcher("/WEB-INF/views/profile.jsp").forward(request, response);
	}

	@Override
  	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  	doGet(request, response);
  	}
}