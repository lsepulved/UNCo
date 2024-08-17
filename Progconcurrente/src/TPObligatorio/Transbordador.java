package TPObligatorio;

import java.util.concurrent.Semaphore;

public class Transbordador {

	int espacioTotal=0;
	int espaciosOcupados=0;
	
//	private Semaphore irOeste;
//	private Semaphore volverEste;
	private Semaphore viaje;
	private Semaphore subir;
	private Semaphore bajar;
//	private Semaphore liberarEntrada;
//	private Semaphore liberarSalida;
	private Semaphore abrirCompuerta;
		
	

	public Transbordador(int capacidad) {
		this.espacioTotal=capacidad;
		this.espaciosOcupados=0;
		
//		this.irOeste=new Semaphore(1);
//		this.volverEste=new Semaphore(0);
		this.viaje=new Semaphore(0);
		this.subir=new Semaphore(0);
		this.bajar=new Semaphore(0);
//		this.liberarEntrada=new Semaphore(1);
//		this.liberarSalida=new Semaphore(0);
		this.abrirCompuerta=new Semaphore(1);
	}
	
	public void liberarEntrada() throws InterruptedException {
		this.abrirCompuerta.acquire();
		System.out.println("Entrada Liberada");
		this.subir.release();
	}

	public void liberarSalida() throws InterruptedException {
		this.abrirCompuerta.acquire();
		System.out.println("Salida Liberada");
		this.bajar.release();
	}
	
	public void subir() throws InterruptedException {
		this.subir.acquire();
		this.espaciosOcupados++;
//		System.out.println(Thread.currentThread().getName()+ " subio al transbordador");		
//		if (this.espaciosOcupados==this.espacioTotal) {
//			this.viaje.release();
//		}else {
//			this.subir.release();
//		}
	}

	public void puedeSubir() throws InterruptedException {	
		if (this.espaciosOcupados==this.espacioTotal) {
			this.viaje.release();
		}else {
			this.subir.release();
		}
	}
	
	public void bajar() throws InterruptedException {
		this.bajar.acquire();
		this.espaciosOcupados--;
//		System.out.println(Thread.currentThread().getName()+ " bajo del transbordador");		
//		if (this.espaciosOcupados==0) {
//			this.viaje.release();
//		}else {
//			this.bajar.release();
//		}
	}
	
	public void puedeBajar() throws InterruptedException {	
		if (this.espaciosOcupados==0) {
			this.viaje.release();
		}else {
			this.bajar.release();
		}
	}
	

	public void viajando() throws InterruptedException {
		this.viaje.acquire();		
		System.out.println("El viaje comenzo");
	}

	public void llegoOeste() throws InterruptedException {
		System.out.println("Llego a destino OESTE");
		this.abrirCompuerta.release();	
	}

	public void llegoEste() throws InterruptedException {
		System.out.println("Llego a destino ESTE");
		this.abrirCompuerta.release();	
	}
	
}
