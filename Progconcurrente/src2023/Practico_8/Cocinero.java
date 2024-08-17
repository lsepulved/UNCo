package Practico_8;

public class Cocinero implements Runnable {
	
	private Olla olla;
	
	public Cocinero(Olla unaOlla) {
		this.olla=unaOlla;
	}
	
	public void run() {
		while (true) {
			this.olla.cocinar();
			this.cocinando();
			this.olla.dejarCocinar();			
		}
	}


	public void cocinando() {
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}
