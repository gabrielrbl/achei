package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import utils.*;

import com.google.gson.*;

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
		JsonObject json = new Gson().fromJson(request.getReader(), JsonObject.class);

		Integer idimovel = Integer.parseInt(json.get("id").getAsString());
				
		Connection conn = MyUtils.getStoredConnection(request);

		Boolean status = false;
		
		try {
	    	status = DBUtils.deleteImovel(conn, idimovel);
		} catch (SQLException e) {
			e.printStackTrace();
			e.getMessage();
		}
		
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(new Gson().toJson(status));
    }
}
