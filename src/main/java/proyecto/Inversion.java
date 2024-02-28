package proyecto;

import java.util.Random;

public class Inversion {
	Random rnd = new Random();
	// ATRIBUTOS
	private double cantidad;
	private String nombre;

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	

	// CONSTRUCTOR
	public Inversion(double cantidad, String nombre) {
		this.cantidad = cantidad;
		this.nombre = nombre;
	}

	// MÉTODO OBTENER BENEFICIOS
	static /* double */ String obtenerBeneficios(Inversion inversion) {
		Random rnd = new Random();
		double rentabilidad = rnd.nextDouble(1, 2), porcentaje = rnd.nextDouble(0.05, 0.75), beneficio = 1;

		if (rentabilidad == 1) {
			porcentaje = (-1) * porcentaje;
			beneficio = porcentaje * inversion.cantidad;
			inversion.cantidad += beneficio;
		} else {
			porcentaje = (1) * porcentaje;
			beneficio = porcentaje * inversion.cantidad;
			inversion.cantidad += beneficio;
		}
		// hay que devolver beneficios , porcentaje y cantidad
		return "Cantidad invertida:" + inversion.cantidad + "Benficio: " + beneficio + " Rentabilidad:" + porcentaje;
	}

	// MÉTODO OBTENER BENEFICIOS con void
	static void obtenerBeneficiosVoid(Inversion inversion) {
		Random rnd = new Random();
		double rentabilidad = rnd.nextDouble(1, 2), porcentaje = rnd.nextDouble(0.05, 0.75), beneficio = 1;

		if (rentabilidad == 1) {
			porcentaje = (-1) * porcentaje;
			beneficio = porcentaje * inversion.cantidad;
			inversion.cantidad += beneficio;
		} else {
			porcentaje = (1) * porcentaje;
			beneficio = porcentaje * inversion.cantidad;
			inversion.cantidad += beneficio;
		}
		System.out.println("Cantidad invertida:" + inversion.cantidad + "\n Benficio: " + beneficio + "\n Rentabilidad:"
				+ porcentaje);
	}
//

	// NOEL AÑADO EL TO STRING PARA PODER VER LA INVERSIONES QUE TIENE EL CLIENTE EN
	// CAJERO ELECTRONICO

	@Override
	public String toString() {
		return "Inversion [Cantidad Invertida=" + cantidad + ", Nombre de la inversion=" + nombre + "]";
	}

}
