package proyecto;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.lang.NullPointerException;

//- Tarea 2(3) crear Clase Cliente con los atributos identificador, password

public class Cliente {
	Random rnd = new Random();

	// atributos
	private int identificador;
	private int password;
	private int indice;

	double monedero = rnd.nextDouble(10000, 20001);

	public Random getRnd() {
		return rnd;
	}

	public void setRnd(Random rnd) {
		this.rnd = rnd;
	}

	// AÑADIR UNA ARRAY DE INVERSIONES EN CLASE CLIENTE
	ArrayList<Inversion> inversiones = new ArrayList<>(5);

	// constructor
	public Cliente(int identificador, int password, int indice) {
		this.setIdentificador(identificador);
		this.password = password;
		this.indice = indice;
	}

	static void verMonedero(Cliente[] array, int identificador) {

		for (int i = 0; i < array.length; i++) {

			if (array[i].getIdentificador() == identificador) {

				System.out.println("El saldo de tu monedero es : " + array[i].monedero + "€");
			}
		}

	}

	static void traspasarMonedero(Cliente[] array, int identificadorEmisor) {
		Scanner sc = new Scanner(System.in);
		int identificadorReceptor;
		double transferencia;
		boolean password = true; // cambiamos nombre de variable
		boolean emptyCliente = true;
		System.out.println("Introduce el identificador del receptor de la transferencia");
		identificadorReceptor = sc.nextInt();
		System.out.println("Introduce el importe de la transferencia");
		transferencia = sc.nextDouble();

		for (int i = 0; i < array.length; i++) {

			if (array[i].getIdentificador() == identificadorEmisor) {

				for (int j = 0; j < array.length; j++) {

					if (array[j].getIdentificador() == identificadorReceptor) {

						array[j].monedero = array[j].monedero + transferencia;
						array[i].monedero = array[i].monedero - transferencia;

						System.out.println("Tranferecia realizada correctamente");
						System.out.println("Tu saldo es ahora de : " + array[i].monedero + "€");
						password = false;

					}

				}

				emptyCliente = false;
			}
		}

		if (password) {

			System.out.println("Error..El Identificador :" + identificadorReceptor + " No existe.");

		}
		if (emptyCliente) {

			System.out.println("Error en tu identificador vuelve a logearte");

		}
		sc.close();
	}

	static void ingresoMonedero(Cliente[] array, int identificador) {

		Scanner sc = new Scanner(System.in);

		boolean errorIngreso = true;

		System.out.println("Introduce el importe a ingresar");
		double ingreso = sc.nextDouble();

		for (int i = 0; i < array.length; i++) {

			if (identificador == array[i].getIdentificador()) {

				array[i].monedero = array[i].monedero + ingreso;
				System.out.println("Acabas de ingresar: " + ingreso);
				System.out.println("Tu monedero es de: " + array[i].monedero);
				System.out.println();
				errorIngreso = false;
			}

		}
		if (errorIngreso) {
			System.err.println("Error..No se pudo realizar el ingreso");
		}
		sc.close();

	}

	static void retiradaMonedero(Cliente[] array, int identificador) {
		Scanner sc = new Scanner(System.in);
		boolean monederoEmpty = true;

		System.out.println("Introduce el importe a retirar");
		double retirada = sc.nextDouble();

		if (retirada > 0) {

			for (int i = 0; i < array.length; i++) {

				if (identificador == array[i].getIdentificador()) {

					if (array[i].monedero >= retirada) {
						array[i].monedero = array[i].monedero - retirada;
						System.out.println("Acabas de retirar : " + retirada + "€");
						System.out.println("Tu monedero es de : " + array[i].monedero + "€");
						System.out.println();
						monederoEmpty = false;
					} else {
						monederoEmpty = true;
					}

				}

			}
		} else if (monederoEmpty || retirada <= 0) {
			System.out.println(
					"No se puede realizar la retirada, Monedero insuficiente o el importe de la retirada son 0 € o menos");
		}
		sc.close();

	}

	static boolean verificarIdentidicador(Cliente[] cliente, int identificador) {
		boolean correcto = false;

		for (int i = 0; i < cliente.length; i++) {
			if (cliente[i].getIdentificador() == identificador) {
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

			}
		}
		return correcto;
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

	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}

	public double getMonedero() {
		return monedero;
	}

	public void setMonedero(double monedero) {
		this.monedero = monedero;
	}

	public ArrayList<Inversion> getInversiones() {
		return inversiones;
	}

	public void setInversiones(ArrayList<Inversion> inversiones) {
		this.inversiones = inversiones;
	}

	public static void añadirInversion(ArrayList<Inversion> matrizInversionCliente) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el nombre de la inversion que quieres crear");
		String nombre = sc.nextLine();
		System.out.println("Introduce el importe de la inversion que quieres crear");
		String importeInversion = sc.nextLine(); // sc.nextDouble();
		Double importeFormateada = 1.0;
		try {
			importeFormateada = Double.parseDouble(importeInversion);
		} catch (NullPointerException | NumberFormatException e) {
			System.out.println("ESTE CODIGO NO FURULA ");
		}
		matrizInversionCliente.add(new Inversion(importeFormateada, nombre));

		sc.close();
	}

	public static void eliminarInversion(ArrayList<Inversion> matrizInversionCliente) {
		Scanner sc = new Scanner(System.in);
		boolean inversionEmpty = true;
		System.out.println("Introduce el nombre de la inversion que quieres eliminar");
		String nombre = sc.nextLine();

		for (int i = 0; i < matrizInversionCliente.size(); i++) {
			Inversion inversion = matrizInversionCliente.get(i);
			if (inversion.getNombre().equalsIgnoreCase(nombre)) {

				matrizInversionCliente.remove(i);
				inversionEmpty = false;
				System.out.println("La inversion : " + nombre + " fue eliminada");
			}
		}

		if (inversionEmpty) {

			System.out.println("Error la inversion :" + nombre + " no existe en tu cartera de inversiones");
		}
		sc.close();
	}

	static void mostrarInversiones(Cliente[] clientes, int identificadorCliente) {
		for (int i = 0; i < clientes.length; i++) {

			if (clientes[i].getIdentificador() == identificadorCliente) {

				for (int j = 0; j < clientes[i].inversiones.size(); j++) {
					System.out.println(clientes[i].inversiones.get(j));
				}
			}
		}
	}

	ArrayList<Recibo> recibos = new ArrayList<>(5);

	static void añadirRecibo(Cliente [] cliente,int identificadorCliente) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese el nombre del recibo:");
		String nombre = sc.nextLine();
		System.out.println("Ingrese la cantidad del recibo:");
		double cantidad = sc.nextDouble();
		Recibo recibo = new Recibo(nombre, cantidad);
		cliente.length;
		System.out.println("Recibo añadido con éxito.");
		sc.close();

	}

	public void añadirRecibo(Recibo recibo) {
		return;

	}

	@Override
	public String toString() {
		return "Cliente [identificador=" + getIdentificador() + ", password=" + password + ", monedero=" + monedero
				+ "€]";
	}

}
