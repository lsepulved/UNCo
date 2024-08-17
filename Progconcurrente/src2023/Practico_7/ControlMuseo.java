package Practico_7;

import java.util.Random;

public class ControlMuseo implements Runnable{

	SalaMuseo sala;
	
	public ControlMuseo(SalaMuseo unaSala) {
		this.sala=unaSala;
	}
	
	public void run() {
		Random random=new Random();
		int valor;
		
		while (true) {
			this.esperando();
			valor=random.nextInt(20)+20;
			this.sala.controlTemperatura(valor);
		}
	}
	
	public void esperando() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
