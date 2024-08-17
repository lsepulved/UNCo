package TeoriaSemaforo;

import java.util.concurrent.Semaphore;

public class Comida {

	private Semaphore pedido;
	private Semaphore comidaLista;
	
	public Comida () {
		this.pedido= new Semaphore(0);
		this.comidaLista=new Semaphore(0);
	}
	
	public void pedirComida() {
		this.pedido.release();
	}
	
	public void esperarComida() {
		try {
			this.comidaLista.acquire();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void esperarPedido() {
		try {
			this.pedido.acquire();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void entregarPedido() {
		this.comidaLista.release();
	}
}
