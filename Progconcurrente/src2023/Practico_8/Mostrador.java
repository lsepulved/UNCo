package Practico_8;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Mostrador {

	private int cantPasteles;
	private Semaphore hayPastel;
	private Semaphore mutex;
	
	private int pesoA;
	private int pesoB;
	private int pesoC;
	
	public Mostrador(int unPesoA, int unPesoB, int unPesoC) {
		this.pesoA=unPesoA;
		this.pesoB=unPesoB;
		this.pesoC=unPesoC;
		
		this.hayPastel=new Semaphore(0);
		this.mutex=new Semaphore(1);
	}
	
	public void ponerPastel() {
		this.hayPastel.release();
	}
	
	public int tomarPastel() {
		int peso=0;
		try {
			this.cantPasteles++;
			this.hayPastel.acquire();
			this.mutex.acquire();
			peso=unPeso;
			this.mutex.release();
//			if ()
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return peso;
	}
}
