package logica;

import java.time.LocalDateTime;

public class Publicacion {
	
	private static int consecutivo = 1;
	
	private int codigo;
	
	private String titulo;
	
	private String texto;
	
	private String nombreCreador;
	
	private LocalDateTime fechaPublicacion;
	
	private List<Comentario> comentarios;
	
	public Publicacion(String titulo, String texto, String nombreCreador) {
		
		codigo = consecutivo;
		
		consecutivo++;
		
		this.titulo = titulo;
		
		this.texto = texto;
		
		this.nombreCreador = nombreCreador;
		
		fechaPublicacion = LocalDateTime.now();
		
		comentarios = new ArrayList<Comentario>();
		
	}
	
	public int getCodigo() {
		
		return codigo;
	}
	
	public String getTitulo() {
		
		return titulo;
	}
	
	public String getTexto() {
		
		return texto;
	}
	
	public String getNombreCreador() {
		
		return nombreCreador;
	}
	
	public LocalDateTime getFechaPublicacion() {
		
		return fechaPublicacion;
	}
	
	public String toString() {
		
		String resultado = titulo + "\n\n";
		
		resultado += "Creado por: " + nombreCreador + " - ";
		
		resultado += fechaPublicacion.toString() + "\n\n";
		
		resultado += texto + "\n\n";
		
		resultado += "Comentarios: \n";
		
		if (comentarios.isEmpty()) {
			
			resultado += "No hay comentarios";
		} else {
			for (Comentario c : comentarios) {
				
				resultado += c.toString() + "\n\n";
			}
		}
	}
	
	public void agregarComentario(String)
	
}
