package Practico_3;

import java.util.Random;

public class Visitante implements Runnable{

	private AreasParque areas;
	
	public Visitante(AreasParque unasAreas) {
		this.areas=unasAreas;
	}
	
	public void run() {
			
		Random random=new Random();
		int area=random.nextInt(this.areas.getAreas().length);
	
		while (true) {
			if (this.areas.reservarEspacio(area)) {
				System.out.println("====================>>>>"+Thread.currentThread().getName()+" realizo una reserva en el area: "+area);
//				try {
//					Thread.sleep(2500);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
			}else {
				System.out.println(Thread.currentThread().getName()+" NO pudo realizar reserva en el area: "+area+" intentare nuevamente");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}			

			

		}
		
	}
}
