package Practico_5;

public class Cocinero implements Runnable {
	
	private Silla silla;
	
	public Cocinero(Silla unaSilla) {
		this.silla=unaSilla;
	}
	
	public void run() {
		while (true) {
			this.silla.tomarPedidoComida();
			this.cocinar();
			this.silla.servirComida();			
		}
	}

	public void cocinar() {
		try {
			System.out.println(Thread.currentThread().getName()+".....COCINERO COCINANDO");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
