package ejercicio4;

import java.util.Random;
import java.util.Scanner;

//- Tarea 2(3) crear Clase Cliente con los atributos identificador, password

public class Cliente {
	Random rnd = new Random();

	// atributos
	int identificador;
	int password;
	double monedero = rnd.nextDouble(1000, 20001);

	// constructor
	public Cliente(int identificador, int password) {
		this.identificador = identificador;
		this.password = password;
	}

	// metodo para mostrar el saldo
	static double mostrarSaldo(Cliente cliente) {
		return cliente.monedero;
	}

	// metodo para ingresar importe
	static void ingresarImporte(Cliente cliente) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Indica el importe a ingresar: ");
		double importe = sc.nextDouble();
		cliente.monedero = importe + cliente.monedero;
		System.out.println("Ha ingresado " + importe + "€");
	}

	// metodo para sacar importe
	static void obtenerImporte(Cliente cliente) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Indica el importe a obtener: ");
		double importe = sc.nextDouble();
		cliente.monedero = cliente.monedero - importe;
		System.out.println("Ha obtenido " + importe + "€");
	}
	
	//metodo para transferir dinero
	static void transferirImporte(Cliente cliente, Cliente cliente1) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Indica el importe a transferir: ");
		double importe = sc.nextDouble();
		cliente.monedero = cliente.monedero - importe;
		cliente1.monedero = cliente1.monedero + importe;
		System.out.println("Ha transferdo " + importe + "€");
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
			} else {
				correcto = false;
				return false;
			}
		}
		return correcto;
	}

	@Override
	public String toString() {
		return "Cliente [identificador=" + identificador + ", password=" + password + ", monedero=" + monedero + "€]";
	}

}
