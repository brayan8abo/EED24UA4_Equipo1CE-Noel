package ejercicio4;

import java.util.Scanner;

public class CajeroElectronico {

	public static void main(String[] args) {
		
		
//		- Tarea 2(1) crear Clase principal CajeroEletronico con un método main de ejecución que muestre un menú de estados solicitando:
//		   - Identificador de cliente
//		   - Password de cliente
//		   tras lo que mostrará un mensaje saludando al identificador.
		
		Scanner sc = new Scanner (System.in);
		int cliente;
		int password;
		
		System.out.println("---------------------------------------");
		System.out.println("-----------CAJERO AUTOMATICO-----------");
		System.out.println("---------------------------------------");
		System.out.println("---------------------------------------");
		System.out.println("INTRODUCE EL IDENTIFICADOR DE CLIENTE :");
		cliente=sc.nextInt();
		System.out.println("---------------------------------------");
		System.out.println("INTRODUCE LA CONTRASEÑA DEL IDENTIFICADOR "+cliente+" :");
		password=sc.nextInt();
		System.out.println("---------------------------------------");
		System.out.println("--------- SALUDOS : " +cliente+" ---------------");
		System.out.println("---------------------------------------");
		
	}

}
