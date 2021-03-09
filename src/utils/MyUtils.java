package utils;

import java.sql.Connection;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Usuario;

public class MyUtils {
	public static final String ATT_NAME_CONNECTION = "ATTRIBUTE_FOR_CONNECTION";
	private static final String ATT_NAME_USER_NAME = "ATTRIBUTE_FOR_STORE_USER_NAME_IN_COOKIE";

	// Store Connection in request attribute.
	// (Information stored only exist during requests)
	public static void storeConnection(ServletRequest request, Connection conn) {
		request.setAttribute(ATT_NAME_CONNECTION, conn);
	}

	// Get the Connection object has been stored in one attribute of the request.
	public static Connection getStoredConnection(ServletRequest request) {
		Connection conn = (Connection) request.getAttribute(ATT_NAME_CONNECTION);
		return conn;
	}

	// Store user info in Session.
	public static void storeLoginedUser(HttpSession session, Usuario usuarioLogado) {
    // On the JSP can access ${usuarioLogado}
		session.setAttribute("usuarioLogado", usuarioLogado);
	}

	// Get the user information stored in the session.
	public static Usuario getLoginedUser(HttpSession session) {
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		return usuarioLogado;
	}

	// Store info in Cookie
	public static void storeUserCookie(HttpServletResponse response, Usuario usuario) {
		System.out.println("Store user cookie");
		Cookie cookieEmail = new Cookie(ATT_NAME_USER_NAME, usuario.getEmail());

		// 1 day (Convert to seconds)
		cookieEmail.setMaxAge(24 * 60 * 60);
    	response.addCookie(cookieEmail);
	}

	public static String getUserNameInCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (ATT_NAME_USER_NAME.equals(cookie.getName())) {
					return cookie.getValue();
				}
			}
		}
		return null;
	}

  // Delete cookie.
	public static void deleteUserCookie(HttpServletResponse response) {
		Cookie cookieEmail = new Cookie(ATT_NAME_USER_NAME, null);

		// 0 seconds (Expires immediately)
		cookieEmail.setMaxAge(0);
		response.addCookie(cookieEmail);
	}
}