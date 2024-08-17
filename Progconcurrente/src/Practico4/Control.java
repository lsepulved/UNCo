package Practico4;

import java.util.Random;

public class Control implements Runnable{

	public GestorCruce gestor;
	
	private Random random=new Random();
	private int tiempo=random.nextInt(2);
	
	public Control(GestorCruce unGestor) {
		this.gestor=unGestor;
	}
	
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
				this.gestor.cambiaSemaforos(tiempo);				
				if (tiempo==0) {				
					System.out.println(Thread.currentThread().getName()+" puede cruzar auto de entrada Norte");
					this.gestor.saleSur();
					this.tiempo=1;
				}else {
					System.out.println(Thread.currentThread().getName()+" puede cruzar auto de entrada Oeste");
					this.gestor.saleEste();
					this.tiempo=0;
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
