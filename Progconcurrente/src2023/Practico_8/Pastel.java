package Practico_8;

public class Pastel implements Runnable{

	Pasteleria caja;
	
	public Pastel(Pasteleria unaCaja) {
		this.caja=unaCaja;
	}
	
	public void run() {
		this.cocinandoPastel();
		this.caja.usarMostrador();
		
	}
	
	public void cocinandoPastel() {
		try {
//			System.out.println(Thread.currentThread().getName()+"..............bajando por el tobogaaaaaaaaan!!!");
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
