package Practico_5;

public class Gato2 implements Runnable{

	Comedor2 comedor;
	
	public Gato2(Comedor2 unComedor) {
		this.comedor=unComedor;
	}
	
	public void run() {
		this.comedor.gatoUsarPlato();
		this.comiendo();
		this.comedor.gatoDejaPlato();
	}
	
	public void comiendo() {
		try {
			System.out.println(Thread.currentThread().getName()+"..........comiendo");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
