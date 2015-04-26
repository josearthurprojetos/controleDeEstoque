package packconexao;
import java.sql.*;

public class Conexao {
	Connection con;
	Statement stm;
	
	public Conexao(){
				try{
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					
					con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433; databaseName=ControleDeEstoque",
							"sa","manager");
					
					stm = con.createStatement();
				}catch(java.lang.ClassNotFoundException e){
					System.err.print(e);
				} catch (SQLException e) {
					System.err.print(e);
				}
	}
	
	public void executaSQL(String query){
		try{
			stm.executeQuery(query);
		}catch(SQLException e){
			System.err.print(e);
		}
	}
	
	public ResultSet retornaDados(String query){
		ResultSet result = null;
		try{
			result = stm.executeQuery(query);
			return result;
		}catch(SQLException e){
			System.err.print(e);
		}
		return result;
	}
	
}
