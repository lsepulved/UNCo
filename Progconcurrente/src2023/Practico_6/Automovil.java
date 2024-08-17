package Practico_6;

public class Automovil implements Runnable {

	private Ferry ferry;
	
	public Automovil(Ferry unFerry) {
		this.ferry=unFerry;
	}
	
	public void run() {
		this.esperando();
		this.ferry.subirAutoFerry();
		this.viajando();	
		this.ferry.salirAutoFerry();
	}
	
	public void esperando() {
		try {
//			System.out.println("esperando");
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void viajando() {
		try {
//			System.out.println("VIAJAAAAAAAAAAAAAAAANDO");
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
