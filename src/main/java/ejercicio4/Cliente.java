package ejercicio4;

//- Tarea 2(3) crear Clase Cliente con los atributos identificador, password

public class Cliente {
	String cliente;
	String password;
	double saldo;

	public Cliente(String identificador, String password) {
		this.cliente = identificador;
		this.password = password;
	}

	public String getIdentificador() {
		return cliente;
	}

	public void setIdentificador(String identificador) {
		this.cliente = identificador;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean verificarIdentidicador(String identificador) {
		return this.cliente.equals(identificador);
	}

	public boolean verificarPassword(String password) {
		return this.password.equals(password);
	}

}
