package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import utils.*;
import model.Usuario;

@WebServlet(urlPatterns = {"/doLogin"})
public class DoLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DoLoginServlet() {
		super();
	}

	@Override
  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String rememberMeStr = request.getParameter("rememberMe");
		boolean remember = "Y".equals(rememberMeStr);

		Usuario usuario = null;
		boolean hasError = false;
		String errorString = null;

		if (email == null || senha == null || email.length() == 0 || senha.length() == 0) {
			hasError = true;
			errorString = "Required username and password!";
		} else {
			Connection conn = MyUtils.getStoredConnection(request);
			try {
				usuario = DBUtils.encontrarUsuario(conn, email, senha);

				if (usuario == null) {
					hasError = true;
					errorString = "User Name or password invalid";
				}
			} catch (SQLException e) {
				e.printStackTrace();
				hasError = true;
				errorString = e.getMessage();
			}
		}

		// If error, forward to /WEB-INF/views/login.jsp
		if (hasError) {
			usuario = new Usuario();
			usuario.setEmail(email);
			usuario.setSenha(senha);

			// Store information in request attribute, before forward.
			request.setAttribute("errorString", errorString);
			request.setAttribute("usuario", usuario);

			// Forward to /WEB-INF/views/login.jsp
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");

			dispatcher.forward(request, response);
		} else {
			// If no error
			// Store user information in Session
			// And redirect to userInfo page.
			HttpSession session = request.getSession();
			MyUtils.storeLoginedUser(session, usuario);

			// If user checked "Remember me".
			if (remember) {
				MyUtils.storeUserCookie(response, usuario);
			} else {
			// Else delete cookie.
				MyUtils.deleteUserCookie(response);
			}

			// Redirect to userInfo page.
			response.sendRedirect(request.getContextPath() + "/userInfo");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}