package Model;

public class ProductoRefrigerado extends Producto {

	private int codigoAprobacion;
	private double tempRefriRecomendada;
	
	public void registrarRefrigerado (int codigoP, String nomProducto, String decripcionP, double valorU, int cantidadExitente,
			int codigoAprobacion, double tempRefriRecomendada) {
		
		ProductoRefrigerado p = new ProductoRefrigerado ();
		p.setCodigoP(codigoP);
		p.setNomProducto(nomProducto);
		p.setDecripcionP(decripcionP);
		p.setValorU(valorU);
		p.setCantidadExitente(cantidadExitente);
		p.setCodigoAprobacion(codigoAprobacion);
		p.setTempRefriRecomendada(tempRefriRecomendada);
		p.setTipoP("Refrigerado");

		for (int i = 0; i < listaProducto.size(); i++) {
			Producto producto = listaProducto.get(i);
			if (producto.getTipoP().equalsIgnoreCase("refrigerado")) {
				ProductoRefrigerado pro = (ProductoRefrigerado) producto;

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
	
	public int getCodigoAprobacion() {
		return codigoAprobacion;
	}
	
	public double getTempRefriRecomendada() {
		return tempRefriRecomendada;
	}
	
	public void setCodigoAprobacion(int codigoAprobacion) {
		this.codigoAprobacion = codigoAprobacion;
	}
	
	public void setTempRefriRecomendada(double tempRefriRecomendada) {
		this.tempRefriRecomendada = tempRefriRecomendada;
	}
}
