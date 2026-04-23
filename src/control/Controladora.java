package control;

import java.util.Map;
import java.util.TreeMap;

import logica.Blog;

public class Controladora {
	
	private Map<integer, Blog> blogs;
	
	public Controladora() {
		
		blogs = new TreeMap<integer, Blogs>();
	}
	
	public void crearBrog(String nombre, String descripcion) {
		
		Blog b = new Blog(nombre, descripcion);
	}

}
