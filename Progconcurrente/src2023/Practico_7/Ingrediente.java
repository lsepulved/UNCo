package Practico_7;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ingrediente {

	private int limiteVegetales;
	private int limiteCarne;
	private int limitePasta;
	
	private int cantVegetales;
	private int cantCarne;
	private int cantPasta;
	
	final Lock cerrojoPasta;
	final Lock cerrojoVegetal;
	final Lock cerrojoCarne;
	
	final Condition disponibleVegetal;
	final Condition disponibleCarne;
	final Condition disponiblePasta;

	public Ingrediente(int unLimiteVegetales, int unLimiteCarne,int unLimitePasta) {
		
		this.limiteCarne=unLimiteCarne;
		this.limitePasta=unLimitePasta;
		this.limiteVegetales=unLimiteVegetales;
		
		this.cantCarne=0;
		this.cantPasta=0;
		this.cantVegetales=0;
		
		this.cerrojoCarne=new ReentrantLock();
		this.cerrojoPasta=new ReentrantLock();
		this.cerrojoVegetal=new ReentrantLock();
		
		this.disponibleCarne=cerrojoCarne.newCondition();
		this.disponiblePasta=cerrojoPasta.newCondition();
		this.disponibleVegetal=cerrojoVegetal.newCondition();
				
	}
	
	public void usarVegetal() {
		this.cerrojoVegetal.lock();
		try {
			while(this.cantVegetales>=this.limiteVegetales) {
				System.out.println(Thread.currentThread().getName()+" esperando vegetales=====================");
				this.disponibleVegetal.await();	
			}
			
			System.out.println("//////////////////////////////"+Thread.currentThread().getName()+" USO VEGETAL//////////////////////////////");
			this.cantVegetales++;
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.cerrojoVegetal.unlock();	
		}
	}
	
	public void dejarVegetal() {
		this.cerrojoVegetal.lock();
		this.cantVegetales--;
		this.disponibleVegetal.signal();
		System.out.println("................................"+Thread.currentThread().getName()+" dejo vegetal=====================");
		this.cerrojoVegetal.unlock();
	}

	public void usarCarne() {
		this.cerrojoCarne.lock();
		try {
			while(this.cantCarne>=this.limiteCarne) {
				System.out.println(Thread.currentThread().getName()+" esperando carne=====================");
				this.disponibleCarne.await();	
			}
			System.out.println("//////////////////////////////"+Thread.currentThread().getName()+" USO CARNE//////////////////////////////");
			this.cantCarne++;
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.cerrojoCarne.unlock();	
		}
	}
	
	public void dejarCarne() {
		this.cerrojoCarne.lock();
		this.cantCarne--;
		this.disponibleCarne.signal();
		System.out.println("................................"+Thread.currentThread().getName()+" dejo Carne=====================");
		this.cerrojoCarne.unlock();
	}

	public void usarPasta() {
		this.cerrojoPasta.lock();
		try {
			while(this.cantPasta>=this.limitePasta) {
				System.out.println(Thread.currentThread().getName()+" esperando pasta=====================");
				this.disponiblePasta.await();	
			}
			
			System.out.println("//////////////////////////////"+Thread.currentThread().getName()+" USO PASTA//////////////////////////////");
			this.cantPasta++;
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.cerrojoPasta.unlock();	
		}
	}
	
	public void dejarPasta() {
		this.cerrojoPasta.lock();
		this.cantPasta--;
		this.disponiblePasta.signal();
		System.out.println("................................"+Thread.currentThread().getName()+" dejo Pasta=====================");
		this.cerrojoPasta.unlock();
	}
	
}
