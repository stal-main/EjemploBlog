package interfaz;

import java.util.Map;
import java.util.Scanner;

import control.Controladora;

public class EjemploBlog {
	
	private static Controladora controladora;
	
	private static Scanner scanner;
	
	public static void menuPublicacion (int codigoBlog) {
		
		boolean salir = false;
		
		while (!salir) {
			
			System.out.println("\nMenu Publicaciones");
			
			System.out.println("\nOpciones");
			
			System.out.println("\n1) Ver publicaciones");
			System.out.println("2) Crear publicaciones");
			System.out.println("3) Administrar comentarios");
			System.out.println("4) Regresar");

			
			System.out.println("\nSeleccione una opcion: ");
			
			int opcion = leerEntero();
			

			
			if (opcion == 1) {
				
				try {
					
					Map<Integer, String> publicaciones = controladora.obtenerPublicaciones(codigoBlog);
					
					if (publicaciones.isEmpty()) {
						
						System.out.println("No hay publicaciones en este blog.");
					}
					
					else {
						
						System.out.println("-Publicaciones-");
						
						for (Map.Entry<Integer, String> entrada : publicaciones.entrySet()) {
							
							System.out.println("[" + entrada.getKey() + "] " + entrada.getValue());
						}
						
						System.out.print("Ingrese el codigo para ver el contenido: ");
						
						int codigoVer = leerEntero();
						
						String contenido = controladora.obtenerPublicacion(codigoBlog, codigoVer);
                        System.out.println("\n" + contenido);
					}
				}
				
				catch (Exception e) {
					
					System.out.println("Error: " + e.getMessage());	
				}							
			}	
			
			else if (opcion == 2) {
				
			}
			
			else if (opcion == 3) {
				
			}
			
			else if (opcion == 4) {
				
				salir = true;
			}
			
			else {
            System.out.println("Opcion no valida. Escoja entre 1 y 4.");
			}
		}		
	}
	
	public static void menuComentario(int codigoBlog, int codigoPublicacion) {
		
		boolean salir = false;
		
		while (!salir) {
			
			System.out.println("\nMenu Comentarios");
			
			System.out.println("\nOpciones");
			
			System.out.println("\n1) Agregar comentario");
			System.out.println("2) Borrar comentario");
			System.out.println("3) Regresar");
			
			System.out.println("\nSeleccione una opcion: ");
			
			int opcion = leerEntero();
			
			if (opcion == 1) {
				
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
	
	private static String leerTexto() {
		 
        String valor = "";
 
        while (valor.isEmpty()) {
            valor = scanner.nextLine().trim();
            if (valor.isEmpty()) {
                System.out.print("El campo no puede estar vacio. Intente de nuevo: ");
            }
        }
 
        return valor;
    }

	public static void main(String[] args) {

		controladora = new Controladora();
		
		scanner = new Scanner(System.in);
		
		boolean salir = false;
		
		while (!salir) {
			
			System.out.println("\nTECtagram"); //que horrendo nombre
			
			System.out.println("\nOpciones");
			
			System.out.println("\n1) Ver blogs");
			System.out.println("2) Crear blog");
			System.out.println("3) Borrar blog");
			System.out.println("4) Seleccionar blog");
			System.out.println("5) Salir");
			
			System.out.println("\nSeleccione una opcion: ");
			
			int opcion = leerEntero();
			
			if (opcion == 1) {
				
				Map<Integer, String> blogs = controladora.obtenerBlogs();
				
				if (blogs.isEmpty()) {
					
					System.out.println("No hay blogs registrados.");
				}
				
				else {
					
					System.out.println("-Blogs-");
					
					for (Map.Entry<Integer, String> entrada : blogs.entrySet()) {
						
						System.out.println("[" + entrada.getKey() + "] " + entrada.getValue());
					}
				}
				
			}
			
			else if (opcion == 2) {
				
				System.out.print("Nombre del blog: ");
				
                String nombre = leerTexto();
 
                System.out.print("Descripcion del blog: ");
                
                String descripcion = leerTexto();
 
                controladora.crearBlog(nombre, descripcion);
                
                System.out.println("Blog creado correctamente.");
			}
			
			else if (opcion == 3) {
				
				Map<Integer, String> blogs = controladora.obtenerBlogs();
				
				if (blogs.isEmpty()) {
					
					System.out.println("No hay blogs registrados.");
				}
				
				else {
				
					System.out.print("Codigo del blog a borrar: ");
	            
					int codigoBorrar = leerEntero();
	
	            	try {
	            		
	            		controladora.borrarBlog(codigoBorrar);
	            		
	            		System.out.println("Blog borrado correctamente.");
	            	} 
	            	
	            	catch (Exception e) {
	            		
	            		System.out.println("Error: " + e.getMessage());
	            	}
				}

			} 
			
			else if (opcion == 4) {
				
				Map<Integer, String> blogs = controladora.obtenerBlogs();
				
				if (blogs.isEmpty()) {
					
					System.out.println("No hay blogs registrados.");
				}
				
				else {
				
					System.out.print("Codigo del blog a seleccionar: ");
					
					int codigoSeleccionar = leerEntero();
	
					Map<Integer, String> blogsDisponibles = controladora.obtenerBlogs();
	
					if (!blogsDisponibles.containsKey(codigoSeleccionar)) {
						
						System.out.println("Error: codigo de blog no valido.");
					} 
	            
					else {
	            	
						menuPublicacion(codigoSeleccionar);
					}
				}
			} 
			
			else if (opcion == 5) {
				
				salir = true;
				
				System.out.println("Hasta luego.");
			} 
			
			else {
				
				System.out.println("Opcion no valida. Escoja entre 1 y 5.");
			}			
		}
		
		scanner.close();
	}
}
