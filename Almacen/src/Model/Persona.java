package Model;

public class Persona {

	private String nombre = "";
	private String apellido = "";
	private int id = 0;
	
	
	public String getNombre() {
		return nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public int getId() {
		return id;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public void setId(int id) {
		this.id = id;
	}
}
