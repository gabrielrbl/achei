package utils;

import java.sql.*;
import java.sql.Date;
import java.util.*;
import model.*;

public class DBUtils {	
	public static Integer insertImovel(Connection conn, Imovel imovel) throws SQLException {
		String sql = "INSERT INTO IMOVEL(IDRESPONSAVEL, TIPO, QUARTOS, BANHEIROS, SUITES, "
				   + "VAGASGARAGEM, AREACONSTRUIDA, AREATOTAL, DESCRICAO, CIDADE, BAIRRO, "
				   + "RUA, NUMERO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	    PreparedStatement pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	    
	    pstm.setInt(1, imovel.getResponsavel().getIdusuario());
	    pstm.setString(2, imovel.getTipo());
	    pstm.setInt(3, imovel.getQuartos());
	    pstm.setInt(4, imovel.getBanheiros());
	    pstm.setInt(5, imovel.getSuites());
	    pstm.setInt(6, imovel.getVagasGaragem());
	    pstm.setDouble(7, imovel.getAreaConstruida());
	    pstm.setDouble(8, imovel.getAreaTotal());
	    pstm.setString(9, imovel.getDescricao());
	    pstm.setString(10, imovel.getCidade());
	    pstm.setString(11, imovel.getBairro());
	    pstm.setString(12, imovel.getRua());
	    pstm.setString(13, imovel.getNumero());
	    
	    pstm.executeUpdate();
	    
	    Integer numero = null;
	    
	    ResultSet rs = pstm.getGeneratedKeys();
	    
	    if (rs != null && rs.next()) {
	    	numero = rs.getInt(1);
	    }
	    
	    return numero;
	}
	
	public static Boolean deleteImovel(Connection conn, Integer idimovel) throws SQLException {
		String sql = "DELETE FROM IMOVEL WHERE IDIMOVEL = "+ idimovel +"";
		
	    PreparedStatement pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);	    
	    Integer rowsAffected = pstm.executeUpdate();
	    
	    return (rowsAffected > 0) ? true : false;
	}
	
	public static Integer insertImovelFoto(Connection conn, ImovelFoto imovelfoto) throws SQLException {
		String sql = "INSERT INTO IMOVELFOTO(IDIMOVEL, FOTO) VALUES (?, ?)";
		
	    PreparedStatement pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	    
	    pstm.setInt(1, imovelfoto.getImovel().getIdimovel());
	    pstm.setString(2, imovelfoto.getFoto());
	    
	    pstm.executeUpdate();
	    
	    Integer numero = null;
	    
	    ResultSet rs = pstm.getGeneratedKeys();
	    
	    if (rs != null && rs.next()) {
	    	numero = rs.getInt(1);
	    }
	    
	    return numero;
	}
	
	public static Integer insertApartamento(Connection conn, Apartamento apartamento) throws SQLException {
		String sql = "INSERT INTO APARTAMENTO(IDIMOVEL, BLOCO, ANDAR, NUMEROAP, SACADA) VALUES (?, ?, ?, ?, ?)";

	    PreparedStatement pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	    
	    pstm.setInt(1, apartamento.getImovel().getIdimovel());
	    pstm.setString(2, apartamento.getBloco());
	    pstm.setInt(3, apartamento.getAndar());
	    pstm.setInt(4, apartamento.getNumeroAp());
	    pstm.setBoolean(5, apartamento.isSacada());
	    
	    pstm.executeUpdate();
	    
	    Integer numero = null;
	    
	    ResultSet rs = pstm.getGeneratedKeys();
	    
	    if (rs != null && rs.next()) {
	    	numero = rs.getInt(1);
	    }
	    
	    return numero;
	}
	
	public static Integer insertCasa(Connection conn, Casa casa) throws SQLException {
		String sql = "INSERT INTO CASA(IDIMOVEL, LOTE, QUADRA) VALUES (?, ?, ?)";

	    PreparedStatement pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	    
	    pstm.setInt(1, casa.getImovel().getIdimovel());
	    pstm.setString(2, casa.getLote());
	    pstm.setString(3, casa.getQuadra());
	    
	    pstm.executeUpdate();
	    
	    Integer numero = null;
	    
	    ResultSet rs = pstm.getGeneratedKeys();
	    
	    if (rs != null && rs.next()) {
	    	numero = rs.getInt(1);
	    }
	    
	    return numero;
	}

	public static Integer insertLocacao(Connection conn, Locacao locacao) throws SQLException {
		String sql = "INSERT INTO LOCACAO(";
	    
		if(locacao.getImovel() instanceof Apartamento) {
			sql += "IDAPARTAMENTO, ";
		} else if(locacao.getImovel() instanceof Casa) {
			sql += "IDCASA, ";
		}
		
		sql += "DATALOCACAOINICIO, DATALOCACAOFIM, VALORMENSAL, VALORANUAL, FORMAPAGAMENTO) VALUES (?, ?, ?, ?, ?, ?)";

	    PreparedStatement pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		
		if(locacao.getImovel() instanceof Apartamento) {
			pstm.setInt(1, ((Apartamento) locacao.getImovel()).getIdapartamento());
		} else if(locacao.getImovel() instanceof Casa) {
			pstm.setInt(1, ((Casa) locacao.getImovel()).getIdcasa());
		}
	    
		pstm.setDate(2, (Date) locacao.getDataLocacaoInicio());
		pstm.setDate(3, (Date) locacao.getDataLocacaoInicio());
		pstm.setDouble(4, locacao.getValorMensal());
		pstm.setDouble(5, locacao.getValorAnual());
		pstm.setString(6, locacao.getFormaPagamento());
		
	    pstm.executeUpdate();
	    
	    Integer numero = null;
	    
	    ResultSet rs = pstm.getGeneratedKeys();
	    
	    if (rs != null && rs.next()) {
	    	numero = rs.getInt(1);
	    }
	    
	    return numero;
	}

	public static Integer insertVenda(Connection conn, Venda venda) throws SQLException {
		String sql = "INSERT INTO VENDA(";
	    
		if(venda.getImovel() instanceof Apartamento) {
			sql += "IDAPARTAMENTO, ";
		} else if(venda.getImovel() instanceof Casa) {
			sql += "IDCASA, ";
		}
		
		sql += "DATAVENDAINICIADA, DATAVENDAFINALIZADA, VALORVENDA, FORMAPAGAMENTO) VALUES (?, ?, ?, ?, ?)";

	    PreparedStatement pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		
		if(venda.getImovel() instanceof Apartamento) {
			pstm.setInt(1, ((Apartamento) venda.getImovel()).getIdapartamento());
		} else if(venda.getImovel() instanceof Casa) {
			pstm.setInt(1, ((Casa) venda.getImovel()).getIdcasa());
		}
	    
		pstm.setDate(2, (Date) venda.getDataVendaIniciada());
		pstm.setDate(3, (Date) venda.getDataVendaFinalizada());
		pstm.setDouble(4, venda.getValorVenda());
		pstm.setString(5, venda.getFormaPagamento());
		
	    pstm.executeUpdate();
	    
	    Integer numero = null;
	    
	    ResultSet rs = pstm.getGeneratedKeys();
	    
	    if (rs != null && rs.next()) {
	    	numero = rs.getInt(1);
	    }
	    
	    return numero;
	}
	
	public static List<Object> queryFindImoveisUsuario(Connection conn, Usuario usuario) throws SQLException {
		String sql = "SELECT * FROM IMOVEL WHERE IDRESPONSAVEL = ?";

	    PreparedStatement pstm = conn.prepareStatement(sql);
	    pstm.setInt(1, usuario.getIdusuario());
	    
	    ResultSet rs = pstm.executeQuery();
	    List<Object> imoveis = new ArrayList<Object>();
	    
	    while (rs.next()) {
	    	Imovel imovel = new Imovel();
	    	imovel.setIdimovel(rs.getInt("idimovel"));
	    	imovel.setResponsavel(usuario);
	    	imovel.setFotos(queryImovelFoto(conn, imovel));
	    	imovel.setTipo(rs.getString("tipo"));
	    	imovel.setQuartos(rs.getInt("quartos"));
	    	imovel.setBanheiros(rs.getInt("banheiros"));
	    	imovel.setSuites(rs.getInt("suites"));
	    	imovel.setVagasGaragem(rs.getInt("vagasgaragem"));
	    	imovel.setAreaConstruida(rs.getDouble("areaconstruida"));
	    	imovel.setAreaTotal(rs.getDouble("areatotal"));
	    	imovel.setDescricao(rs.getString("descricao"));
	    	imovel.setCidade(rs.getString("cidade"));
	    	imovel.setBairro(rs.getString("bairro"));
	    	imovel.setRua(rs.getString("rua"));
	    	imovel.setNumero(rs.getString("numero"));
	    	imovel.setStatus(rs.getBoolean("status"));
	    	
	    	switch (rs.getString("tipo")) {
			case "AP":
				try {
					Apartamento apartamento = queryFindApartamento(conn, imovel);
					imoveis.add(apartamento);
				} catch (SQLException e) {
			    	e.printStackTrace();
			    	e.getMessage();
				}
				break;
			case "CA":
				try {
					Casa casa = queryFindCasa(conn, imovel);
					imoveis.add(casa);
				} catch (SQLException e) {
			    	e.printStackTrace();
			    	e.getMessage();
				}
				break;
			}
	    }
	    return imoveis;
	}
	
	public static List<UsuarioContato> queryFindUsuarioContato(Connection conn, Usuario usuario) throws SQLException {
		String sql = "SELECT * FROM USUARIOCONTATO WHERE IDUSUARIO = ?";

	    PreparedStatement pstm = conn.prepareStatement(sql);
	    pstm.setInt(1, usuario.getIdusuario());
	    
	    ResultSet rs = pstm.executeQuery();
	    List<UsuarioContato> usuariocontato = new ArrayList<UsuarioContato>();
	    
	    while (rs.next()) {
	    	UsuarioContato uc = new UsuarioContato();
	    	uc.setIdusuariocontato(rs.getInt("idusuariocontato"));
	    	uc.setUsuario(usuario);
	    	uc.setTipo(rs.getString("tipo"));
	    	uc.setContato(rs.getString("contato"));
	    	usuariocontato.add(uc);
	    }
	    return usuariocontato;
	}

	public static Venda queryFindVenda(Connection conn, Imovel imovel) throws SQLException {
		String sql = "SELECT * FROM VENDA ";
		if(imovel instanceof Apartamento) {
			sql += "WHERE IDAPARTAMENTO = "+ ((Apartamento) imovel).getIdapartamento() +"";
		} else if(imovel instanceof Casa) {
			sql += "WHERE IDCASA = "+ ((Casa) imovel).getIdcasa() +"";
		}
		
	    PreparedStatement pstm = conn.prepareStatement(sql);
	    ResultSet rs = pstm.executeQuery();

    	Venda venda = null;
	    
	    if (rs.next()) {
	    	venda = new Venda();
	    	venda.setIdvenda(rs.getInt("idvenda"));
	    	venda.setImovel(imovel);
	    	venda.setDataVendaFinalizada(rs.getDate("datavendafinalizada"));
	    	venda.setDataVendaIniciada(rs.getDate("datavendainiciada"));
	    	venda.setFormaPagamento(rs.getString("formapagamento"));
	    	venda.setValorVenda(rs.getDouble("valorvenda"));
	    }
		return venda;
	}

	public static Locacao queryFindLocacao(Connection conn, Imovel imovel) throws SQLException {
		String sql = "SELECT * FROM LOCACAO ";
		if(imovel instanceof Apartamento) {
			sql += "WHERE IDAPARTAMENTO = "+ ((Apartamento) imovel).getIdapartamento() +"";
		} else if(imovel instanceof Casa) {
			sql += "WHERE IDCASA = "+ ((Casa) imovel).getIdcasa() +"";
		}
		
	    PreparedStatement pstm = conn.prepareStatement(sql);
	    ResultSet rs = pstm.executeQuery();

    	Locacao locacao = null;
	    
	    if (rs.next()) {
	    	locacao = new Locacao();
	    	locacao.setIdlocacao(rs.getInt("idlocacao"));
	    	locacao.setImovel(imovel);
	    	locacao.setDataLocacaoFim(rs.getDate("datalocacaofim"));
	    	locacao.setDataLocacaoInicio(rs.getDate("datalocacaoinicio"));
	    	locacao.setFormaPagamento(rs.getString("formapagamento"));
	    	locacao.setValorAnual(rs.getDouble("valoranual"));
	    	locacao.setValorMensal(rs.getDouble("valormensal"));
	    }
		return locacao;
	}
	
	public static List<Object> queryImoveisLocacaoVenda(Connection conn, String tipoNegocio, String tipoImovel) throws SQLException {
		String sql = "SELECT * FROM IMOVEL";
		
		switch (tipoImovel) {
		case "ap":
			sql += " WHERE TIPO = 'AP'";
			break;
		case "ca":
			sql += " WHERE TIPO = 'CA'";
			break;
		default:
			break;
		}
		
	    PreparedStatement pstm = conn.prepareStatement(sql);
	    ResultSet rs = pstm.executeQuery();
	    List<Object> imoveis = new ArrayList<Object>();
	    
	    while (rs.next()) {
	    	Imovel imovel = new Imovel();
	    	imovel.setIdimovel(rs.getInt("idimovel"));
	    	imovel.setFotos(queryImovelFoto(conn, imovel));
	    	imovel.setTipo(rs.getString("tipo"));
	    	imovel.setQuartos(rs.getInt("quartos"));
	    	imovel.setBanheiros(rs.getInt("banheiros"));
	    	imovel.setSuites(rs.getInt("suites"));
	    	imovel.setVagasGaragem(rs.getInt("vagasgaragem"));
	    	imovel.setAreaConstruida(rs.getDouble("areaconstruida"));
	    	imovel.setAreaTotal(rs.getDouble("areatotal"));
	    	imovel.setDescricao(rs.getString("descricao"));
	    	imovel.setCidade(rs.getString("cidade"));
	    	imovel.setBairro(rs.getString("bairro"));
	    	imovel.setRua(rs.getString("rua"));
	    	imovel.setNumero(rs.getString("numero"));
	    	imovel.setStatus(rs.getBoolean("status"));
	    	
	    	switch (rs.getString("tipo")) {
			case "AP":
				try {
					Apartamento apartamento = queryFindApartamento(conn, imovel);
				
					switch (tipoNegocio) {
					case "comprar":
						if (queryFindVenda(conn, apartamento) != null) {
							imoveis.add(queryFindVenda(conn, apartamento));
						}
						break;
					case "alugar":
						if (queryFindLocacao(conn, apartamento) != null) {
							imoveis.add(queryFindLocacao(conn, apartamento));
						}
						break;
					}
				} catch (SQLException e) {
			    	e.printStackTrace();
			    	e.getMessage();
				}
				break;
			case "CA":
				try {
					Casa casa = queryFindCasa(conn, imovel);
					
					if (casa != null) {
						switch (tipoNegocio) {
						case "comprar":
							if (queryFindVenda(conn, casa) != null) {
								imoveis.add(queryFindVenda(conn, casa));
							}
							break;
						case "alugar":
							if (queryFindLocacao(conn, casa) != null) {
								imoveis.add(queryFindLocacao(conn, casa));
							}
							break;
						}
					}
				} catch (SQLException e) {
			    	e.printStackTrace();
			    	e.getMessage();
				}
				break;
			}
	    }
	    return imoveis;
	}
	
	public static <T extends Imovel> Apartamento queryFindApartamento(Connection conn, Imovel imovel) throws SQLException {
		String sql = "SELECT * FROM APARTAMENTO WHERE IDIMOVEL = "+ imovel.getIdimovel() +" LIMIT 1";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();

		Apartamento ap = null;
		
		if (rs.next()) {
			ap = new Apartamento();
			ap.setIdapartamento(rs.getInt("idapartamento"));
			ap.setImovel(imovel);
			ap.setBloco(rs.getString("bloco"));
			ap.setAndar(rs.getInt("andar"));
			ap.setNumeroAp(rs.getInt("numeroAp"));
			ap.setSacada(rs.getBoolean("sacada"));
		}
		return ap;
	}
	
	public static <T extends Imovel> Casa queryFindCasa(Connection conn, Imovel imovel) throws SQLException {
		String sql = "SELECT * FROM CASA WHERE IDIMOVEL = "+ imovel.getIdimovel() +" LIMIT 1";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		
		Casa ca = null;
		
		if (rs.next()) {
			ca = new Casa();
			ca.setIdcasa(rs.getInt("idcasa"));
			ca.setImovel(imovel);
			ca.setLote(rs.getString("lote"));
			ca.setQuadra(rs.getString("quadra"));
		}
		return ca;
	}
	
	public static Usuario queryResponsavelImovel(Connection conn, Integer idusuario) throws SQLException {
		String sql = "SELECT * FROM USUARIO WHERE IDUSUARIO = ?";
		
	    PreparedStatement pstm = conn.prepareStatement(sql);
	    pstm.setInt(1, idusuario);
	    ResultSet rs = pstm.executeQuery();

    	Usuario responsavel = null;

	    if (rs.next()) {
	    	responsavel = new Usuario();
	    	responsavel.setIdusuario(rs.getInt("idusuario"));
	    	responsavel.setNome(rs.getString("nome"));
	    	responsavel.setCpf(rs.getString("cpf"));
	    	responsavel.setEmail(rs.getString("email"));
	    	responsavel.setSenha(rs.getString("senha"));
	    	responsavel.setObservacao(rs.getString("observacao"));
	    	responsavel.setAtivo(rs.getBoolean("ativo"));
	    }
		return responsavel;
	}
	
	public static List<ImovelFoto> queryImovelFoto(Connection conn, Imovel imovel) throws SQLException {
		String sql = "SELECT * FROM IMOVELFOTO WHERE IDIMOVEL = "+ imovel.getIdimovel() +"";
		
	    PreparedStatement pstm = conn.prepareStatement(sql);
	    ResultSet rs = pstm.executeQuery();
	    
	    List<ImovelFoto> fotos = new ArrayList<ImovelFoto>();

	    while (rs.next()) {
	    	ImovelFoto imf = new ImovelFoto();
	    	imf.setIdimovelfoto(rs.getInt("idimovelfoto"));
	    	imf.setImovel(imovel);
	    	imf.setFoto(rs.getString("foto"));
	    	fotos.add(imf);
	    }
		return fotos;
	}
	
	public static List<Imovel> queryImoveis(Connection conn) throws SQLException {
		String sql = "SELECT * FROM IMOVEL";

	    PreparedStatement pstm = conn.prepareStatement(sql);
	    ResultSet rs = pstm.executeQuery();
	    List<Imovel> imoveis = new ArrayList<Imovel>();
	    
	    while (rs.next()) {
	    	Imovel imovel = new Imovel();
	    	imovel.setResponsavel(queryResponsavelImovel(conn, rs.getInt("idresponsavel")));
	    	imovel.setIdimovel(rs.getInt("idimovel"));
	    	imovel.setFotos(queryImovelFoto(conn, imovel));
	    	imovel.setTipo(rs.getString("tipo"));
	    	imovel.setQuartos(rs.getInt("quartos"));
	    	imovel.setBanheiros(rs.getInt("banheiros"));
	    	imovel.setSuites(rs.getInt("suites"));
	    	imovel.setVagasGaragem(rs.getInt("vagasgaragem"));
	    	imovel.setAreaConstruida(rs.getDouble("areaconstruida"));
	    	imovel.setAreaTotal(rs.getDouble("areatotal"));
	    	imovel.setDescricao(rs.getString("descricao"));
	    	imovel.setCidade(rs.getString("cidade"));
	    	imovel.setBairro(rs.getString("bairro"));
	    	imovel.setRua(rs.getString("rua"));
	    	imovel.setNumero(rs.getString("numero"));
	    	imovel.setStatus(rs.getBoolean("status"));
	    	
	    	switch (rs.getString("tipo")) {
			case "AP":
				try {
					imoveis.add(queryFindApartamento(conn, imovel));
				} catch (SQLException e) {
			    	e.printStackTrace();
			    	e.getMessage();
				}
				break;
			case "CA":
				try {
					imoveis.add(queryFindCasa(conn, imovel));
				} catch (SQLException e) {
			    	e.printStackTrace();
			    	e.getMessage();
				}
				break;
			default:
				break;
			}
	    }
	    return imoveis;
	}
	
	public static Imovel queryFindImovelId(Connection conn, Integer idimovel) throws SQLException {
		String sql = "SELECT * FROM IMOVEL WHERE IDIMOVEL = "+ idimovel +"";
		
	    PreparedStatement pstm = conn.prepareStatement(sql);
	    ResultSet rs = pstm.executeQuery();
	    
		Imovel imovel = null;
	    
	    if (rs.next()) {
	    	imovel = new Imovel();
	    	imovel.setIdimovel(rs.getInt("idimovel"));
	    	imovel.setResponsavel(queryResponsavelImovel(conn, rs.getInt("idresponsavel")));
	    	imovel.setFotos(queryImovelFoto(conn, imovel));
	    	imovel.setTipo(rs.getString("tipo"));
	    	imovel.setQuartos(rs.getInt("quartos"));
	    	imovel.setBanheiros(rs.getInt("banheiros"));
	    	imovel.setSuites(rs.getInt("suites"));
	    	imovel.setVagasGaragem(rs.getInt("vagasgaragem"));
	    	imovel.setAreaConstruida(rs.getDouble("areaconstruida"));
	    	imovel.setAreaTotal(rs.getDouble("areatotal"));
	    	imovel.setDescricao(rs.getString("descricao"));
	    	imovel.setCidade(rs.getString("cidade"));
	    	imovel.setBairro(rs.getString("bairro"));
	    	imovel.setRua(rs.getString("rua"));
	    	imovel.setNumero(rs.getString("numero"));
	    	imovel.setStatus(rs.getBoolean("status"));
	    }
    	return imovel;
	}
	
	public static Object queryImovel(Connection conn, Imovel imovel) throws SQLException {
		Object retorno = null;
	    
		switch (imovel.getTipo()) {
		case "AP":
			Apartamento ap = queryFindApartamento(conn, imovel);
			
			retorno = queryFindLocacao(conn, ap) != null ? queryFindLocacao(conn, ap) : queryFindVenda(conn, ap);
			break;
		case "CA":
			Casa ca = queryFindCasa(conn, imovel);
			
			retorno = queryFindLocacao(conn, ca) != null ? queryFindLocacao(conn, ca) : queryFindVenda(conn, ca);
			break;
		}
    	return retorno;
	}
	

	public static Usuario encontrarUsuario(Connection conn, String email, String senha) throws SQLException {
	    String sql = "SELECT IDUSUARIO, NOME, CPF, EMAIL, SENHA, OBSERVACAO, ATIVO FROM USUARIO WHERE LOWER(EMAIL) = LOWER(?) AND SENHA = ?";
	
	    PreparedStatement pstm = conn.prepareStatement(sql);
	    pstm.setString(1, email);
	    pstm.setString(2, senha);
	    ResultSet rs = pstm.executeQuery();

	    if (rs.next()) {
	    	Usuario usuario = new Usuario();
	      	usuario.setIdusuario(rs.getInt("idusuario"));
	      	usuario.setNome(rs.getString("nome"));
	      	usuario.setCpf(rs.getString("cpf"));
	      	usuario.setEmail(email);
	      	usuario.setSenha(senha);
	      	usuario.setObservacao(rs.getString("observacao"));
	      	usuario.setAtivo(rs.getBoolean("ativo"));
	      	return usuario;
		}
	    return null;
	}

	public static Usuario encontrarUsuario(Connection conn, String email) throws SQLException {
	    String sql = "SELECT IDUSUARIO, NOME, CPF, EMAIL, SENHA, OBSERVACAO, ATIVO FROM USUARIO WHERE LOWER(EMAIL) = LOWER(?)";
	
	    PreparedStatement pstm = conn.prepareStatement(sql);
	    pstm.setString(1, email);
	
	    ResultSet rs = pstm.executeQuery();
	
	    if (rs.next()) {
	    	Usuario usuario = new Usuario();
	    	usuario.setIdusuario(rs.getInt("idusuario"));
	    	usuario.setNome(rs.getString("nome"));
	      	usuario.setCpf(rs.getString("cpf"));
	      	usuario.setEmail(email);
	      	usuario.setSenha(rs.getString("senha"));
	      	usuario.setObservacao(rs.getString("observacao"));
	      	usuario.setAtivo(rs.getBoolean("ativo"));
	      	return usuario;
		}
	    return null;
	}
}