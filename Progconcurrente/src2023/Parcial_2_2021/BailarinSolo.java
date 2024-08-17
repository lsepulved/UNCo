package Parcial_2_2021;

import java.util.Random;

public class BailarinSolo implements Runnable{

	private Sala sala;
	
	public BailarinSolo (Sala unaSala) {
		this.sala=unaSala;
	}
	
	public void run() {
		int fila=0;
		Random random=new Random();
		
		fila=random.nextInt(2)+1;
		this.esperando();
		if (fila==1) {
			this.sala.entraFila1();
		}else {
			this.sala.entraFila2();
		}
	}
	
	public void esperando() {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
