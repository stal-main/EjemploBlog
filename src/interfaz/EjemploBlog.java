package interfaz;

import java.util.Map;
import java.util.Scanner;

import control.Controladora;

public class EjemploBlog {
	
	private static Controladora controladora;
	
	private static Scanner scanner;
	
	public static void menuPublicacion () {
		
		boolean salir = false;
		
		while (!salir) {
			
			System.out.println("Menu Publicaciones");
			
			System.out.println("Opciones:");
			
			System.out.println("1) Ver publicaciones");
			System.out.println("2) Crear publicaciones");
			System.out.println("3) Administrar comentarios");
			System.out.println("4) Regresar");

			
			System.out.println("Seleccione una opcion: ");
			
			int opcion = leerEntero();
			
			switch (opcion) {
			
			
			}
			
		}
		
	}
	
	public static void menuComentario(int codigoBlog, int codigoPublicacion) {
		
		boolean salir = false;
		
		while (!salir) {
			
			System.out.println("Menu Comentarios");
			
			System.out.println("Opciones:");
			
			System.out.println("1) Agregar comentario");
			System.out.println("2) Borrar comentario");
			System.out.println("3) Regresar");
			
			System.out.println("Seleccione una opcion: ");
			
			int opcion = leerEntero();
			
			switch (opcion) {
		
			}
		}
		
	}
	
	private static int leerEntero() {
		
		int valor = 0;
		
		try {
			
			valor = Integer.parseInt(scanner.nextLine().trim());			
		}
		
		catch (NumberFormatException e) {
			
			System.out.println("Entrada no valida");
		}
		
		return valor;
	}

	public static void main(String[] args) {

		controladora = new Controladora();
		
		boolean salir = false;
		
		while (!salir) {
			
			System.out.println("TECtagram"); //que horrendo nombre
			
			System.out.println("Opciones:");
			
			System.out.println("1) Ver blogs");
			System.out.println("2) Crear blog");
			System.out.println("3) Borrar blog");
			System.out.println("4) Seleccionar blog");
			System.out.println("5) Salir");
			
			System.out.println("Seleccione una opcion: ");
			
			int opcion = leerEntero();
			
			switch (opcion) {
			
			}
			
		}

	}

}
