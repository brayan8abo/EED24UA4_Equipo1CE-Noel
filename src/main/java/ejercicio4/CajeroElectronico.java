package ejercicio4;

import java.util.Scanner;

import ejercicio4.Cliente;

public class CajeroElectronico {

	public static void main(String[] args) {

//		- Tarea 2(1) crear Clase principal CajeroEletronico con un método main de ejecución que muestre un menú de estados solicitando:
//		   - Identificador de cliente
//		   - Password de cliente
//		   tras lo que mostrará un mensaje saludando al identificador.

		Cliente[] clientes = new Cliente[5];

		clientes[0] = new Cliente(1, 1);
		clientes[1] = new Cliente(2, 2);
		clientes[2] = new Cliente(3, 3);
		clientes[3] = new Cliente(4, 4);
		clientes[4] = new Cliente(5, 5);

		Scanner sc = new Scanner(System.in);

		int identificadorCliente;
		int password;
		boolean para = true;

		System.out.println("---------------------------------------");
		System.out.println("-----------CAJERO AUTOMATICO-----------");
		System.out.println("---------------------------------------");
		System.out.println("---------------------------------------");
		do {
			System.out.println("INTRODUCE EL IDENTIFICADOR DE CLIENTE :");
			identificadorCliente = sc.nextInt();
			if (Cliente.verificarIdentidicador(clientes, identificadorCliente)) {
				System.out.println("---------------------------------------");
				para = false;

				System.out.println("INTRODUCE LA CONTRASEÑA DEL IDENTIFICADOR " + identificadorCliente + " :");
				password = sc.nextInt();

				if (Cliente.verificarPassword(clientes, password)) {

					System.out.println("---------------------------------------");
					System.out.println("--------- SALUDOS : " + identificadorCliente + " ---------------");
					System.out.println("---------------------------------------");

				} else if (!Cliente.verificarPassword(clientes, password)) {
					System.out.println("Error: credenciales incorrectas");
					para = false;
				}

			} else {
				System.out.println("Error: el usuario no existe");
				para = false;
			}

		} while (para);
		sc.close();

		if (!para) {
			System.out.println("---------------------------------------");
			System.out.println("---------------- ADIOS ----------------");
			System.out.println("---------------------------------------");
		}
	}
}
