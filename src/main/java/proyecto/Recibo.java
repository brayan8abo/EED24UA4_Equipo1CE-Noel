package proyecto;

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
	
	
	public void añadirRecibo(Cliente cliente) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre del recibo:");
        String nombre = sc.nextLine();
        System.out.println("Ingrese la cantidad del recibo:");
        double cantidad = sc.nextDouble();
        Recibo recibo = new Recibo(nombre, cantidad);
        cliente.añadirRecibo(recibo);
        System.out.println("Recibo añadido con éxito.");
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
