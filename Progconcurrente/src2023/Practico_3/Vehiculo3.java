package Practico_3;

public class Vehiculo3 implements Runnable{
	private String patente;
	private int modelo;
	private String marca;
	private int kms;
	
	public Vehiculo3(String unaPatente, int unModelo, String unaMarca, int unosKms) {
		this.setPatente(unaPatente);
		this.setModelo(unModelo);
		this.setMarca(unaMarca);
		this.setKms(unosKms);
	}
	
	public void run() {
		
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public int getModelo() {
		return modelo;
	}

	public void setModelo(int modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getKms() {
		return kms;
	}

	public void setKms(int kms) {
		this.kms = kms;
	}
}
