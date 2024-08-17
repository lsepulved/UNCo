package Practico6;

import java.util.Random;

public class ControlTemperatura implements Runnable{

	private GestorSala gestor;
	private int temperaturaActual;
	
	public ControlTemperatura(GestorSala unGestor) {
		this.gestor=unGestor;
		this.temperaturaActual=0;
	}
	
	public void run() {
		Random random=new Random();
		while (true) {
			this.temperaturaActual=random.nextInt(21)+20;
			this.gestor.notificarTemperatura(temperaturaActual);
			this.informar();			
		}
	}
	
	private void informar() {
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
