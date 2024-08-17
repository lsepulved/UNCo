package Practico_4;

import java.util.concurrent.Semaphore;

public class Impresora {
	private boolean disponible;
	private Semaphore sem;
	private String nombre;
	private char tipo;
	
	public Impresora(String unNOmbre,char unTipo) {
		this.setDisponible(true);
		this.sem= new Semaphore(1);
		this.nombre=unNOmbre;
		this.tipo=unTipo;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	
	public void usoImpresora() {
		try {
			this.sem.acquire();
			this.disponible=false;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void liberoImpresora() {
		this.disponible=true;
		this.sem.release();
	}
	
	public char getTipo() {
		return this.tipo;
	}
}
