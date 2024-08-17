package Practico_5;

public class Mozo implements Runnable{

	private Silla silla;
	public Mozo(Silla unaSilla) {
		this.silla=unaSilla;
	}
	
	public void run() {
		while (true) {
			this.silla.tomarPedidoBebida();
			this.prepararBebida();
			this.silla.servirBebida();			
		}
	}
	
	public void prepararBebida() {
		try {
			System.out.println(Thread.currentThread().getName()+".....preparando BEBIDA");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
