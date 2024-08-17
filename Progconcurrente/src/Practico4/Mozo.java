package Practico4;

public class Mozo implements Runnable{

	public Mesa mesa;
	
	public Mozo(Mesa unaMesa) {
		this.mesa=unaMesa;
	}
	
	public void run() {
		while (true) {
			System.out.println(Thread.currentThread().getName()+ " realizando recetas");
			this.mesa.realizaRecetas();
			this.mesa.tomarPedido();
			System.out.println(Thread.currentThread().getName()+ " toma pedido");
			this.cocinar();
			System.out.println(Thread.currentThread().getName()+ " servir pedido");
			this.mesa.servirPedido();
			this.mesa.cobraMesa();
			System.out.println(Thread.currentThread().getName()+ " cobrar");
			
		}
	}
	
	public void cocinar() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
