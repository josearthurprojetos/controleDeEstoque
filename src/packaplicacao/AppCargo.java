package packaplicacao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import packmodelo.Cargo;
import packmodelo.Funcionario;

public class AppCargo extends Crud<Cargo> {

	@Override
	public void cadastrar(Cargo obj) {
		this.query = "INSERT INTO CARGO(nome_cargo, salario_cargo) VALUES('"+ 
				obj.getCargo() +"','"+ obj.getSalario() +"')";
		this.con.executaSQL(query);
	}

	@Override
	public void alterar(Cargo obj) {
		this.query = "UPDATE cargo SET nome_cargo = '" + obj.getCargo() 
				+ "', salario_cargo = "+ obj.getSalario() +
				" WHERE cod_cargo = " + obj.getCodigoCargo();
		
		con.executaSQL(this.query);
	}

	@Override
	public void excluir(Cargo obj) {
		this.query = "DELETE FROM cargo WHERE cod_cargo = " +obj.getCodigoCargo();
		con.executaSQL(this.query);
	}

	@Override
	public Cargo consultaId(int id) {
		Cargo cargo = new Cargo();
		ResultSet result;
		this.query = "SELECT * FROM cargo WHERE cod_cargo = " + id;
		
		
		try{
			result = this.con.retornaDados(this.query);
			result.next();
			cargo.setCargo(result.getString("nome_cargo"));
			cargo.setSalario(result.getFloat("salario_cargo"));
			cargo.setCodigoCargo(id);
			return cargo;
		}catch(Exception e){
			System.err.print(e);
		}

		return null;
	}

	@Override
	public Collection<Cargo> consultaNome(String nome) {
		ResultSet result;
		
		this.query = "SELECT * FROM cargo WHERE nome_cargo like '%" + nome + "%'";

		try{
			result = con.retornaDados(this.query);
			return resultEmObjeto(result);
		}catch(Exception e){
			System.err.print(e);
		}
		
		return null;
	}

	@Override
	public Collection<Cargo> listaTodos() {
		ResultSet result;
		this.query = "SELECT * FROM cargo";
		
		try{
			result = con.retornaDados(this.query);
			return resultEmObjeto(result);
		}catch(Exception e){
			System.err.print(e);
		}
		return null;
	}

	@Override
	public Collection<Cargo> resultEmObjeto(ResultSet result) {
		Collection<Cargo> cargoLista = new ArrayList<Cargo>();
		try{
			while(result.next()){
				cargoLista.add(new Cargo(result.getString("nome_cargo"),
						result.getFloat("salario_cargo"),
						result.getInt("cod_cargo")));

			}
			return cargoLista;
		}catch(Exception e){
			System.err.print(e);
		}
		return null;
	}
}
