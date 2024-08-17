package Practico4;

import java.util.concurrent.Semaphore;

public class Mesa {

	private Semaphore disponible;
	private Semaphore pedido;
	private Semaphore comer;
	private Semaphore finaliza;
	
	public Mesa() {
		this.disponible=new Semaphore(0);
		this.pedido=new Semaphore(0);
		this.comer=new Semaphore(0);
		this.finaliza=new Semaphore(0);
	}
	
	//mozo
	public void realizaRecetas() {
		this.disponible.release();
	}
	
	//empleado
	public void ocuparMesa() {
		try {
			this.disponible.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//empleado
	public void realizarPedido() {
		this.pedido.release();
	}
	
	//mozo
	public void tomarPedido() {
		try {
			this.pedido.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//mozo
	public void servirPedido() {
		this.comer.release();
	}
	
	
	//empleado
	public void comer() {
		try {
			this.comer.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//empleado
	public void finalizar() {
		this.finaliza.release();
	}
	
	//mozo
	public void cobraMesa() {
		try {
			this.finaliza.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
