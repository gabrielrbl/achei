package utils;

import java.sql.*;
import java.util.*;
import model.*;

public class DBUtils {
	public static Usuario encontrarUsuario(Connection conn, String email, String senha) throws SQLException {
	    String sql = "SELECT IDUSUARIO, NOME, CPF, EMAIL, SENHA, OBSERVACAO, ATIVO FROM USUARIO WHERE EMAIL = ? AND SENHA = ?";
	
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
	    String sql = "SELECT IDUSUARIO, NOME, CPF, EMAIL, SENHA, OBSERVACAO, ATIVO FROM USUARIO WHERE EMAIL = ?";
	
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
	
	public static <T extends Imovel> Apartamento queryFindApartamento(Connection conn, Imovel imovel) throws SQLException {
		String sql = "SELECT * FROM APARTAMENTO WHERE IDIMOVEL = ? LIMIT 1";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, imovel.getIdimovel());
		ResultSet rs = pstm.executeQuery();

		Apartamento ap = new Apartamento();
		
		while (rs.next()) {
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
		String sql = "SELECT * FROM CASA WHERE IDIMOVEL = ? LIMIT 1";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, imovel.getIdimovel());
		ResultSet rs = pstm.executeQuery();
		
		Casa ca = new Casa();
		
		while (rs.next()) {
			ca.setIdcasa(rs.getInt("idcasa"));
			ca.setImovel(imovel);
			ca.setLote(rs.getString("lote"));
			ca.setQuadra(rs.getString("quadra"));
		}
		return ca;
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