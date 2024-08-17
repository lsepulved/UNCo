package Practico_8;

public class Canibal implements Runnable{

	private Olla olla;
	
	public Canibal(Olla unaOlla) {
		this.olla=unaOlla;
	}
	
	public void run() {
		this.olla.usarOllaCanibal();
		this.comiendo();
		this.olla.dejarOllaCanibal();
	}
	
	public void comiendo() {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
