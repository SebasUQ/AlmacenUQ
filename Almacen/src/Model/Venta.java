package Model;

public class Venta {

	private int codigo = 0;
	private String fechaV = "";
	private double totalV = 0;
	private double IVA = 0.19;
	
	
	public int getCodigo() {
		return codigo;
	}
	
	public String getFechaV() {
		return fechaV;
	}
	
	public double getTotalV() {
		return totalV;
	}
	
	public double getIVA() {
		return IVA;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public void setFechaV(String fechaV) {
		this.fechaV = fechaV;
	}
	
	public void setTotalV(double totalV) {
		this.totalV = totalV;
	}
	
	public void setIVA(double iVA) {
		IVA = iVA;
	}
}
