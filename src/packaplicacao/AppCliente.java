package packaplicacao;

import java.awt.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import packmodelo.ClienteFornecedor;
import packmodelo.Funcionario;

public class AppCliente extends Crud<ClienteFornecedor> {

	@Override
	public void cadastrar(ClienteFornecedor obj) {
		this.query = "INSERT INTO CLIENTEREVENDEDOR"+
				"(nome_cliente, empresa_cliente, datacadastro_cliente, valorvendido_cliente)" +
				"VALUES('" + obj.getNome() + "','"+ obj.getNomeEmpresa() +"','" + obj.getDataCadastro() + "' , " +
				obj.getValorVendido() + ")";
		
		this.con.executaSQL(this.query);
	}

	@Override
	public void alterar(ClienteFornecedor obj) {
		this.query = "UPDATE CLIENTEREVENDEDOR SET "+
				"nome_cliente = '" + obj.getNome() + "', "+
				"empresa_cliente = '"+obj.getNomeEmpresa() +"', " +
				"datacadastro_cliente = '" + obj.getDataCadastro() + "' ," +
				"valorvendido_cliente = " + obj.getValorVendido() + 
				" WHERE cod_cliente = " + obj.getCodigo();
		this.con.executaSQL(this.query);
	}

	@Override
	public void excluir(ClienteFornecedor obj) {
		this.query = "DELETE FROM CLIENTEREVENDEDOR WHERE COD_CLIENTE = " + obj.getCodigo();
		this.con.executaSQL(query);
	}

	@Override
	public ClienteFornecedor consultaId(int id) {
		ResultSet result;
		ClienteFornecedor cli = new ClienteFornecedor();
		this.query = "SELECT * FROM clienterevendedor WHERE cod_cliente = " + id;

		try {
			result = this.con.retornaDados(query);
			result.next();
			cli.setNome(result.getString("nome_cliente"));
			cli.setCodigo(result.getInt("cod_cliente"));
			cli.setCpf(result.getString("cpf_cliente"));
			cli.setRg(result.getString("rg_cliente"));
			cli.setTelFixo(result.getString("tel_cliente"));
			cli.setTelCelular(result.getString("cel_cliente"));
			cli.setFoto(result.getString("foto_cliente"));
			cli.setNomeEmpresa(result.getString("empresa_cliente"));
			cli.setDataCadastro(result.getDate("datacadastro_cliente"));
			cli.setValorVendido(result.getFloat("valorvendido_cliente"));
			return cli;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Collection<ClienteFornecedor> consultaNome(String nome) {
		ResultSet result;
		this.query = "Select * from clienterevendedor where nome_cliente like '%"+nome+"%'";
		result = this.con.retornaDados(this.query);

		return resultEmObjeto(result);
	}

	@Override
	public Collection<ClienteFornecedor> listaTodos() {
		ResultSet result;
		this.query = "Select * from clienterevendedor";
		result = this.con.retornaDados(this.query);
		return resultEmObjeto(result);
	}

	@Override
	public Collection<ClienteFornecedor> resultEmObjeto(ResultSet result) {
		Collection<ClienteFornecedor> clientes = new ArrayList<ClienteFornecedor>();
		try {
			while(result.next()){
				clientes.add(new ClienteFornecedor(result.getString("nome_cliente"),
						result.getInt("cod_cliente"),
						result.getString("cpf_cliente"),
						result.getString("rg_cliente"),
						result.getString("tel_cliente"),
						result.getString("cel_cliente"),
						result.getString("foto_cliente"),
						result.getDate("datacadastro_cliente"),
						result.getString("empresa_cliente"),
						result.getFloat("valorvendido_cliente")));
			}
			return clientes;
		} catch (SQLException e) {
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

}
