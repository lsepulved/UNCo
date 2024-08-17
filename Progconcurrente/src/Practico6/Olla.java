package Practico6;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Olla {
	
	private int raciones;
	private boolean avisarCocinero;
	private int capacidadOlla;
	private Lock cerrojo;
	private Condition hayComida;
	private Condition sinComida;
	private Condition terminoCocinar;

	public Olla(int unasRaciones) {
		this.raciones=unasRaciones;
		this.capacidadOlla=unasRaciones;
		this.avisarCocinero=false;
		this.cerrojo=new ReentrantLock();
		this.hayComida=cerrojo.newCondition();
		this.sinComida=cerrojo.newCondition();
		this.terminoCocinar=cerrojo.newCondition();
	}
	
	//canibal
	public void comer() {
		this.cerrojo.lock();
		try {
			
			while(this.ollaVacia()) {
				if (!this.avisarCocinero) {
					this.avisarCocinero=true;
					System.out.println("===="+Thread.currentThread().getName()+ " le pide al Cocinero que cocine");
					this.sinComida.signal();	
					this.hayComida.await();
					this.terminoCocinar.signalAll();
					
				}else {
					this.terminoCocinar.await();
				}
			}
			this.raciones--;
			System.out.println("===="+Thread.currentThread().getName()+ " comio una racion");			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			this.cerrojo.unlock();
		}
	}
	
	//cocinero
	public void cocinar() {
		this.cerrojo.lock();
		try {		
			while(!this.ollaVacia()) {
				this.sinComida.await();
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//cociner
	public void terminaCocinar() {
		this.raciones=this.capacidadOlla;
		this.hayComida.signal();
		this.avisarCocinero=false;
		this.cerrojo.unlock();
	}
	
	public boolean ollaVacia() {
		return this.raciones==0;
	}
}
