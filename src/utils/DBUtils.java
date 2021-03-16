package utils;

import java.sql.*;
import java.util.*;
import model.*;

public class DBUtils {
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
	
	
	public static Integer insertImovel(Connection conn, Imovel imovel) throws SQLException {
		String sql = "INSERT INTO IMOVEL(IDRESPONSAVEL, TIPO, DORMITORIOS, BANHEIROS, SUITES, "
				   + "VAGASGARAGEM, AREACONSTRUIDA, AREATOTAL, VALOR, DESCRICAO, CIDADE, BAIRRO, RUA, "
				   + "NUMERO, OBSERVACAO, STATUS) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	    PreparedStatement pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	    
	    pstm.setInt(1, imovel.getResponsavel().getIdusuario());
	    pstm.setString(2, imovel.getTipo());
	    pstm.setInt(3, imovel.getDormitorios());
	    pstm.setInt(4, imovel.getBanheiros());
	    pstm.setInt(5, imovel.getSuites());
	    pstm.setInt(6, imovel.getVagasGaragem());
	    pstm.setDouble(7, imovel.getAreaConstruida());
	    pstm.setDouble(8, imovel.getAreaTotal());
	    pstm.setDouble(9, imovel.getValor());
	    pstm.setString(10, imovel.getDescricao());
	    pstm.setString(11, imovel.getCidade());
	    pstm.setString(12, imovel.getBairro());
	    pstm.setString(13, imovel.getRua());
	    pstm.setString(14, imovel.getNumero());
	    pstm.setString(15, imovel.getObservacao());
	    pstm.setString(16, imovel.getStatus());
	    
	    pstm.executeUpdate();
	    
	    Integer numero = null;
	    
	    ResultSet rs = pstm.getGeneratedKeys();
	    
	    if (rs != null && rs.next()) {
	    	numero = rs.getInt(1);
	    }
	    
	    return numero;
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
	    	imovel.setDormitorios(rs.getInt("dormitorios"));
	    	imovel.setBanheiros(rs.getInt("banheiros"));
	    	imovel.setSuites(rs.getInt("suites"));
	    	imovel.setVagasGaragem(rs.getInt("vagasgaragem"));
	    	imovel.setAreaConstruida(rs.getDouble("areaconstruida"));
	    	imovel.setAreaTotal(rs.getDouble("areatotal"));
	    	imovel.setValor(rs.getDouble("valor"));
	    	imovel.setDescricao(rs.getString("descricao"));
	    	imovel.setCidade(rs.getString("cidade"));
	    	imovel.setBairro(rs.getString("bairro"));
	    	imovel.setRua(rs.getString("rua"));
	    	imovel.setNumero(rs.getString("numero"));
	    	imovel.setObservacao(rs.getString("observacao"));
	    	imovel.setStatus(rs.getString("status"));
	    	
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
	
	
	

	public static Venda queryFindVenda(Connection conn, Imovel imovel) throws SQLException {
		String sql = "SELECT * FROM VENDA ";
		if(imovel instanceof Apartamento) {
			sql += "WHERE IDAPARTAMENTO = "+ ((Apartamento) imovel).getIdapartamento() +"";
		} else if(imovel instanceof Casa) {
			sql += "WHERE IDCASA = "+ ((Casa) imovel).getIdcasa() +"";
		}
		
	    PreparedStatement pstm = conn.prepareStatement(sql);
	    ResultSet rs = pstm.executeQuery();

    	Venda venda = new Venda();
	    
	    if (rs.next()) {
	    	venda.setIdvenda(rs.getInt("idvenda"));
	    	venda.setImovel(imovel);
	    	venda.setDataPagamentoVenda(rs.getDate("datapagamentovenda"));
	    	venda.setDataVendaFinalizada(rs.getDate("datavendafinalizada"));
	    	venda.setDataVendaIniciada(rs.getDate("datavendainiciada"));
	    	venda.setFormaPagamento(rs.getString("formapagamento"));
	    	venda.setValorAnual(rs.getDouble("valoranual"));
	    	venda.setValorMensal(rs.getDouble("valormensal"));
			return venda;
	    }
		return null;
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

    	Locacao locacao = new Locacao();
	    
	    if (rs.next()) {
	    	locacao.setIdlocacao(rs.getInt("idlocacao"));
	    	locacao.setImovel(imovel);
	    	locacao.setDataLocacaoFim(rs.getDate("datalocacaofim"));
	    	locacao.setDataLocacaoInicio(rs.getDate("datalocacaoinicio"));
	    	locacao.setFormaPagamento(rs.getString("formapagamento"));
	    	locacao.setValorAnual(rs.getDouble("valoranual"));
	    	locacao.setValorMensal(rs.getDouble("valormensal"));
			return locacao;
	    }
	    return null;
	}
	
	public static List<Object> queryImoveisLocacaoVenda(Connection conn, String tipoNegocio, String tipoImovel) throws SQLException {
		String sql = "SELECT * FROM IMOVEL";
		
		switch (tipoImovel) {
		case "ap":
			sql += " WHERE TIPO = \"AP\"";
			break;
		case "ca":
			sql = " WHERE TIPO = \"CA\"";
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
	    	imovel.setDormitorios(rs.getInt("dormitorios"));
	    	imovel.setBanheiros(rs.getInt("banheiros"));
	    	imovel.setSuites(rs.getInt("suites"));
	    	imovel.setVagasGaragem(rs.getInt("vagasgaragem"));
	    	imovel.setAreaConstruida(rs.getDouble("areaconstruida"));
	    	imovel.setAreaTotal(rs.getDouble("areatotal"));
	    	imovel.setValor(rs.getDouble("valor"));
	    	imovel.setDescricao(rs.getString("descricao"));
	    	imovel.setCidade(rs.getString("cidade"));
	    	imovel.setBairro(rs.getString("bairro"));
	    	imovel.setRua(rs.getString("rua"));
	    	imovel.setNumero(rs.getString("numero"));
	    	imovel.setObservacao(rs.getString("observacao"));
	    	imovel.setStatus(rs.getString("status"));
	    	
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
		String sql = "SELECT * FROM APARTAMENTO WHERE IDIMOVEL = ? LIMIT 1";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, imovel.getIdimovel());
		ResultSet rs = pstm.executeQuery();

		Apartamento ap = new Apartamento();
		
		if (rs.next()) {
			ap.setIdapartamento(rs.getInt("idapartamento"));
			ap.setImovel(imovel);
			ap.setBloco(rs.getString("bloco"));
			ap.setAndar(rs.getInt("andar"));
			ap.setNumeroAp(rs.getInt("numeroAp"));
			ap.setSacada(rs.getBoolean("sacada"));
			return ap;
		}
		return null;
	}
	
	public static <T extends Imovel> Casa queryFindCasa(Connection conn, Imovel imovel) throws SQLException {
		String sql = "SELECT * FROM CASA WHERE IDIMOVEL = ? LIMIT 1";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, imovel.getIdimovel());
		ResultSet rs = pstm.executeQuery();
		
		Casa ca = new Casa();
		
		if (rs.next()) {
			ca.setIdcasa(rs.getInt("idcasa"));
			ca.setImovel(imovel);
			ca.setLote(rs.getString("lote"));
			ca.setQuadra(rs.getString("quadra"));
			return ca;
		}
		return null;
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
	    	imovel.setIdimovel(rs.getInt("idimovel"));
	    	imovel.setFotos(queryImovelFoto(conn, imovel));
	    	imovel.setTipo(rs.getString("tipo"));
	    	imovel.setDormitorios(rs.getInt("dormitorios"));
	    	imovel.setBanheiros(rs.getInt("banheiros"));
	    	imovel.setSuites(rs.getInt("suites"));
	    	imovel.setVagasGaragem(rs.getInt("vagasgaragem"));
	    	imovel.setAreaConstruida(rs.getDouble("areaconstruida"));
	    	imovel.setAreaTotal(rs.getDouble("areatotal"));
	    	imovel.setValor(rs.getDouble("valor"));
	    	imovel.setDescricao(rs.getString("descricao"));
	    	imovel.setCidade(rs.getString("cidade"));
	    	imovel.setBairro(rs.getString("bairro"));
	    	imovel.setRua(rs.getString("rua"));
	    	imovel.setNumero(rs.getString("numero"));
	    	imovel.setObservacao(rs.getString("observacao"));
	    	imovel.setStatus(rs.getString("status"));
	    	
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

  /*public static Product findProduct(Connection conn, String code) throws SQLException {
    String sql = "Select a.Code, a.Name, a.Price from Product a where a.Code=?";

    PreparedStatement pstm = conn.prepareStatement(sql);
    pstm.setString(1, code);

    ResultSet rs = pstm.executeQuery();

    while (rs.next()) {
      String name = rs.getString("Name");
      float price = rs.getFloat("Price");
      Product product = new Product(code, name, price);
      return product;
    }
    return null;
  }

  public static void updateProduct(Connection conn, Product product) throws SQLException {
    String sql = "Update Product set Name =?, Price=? where Code=? ";

    PreparedStatement pstm = conn.prepareStatement(sql);

    pstm.setString(1, product.getName());
    pstm.setFloat(2, product.getPrice());
    pstm.setString(3, product.getCode());
    pstm.executeUpdate();
  }

  public static void insertProduct(Connection conn, Product product) throws SQLException {
    String sql = "Insert into Product(Code, Name,Price) values (?,?,?)";

    PreparedStatement pstm = conn.prepareStatement(sql);

    pstm.setString(1, product.getCode());
    pstm.setString(2, product.getName());
    pstm.setFloat(3, product.getPrice());

    pstm.executeUpdate();
  }

  public static void deleteProduct(Connection conn, String code) throws SQLException {
    String sql = "Delete from Product where Code= ?";

    PreparedStatement pstm = conn.prepareStatement(sql);

    pstm.setString(1, code);

    pstm.executeUpdate();
  }
  */

}