package Model;

import java.util.ArrayList;

public class Producto {
	
	public static ArrayList <Producto> listaProducto = new ArrayList <>();
	
	private int codigoP;
	private String nomProducto;
	private String decripcionP;
	private double valorU;
	private int cantidadExitente;
	private String tipoP;
	
	
	public int getCodigoP() {
		return codigoP;
	}
	
	public String getNomProducto() {
		return nomProducto;
	}
	
	public String getDecripcionP() {
		return decripcionP;
	}
	
	public double getValorU() {
		return valorU;
	}
	
	public int getCantidadExitente() {
		return cantidadExitente;
	}
	
	public String getTipoP() {
		return tipoP;
	}
	
	public void setCodigoP(int codigoP) {
		this.codigoP = codigoP;
	}
	
	public void setNomProducto(String nomProducto) {
		this.nomProducto = nomProducto;
	}
	
	public void setDecripcionP(String decripcionP) {
		this.decripcionP = decripcionP;
	}
	
	public void setValorU(double valorU) {
		this.valorU = valorU;
	}
	
	public void setCantidadExitente(int cantidadExitente) {
		this.cantidadExitente = cantidadExitente;
	}
	
	public void setTipoP(String tipoP) {
		this.tipoP = tipoP;
	}

	public static ArrayList<Producto> getListaProducto() {
		return listaProducto;
	}
}
