package proyecto;

import java.util.Scanner;

import proyecto.Cliente;

public class CajeroElectronico {

	public static void main(String[] args) {

//		- Tarea 2(1) crear Clase principal CajeroEletronico con un método main de ejecución que muestre un menú de estados solicitando:
//		   - Identificador de cliente
//		   - Password de cliente
//		   tras lo que mostrará un mensaje saludando al identificador.
		
		
		
		//EL PROGRAMA SOLO DEJA DE FUNCIONAR CUANDO SE INTRODUCE UN IDENTIFICADOR INCORRECTO

		Cliente[] clientes = new Cliente[5];

		clientes[0] = new Cliente(6123,1,1);
		clientes[1] = new Cliente(231,23,2);
		clientes[2] = new Cliente(4312,3,3);
		clientes[3] = new Cliente(6423,4,4);
		clientes[4] = new Cliente(5512,5,5);
		
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
				para = true;
				System.out.println("INTRODUCE LA CONTRASEÑA DEL IDENTIFICADOR " + identificadorCliente + " :");
				password = sc.nextInt();
				if (Cliente.verificarPassword(clientes, password)) {
					System.out.println("---------------------------------------");
					System.out.println("--------- SALUDOS : " + identificadorCliente + " ---------------");
					System.out.println("---------------------------------------");
					menu(clientes, identificadorCliente);
				} else {
					System.out.println("Error: credenciales incorrectas");
					
				}
				
			} else {
				System.out.println("Error: el usuario no existe");
				para = false;
			}
			if (!para) {
				System.out.println("---------------------------------------");
				System.out.println("---------------- ADIOS ----------------");
				System.out.println("---------------------------------------");
			}
			
		} while (para);
		
		
		
		
	}
	
	static void menu(Cliente[] clientes, int identificadorCliente) {
		Scanner sc = new Scanner(System.in);
		int opcion=1;
		
		do {
			System.out.println("1: Mostrar saldo actual");
			System.out.println("2: Ingresar importe");
			System.out.println("3: Retirar importe");
			System.out.println("4: Transferir importe");
			System.out.println("0: Salir (volverá al menú de introducción de claves)");
			opcion = sc.nextInt();
			switch (opcion) {
			case 1:
				System.out.println("1: Mostrar saldo actual");
				//System.out.println(Cliente.mostrarSaldo(clientes[0])); old
				Cliente.verMonedero(clientes, identificadorCliente);//new
				
				break;
			case 2:
				System.out.println("2: Ingresar importe");
				//Cliente.ingresarImporte(clientes[0]); old
				Cliente.ingresoMonedero(clientes, identificadorCliente); //new
				break;
			case 3:
				System.out.println("3: Retirar importe");
				//Cliente.obtenerImporte(clientes[0]); old
				Cliente.retiradaMonedero(clientes, identificadorCliente);//new
				break;
			case 4:
				System.out.println("4: Transferir importe");
				//Cliente.transferirImporte(clientes[0], clientes[0]); old
				Cliente.traspasarMonedero(clientes, identificadorCliente);//new
				break;
			case 0:
				System.out.println("Ha salido del menu");
				break;
			default:
				System.out.println("Opción incorrecta, escriba una opción del 0 al 4");
				break;
			}
		} while (opcion !=0);
	}
}
