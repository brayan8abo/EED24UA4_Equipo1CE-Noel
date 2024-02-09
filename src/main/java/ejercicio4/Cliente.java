package ejercicio4;

//- Tarea 2(3) crear Clase Cliente con los atributos identificador, password

public class Cliente {
	int identificador;
	int password;
	double saldo;

	public Cliente(int identificador, int password) {
		this.identificador = identificador;
		this.password = password;
	}

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	static boolean verificarIdentidicador(Cliente[] cliente, int identificador) {
		boolean correcto = false;

		for (int i = 0; i < cliente.length; i++) {
			if (cliente[i].identificador == identificador) {
				correcto = true;
				return correcto;
			}

		}

		return correcto;

	}

	static boolean verificarPassword(Cliente[] cliente, int password) {
		boolean correcto = false;

		for (int i = 0; i < cliente.length; i++) {

			if (cliente[i].password == password) {

				correcto = true;
				return correcto;
			}else {
				correcto = false;
				return false;

			}
		}
		return correcto;
	}
}
