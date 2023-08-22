package Model;

public class ClienteJuridico extends Cliente {
	
	/*
	 * Atributos basicos del cliente Juridico.
	 */

	private int nit = 0;
	
	public void RegistrarClienteJ (String nom, String ape, int id, String direc, Long tel, int nit) {
		
		ClienteJuridico clienteJ = new ClienteJuridico ();
		
		clienteJ.setNombre (nom);
		clienteJ.setApellido (ape);
		clienteJ.setId (id);
		clienteJ.setDireccion (direc);
		clienteJ.setTel (tel);
		clienteJ.setNit (nit);
		clienteJ.setTipo("Juridico");
		
		listaClientes.add(clienteJ);
	}
	
	//-----------------------------------------------------------------------------------------------------------------------------//
	
	/*
	 * Getters y Setters de los atributos basicos.
	 */

	public int getNit() {
		return nit;
	}

	public void setNit(int nit) {
		this.nit = nit;
	}
	
	
}
