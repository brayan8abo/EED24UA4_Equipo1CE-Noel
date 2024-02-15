package proyecto;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

class ClienteTestObtenerImporteProgramador2Pablo {

	@Test
	void testRetiradaMonedero() {
		Cliente[] clientes = new Cliente[2];

		clientes[0] = new Cliente(1, 1, 1);
		clientes[1] = new Cliente(2, 23, 2);
		
        int identificador = 1;
        
        clientes[0].monedero = 50;
        
        // intento de mockear
        ScannerMock scannerMock = new ScannerMock("25.0"); // Simulamos una retirada de 25 euros
        
        Cliente.retiradaMonedero(clientes, identificador);
        //tengo que introducir en la consola el importe a retirar
        //no está mockeando bien
        System.setIn(scannerMock.getInputStream());
        
        // Comprobar que retira la cantidad
        assertEquals(25.0, clientes[0].monedero);
	}
	
	 class ScannerMock {
	        private String input;
	        private ByteArrayOutputStream output = new ByteArrayOutputStream();
	        
	        public ScannerMock(String input) {
	            this.input = input;
	        }
	        
	        public InputStream getInputStream() {
	            return new ByteArrayInputStream(input.getBytes());
	        }
	        
	        public String getOutput() {
	            return output.toString().trim();
	        }
	    }

}
