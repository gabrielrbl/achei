package servlet;

import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.*;
import utils.*;

@WebServlet("/doNewImovel")
public class DoNewImovel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DoNewImovel() {
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
		
		String tipoImovel = request.getParameter("tipoImovel");
		String[] fotos = request.getParameterValues("fotos");
		String quartos = request.getParameter("quartos");
		String banheiros = request.getParameter("banheiros");
		String suites = request.getParameter("suites");
		String vagasGaragem = request.getParameter("vagasGaragem");
		String areaConstruida = request.getParameter("areaConstruida");
		String areaTotal = request.getParameter("areaTotal");
		String cidade = request.getParameter("cidade");
		String bairro = request.getParameter("bairro");
		String rua = request.getParameter("rua");
		String numero = request.getParameter("numero");
		String descricao = request.getParameter("descricao");
		
		String tipoNegocio = request.getParameter("tipoNegocio");
		
		// AP
		String bloco = null;
		Integer andar = null;
		Integer numeroAp = null;
		Boolean sacada = false;
		// CASA
		String lote = null;
		String quadra = null;
		
		switch (tipoImovel) {
		case "AP":
			bloco = request.getParameter("bloco");
			andar = Integer.parseInt(request.getParameter("andar"));
			numeroAp = Integer.parseInt(request.getParameter("numeroAp"));
			sacada = Boolean.valueOf(request.getParameter("sacada") != null);
			break;
		case "CA":
			lote = request.getParameter("lote");
			quadra = request.getParameter("quadra");
			break;
		}
		
		//
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// LOCAÇÃO
		Date dataLocacaoInicio = null;
		Date dataLocacaoFim = null;
		Double valorMensal = null;
		Double valorAnual = null;
		String formaPagamentoLocacao = null;
		// VENDA
		Date dataVendaIniciada = null;
		Date dataVendaFinalizada = null;
		Double valorVenda = null;
		String formaPagamentoVenda = null;
		
		
		switch (tipoNegocio) {
		case "alugar":
			try {
				dataLocacaoInicio = new java.sql.Date(sdf.parse(request.getParameter("dataLocacaoInicio")).getTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			try {
				dataLocacaoFim =  new java.sql.Date(sdf.parse(request.getParameter("dataLocacaoFim")).getTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			valorMensal = Double.parseDouble(request.getParameter("valorMensal"));
			valorAnual = Double.parseDouble(request.getParameter("valorAnual"));
			formaPagamentoLocacao = request.getParameter("formaPagamentoLocacao");
			break;
		case "comprar":
			try {
				dataVendaIniciada = new java.sql.Date(sdf.parse(request.getParameter("dataVendaIniciada")).getTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			try {
				dataVendaFinalizada = new java.sql.Date(sdf.parse(request.getParameter("dataVendaIniciada")).getTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			valorVenda = Double.parseDouble(request.getParameter("valorVenda"));
			formaPagamentoVenda = request.getParameter("formaPagamentoVenda");
			break;
		}
		
		List<ImovelFoto> fotosList = new ArrayList<ImovelFoto>();

		HttpSession session = (request.getSession());
		
		Imovel imovel = new Imovel();
		imovel.setResponsavel((Usuario) session.getAttribute("usuarioLogado"));
		imovel.setTipo(tipoImovel);
		imovel.setQuartos(Integer.parseInt(quartos));
		imovel.setBanheiros(Integer.parseInt(banheiros));
		imovel.setSuites(Integer.parseInt(suites));
		imovel.setVagasGaragem(Integer.parseInt(vagasGaragem));
		imovel.setAreaConstruida(Double.parseDouble(areaConstruida));
		imovel.setAreaTotal(Double.parseDouble(areaTotal));
		imovel.setCidade(cidade);
		imovel.setBairro(bairro);
		imovel.setRua(rua);
		imovel.setNumero(numero);
		imovel.setDescricao(descricao);
		
		Connection conn = MyUtils.getStoredConnection(request);
		
		try {
			imovel.setIdimovel(DBUtils.insertImovel(conn, imovel));
			
			for (int i=0; i<fotos.length; i++) {
				ImovelFoto imf = new ImovelFoto();
				imf.setImovel(imovel);
				imf.setFoto(fotos[i]);
				imf.setIdimovelfoto(DBUtils.insertImovelFoto(conn, imf));				
				fotosList.add(imf);
			}
			imovel.setFotos(fotosList);
			
			switch (tipoImovel) {
			case "AP":
				Apartamento ap = new Apartamento();
				ap.setImovel(imovel);
				ap.setBloco(bloco);
				ap.setAndar(andar);
				ap.setNumeroAp(numeroAp);
				ap.setSacada(sacada);
				
				ap.setIdapartamento(DBUtils.insertApartamento(conn, ap));
				
				switch (tipoNegocio) {
				case "alugar":
					Locacao loca = new Locacao();
					loca.setImovel(ap);
					loca.setDataLocacaoInicio(dataLocacaoInicio);
					loca.setDataLocacaoFim(dataLocacaoFim);
					loca.setValorMensal(valorMensal);
					loca.setValorAnual(valorAnual);
					loca.setFormaPagamento(formaPagamentoLocacao);
					
					loca.setIdlocacao(DBUtils.insertLocacao(conn, loca));
					break;
				case "comprar":
					Venda ve = new Venda();
					ve.setImovel(ap);
					ve.setDataVendaIniciada(dataVendaIniciada);
					ve.setDataVendaFinalizada(dataVendaFinalizada);
					ve.setValorVenda(valorVenda);
					ve.setFormaPagamento(formaPagamentoVenda);
					
					ve.setIdvenda(DBUtils.insertVenda(conn, ve));
					break;
				}
				break;
			case "CA":
				Casa ca = new Casa();
				ca.setImovel(imovel);
				ca.setLote(lote);
				ca.setQuadra(quadra);
				
				ca.setIdcasa(DBUtils.insertCasa(conn, ca));
				
				switch (tipoNegocio) {
				case "alugar":
					Locacao loca = new Locacao();
					loca.setImovel(ca);
					loca.setDataLocacaoInicio(dataLocacaoInicio);
					loca.setDataLocacaoFim(dataLocacaoFim);
					loca.setValorMensal(valorMensal);
					loca.setValorAnual(valorAnual);
					loca.setFormaPagamento(formaPagamentoLocacao);
					
					loca.setIdlocacao(DBUtils.insertLocacao(conn, loca));
					break;
				case "comprar":
					Venda ve = new Venda();
					ve.setImovel(ca);
					ve.setDataVendaIniciada(dataVendaIniciada);
					ve.setDataVendaFinalizada(dataVendaFinalizada);
					ve.setValorVenda(valorVenda);
					ve.setFormaPagamento(formaPagamentoVenda);
					
					ve.setIdvenda(DBUtils.insertVenda(conn, ve));
					break;
				}
				break;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			e.getMessage();
		}
		
		request.setAttribute("msgString", "Imóvel inserido com sucesso!");

		List<Object> imovelList = null;

	    try {
	    	imovelList = DBUtils.queryFindImoveisUsuario(conn, MyUtils.getLoginedUser(request.getSession()));
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    	e.getMessage();
	    }
	    
	    request.setAttribute("imovelList", imovelList);

		request.getRequestDispatcher("/WEB-INF/views/userImoveis.jsp").forward(request, response);
	}
}