package proyecto;


import java.util.Scanner;

public class CajeroElectronico {

	public static void main(String[] args) {


		// EL PROGRAMA SOLO DEJA DE FUNCIONAR CUANDO SE INTRODUCE UN IDENTIFICADOR
		// INCORRECTO

		Cliente[] clientes = new Cliente[5];

		clientes[0] = new Cliente(6123, 1, 1);
		clientes[1] = new Cliente(231, 23, 2);
		clientes[2] = new Cliente(4312, 3, 3);
		clientes[3] = new Cliente(6423, 4, 4);
		clientes[4] = new Cliente(5512, 5, 5);

		Recibo[] recibos = new Recibo[3];
		
		recibos[0] = new Recibo("Luz", 100);
		recibos[1] = new Recibo("Agua", 45);
		recibos[2] = new Recibo("Seguro hogar", 250);

		Scanner sc = new Scanner(System.in);

		int identificadorCliente;
		int password;
		boolean isCliente = true;

		System.out.println("---------------------------------------");
		System.out.println("-----------CAJERO AUTOMATICO-----------");
		System.out.println("---------------------------------------");
		System.out.println("---------------------------------------");
		do {
			System.out.println("INTRODUCE EL IDENTIFICADOR DE CLIENTE :");
			identificadorCliente = sc.nextInt();
			if (Cliente.verificarIdentidicador(clientes, identificadorCliente)) {
				System.out.println("---------------------------------------");
				isCliente = true;
				System.out.println("INTRODUCE LA CONTRASEÑA DEL IDENTIFICADOR " + identificadorCliente + " :");
				password = sc.nextInt();
				if (Cliente.verificarPassword(clientes, password)) {
					System.out.println("---------------------------------------");
					System.out.println("--------- SALUDOS : " + identificadorCliente + " ---------------");
					System.out.println("---------------------------------------");

					for (int i = 0; i < clientes.length; i++) {

						if (clientes[i].getIdentificador() == identificadorCliente) {

							for (int j = 0; j < recibos.length; j++) {

								if (recibos[j].pagarRecibos()) {

									System.out.println("\nTienes que pagar el recibo de " + recibos[j].getNombre()
											+ " por un importe de : " + recibos[j].getCantidadRecibo() + " €\n");

									System.out.println("\nTu saldo en cuenta antes de pagar el recibo : "
											+ recibos[j].getNombre() + " es de : " + clientes[i].getMonedero() + "€\n");

									clientes[i].setMonedero(clientes[i].getMonedero() - recibos[j].getCantidadRecibo());

									System.out.println("\nTu saldo en cuenta después de pagar el recibo : "
											+ recibos[j].getNombre() + " es de : " + clientes[i].getMonedero() + "€\n");
								}
							}
						}
					}
					menu(clientes, identificadorCliente);
				} else {
					System.out.println("Error: credenciales incorrectas");
				}
			} else {
				System.out.println("Error: el usuario no existe");
				isCliente = false;
			}
			if (!isCliente) {
				System.out.println("---------------------------------------");
				System.out.println("---------------- ADIOS ----------------");
				System.out.println("---------------------------------------");
			}

		} while (isCliente);
sc.close();
	}

	static void menu(Cliente[] clientes, int identificadorCliente) {
		Scanner sc = new Scanner(System.in);
		int opcion = 1;

		do {
			System.out.println("1: Mostrar saldo actual");
			System.out.println("2: Ingresar importe");
			System.out.println("3: Retirar importe");
			System.out.println("4: Transferir importe");
			System.out.println("5: Añadir inversion");
			System.out.println("6: Eliminar inversion");
			System.out.println("7: Mostrar inversiones");
			System.out.println("0: Salir (volverá al menú de introducción de claves)");
			opcion = sc.nextInt();
			switch (opcion) {
			case 1:
				System.out.println("1: Mostrar saldo actual");
				Cliente.verMonedero(clientes, identificadorCliente);
				break;
			case 2:
				System.out.println("2: Ingresar importe");
				Cliente.ingresoMonedero(clientes, identificadorCliente); 
				break;
			case 3:
				System.out.println("3: Retirar importe");
				
				Cliente.retiradaMonedero(clientes, identificadorCliente);
				break;
			case 4:
				System.out.println("4: Transferir importe");
				
				Cliente.traspasarMonedero(clientes, identificadorCliente);
				break;
			case 5:
				System.out.println("5: Añadir inversion");
				for (int i = 0; i < clientes.length; i++) {

					if (clientes[i].getIdentificador() == identificadorCliente) {

						Cliente.añadirInversion(clientes[i].inversiones);
					}
				}
				break;
			case 6:
				System.out.println("6: Eliminar inversion");
				for (int i = 0; i < clientes.length; i++) {

					if (clientes[i].getIdentificador() == identificadorCliente) {

						Cliente.eliminarInversion(clientes[i].inversiones);
					}
				}
				break;
			case 7:
				System.out.println("7: Mostrar inversiones");
				Cliente.mostrarInversiones(clientes, identificadorCliente);
				break;
			case 8:
				System.out.println("8. Añadir recibos");
				Cliente.añadirRecibo(clientes, identificadorCliente);
			case 0:
				System.out.println("Ha salido del menu");
				
				break;
			default:
				System.out.println("Opción incorrecta, escriba una opción del 0 al 4");
				break;
			}
		} while (opcion != 0);
		sc.close();
	}

	static boolean clienteExiste(Cliente[] clientes, int identificadorCliente) {

		boolean correcto = false;

		for (int i = 0; i < clientes.length; i++) {

			if (clientes[i].getIdentificador() == identificadorCliente) {

				correcto = true;
			}

		}
	
		return correcto;
	
	}
	
}
