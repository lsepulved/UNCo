package Practico5;

import java.util.concurrent.Semaphore;

public class Cuerda {

	private int capacidad;
	private int cruzando;
	private int esperandoLadoA;
	private int esperandoLadoB;
	
	private Semaphore cruzandoLadoA;
	private Semaphore cruzandoLadoB;
	private Semaphore mutex;
	
	public Cuerda(int unaCapacidad) {
		this.capacidad=unaCapacidad;
		this.cruzando=0;
		this.esperandoLadoA=0;
		this.esperandoLadoB=0;
		this.cruzandoLadoA=new Semaphore(0);
		this.cruzandoLadoB=new Semaphore(0);
		this.mutex=new Semaphore(1);
	}
	
	public void esperar(char lado) {
		try {
			this.mutex.acquire();
			this.iniciarlizarLado(lado);
			if (lado=='A') {
				this.esperandoLadoA++;
				System.out.println("Esperando del lado A "+this.esperandoLadoA);
			}else {
				this.esperandoLadoB++;
				System.out.println("Esperando del lado B "+this.esperandoLadoB);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.mutex.release();
	}
	
	public void iniciarlizarLado(char lado) {
		if (esperandoLadoA==0 && esperandoLadoB==0) {
			if (lado=='A') {
				this.cruzandoLadoA.release(this.capacidad);
			}else {
				this.cruzandoLadoB.release(this.capacidad);				
			}
		}
	}
	
	public void cruzar(char lado) {
		
		try {
			if (lado=='A') {
				this.cruzandoLadoA.acquire();
			}else {
				this.cruzandoLadoB.acquire();
			}
			this.mutex.acquire();
			this.cruzando++;
			this.mutex.release();
				
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
					
	}
	
	public void terminarCruce(char lado) {
		try {
			this.mutex.acquire();
			this.cruzando--;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.mutex.release();
		if (this.cruzando==0) {
			cambiarTurno(lado);
		}
	}
	
	public void cambiarTurno(char lado) {
		if (lado=='A') {
			if (this.esperandoLadoB>0) {
				this.cruzandoLadoB.release(this.capacidad);
			}else {
				if (this.esperandoLadoA>0) {
					this.cruzandoLadoA.release(this.capacidad);
				}
			}
		}
		
		if (lado=='B') {
			if (this.esperandoLadoA>0) {
				this.cruzandoLadoA.release(this.capacidad);
			}else {
				if (this.esperandoLadoB>0) {
					this.cruzandoLadoB.release(this.capacidad);
				}
			}
		}
	}
	
}
