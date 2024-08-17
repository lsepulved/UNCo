package Practico4;

import java.util.concurrent.Semaphore;

public class GestorCruce {

	private Semaphore entradaOeste;
	private Semaphore entradaNorte;
	private Semaphore salidaEste;
	private Semaphore salidaSur;
//	private Semaphore sensorNorte;
//	private Semaphore sensorOeste;
	
	public GestorCruce() {
		this.entradaOeste=new Semaphore(0);
		this.entradaNorte=new Semaphore(0);
//		this.sensorNorte=new Semaphore(0);
//		this.sensorOeste=new Semaphore(0);
		this.salidaEste=new Semaphore(0);
		this.salidaSur=new Semaphore(0);		
	}
	
	//coche en Norte
	public void llegaNorte() {
		this.entradaNorte.release();
	}

	//coche en Oeste
	public void LlegaOeste() {
		this.entradaOeste.release();
	}
	
	public void cambiaSemaforos(int destino) {
		
		if (destino==0) {
			try {
				this.entradaNorte.acquire();				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try {
				this.entradaOeste.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}
	
	public void saleSur() {
		this.salidaSur.release();
	}

	public void saleEste() {
		this.salidaEste.release();
	}
	
	public void sale(int destino) {
		
		if (destino==0) {
			try {
				this.salidaSur.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try {
				this.salidaEste.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}

