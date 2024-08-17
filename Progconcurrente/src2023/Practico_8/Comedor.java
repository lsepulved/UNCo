package Practico_8;

import java.util.concurrent.Semaphore;

public class Comedor {

	private Semaphore entraComedor;
	private Semaphore mostradorBandeja;
	private Semaphore abridor;
	private Semaphore mostradorPostre;
	
	public Comedor(int limiteComedor,int cantBandeja, int cantAbridor,int cantPostre) {
		this.entraComedor=new Semaphore(limiteComedor);
		this.mostradorBandeja=new Semaphore(cantBandeja);
		this.abridor=new Semaphore(cantAbridor);
		this.mostradorPostre=new Semaphore(cantPostre);
	}

	public void entraComedor() {
		try {
			this.entraComedor.acquire();
			System.out.println(Thread.currentThread().getName()+"...............entra al COMEDOR");
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void usarBandeja() {
		try {
			this.mostradorBandeja.acquire();
			System.out.println(Thread.currentThread().getName()+"...............usando BANDEJA COMIDA");
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void usarAbridor() {
		try {
			this.abridor.acquire();
			System.out.println(Thread.currentThread().getName()+"...............usando ABRIDOR");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void tomarPostre() {
		try {
			this.mostradorPostre.acquire();
			System.out.println(Thread.currentThread().getName()+"...............usando PLATO POSTRE");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void salirComedor() {
		System.out.println(Thread.currentThread().getName()+"=================sale del Comedor================");
		this.entraComedor.release();
	}
	
	public void dejarBandejaComida() {
		System.out.println(Thread.currentThread().getName()+"!!!!!!!!!!!deja BANDEJA COMIDA!!!!!!!!!!!");
		this.mostradorBandeja.release();
	}
	
	public void dejarAbridor() {
		System.out.println(Thread.currentThread().getName()+"!!!!!!!!!!!!!!!!!!!!!!!!deja ABRIDOR!!!!!!!!!!!");
		this.abridor.release();
	}
	
	public void dejarPlatoPostre() {
		System.out.println(Thread.currentThread().getName()+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!deja BANDEJA PLATO POSTRE!!!!!!!!!!!");
		this.mostradorPostre.release();
	}
	
}
