package Practico5;

import java.util.concurrent.Semaphore;

public class Mesa {

	private Semaphore disponible;
	private Semaphore pedidoBebida;
	private Semaphore pedidoComida;
	private Semaphore comer;
	private Semaphore beber;

	
	public Mesa() {
		this.disponible=new Semaphore(2);
		this.pedidoBebida=new Semaphore(0);
		this.pedidoComida=new Semaphore(0);
		this.comer=new Semaphore(0);
		this.beber=new Semaphore(0);		
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
	public void pedirBebida() {
		this.pedidoBebida.release();
	}
	
	//empleado
	public void pedirComida() {
		this.pedidoComida.release();
	}
	
	//mozo
	public void tomarPedidoBebida() {
		try {
			this.pedidoBebida.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//cocinero
	public void tomarPedidoComida() {
		try {
			this.pedidoComida.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//mozo
	public void servirBebida() {
		this.beber.release();
	}

	//cocinero
	public void servirComida() {
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
	public void beber() {
		try {
			this.beber.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//empleado
	public void dejarMesa() {
		this.disponible.release();
	}
	
//	//empleado
//	public void finalizar() {
//		this.finaliza.release();
//	}
	
//	//mozo
//	public void cobraMesa() {
//		try {
//			this.finaliza.acquire();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
}
