package proyecto;

import java.util.Random;

public class Recibo {
	//ATRIBUTOS
	String nombre;
	double cantidadRecibo;
	
	//CONSTRUCTOR
	public Recibo(String nombre, double cantidadRecibo) {
		this.nombre = nombre;
		this.cantidadRecibo = cantidadRecibo;
	}
	
	//MÉTODO PAGAR RECIBO  pagarRecibos que según una probabilidad de entre 1 a 4 veces devuelva true
	static boolean pagarRecibos() {
		//no hace falta pasar cantidad
		
		Random rnd = new Random();
		double probabilidad = rnd.nextDouble(1, 4);
		boolean pagar;
		if(probabilidad==1) {
			pagar=true;
		}else {
			pagar=false;
		}
		
		return pagar;
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
