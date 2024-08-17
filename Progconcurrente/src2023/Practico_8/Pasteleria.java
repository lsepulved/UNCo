package Practico_8;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Pasteleria {

	private Semaphore hayCaja;
	private Semaphore sacaCaja;
	private Semaphore hayPastel;
	private Semaphore tomarPastel;
	private Semaphore soltarPastel;
	private Semaphore mutex;
	
	private int capacidadCaja;
	private int ocupacionCaja;
	
	private int pastelAEsperando;
	private int pastelBEsperando;
	private int pastelCEsperando;
	
	private int pesoPastelA;
	private int pesoPastelB;
	private int pesoPastelC;
	
	public Pasteleria(int unaCapacidadCaja, int unPesoPastelA, int unPesoPastelB, int unPesoPastelC) {
		
		this.capacidadCaja=unaCapacidadCaja;
		this.ocupacionCaja=0;
		
		this.pesoPastelA=unPesoPastelA;
		this.pesoPastelB=unPesoPastelB;
		this.pesoPastelC=unPesoPastelC;
		
		this.hayCaja=new Semaphore(1);
		this.tomarPastel=new Semaphore(0);
		this.soltarPastel=new Semaphore(0);
		this.sacaCaja=new Semaphore(0);
		this.hayPastel=new Semaphore(0);
		this.mutex=new Semaphore(1);
		
		this.pastelAEsperando=0;
		this.pastelBEsperando=0;
		this.pastelCEsperando=0;
	}

	public void usarMostrador() {
		this.hayPastel.release();
	}
	
	public int tomarPastel() {
		Random random=new Random();
		int valor;
		int peso=0;
		
		try {
			this.pastelAEsperando++;
			
			this.hayPastel.acquire();
			this.mutex.acquire();
			valor=random.nextInt(3);
			
			switch (valor) {
			case 1:
				peso=this.pesoPastelA;
				break;
			case 2:
				peso=this.pesoPastelB;
				break;
			case 3:
				peso=this.pesoPastelC;
				break;

			default:
				break;
			}
			
			if ((this.ocupacionCaja+peso)<=this.capacidadCaja) {
				this.soltarPastel.release();	
			}
			
			
			this.mutex.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return peso;
	}

	public void soltarPastel() {
		try {
			this.soltarPastel.acquire();
			this.hayCaja.acquire();
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		if ((this.ocupacion+this.pesoPastelA)<=this.capacidad) {
//			this.ocupacion=this.ocupacion+this.pesoPastelA;
//			this.pastelAEsperando--;
//		}else {
//			this.hayPastel.release();
//		}
//	
//		if ((this.ocupacion+this.pesoPastelA)>this.capacidad ||(this.ocupacion+this.pesoPastelB)>this.capacidad||(this.ocupacion+this.pesoPastelC)>this.capacidad) {
//			this.empaquetar.release();
//		}			
		
	}
	public void tomarPastelB() {
		try {
			this.pastelBEsperando++;
			
			this.hayPastel.acquire();
			this.mutex.acquire();
			
			if ((this.ocupacionCaja+this.pesoPastelB)<=this.capacidadCaja) {
				this.ocupacionCaja=this.ocupacionCaja+this.pesoPastelB;
				this.pastelBEsperando--;
			}else {
				this.hayPastel.release();
			}
						
			this.mutex.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void tomarPastelC() {
		try {
			this.pastelCEsperando++;
			
			this.hayPastel.acquire();
			this.mutex.acquire();
			
			if ((this.ocupacionCaja+this.pesoPastelC)<this.capacidadCaja) {
				this.ocupacionCaja=this.ocupacionCaja+this.pesoPastelC;
				this.pastelCEsperando--;
			}else {
				this.hayPastel.release();
			}
						
			this.mutex.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void retirarCaja() {
		try {
			this.empaquetar.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void reponerCaja() {
		this.hayCaja.release();
	}
}
