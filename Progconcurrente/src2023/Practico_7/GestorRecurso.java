package Practico_7;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GestorRecurso {
	
	private int cantComputadora;
	private int cantLibro;
	
	private int limiteCompus;
	private int limiteLibros;	
	
	final Lock cerrojoComp;
	final Lock cerrojoLibro;
	
	final Condition disponibleCompu;
	final Condition disponibleLibro;
	
	public GestorRecurso(int unasCompus, int unosLibros) {
		this.cantComputadora=0;
		this.cantLibro=0;
		
		this.limiteCompus=unasCompus;
		this.limiteLibros=unosLibros;
		
		this.cerrojoComp=new ReentrantLock();
		this.cerrojoLibro=new ReentrantLock();
		

		this.disponibleCompu=this.cerrojoComp.newCondition();
		this.disponibleLibro=this.cerrojoLibro.newCondition();

	}
	
	public void usarComputadora() {
		
		this.cerrojoComp.lock();
		
		try {
			while (this.cantComputadora>=this.limiteCompus) {
				System.out.println(Thread.currentThread().getName()+" esperando una computadora LIBRE=====================");
				this.disponibleCompu.await();	
			}

			System.out.println("_______________"+Thread.currentThread().getName()+" _______________________usa computadora");
			this.cantComputadora++;
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.cerrojoComp.unlock();	
		}
		
	}

	public void dejarComputadora() {
		this.cerrojoComp.lock();
		System.out.println("============="+Thread.currentThread().getName()+"!!!!!!!!!!!!!!!!!!!!!!!!DEJA COMPUTADORA!!!!!!!!!!!!!!!!!!!!!!");
		this.cantComputadora--;
		this.disponibleCompu.signal();
		this.cerrojoComp.unlock();
	}
	
	
	public void usarLibro() {
		
		this.cerrojoLibro.lock();
		
		try {
			while (this.cantLibro>=this.limiteLibros) {
				System.out.println(Thread.currentThread().getName()+" esperando un libro LIBRE=====================");
				this.disponibleLibro.await();	
			}
			
			System.out.println("============="+Thread.currentThread().getName()+"======================usa LIBRO");
			this.cantLibro++;
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.cerrojoLibro.unlock();	
		}
		
	}
	
	public void dejarLibro() {
		this.cerrojoLibro.lock();
		System.out.println("============="+Thread.currentThread().getName()+"======================DEJA LIBRO=====================");
		this.cantLibro--;
		this.disponibleLibro.signal();
		this.cerrojoLibro.unlock();
	}
	
	
}
