package logica;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;

public class Blog {
	
private static int consecutivo = 1;
	
	private int codigo;
	
	private String nombre;
	
	private String descripcion;
	
	private LocalDateTime fechaCreacion;
	
	private Map<Integer, Publicacion> publicaciones;
	
	public Blog(String nombre, String descripcion) {
		
		codigo = consecutivo;
		
		consecutivo++; 
		
		this.nombre = nombre;
		
		this.descripcion = descripcion;
		
		fechaCreacion = LocalDateTime.now();
		
		publicaciones = new TreeMap<integer, Publicacion>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCodigo() {
		return codigo;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}
	
	public void crearPublicacion(String titulo, String texto, String nombreCreador) {
		
		Publicacion p = new Publicacion(titulo, texto, nombreCreador);
		
		publicaciones.put(p.getCodigo(), p);
	}
	
	public String obtenerPublicacion(int codigoPublicacion) throws Exception {
		
		if (!publicaciones.containsKey(codigoPublicacion)) {
			throw new Exception("Codigo de publicacion no encontrado");
		}
		
		Publicacion p = publicaciones.get(codigoPublicacion);
		
		return p.toString();
	}

}
