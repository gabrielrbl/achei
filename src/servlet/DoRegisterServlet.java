package servlet;

import java.io.IOException;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import utils.*;
import model.*;

@WebServlet("/doRegister")
public class DoRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DoRegisterServlet() {
		super();
	}

	@Override
  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tipoCadastro = request.getParameter("tipoCadastro");
		
		String errorString = null;
		boolean hasError = false;
		
		//PF
		String nomePF = null;
		String senhaPF = null;
		String cpfPF = null;
		String emailPF = null;
		String confirmarsenhaPF = null;
		String generoPF = null;
		//PJ
		String nomePJ = null;
		String senhaPJ = null;
		String cnpjPJ = null;
		String emailPJ = null;
		String confirmarsenhaPJ = null;
		String generoPJ = null;
		
		Connection conn = MyUtils.getStoredConnection(request);
		
		Usuario usuario = null;

		switch (tipoCadastro) {
		case "PF":
			nomePF = request.getParameter("nomePF");
			senhaPF = request.getParameter("senhaPF");
			cpfPF = request.getParameter("cpfPF");
			emailPF = request.getParameter("emailPF");
			confirmarsenhaPF = request.getParameter("confirmarsenhaPF");
			generoPF = request.getParameter("generoPF");
			
			if (!confirmarsenhaPF.equals(senhaPF)) {
				hasError = true;
				errorString = "Confirmação de senha diferente!";
			} else {
				try {
					usuario = new Usuario();
					usuario.setNome(nomePF);
					usuario.setGenero(generoPF);
					usuario.setEmail(emailPF);
					usuario.setSenha(senhaPF);
					usuario.setObservacao(null);
					usuario.setAtivo(true);
					usuario.setIdusuario(DBUtils.insertUsuario(conn, usuario));
					
					UsuarioPessoaFisica usuarioPF = new UsuarioPessoaFisica();
					usuarioPF.setUsuario(usuario);
					usuarioPF.setCpf(cpfPF);
					usuarioPF.setIdusuariopessoafisica(DBUtils.insertUsuarioPF(conn, usuarioPF));
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			break;
		case "PJ":
			nomePJ = request.getParameter("nomePJ");
			senhaPJ = request.getParameter("senhaPJ");
			cnpjPJ = request.getParameter("cpfPJ");
			emailPJ = request.getParameter("emailPJ");
			confirmarsenhaPJ = request.getParameter("confirmarsenhaPJ");
			generoPJ = request.getParameter("generoPJ");
			
			if (!confirmarsenhaPJ.equals(senhaPJ)) {
				hasError = true;
				errorString = "Confirmação de senha diferente!";
			} else {
				try {
					usuario = new Usuario();
					usuario.setNome(nomePJ);
					usuario.setGenero(generoPJ);
					usuario.setEmail(emailPJ);
					usuario.setSenha(senhaPJ);
					usuario.setObservacao(null);
					usuario.setAtivo(true);
					
					usuario.setIdusuario(DBUtils.insertUsuario(conn, usuario));
					
					UsuarioPessoaJuridica usuarioPJ = new UsuarioPessoaJuridica();
					usuarioPJ.setUsuario(usuario);
					usuarioPJ.setCnpj(cnpjPJ);
					usuarioPJ.setIdusuariopessoajuridica(DBUtils.insertUsuarioPJ(conn, usuarioPJ));
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			break;
		}
		
		if (hasError) {
			request.setAttribute("errorString", errorString);
			
			request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);
		} else {
			HttpSession session = request.getSession();
			MyUtils.storeLoginedUser(session, usuario);
			MyUtils.storeUserCookie(response, usuario);

			response.sendRedirect(request.getContextPath() + "/home");
		}
	}
}