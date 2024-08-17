package Practico6;

public class Cocinero implements Runnable{

	Olla olla;
	
	public Cocinero(Olla unaOlla) {
		this.olla=unaOlla;
	}
	
	public void run() {		
		while (true) {
			this.olla.cocinar();
			System.out.println("===="+Thread.currentThread().getName()+ " cocinando");
			this.cocina();
			this.olla.terminaCocinar();
		}
	}
	
	public void cocina() {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
