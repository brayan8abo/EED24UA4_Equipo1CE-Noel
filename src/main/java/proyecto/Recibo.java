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
	 boolean pagarRecibos() {
		//no hace falta pasar cantidad
		
		Random rnd = new Random();
		double probabilidad =1; //rnd.nextDouble(1, 4); No funciona, lo pongo a 1 para probar que funcione que le toque pagar, para lo que inclui en cajero electronico
		boolean pagar=false;
		if(probabilidad==1) {
			pagar=true;
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
