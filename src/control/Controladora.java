package control;

import java.util.Map;
import java.util.TreeMap;

import logica.Blog;

public class Controladora {
	
	private Map<Integer, Blog> blogs;
	
	public Controladora() {
		
		blogs = new TreeMap<Integer, Blog>();
	}
	
	public void crearBrog(String nombre, String descripcion) {
		
		Blog b = new Blog(nombre, descripcion);
		
		blogs.put(b.getCodigo(), b);
	}
	
	public void borrarBlog(int codigoBlog) throws Exception {
		
		if (!blogs.containsKey(codigoBlog)) {
			
			throw new Exception("El codigo del blog no es valido");
		}
		
		blogs.remove(codigoBlog);
	}
	
	public Map<Integer, String> obtenerBlogs() {
		
		Map<Integer, String> resultado = new TreeMap<Integer, String>();
		
		for (Blog b : blogs.values()) {
			
			resultado.put(b.getCodigo(), b.getNombre());
		}
		
		return resultado;
	}
	
	public void crearPublicacion(int codigoBlog, String titulo, String texto, String nombre) throws Exception {
		
		if (!blogs.containsKey(codigoBlog)) {
			
			throw new Exception("El codigo del blog no es valido");
		} 
		
		Blog b = blogs.get(codigoBlog);
		
		b.crearPublicacion(titulo, texto, nombre);
		
		
	}
}
