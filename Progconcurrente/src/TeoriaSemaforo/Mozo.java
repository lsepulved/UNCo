package TeoriaSemaforo;

public class Mozo implements Runnable{
	private Comida comida;
	
	public Mozo(Comida unaComida) {
		this.comida=unaComida;
	}
	
	public void run() {
		while (true) {
			try {
				System.out.println(Thread.currentThread().getName() + " generando pedido");
				generarPedido();
				System.out.println(Thread.currentThread().getName() +" entrega pedido al Cocinero");
				comida.pedirComida();
				System.out.println(Thread.currentThread().getName() +" esperando comida");
				comida.esperarComida();											
			} catch (Exception e) {
				e.printStackTrace();
			}
		}			
	}
	
	public void generarPedido() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
