package Practico4;

public class Empleado implements Runnable{

	public Mesa mesa;
	
	public Empleado(Mesa unaMesa) {
		this.mesa=unaMesa;
	}
	
	public void run() {
		try {
			this.mesa.ocuparMesa();
			System.out.println(Thread.currentThread().getName()+ " ocupa mesa");
			System.out.println(Thread.currentThread().getName()+ " realizar pedido");
			this.mesa.realizarPedido();
			this.mesa.comer();
			System.out.println(Thread.currentThread().getName()+ " comiendo");
			this.comer();
			this.mesa.finalizar();
			System.out.println(Thread.currentThread().getName()+ " llama a mozo para pagar");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void comer() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
