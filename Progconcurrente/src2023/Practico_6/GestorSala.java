package Practico_6;

public class GestorSala {

	private int cantPersonasEsperando;
	private int cantJubiladosEsperando;
	private int cantPersonas;
	private int cantJubilados;
	private int umbralTemperatura;
	
	private int capacidad;
	
	
	public GestorSala(int unaCapacidad,int unUmbral ) {
		this.capacidad=unaCapacidad;
		this.umbralTemperatura=unUmbral;
		
		this.cantPersonas=0;
		this.cantJubilados=0;
		
		this.cantJubiladosEsperando=0;
		this.cantPersonasEsperando=0;
	}
	
	public synchronized void personaEntraSala() {
		this.cantPersonasEsperando++;
		while (this.cantPersonas>=this.capacidad || this.cantJubiladosEsperando>0) {
			try {
				System.out.println(Thread.currentThread().getName()+" esperando porque la sala esta llena o hay jubilados esperando: "+this.cantJubiladosEsperando);				
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("================================"+Thread.currentThread().getName()+" entra a sala");
		this.cantPersonasEsperando--;
		this.cantPersonas++;
		
	}
	
	public synchronized void jubiladoEntraSala() {
		this.cantJubiladosEsperando++;
		
		while (this.cantPersonas>=this.capacidad) {
			try {
				System.out.println(Thread.currentThread().getName()+" esperando porque la sala esta llena");				
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("_______________"+Thread.currentThread().getName()+" entra a sala");
		this.cantJubiladosEsperando--;
		this.cantPersonas++;
		
	}
	
	public synchronized void salirPersona() {
		this.cantPersonas--;
		System.out.println("......................................"+Thread.currentThread().getName()+" sale de la sala");
		this.notify();
	}
	
	public synchronized void controlTemperatura(int medicion) {
		if (medicion>=this.umbralTemperatura) {
			this.capacidad=5;			
			System.out.println(Thread.currentThread().getName()+" cambia la capacidad de la sala por superar el umbral de temperatura");
		}else {
			System.out.println(Thread.currentThread().getName()+" cambia la capacidad de la sala porque el umbral de temperatura es menor al limite");
			this.capacidad=10;
		}
		
		
	}
	
}
