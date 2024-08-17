package Practico5;

public class Mozo implements Runnable{

	public Mesa mesa;
	
	public Mozo(Mesa unaMesa) {
		this.mesa=unaMesa;
	}
	
	public void run() {
		System.out.println(Thread.currentThread().getName()+ "=======Comienza el dia laboral======");
		
		while (true) {
			System.out.println(Thread.currentThread().getName()+ "===///Probando nuevas recetas de pollos hasta que llegue un empleado///===");
			this.mesa.tomarPedidoBebida();
			System.out.println(Thread.currentThread().getName()+ " toma pedido de bebida");
			this.buscarBebida();
			System.out.println(Thread.currentThread().getName()+ " servir bebida");
			this.mesa.servirBebida();			
		}
	}
	
	public void buscarBebida() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
