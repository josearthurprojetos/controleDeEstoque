package packmodelo;

public class Cargo {
	private int codigo_cargo;
	private String cargo;
	private float salario;
	
	public Cargo(){}
	
	public Cargo(String cargo, float salario, int codigo){
		this.setCargo(cargo);
		this.setSalario(salario);
		this.setCodigoCargo(codigo);
	}
	
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	
	public int getCodigoCargo() {
		return codigo_cargo;
	}
	public void setCodigoCargo(int codigo) {
		this.codigo_cargo = codigo;
	}
}
