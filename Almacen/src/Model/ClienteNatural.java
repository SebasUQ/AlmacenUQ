package Model;

public class ClienteNatural extends Cliente{
	
	
	/*
	 * Atributos basicos del cliente natural.
	 */

	private String email = "";
	private String fechaNac = "";
	
	public void RegistrarClienteN (String nom, String ape, int id, String direc, Long tel, String email, String fechaNac) {
		
		ClienteNatural clienteN = new ClienteNatural ();
		
		clienteN.setNombre (nom);
		clienteN.setApellido (ape);
		clienteN.setId (id);
		clienteN.setDireccion (direc);
		clienteN.setTel (tel);
		clienteN.setEmail (email);
		clienteN.setFechaNac (fechaNac);
		clienteN.setTipo ("Natural");
		
		listaClientes.add(clienteN);
	}
	
	
	
	//-----------------------------------------------------------------------------------------------------------------------------//
	
	/*
	 * Getters y Setters de los atributos basicos.
	 */
	
	public String getEmail() {
		return email;
	}
	
	public String getFechaNac() {
		return fechaNac;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}

}
