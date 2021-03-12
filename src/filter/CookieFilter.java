package filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Usuario;
import utils.*;

@WebFilter(filterName="cookieFilter", urlPatterns={"/*"})
public class CookieFilter implements Filter {
	public CookieFilter() { }

	@Override
	public void init(FilterConfig fConfig) throws ServletException { }

	@Override
	public void destroy() { }

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();

		Usuario userInSession = MyUtils.getLoginedUser(session);

		if (userInSession != null) {
			session.setAttribute("COOKIE_CHECKED", "CHECKED");
			chain.doFilter(request, response);
			return;
		}

		Connection conn = MyUtils.getStoredConnection(request);

		String checked = (String) session.getAttribute("COOKIE_CHECKED");
		if (checked == null && conn != null) {
			String email = MyUtils.getUserNameInCookie(req);
			try {
				Usuario usuario = DBUtils.encontrarUsuario(conn, email);
				MyUtils.storeLoginedUser(session, usuario);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			session.setAttribute("COOKIE_CHECKED", "CHECKED");
		}
		chain.doFilter(request, response);
	}
}