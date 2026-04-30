package logica;

import java.time.LocalDateTime;

public class Comentario {
	
	private LocalDateTime fechaCreacion;
	
	private String email;
	
	private String ip;
	
	private String texto;
	

	public Comentario (String email, String ip, String texto) {
		
		this.email = email;
		
		this.ip = ip;
		
		this.texto = texto;
		
		fechaCreacion = LocalDateTime.now();

	}
	
	public LocalDateTime obtenerFechaCreacion() {
		
		return fechaCreacion;
	}
	
	public String obtenerEmail() {
		
		return email;
	}
	
	public String obtenerIp() {
		
		return ip;
	}
	
	public String obtenerTexto() {
		
		return texto;
	}
	
	public String toString() {
		
		String resultado = email + " - " + ip + " - " + fechaCreacion.toString() + "\n";
		
		resultado += texto + "\n";
		
		return resultado;
	}
}
