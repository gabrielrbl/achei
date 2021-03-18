package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

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
		Integer idimovel = Integer.parseInt(request.getParameter("idImovel"));

		Connection conn = MyUtils.getStoredConnection(request);
		
		try {
	    	DBUtils.deleteImovel(conn, idimovel);
		} catch (SQLException e) {
			e.printStackTrace();
			e.getMessage();
		}

		List<Object> imovel = null;

	    try {
	    	imovel = DBUtils.queryFindImoveisUsuario(conn, MyUtils.getLoginedUser(request.getSession()));
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    	e.getMessage();
	    }

	    request.setAttribute("msgString", "Imóvel excluído com sucesso!");
	    request.setAttribute("imovelList", imovel);

		request.getRequestDispatcher("/WEB-INF/views/userImoveis.jsp").forward(request, response);
    }
}
