package packmodelo;

/***********************************************************************
 * Module:  Funcionario.java
 * Author:  josé
 * Purpose: Defines the Class Funcionario
 ***********************************************************************/

/** @pdOid 17598bde-0991-4bfb-a31a-1c5a29774afa */
public class Funcionario extends Pessoa {
	private Cargo cargo;
	
	public Funcionario(){}
	
	public Funcionario(String nome, int codigo, String CPF, String RG, String telFixo, String telCelular, String Foto, Cargo cargo){
		super(nome, codigo, CPF, RG,telFixo,telCelular, Foto);
		this.setCargo(cargo);
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
}