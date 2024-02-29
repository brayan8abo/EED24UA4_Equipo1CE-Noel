package proyecto;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Recibo {
	// ATRIBUTOS
	private String nombre;
	private double cantidadRecibo;

	// CONSTRUCTOR
	public Recibo(String nombre, double cantidadRecibo) {
		this.nombre = nombre;
		this.cantidadRecibo = cantidadRecibo;
	}

	// MÉTODO PAGAR RECIBO pagarRecibos que según una probabilidad de entre 1 a 4
	// veces devuelva true
	boolean pagarRecibos() {
		// no hace falta pasar cantidad

		Random random = new Random();
		int probabilidad = random.nextInt(4) + 1; // Número aleatorio entre 1 y 4
		return probabilidad == 1; // Devuelve true con una probabilidad de 1/4
	}

//		Random rnd = new Random();
//		double probabilidad =1; //rnd.nextDouble(1, 4); No funciona, lo pongo a 1 para probar que funcione que le toque pagar, para lo que inclui en cajero electronico
//		boolean pagar=false;
//		if(probabilidad==1) {
//			pagar=true;
//		}

//		return pagar;

	ArrayList<Recibo> recibos = new ArrayList<>(5);

	static void añadirRecibo(Cliente[] clientes, int identificadorCliente) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese el nombre del recibo:");
		String nombre = sc.nextLine();
		System.out.println("Ingrese la cantidad del recibo:");
		double cantidad = sc.nextDouble();
		sc.nextLine(); 
		if (identificadorCliente >= 0 && identificadorCliente < clientes.length) {
			clientes[identificadorCliente].añadirRecibo(recibo);
			System.out.println("Recibo añadido con éxito.");
		} else {
			System.out.println("Identificador de cliente inválido.");
		}
		sc.close();
	}
	static void eliminarRecibo(Cliente[] clientes, int identificadorCliente) {
	    Scanner sc = new Scanner(System.in);
	    if (identificadorCliente >= 0 && identificadorCliente < clientes.length) {
	        Cliente cliente = clientes[identificadorCliente];
	        ArrayList<Recibo> recibos = cliente.getRecibos();

	        if (recibos.isEmpty()) {
	            System.out.println("El cliente no tiene recibos para eliminar.");
	            return;
	        }

	        System.out.println("Recibos del cliente " + cliente.getNombre() + ":");
	        for (int i = 0; i < recibos.size(); i++) {
	            System.out.println(i + ". " + recibos.get(i).getNombre() + " - Cantidad: " + recibos.get(i).getCantidad());
	        }

	        System.out.print("Ingrese el índice del recibo a eliminar: ");
	        int indexRecibo = sc.nextInt();
	        sc.nextLine(); // Consumir el salto de línea después de leer el entero

	        if (indexRecibo >= 0 && indexRecibo < recibos.size()) {
	            cliente.removeRecibo(indexRecibo);
	            System.out.println("Recibo eliminado con éxito.");
	        } else {
	            System.out.println("Índice de recibo inválido.");
	        }
	    } else {
	        System.out.println("Identificador de cliente inválido.");
	    }
	    sc.close();
	}

	public void añadirRecibo(Recibo recibo) {
		return;

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getCantidadRecibo() {
		return cantidadRecibo;
	}

	public void setCantidadRecibo(double cantidadRecibo) {
		this.cantidadRecibo = cantidadRecibo;
	}

}
