package Practico4;

import java.util.Random;

public class Coche implements Runnable{

	public GestorCruce gestor;
	
	public Coche (GestorCruce unGestor) {
		this.gestor=unGestor;
	}
	
	public void run() {
	
		Random random=new Random();
		int destino=random.nextInt(2);
		
		if (destino==0) {
			System.out.println(Thread.currentThread().getName()+" llega entrada Norte");
			this.gestor.llegaNorte();
		}else {
			System.out.println(Thread.currentThread().getName()+" llega entrada Oeste");			
			this.gestor.LlegaOeste();
		}
		
		this.gestor.sale(destino);
		
		if (destino==0) {
			System.out.println(Thread.currentThread().getName()+" sale por Sur");
		}else {
			System.out.println(Thread.currentThread().getName()+" sale por Este");
		}
	}
}
