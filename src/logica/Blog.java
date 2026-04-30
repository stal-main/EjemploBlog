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
		
		publicaciones = new TreeMap<Integer, Publicacion>();
	}

	public String obtenerNombre() {
		return nombre;
	}

	public void actualizarNombre(String nombre) {
		this.nombre = nombre;
	}

	public String obtenerDescripcion() {
		return descripcion;
	}

	public void actualizarDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int obtenerCodigo() {
		return codigo;
	}

	public LocalDateTime obtenerFechaCreacion() {
		return fechaCreacion;
	}
	
	public void crearPublicacion(String titulo, String texto, String nombreCreador) {
		
		Publicacion p = new Publicacion(titulo, texto, nombreCreador);
		
		publicaciones.put(p.obtenerCodigo(), p);
	}
	private void revisarPublicacionesExistentes(int codigoPublicacion) throws Exception {
		
		if (!publicaciones.containsKey(codigoPublicacion)) {
			throw new Exception("Codigo de publicacion no encontrado");
		}		
	}
	
	public String obtenerPublicacion(int codigoPublicacion) throws Exception {
		
		revisarPublicacionesExistentes(codigoPublicacion);
			
		Publicacion p = publicaciones.get(codigoPublicacion);
		
		return p.toString();
	}
	
	public Map<Integer, String> obtenerTitulosPublicaciones() {
		
		Map<Integer, String> titulos = new TreeMap<Integer, String>();
		
		for (Publicacion p : publicaciones.values()) {
			titulos.put(p.obtenerCodigo(), p.obtenerTitulo());
		}
		
		return titulos;
	}
	
	public void agregarComentario(int codigoPublicacion, String email, String ip, String texto) throws Exception {
		
		revisarPublicacionesExistentes(codigoPublicacion);
		
		Publicacion p = publicaciones.get(codigoPublicacion);
		
		p.agregarComentario(email, ip, texto);
	}
	
	public void borrarComentario(int codigoPublicacion, int posicion) throws Exception {
		
		revisarPublicacionesExistentes(codigoPublicacion);
		
		Publicacion p = publicaciones.get(codigoPublicacion);
		
		p.borrarComentario(posicion);	
	}	
}
