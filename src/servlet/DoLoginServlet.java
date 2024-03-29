package servlet;

import java.io.IOException;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import utils.*;
import model.Usuario;

@WebServlet("/doLogin")
public class DoLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DoLoginServlet() {
		super();
	}

	@Override
  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
	    Boolean remember = Boolean.valueOf(request.getParameter("lembrarMe") != null);

		Usuario usuario = null;
		boolean hasError = false;
		String errorString = null;

		if(email == null || senha == null || email.length() == 0 || senha.length() == 0) {
			hasError = true;
			errorString = "E-mail e senha necessários!";
		} else {
			Connection conn = MyUtils.getStoredConnection(request);
			try {
				usuario = DBUtils.encontrarUsuario(conn, email, senha);

				if (usuario == null) {
					hasError = true;
					errorString = "E-mail ou senha inválidos!";
				}
			} catch (SQLException e) {
				e.printStackTrace();
				hasError = true;
				errorString = e.getMessage();
			}
		}

		if(hasError) {
			request.setAttribute("errorString", errorString);

			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		} else {
			HttpSession session = request.getSession();
			MyUtils.storeLoginedUser(session, usuario);

			if (remember) {
				MyUtils.storeUserCookie(response, usuario);
			} else {
				MyUtils.deleteUserCookie(response);
			}

			response.sendRedirect(request.getContextPath() + "/home");
		}
	}
}