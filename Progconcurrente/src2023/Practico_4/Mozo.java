package Practico_4;

public class Mozo implements Runnable{

	Silla silla;
	public Mozo(Silla unaSilla) {
		this.silla=unaSilla;
	}
	
	public void run() {
		while(true) {
			this.silla.tomarPedido();
			System.out.println(Thread.currentThread().getName()+" toma pedido");
			this.silla.pedidoListo();
			this.cocinando();	
			this.silla.servirPedido();
			System.out.println(Thread.currentThread().getName()+" servir pedido");
		}
	}
	
	public void cocinando() {
		System.out.println("..................COCINANDO");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
