package Practico_8;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CentroHemoterapia {
	
	private int cantCamillas;
	private int limiteCamillas;
	
	private int cantSala;
	private int limiteSala;
	
	private int cantRevistas;
	private int limiteRevistas;
	
	private final Lock cerrojo;
	private final Condition camillas;
	private final Condition sala;
	private final Condition revistas;
	
	public CentroHemoterapia(int unLimiteCamillas, int unLimiteSala, int unLimiteRevistas) {
		
		this.cantCamillas=0;
		this.limiteCamillas=unLimiteCamillas;
		
		this.cantSala=0;
		this.limiteSala=unLimiteSala;
		
		this.cantRevistas=0;
		this.limiteRevistas=unLimiteRevistas;
		
		this.cerrojo= new ReentrantLock();
		this.camillas= cerrojo.newCondition();
		this.sala=cerrojo.newCondition();
		this.revistas= cerrojo.newCondition();
		
	}
	
	public void entrarSala() {
		this.cerrojo.lock();
		
		try {
			while (this.cantSala>=this.limiteSala) {
				System.out.println("________________"+Thread.currentThread().getName()+ " esperando para ingresar a la sala de espera");
				this.sala.await();
			}
			this.cantSala++;
			System.out.println(Thread.currentThread().getName()+ " ingresa a la sala de espera_____________");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.cerrojo.unlock();
		}
	}

	public void usarRevista() {
		this.cerrojo.lock();
		
		try {
			while (this.cantRevistas>=this.limiteRevistas) {
				System.out.println("+++++++++++++++++++++++++++"+Thread.currentThread().getName()+ " esperando para usar una REVISTA");
				this.revistas.await();
			}
			this.cantRevistas++;
			System.out.println(Thread.currentThread().getName()+ " USANDO REVISTA MUY INTERESANTE++++++++++++++++++");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.cerrojo.unlock();
		}
	}

	public void usarCamilla() {
		this.cerrojo.lock();
		
		try {
			while (this.cantCamillas>=this.limiteCamillas) {
				System.out.println("================="+Thread.currentThread().getName()+ " esperando para usar una camilla");
				this.camillas.await();
			}
			this.cantCamillas++;
			System.out.println("||||||||||||||"+Thread.currentThread().getName()+ " USANDO Camilla========================");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.cerrojo.unlock();
		}
	}

	public void dejarCamilla() {
		this.cerrojo.lock();
		
		this.cantCamillas--;
		if (this.cantCamillas>0) {
			System.out.println("_______________"+Thread.currentThread().getName()+ " dejo camilla");
			this.camillas.signal();
		}
		
		this.cerrojo.unlock();
	}

	public void dejarRevista() {
		this.cerrojo.lock();
		
		this.cantRevistas--;
		if (this.cantRevistas>0) {
			System.out.println("+++++++++++++++++"+Thread.currentThread().getName()+ " dejo revista");
			this.revistas.signal();
		}
		
		this.cerrojo.unlock();
	}
	public void dejarSala() {
		this.cerrojo.lock();
		
		this.cantSala--;
		if (this.cantSala>0) {
			System.out.println("================="+Thread.currentThread().getName()+ " dejo sala");
			this.sala.signal();
		}
		
		this.cerrojo.unlock();
	}
	
}
