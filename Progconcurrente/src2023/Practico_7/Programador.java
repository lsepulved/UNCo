package Practico_7;

import java.util.Random;

public class Programador implements Runnable{

	GestorRecurso gestor;
	
	public Programador(GestorRecurso unGestor) {
		this.gestor=unGestor;
	}
	
	public void run() {
		
		Random random=new Random();
		int valor;
		
		this.esperando();
		valor=random.nextInt(2);
		
		if (valor==0) {
			this.gestor.usarComputadora();
			this.gestor.usarLibro();
			this.trabajando();
			this.gestor.dejarComputadora();
			this.gestor.dejarLibro();
		}else {
			this.gestor.usarLibro();
			this.gestor.usarComputadora();
			this.trabajando();
			this.gestor.dejarLibro();
			this.gestor.dejarComputadora();
		}
		
	}

	public void trabajando() {
		try {
			System.out.println(Thread.currentThread().getName()+"..........TRABAJANDO!!!!");
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void esperando() {
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
