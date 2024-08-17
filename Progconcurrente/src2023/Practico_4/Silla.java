package Practico_4;

import java.util.concurrent.Semaphore;

public class Silla {
	
	String nombre;
	Semaphore mesa;
	Semaphore mozo;
	Semaphore servir;
	Semaphore comer;
	
	public Silla (String unNombre) {
		this.nombre=unNombre;
		this.mesa=new Semaphore(1);
		this.mozo=new Semaphore(0);
		this.servir=new Semaphore(0);
		this.comer=new Semaphore(0);
	}
	
	public boolean ocuparMesa() {
		boolean exito=false;
		try {
			this.mesa.acquire();
			exito=true;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return exito;
	}
	
	public void llamarMozo() {
		this.mozo.release();
	}
	
	public void tomarPedido() {
		try {
			this.mozo.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void pedidoListo() {
		this.servir.release();
	}
	
	public void servirPedido() {
		try {
			this.servir.acquire();
			this.comer.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void comer() {
		try {
			this.comer.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void terminarComer() {
		this.mesa.release();
	}
}
