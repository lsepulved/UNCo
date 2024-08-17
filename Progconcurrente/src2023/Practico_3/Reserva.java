package Practico_3;

import java.util.Random;

public class Reserva implements Runnable{
	private SalaConcierto3 sala;
	
	public Reserva (SalaConcierto3 unaSala) {
		this.sala=unaSala;
	}
	
	public void run() {
		int asiento;
		
		while (this.sala.asientoDisponible()) {
			
			asiento=new Random().nextInt(10);
			
			if (this.sala.reservarAsiento(asiento)) {
				System.out.println(Thread.currentThread().getName()+" reservo el asiento "+asiento);
			}else {
				System.out.println(Thread.currentThread().getName()+"  el asiento "+asiento+" no esta disponible");
//				try {
//					Thread.sleep(500);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}

			}

			
		}
		
			
	}
}

