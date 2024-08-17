package TeoriaSemaforo;

public class Cocinero implements Runnable {

	private Comida comida;
	
	public Cocinero (Comida unaComida) {
		this.comida=unaComida;
	}
	
	public void run() {
		while (true) {
			try {
				System.out.println(Thread.currentThread().getName()+ " esperando pedido");
				comida.esperarPedido();
				System.out.println(Thread.currentThread().getName()+ " preparando pedido");
				prepararComida();
				System.out.println(Thread.currentThread().getName()+ " entrega pedido");
				comida.entregarPedido();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public void prepararComida() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
