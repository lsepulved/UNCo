package Practico6;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CentroHemoterapia {

	private int camillas;
	private int lugaresEspera;
	private int revistas;
	
	private final Lock cerrojo;
	private final Condition camillaDisponible;
	private final Condition lugarDisponible;
	

	public CentroHemoterapia(int unasCamillas, int cantLugares, int unasRevistas) {
		this.camillas=unasCamillas;
		this.lugaresEspera=cantLugares;
		this.revistas=unasRevistas;
		this.cerrojo=new ReentrantLock(true);
		this.camillaDisponible=cerrojo.newCondition();
		this.lugarDisponible=cerrojo.newCondition();

	}
	
	public void entrarCentro() {
		this.cerrojo.lock();
		try {
			while (this.salaLlena()) {
				this.lugarDisponible.await();
			}
			this.lugaresEspera--;
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			this.cerrojo.unlock();
		}
	}
	
	public boolean salaLlena() {
		return this.lugaresEspera==0;
	}
	
	public void usarCamilla() {
		boolean tieneRevista=false;
		
		this.cerrojo.lock();
		try {
			while(this.camillasOcupadas()) {
				if (!this.revistasOcupadas() && !tieneRevista) {
					this.revistas--;
					tieneRevista=true;
					System.out.println("==="+Thread.currentThread().getName()+ " toma revista, revistas disponibles "+this.revistas);
				}				
				this.camillaDisponible.await();												
			}
			if (tieneRevista) {
				System.out.println("==="+Thread.currentThread().getName()+ " devuelve revista, revistas disponibles "+this.revistas);
				this.revistas++;
			}
			System.out.println("==="+Thread.currentThread().getName()+ " ocupa camilla");
			this.camillas--;			
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {			
			this.cerrojo.unlock();
		}
	}
	
	public boolean camillasOcupadas() {
		return this.camillas==0;
	}
	
	public boolean revistasOcupadas() {
		return this.revistas==0;
	}
	
	public void salirCentro() {
		this.cerrojo.lock();
		this.camillas++;
		this.camillaDisponible.signal();
		this.lugaresEspera++;
		this.lugarDisponible.signal();
		this.cerrojo.unlock();
	}
	
}
