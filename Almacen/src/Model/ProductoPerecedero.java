package Model;

public class ProductoPerecedero extends Producto{

	private String fechaVencimiento;
	
	public void registrarPerecedero (int codigoP, String nomProducto, String decripcionP, double valorU, int cantidadExitente,
			String fechaVencimiento) {
		
		ProductoPerecedero p = new ProductoPerecedero ();
		p.setCodigoP(codigoP);
		p.setNomProducto(nomProducto);
		p.setDecripcionP(decripcionP);
		p.setValorU(valorU);
		p.setCantidadExitente(cantidadExitente);
		p.setFechaVencimiento(fechaVencimiento);
		p.setTipoP("Perecedero");

		for (int i = 0; i < listaProducto.size(); i++) {
			Producto producto = listaProducto.get(i);
			if (producto.getTipoP().equalsIgnoreCase("perecedero")) {
				ProductoPerecedero pro = (ProductoPerecedero) producto;

				if (pro.getCodigoP() == codigoP) {
					pro.setCantidadExitente(pro.getCantidadExitente() + cantidadExitente);
					listaProducto.add(i, pro);
				}
				else {
					listaProducto.add(p);
				}
			}
		}
	}

	public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
}
