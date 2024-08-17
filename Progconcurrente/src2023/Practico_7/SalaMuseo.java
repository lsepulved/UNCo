package Practico_7;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SalaMuseo {

	private int cantJubilados;
	private int cantPersonas;	
	private int cantJubiladosEsperando;
	private int cantPersonasEsperando;
	private int capacidad;
	private int umbralTemperatura;
	
	final Lock cerrojo;
	final Condition disponiblePersona;
	final Condition disponibleJubilado;
	
	public SalaMuseo(int unaCapacidad, int unUmbral) {
		this.capacidad=unaCapacidad;
		this.umbralTemperatura=unUmbral;
		this.cantJubilados=0;
		this.cantPersonas=0;
		this.cantJubiladosEsperando=0;
		this.cantPersonasEsperando=0;
		
		
		this.cerrojo=new ReentrantLock();
		this.disponibleJubilado=cerrojo.newCondition();
		this.disponiblePersona=cerrojo.newCondition();
	}
	
	
	public void entrarSala() {
		
		this.cerrojo.lock();
		this.cantPersonasEsperando++;
		
		try {
			while(this.cantPersonas>=this.capacidad || this.cantJubiladosEsperando>0) {
				System.out.println(Thread.currentThread().getName()+" esperando porque la sala esta llena: "+this.cantPersonas+" o hay jubilados esperando: "+this.cantJubiladosEsperando);
				this.disponiblePersona.await();
			}
			
			System.out.println("_______________"+Thread.currentThread().getName()+" entra a sala");
			this.cantPersonas++;
			this.cantPersonasEsperando--;
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.cerrojo.unlock();		
		}
		
	}
	
	public void entrarSalaJubilado() {
		
		this.cerrojo.lock();
		this.cantJubiladosEsperando++;
		
		try {
			while(this.cantPersonas>=this.capacidad) {
				System.out.println(Thread.currentThread().getName()+" esperando porque la sala esta llena");
				this.disponibleJubilado.await();
			}
		
			System.out.println("_______________"+Thread.currentThread().getName()+" entra a sala");			
			this.cantPersonas++;
			this.cantJubiladosEsperando--;
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.cerrojo.unlock();		
		}
		
	}
	
	public void salirSala() {
		this.cerrojo.lock();
		
		this.cantPersonas--;
		if (this.cantJubiladosEsperando>0) {
			this.disponibleJubilado.signal();
		}else {
			this.disponiblePersona.signal();
		}
		
		System.out.println("......................................"+Thread.currentThread().getName()+" sale de la sala");
		this.cerrojo.unlock();
	}

	public void controlTemperatura(int unaMedicion) {
		this.cerrojo.lock();
		
		if (unaMedicion>this.umbralTemperatura) {
			this.capacidad=5;			
			System.out.println(Thread.currentThread().getName()+" cambia la capacidad de la sala por superar el umbral de temperatura");
		}else {
			System.out.println(Thread.currentThread().getName()+" cambia la capacidad de la sala porque el umbral de temperatura es menor al limite");
			this.capacidad=10;
		}
		
		this.cerrojo.unlock();
	}
	
}
