package packaplicacao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import packmodelo.Funcionario;

public class AppFuncionario extends Crud<Funcionario> {
	
	@Override
	public void cadastrar(Funcionario obj) {		
		this.query = "INSERT INTO Funcionario(nome_func,cargo_func,cpf_func,rg_func,tel_func,cel_func,foto_func) values('"+
				obj.getNome()+"','"+
				obj.getCargo().getCodigoCargo()+ "','"+
				obj.getCpf()+ "','"+
				obj.getRg()+ "','"+
				obj.getTelFixo()+ "','"+
				obj.getTelCelular()+ "','"+
				obj.getFoto()+"');";
		
		this.con.executaSQL(query);
	}

	@Override
	public void alterar(Funcionario obj) {
		this.query = "UPDATE Funcionario SET "+
				"nome_func= '" + obj.getNome() + "', "+
				"cargo_func= '" + obj.getCargo().getCodigoCargo() + "', "+
				"cpf_func= '" + obj.getCpf() + "', "+
				"rg_func= '" + obj.getRg() + "', "+
				"tel_func= '" + obj.getTelFixo() + "', "+
				"cel_func= '" + obj.getTelCelular() + "', "+
				"foto_func= '" + obj.getFoto() + "' "+
				"WHERE cod_func = "+ obj.getCodigo();
		this.con.executaSQL(this.query);
	}

	@Override
	public void excluir(Funcionario obj) {
		this.query = "DELETE FROM Funcionario WHERE cod_func = " + obj.getCodigo();
		this.con.executaSQL(query);
	}

	@Override
	public Funcionario consultaId(int id) {
		ResultSet result;
		AppCargo appCargo = new AppCargo();
		Funcionario func = new Funcionario();
		this.query = "SELECT * FROM Funcionario WHERE cod_func = " + id;

		try {
			result = this.con.retornaDados(query);
			result.next();
			func.setNome(result.getString("nome_func"));
			func.setCodigo(result.getInt("cod_func"));
			func.setCpf(result.getString("cpf_func"));
			func.setRg(result.getString("rg_func"));
			func.setTelFixo(result.getString("tel_func"));
			func.setTelCelular(result.getString("cel_func"));
			func.setFoto(result.getString("foto_func"));
			func.setCargo(appCargo.consultaId(result.getInt("cargo_func")));
			return func;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Collection<Funcionario> consultaNome(String nome) {
		ResultSet result;
		this.query = "select * from funcionario where nome_func like '%"+nome+"%'";
		result = this.con.retornaDados(this.query);
		return resultEmObjeto(result);		
		
	}

	@Override
	public Collection<Funcionario> listaTodos() {
		ResultSet result;
		this.query = "select * from funcionario";
		result = this.con.retornaDados(this.query);
		return resultEmObjeto(result);	
	}

	@Override
	public Collection<Funcionario> resultEmObjeto(ResultSet result) {
		Collection<Funcionario> funcionarios = new ArrayList<Funcionario>();
		AppCargo cargo = new AppCargo();
		try {
			while(result.next()){
				funcionarios.add(new Funcionario(result.getString("nome_func"),
						result.getInt("cod_func"),
						result.getString("cpf_func"),
						result.getString("rg_func"),
						result.getString("tel_func"),
						result.getString("cel_func"),
						result.getString("foto_func"),
						cargo.consultaId(result.getInt("cargo_func"))));
			}
			return funcionarios;
		} catch (SQLException e) {
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
