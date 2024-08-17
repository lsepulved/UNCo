package Practico_6;

import java.util.LinkedList;
import java.util.Random;

public class Puente {

	private int limite;
	private int cantEsperandoNorte;
	private int cantEsperandoSur;
	private int cantEntraNorte;
	private int cantEntraSur;
	private int cruzando;
	
	private boolean turnoNorte;
	
	private LinkedList<Thread> cola;
	
	public Puente(int unLimite) {
		Random random=new Random();
		int valor;
		
		this.cola=new LinkedList<Thread>();
		this.limite=unLimite;
		this.cantEsperandoNorte=0;
		this.cantEsperandoSur=0;
		
		this.cantEntraNorte=0;
		this.cantEntraSur=0;
		
		this.cruzando=0;
		
		valor=random.nextInt(2);
		if (valor==0) {
			this.turnoNorte=true;
		}else {
			this.turnoNorte=false;
		}
		
	}
		
	public synchronized void entrarNortePuente() {
		
		try {
			this.cantEsperandoNorte++;
			while (this.cantEntraNorte>=this.limite || this.turnoNorte==false) {
				System.out.println(Thread.currentThread().getName()+".....debe esperar en el Norte");
				this.wait();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.cantEsperandoNorte--;
		System.out.println(Thread.currentThread().getName()+"======================================================entra desde el Norte========");
		this.cola.add(Thread.currentThread());
		this.cruzando++;
		this.cantEntraNorte++;

	}
	
	public synchronized void entrarSurPuente() {
		
		try {
			this.cantEsperandoSur++;
			while (this.cantEntraSur>=this.limite || this.turnoNorte==true) {
				System.out.println(Thread.currentThread().getName()+".....debe esperar en el SUR");
				this.wait();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.cantEsperandoSur--;
		System.out.println(Thread.currentThread().getName()+"================================entra desde el Sur===========");
		this.cola.add(Thread.currentThread());
		this.cruzando++;
		this.cantEntraSur++;

	}
	public synchronized void salirPuenteSur() {
//		boolean band=false;
		
		System.out.println(Thread.currentThread().getName()+" .... intenta salir del puente sur");

		try {
			while (this.cola.getFirst()!=Thread.currentThread()|| this.turnoNorte==false) {
				System.out.println(Thread.currentThread().getName()+" .... no puede salir, no es su turno");				
				this.wait();
			}	
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		this.cruzando--;
		this.cola.remove();
		System.out.println(Thread.currentThread().getName()+".............................SALE DEL PUENTE SUR.............");

		if (this.cruzando==0) {
			if (this.cantEsperandoSur>0) {
				System.out.println(".....CAMBIA DE TURNO, LE TOCA A LOS DEL SUR INGRESAR.............");
				this.cantEntraSur=0;
				this.turnoNorte=false;
			}else {
				System.out.println(".....NO HAY AUTOS EN EL SUR, SIGUE TURNO NORTE.............");
				this.cantEntraNorte=0;
				this.turnoNorte=true;
			}
//			this.notifyAll();
		}			
		this.notifyAll();
		
//		if (cola.peek().getId()==Thread.currentThread().getId()) {
//			this.cruzando--;
//			band=true;
//			this.cola.remove();
//			System.out.println(Thread.currentThread().getName()+".....SALE DEL PUENTE.............");
//
//			if (this.cruzando==0) {
//				if (this.cantEsperandoSur>0) {
//					System.out.println(Thread.currentThread().getName()+".....CAMBIA DE TURNO, LE TOCA A LOS DEL SUR INGRESAR.............");
//					this.turnoNorte=false;
//				}else {
//					System.out.println(Thread.currentThread().getName()+".....NO HAY AUTOS EN EL SUR, SIGUE TURNO NORTE.............");				
//				}
//				this.notifyAll();
//			}			
//		}

//		return band;
	}	

	public synchronized void salirPuenteNorte() {

		System.out.println(Thread.currentThread().getName()+" .... intenta salir del puente norte");
		
		try {
			while ((this.cola.getFirst()!=Thread.currentThread())|| this.turnoNorte==true) {
				System.out.println(Thread.currentThread().getName()+" .... no puede salir, no es su turno");				
				this.wait();
			}	
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.cruzando--;
		this.cola.remove();
		System.out.println(Thread.currentThread().getName()+"...............SALE DEL PUENTE NORTE.............");
		
		if (this.cruzando==0) {
			if (this.cantEsperandoNorte>0) {
				System.out.println(".....CAMBIA DE TURNO, LE TOCA A LOS DEL NORTE INGRESAR.............");
				this.cantEntraNorte=0;
				this.turnoNorte=true;
			}else {
				System.out.println(".....NO HAY AUTOS EN EL NORTE, SIGUE TURNO SUR.............");
				this.cantEntraSur=0;
				this.turnoNorte=false;
			}
			
//			this.notifyAll();
		}
		this.notifyAll();
		
//		if (cola.peek().getId()==Thread.currentThread().getId()) {
//			this.cruzando--;
//			band=true;
//			this.cola.remove();
//			System.out.println(Thread.currentThread().getName()+".....SALE DEL PUENTE.............");
//			
//			if (this.cruzando==0) {
//				if (this.cantEsperandoNorte>0) {
//					System.out.println(Thread.currentThread().getName()+".....CAMBIA DE TURNO, LE TOCA A LOS DEL NORTE INGRESAR.............");
//					this.turnoNorte=true;
//				}else {
//					System.out.println(Thread.currentThread().getName()+".....NO HAY AUTOS EN EL NORTE, SIGUE TURNO SUR.............");				
//				}
//				
//				this.notifyAll();
//			}
//			
//		}

	}	
	
}
