package Practico_8;

import java.util.Random;

public class Soldado implements Runnable{

	private Comedor comedor;
	
	public Soldado(Comedor unComedor) {
		this.comedor=unComedor;
	}
	
	public void run() {
		Random random= new Random();
		boolean valor;
		
		this.esperando();
		this.comedor.entraComedor();
		this.comedor.usarBandeja();
		valor=random.nextBoolean();
		
		if (valor) {
			this.comedor.usarAbridor();
			this.usarAbridor();
			this.comedor.dejarAbridor();
		}
		
		this.comer();
		valor=random.nextBoolean();
		
		if (valor) {
			this.comedor.tomarPostre();
			this.comer();
			this.comedor.dejarPlatoPostre();
		}
		
		this.comedor.dejarBandejaComida();
		this.comedor.salirComedor();
	}
	
	public void esperando() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void comer() {
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void usarAbridor() {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
