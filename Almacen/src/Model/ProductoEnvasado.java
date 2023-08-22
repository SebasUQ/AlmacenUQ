package Model;

public class ProductoEnvasado extends Producto{

	private String fechaEnvasado;
	private double pesoEnvase;
	private String paisOrigen;
	
	public void registrarEnvasado (int codigoP, String nomProducto, String decripcionP, double valorU, int cantidadExitente,
			                        String fechaE, double pesoEnvase, String paisOrigen) {
		
		ProductoEnvasado p = new ProductoEnvasado ();
		p.setCodigoP(codigoP);
		p.setNomProducto(nomProducto);
		p.setDecripcionP(decripcionP);
		p.setValorU(valorU);
		p.setCantidadExitente(cantidadExitente);
		p.setFechaEnvasado(fechaE);
		p.setPesoEnvase(pesoEnvase);
		p.setPaisOrigen(paisOrigen);
		p.setTipoP("Envasado");
		
		for (int i = 0; i < listaProducto.size(); i++) {
			
			Producto producto = listaProducto.get(i);
			if (producto.getTipoP().equalsIgnoreCase("Envasado")) {
				ProductoEnvasado pro = (ProductoEnvasado) producto;
				
				if (pro.getCodigoP() == codigoP && pro.getPaisOrigen().equalsIgnoreCase(paisOrigen)) {
					pro.setCantidadExitente(pro.getCantidadExitente() + cantidadExitente);
					listaProducto.add(i, pro);
				}
				else {
					listaProducto.add(p);
				}
			}
		}
	}
	
	
	public String getFechaEnvasado() {
		return fechaEnvasado;
	}
	
	public double getPesoEnvase() {
		return pesoEnvase;
	}
	
	public String getPaisOrigen() {
		return paisOrigen;
	}
	
	public void setFechaEnvasado(String fechaEnvasado) {
		this.fechaEnvasado = fechaEnvasado;
	}
	
	public void setPesoEnvase(double pesoEnvase) {
		this.pesoEnvase = pesoEnvase;
	}
	
	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}
}
