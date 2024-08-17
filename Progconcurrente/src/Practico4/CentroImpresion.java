package Practico4;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class CentroImpresion {

	private Semaphore[] impresorasA;
	private Semaphore[] impresorasB;
	
	public CentroImpresion(int cantImpresorasA, int cantImpresorasB) {
		
		this.impresorasA=new Semaphore[cantImpresorasA];
		this.impresorasB=new Semaphore[cantImpresorasB];
		
		for (int i=0;i<impresorasA.length;i++) {
			this.impresorasA[i]=new Semaphore(1);	
		}

		for (int i=0;i<impresorasB.length;i++) {
			this.impresorasB[i]=new Semaphore(1);	
		}
	}
	
	public boolean usarImpresoraA() {
		
		boolean exito=false;
		Random random=new Random();
		int i=random.nextInt(this.impresorasA.length);
		
		try {
			this.impresorasA[i].acquire();
			System.out.println(Thread.currentThread().getName()+" usando Impresora A"+i);			
			exito=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" liberando Impresora A"+i);
		this.impresorasA[i].release();
		return exito;
	}

	public boolean usarImpresoraB() {
		
		boolean exito=false;
		Random random=new Random();
		int i=random.nextInt(this.impresorasB.length);
		
		try {
			this.impresorasB[i].acquire();
			System.out.println(Thread.currentThread().getName()+" usando Impresora B"+i);			
			exito=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" liberando Impresora B"+i);
		this.impresorasB[i].release();
		return exito;
	}
	
}
