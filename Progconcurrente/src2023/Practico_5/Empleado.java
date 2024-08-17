package Practico_5;

import java.util.Random;

public class Empleado implements Runnable {

	private Silla silla;
	public Empleado(Silla unaSilla) {
		this.silla=unaSilla;
	}
	
	public void run() {
		int valor=0;
		Random random=new Random();
		
		this.silla.ocuparMesa();
		
		valor=random.nextInt(3);
		
		switch (valor) {
		case 0:
			System.out.println("..............solo BEBIDA");
			this.silla.pedirBebida();
			this.silla.tomar();
			break;
		case 1:
			System.out.println("..............solo COMIDA");
			this.silla.pedirComida();
			this.silla.comer();
	
			break;
		case 2:
			System.out.println("..............BEBIDA Y COMIDA");
			this.silla.pedirBebida();
			this.silla.tomar();
			this.silla.pedirComida();
			this.silla.comer();
			
			break;
		default:
			break;
		}
		
		this.silla.dejarMesa();		
	}
}
