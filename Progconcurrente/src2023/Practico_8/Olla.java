package Practico_8;

import java.util.concurrent.Semaphore;

public class Olla {

	private int limiteOlla;
	private int cantRaciones;
	private int cantCanibales;
	private int cantCanibalesEsperando;
	
	private Semaphore canibales;
	private Semaphore cocinero;
	private Semaphore mutexCocinero;
	private Semaphore mutexCanibal;
	
	public Olla(int limiteOlla) {
		this.limiteOlla=limiteOlla;
		this.cantRaciones=limiteOlla;
		this.cantCanibales=0;
		this.cantCanibalesEsperando=0;
		
		this.canibales=new Semaphore(limiteOlla);
		this.cocinero=new Semaphore(0);
		
		this.mutexCanibal=new Semaphore(1);
		this.mutexCocinero=new Semaphore(1);
	}
	
	public void usarOllaCanibal() {
		try {
			this.mutexCanibal.acquire();
			this.cantCanibalesEsperando++;
			this.mutexCanibal.release();
			
			this.canibales.acquire();
			System.out.println(Thread.currentThread().getName()+" comiendo en la olla");
			this.mutexCanibal.acquire();
			this.cantCanibales++;
			this.cantRaciones--;
			this.cantCanibalesEsperando--;
			this.mutexCanibal.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void dejarOllaCanibal() {
		try {
			this.mutexCanibal.acquire();
			System.out.println(Thread.currentThread().getName()+" dejando la olla");
			this.cantCanibales--;
			if (this.cantCanibales==0 && this.cantRaciones==0) {
				this.cocinero.release();
			}
			this.mutexCanibal.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public void cocinar() {
		try {
			this.cocinero.acquire();
			System.out.println(Thread.currentThread().getName()+" COCINANDO");
			this.mutexCocinero.acquire();
			this.cantRaciones=this.limiteOlla;
			this.mutexCocinero.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void dejarCocinar() {
		try {
			this.mutexCocinero.acquire();
			System.out.println(Thread.currentThread().getName()+" TERMINO DE COCINAR");
			if (this.cantCanibalesEsperando>this.limiteOlla) {
				this.canibales.release(this.limiteOlla);	
			}else {
				this.canibales.release(this.cantCanibalesEsperando);
			}
			
			this.mutexCocinero.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
