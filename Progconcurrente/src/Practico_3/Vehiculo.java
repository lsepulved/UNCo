package Practico_3;

public class Vehiculo {

	private String patente;
	private int modelo=0;
	private String marca;
	private int km;
	
	public Vehiculo(String unaPatente,int unModelo, String unaMarca, int unKm) {
		this.patente=unaPatente;
		this.modelo=unModelo;
		this.marca=unaMarca;
		this.km=unKm;
	}
	
	public String getPatente() {
		return this.patente;
	}
	
	public int getModelo() {
		return this.modelo;
	}
	
	public String getMarca() {
		return this.marca;
	}
	
	public int getKm() {
		return this.km;
	}
	
}

