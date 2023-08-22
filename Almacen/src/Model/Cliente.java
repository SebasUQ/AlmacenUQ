package Model;

import java.util.ArrayList;

public class Cliente extends Persona {
	
	private biblioteca metodo = new biblioteca ();
	
	/*
	 * Atributos basicos de un cliente.
	 */
	
	private String direccion = "";
	private Long tel;
	private String tipo = "";

	public static ArrayList <Cliente> listaClientes = new ArrayList <>();
	
	public void registrarCliente (String nom, String ape, int id, String direc, Long tel) {
		
		Cliente cliente = new Cliente ();
		
		cliente.setNombre(nom);
		cliente.setApellido(ape);
		cliente.setId(id);
		cliente.setDireccion(direc);
		cliente.setTel(tel);
		cliente.setTipo("Comun");
		
		listaClientes.add(cliente);
	}
	
	public boolean verificarCliente (int id) {
		boolean respuesta = false;
		for (int i = 0; i< listaClientes.size(); i++) {
			Cliente c = listaClientes.get(i);
			if (c.getId() == id) {
				respuesta = true;
			}
		}
		return respuesta;
	}
	
	public void eliminarCliente (int id) {
		for (int i = 0;i < listaClientes.size(); i++) {
			Cliente c = listaClientes.get(i);
			if (c.getId() == id) {
				listaClientes.remove(i);
			}
		}
	}
	
	public void verDetalles (int id) {
		boolean centinela = false;
		String mensaje = "";
		
		for (int i = 0; i<listaClientes.size() && centinela == false;i++) {
			Cliente c = listaClientes.get(i);
			int ced = c.getId();
			if (ced == id) {
				String tipo = c.getTipo();
				
				if (tipo.equalsIgnoreCase("juridico")) {
					
					ClienteJuridico cj = (ClienteJuridico) c;
					
					mensaje += "tipo de cliente: "+cj.getTipo() + "\n"+"\n"+"Nit: "+cj.getNit();
					
				}
				else if (tipo.equalsIgnoreCase("natural")) {
					
					ClienteNatural cn = (ClienteNatural) c;
					
					mensaje+= "tipo de Cliente: "+cn.getTipo() + "\n\n"+ "E-mail: "+cn.getEmail()+ "\n\n"+ "Fecha de nacimiento: "+cn.getFechaNac();
				}
				
				centinela = true;
			}
		}
		
		metodo.imprimir(mensaje);
	}
	
	//-----------------------------------------------------------------------------------------------------------------------------//
	
	/*
	 *  Getters y Setters de los atributos basicos.
	 */
	

	public String getDireccion() {
		return direccion;
	}
	public Long getTel() {
		return tel;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public void setTel(Long tel) {
		this.tel = tel;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}
	
}
