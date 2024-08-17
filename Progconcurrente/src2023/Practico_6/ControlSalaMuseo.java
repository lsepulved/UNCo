package Practico_6;

import java.util.Random;

public class ControlSalaMuseo implements Runnable {

	GestorSala gestor;
	
	public ControlSalaMuseo(GestorSala unGestor) {
		this.gestor=unGestor;
	}
	
	public void run() {
		Random random=new Random();
		int valor;
		while (true) {
			valor=20+random.nextInt(20);		
			this.medirTemperatura();
			this.gestor.controlTemperatura(valor);			
		}
		
	}
	
	public void medirTemperatura() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
