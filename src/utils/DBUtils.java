package utils;

import java.sql.*;
//import java.util.*;
import model.Usuario;

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

/*	public static List<Product> queryProduct(Connection conn) throws SQLException {
		String sql = "Select a.Code, a.Name, a.Price from Product a ";

	    PreparedStatement pstm = conn.prepareStatement(sql);
	
	    ResultSet rs = pstm.executeQuery();
	    List<Product> list = new ArrayList<Product>();
	    while (rs.next()) {
	    	String code = rs.getString("Code");
	    	String name = rs.getString("Name");
	    	float price = rs.getFloat("Price");
	    	Product product = new Product();
	    	product.setCode(code);
	    	product.setName(name);
	    	product.setPrice(price);
	    	list.add(product);
	    }
	    return list;
	}

  public static Product findProduct(Connection conn, String code) throws SQLException {
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