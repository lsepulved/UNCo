package Practico6;

import java.util.Random;

public class Soldado implements Runnable{

	private Cuartel cuartel;
	
	public Soldado(Cuartel unCuartel) {
		this.cuartel=unCuartel;
	}
	
	public void run() {
		Random random= new Random();
		boolean quiereBotella;
		boolean quierePostre;
		
		quiereBotella=random.nextBoolean();
		quierePostre=random.nextBoolean();
		
		this.cuartel.tomarBandejaAlmuerzo();
		System.out.println("====="+Thread.currentThread().getName()+ " toma bandeja de almuerzo");
		
		if (quiereBotella) {
			this.cuartel.tomarAbridor();
			System.out.println("====="+Thread.currentThread().getName()+ " toma abridor");
			this.usarAbridor();
			this.cuartel.dejarAbridor();
			System.out.println("====="+Thread.currentThread().getName()+ " devolver abridor");
		}
		this.comer();
		
		this.cuartel.devolverBandejaAlmuerzo();
		System.out.println("====="+Thread.currentThread().getName()+ " devolver bandeja de almuerzo");
		
		if (quierePostre) {
			this.cuartel.tomarBandejaPostre();;
			System.out.println("====="+Thread.currentThread().getName()+ " toma bandeja de postre");
			this.comer();
			this.cuartel.dejarBandejaPostre();;
			System.out.println("====="+Thread.currentThread().getName()+ " devolver bandeja de postre");
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
	
	public void comer() {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
