package Practico5;

public class Cocinero implements Runnable{

	public Mesa mesa;
	
	public Cocinero(Mesa unaMesa) {
		this.mesa=unaMesa;
	}
		
	public void run() {
		
		System.out.println(Thread.currentThread().getName()+ "=======Comienza el dia laboral======");
		
		while (true) {
			System.out.println(Thread.currentThread().getName()+ " realizando nuevas recetas hasta que llegue un empleado");
			this.mesa.tomarPedidoComida();
			System.out.println(Thread.currentThread().getName()+ " toma pedido de comida");
			this.cocinar();
			System.out.println(Thread.currentThread().getName()+ " servir pedido de comida");
			this.mesa.servirComida();		
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
