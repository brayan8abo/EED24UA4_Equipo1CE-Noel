package ejercicio4;

import java.util.Scanner;

import ejercicio4.Cliente;

public class CajeroElectronico {

	public static void main(String[] args) {

//		- Tarea 2(1) crear Clase principal CajeroEletronico con un método main de ejecución que muestre un menú de estados solicitando:
//		   - Identificador de cliente
//		   - Password de cliente
//		   tras lo que mostrará un mensaje saludando al identificador.

		Scanner sc = new Scanner(System.in);
		String cliente = "";
		String password = "";
		boolean para = true;

		System.out.println("---------------------------------------");
		System.out.println("-----------CAJERO AUTOMATICO-----------");
		System.out.println("---------------------------------------");
		System.out.println("---------------------------------------");
		System.out.println("INTRODUCE EL IDENTIFICADOR DE CLIENTE :");
		cliente = sc.nextLine();
		System.out.println("---------------------------------------");
		System.out.println("INTRODUCE LA CONTRASEÑA DEL IDENTIFICADOR " + cliente + " :");
		password = sc.nextLine();
		System.out.println("---------------------------------------");
		System.out.println("--------- SALUDOS : " + cliente + " ---------------");
		System.out.println("---------------------------------------");

//      - Tarea 2(3)crear un registro de clientes en la clase CajeroEletronico con 5 clientes diferentes
//	    modificar la ejecución del menu para que compruebe si el identificador introducido existe y después si la password es correcta.
//	    En caso erróneo se debe mostrar y volverá a empezar:
//	     - Si el usuario no está en el registro: "Error: el usuario no existe"
//	     - Si la contraseña no es correcta: "Error: credenciales incorrectas"
		
		Cliente[] clientes = new Cliente[5];

		clientes[0] = new Cliente("Cliente1", "A");
		clientes[1] = new Cliente("Cliente2", "B");
		clientes[2] = new Cliente("Cliente3", "C");
		clientes[3] = new Cliente("Cliente4", "D");
		clientes[4] = new Cliente("Cliente5", "E");

		for (int i = 0; i < clientes.length; i++) {
			do {
				cliente = sc.nextLine();
				if (!clientes[i].verificarIdentidicador(cliente)) {

				} else {
					System.out.println("Error: Error: el usuario no existe");
				}
				password = sc.nextLine();

				if (!clientes[i].verificarPassword(password)) {
					System.out.println("Acceso Concedido");
					para = false;
				} else {
					System.out.println("Error: credenciales incorrectas");
				}

			} while (para);
		}

		sc.nextLine();

	}
}
