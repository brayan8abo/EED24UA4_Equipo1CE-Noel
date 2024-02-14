package proyecto;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import java.io.InputStream;

class ClienteTestTarea2Coordinador {

	@Test
	void testTraspasarMonederoValido() {

		Cliente[] clientes = new Cliente[5];

		clientes[0] = new Cliente(1, 1, 1);
		clientes[1] = new Cliente(2, 23, 2);
		clientes[2] = new Cliente(3, 3, 3);
		clientes[3] = new Cliente(4, 4, 4);
		clientes[4] = new Cliente(5, 5, 5);

		clientes[0].monedero = 100;// Utilizamos el identificador de clientes en la posicion 0 de emisor
		clientes[1].monedero = 50;// y identificador del clientes en la poscion 1 como recepor para hacer el test
									// valido
		clientes[2].monedero = 50;
		clientes[3].monedero = 50;
		clientes[4].monedero = 50;

		String input = "2\n50\n"; // Identificador receptor y cantidad a transferir
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		Cliente.traspasarMonedero(clientes, 1);

		// Verificar que la transferencia se realizo correctamente

		assertEquals(50.0, clientes[0].monedero, 0);
		assertEquals(100.0, clientes[1].monedero, 0);

	}

	@Test
	void testTraspasarMonederoNoValidoErrorEnElIdentificadorDestino() {

		Cliente[] clientes = new Cliente[5];

		clientes[0] = new Cliente(1, 1, 1);
		clientes[1] = new Cliente(2, 23, 2);
		clientes[2] = new Cliente(3, 3, 3);
		clientes[3] = new Cliente(4, 4, 4);
		clientes[4] = new Cliente(5, 5, 5);



		String input = "6\n50\n"; //aqui esta el error el identificador 6 no existe en la array de clientes
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		Cliente.traspasarMonedero(clientes, 1);

		// Verificar que se imprime el mensaje puesto en el metodo
		assertFalse(systemOut().contains("Error..El Identificador :6 No existe."));
		
		
	}
	
	@Test
	void testTraspasarMonederoNoValidoErrorEnElIdentificadorEmisor() {

		Cliente[] clientes = new Cliente[5];

		clientes[0] = new Cliente(1, 1, 1);
		clientes[1] = new Cliente(2, 23, 2);
		clientes[2] = new Cliente(3, 3, 3);
		clientes[3] = new Cliente(4, 4, 4);
		clientes[4] = new Cliente(5, 5, 5);

// Utilizamos clientes en la posicion 0 de emisor y clientes en la poscion 1 como recepor para hacer el test valido

		String input = "2\n50\n"; //
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		Cliente.traspasarMonedero(clientes, 6);// aqui esta el error el identificador emisor no existe

		// Verificar que se imprime el mensaje puesto en el metodo
		assertFalse(systemOut().contains("Error en tu identificador vuelve a logearte"));
		
		
	}

	private String systemOut() {
		// TODO Auto-generated method stub
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	    PrintStream originalOut = System.out;
	    System.setOut(new PrintStream(outputStream));
	    String output = outputStream.toString();
	    System.setOut(originalOut); 
	    return output;
	}

	
}
