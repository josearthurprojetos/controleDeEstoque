package packaplicacao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import packmodelo.Produto;

public class AppProduto extends Crud<Produto>{

	@Override
	public void cadastrar(Produto obj) {
		this.query = 
				"INSERT INTO PRODUTO(PRECOCOMPRA_PRODUTO,"+
						" PRECOVENDA_PRODUTO, NOME_PRODUTO, MARCA_FORN_PRODUTO, QUANTIDADE_PRODUTO)"+
						"VALUES("+obj.getPrecoCompra()+","
						+obj.getPrecoVenda() + ", '"+
						obj.getNomeProduto() + "','"+
						obj.getMarcaProduto() + "',"+
						obj.getQuantProduto() + ")";
		
		this.con.executaSQL(query);
	}

	@Override
	public void alterar(Produto obj) {
		this.query = 
				"UPDATE PRODUTO SET " +
				" PRECOCOMPRA_PRODUTO = " + obj.getPrecoCompra()+ "," +
				" PRECOVENDA_PRODUTO = " + obj.getPrecoVenda() + ", "+
				" NOME_PRODUTO = '" + obj.getNomeProduto() + "',"+
				" MARCA_FORN_PRODUTO = '" + obj.getMarcaProduto() + "'," +
				" QUANTIDADE_PRODUTO = " + obj.getQuantProduto() +
				" WHERE COD_PRODUTO = " + obj.getCodigo();

		this.con.executaSQL(query);
	}

	@Override
	public void excluir(Produto obj) {
		this.query = "DELETE FROM PRODUTO WHERE COD_PRODUTO = "+ obj.getCodigo();
		
		this.con.executaSQL(this.query);
	}

	@Override
	public Produto consultaId(int id) {
		ResultSet result;
		Produto produto = new Produto();
		
		this.query = "SELECT * FROM PRODUTO WHERE COD_PRODUTO = " + id;
		
		result = this.con.retornaDados(this.query);
		try{
			if(result.first()){
				produto.setCodigo(id);
				produto.setPrecoVenda(result.getFloat("PRECOVENDA_PRODUTO"));
				produto.setPrecoCompra(result.getFloat("PRECOCOMPRA_PRODUTO"));
				produto.setNomeProduto(result.getString("NOME_PRODUTO"));
				produto.setMarcaProduto(result.getString("MARCA_FORN_PRODUTO"));
				produto.setQuantProduto(result.getInt("QUANTIDADE_PRODUTO"));

				return produto;
				
			}
		}catch(SQLException ex){
			System.err.println("Erro com result set :" + ex.getMessage());
		}catch(Exception e){
			System.err.println("Erro :" + e.getMessage());
		}
		return null;
	}

	@Override
	public Collection<Produto> consultaNome(String nome) {
		ResultSet result;
		// Esta query busca nome do produto e nome do fornecedor. A tabela fornecedor não foi criada!
		this.query = "SELECT * FROM PRODUTO WHERE NOME_PRODUTO LIKE '%" + nome +"%' "
				+ " OR MARCA_FORN_PRODUTO LIKE '%" + nome + "%'";
		
		result = this.con.retornaDados(this.query);
		
		return resultEmObjeto(result);
	}

	@Override
	public Collection<Produto> listaTodos() {
		ResultSet result;
		this.query = "SELECT * FROM PRODUTO";
		
		result = this.con.retornaDados(this.query);
		
		return resultEmObjeto(result);
	}

	@Override
	public Collection<Produto> resultEmObjeto(ResultSet result) {
		Collection<Produto> produtos = new ArrayList<Produto>();
		try{
			while(result.next()){
				produtos.add(new Produto(
						result.getInt("COD_PRODUTO"),
						result.getFloat("PRECOVENDA_PRODUTO"),
						result.getFloat("PRECOCOMPRA_PRODUTO"),
						result.getString("NOME_PRODUTO"),
						result.getString("MARCA_FORN_PRODUTO"),
						result.getInt("QUANTIDADE_PRODUTO")
						));
			}
			return produtos;
		}catch(Exception e){
			System.out.println(e.getMessage());
		}

		return null;
	}
	
	

}
