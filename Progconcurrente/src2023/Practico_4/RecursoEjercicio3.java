package Practico_4;

import java.util.concurrent.Semaphore;

public class RecursoEjercicio3 {
	
	Semaphore sem1=new Semaphore(1);
	Semaphore sem2=new Semaphore(0);
	Semaphore sem3=new Semaphore(0);
	
	public RecursoEjercicio3() {
		
	}
	
	public void P1() {
		try {
			sem1.acquire();
			System.out.println(Thread.currentThread().getName() + " entro al P1");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sem2.release();
	}
	
	
	public void P3() {
		try {
			sem2.acquire();
			System.out.println(Thread.currentThread().getName() + " entro al P3");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sem3.release();
	}

	public void P2() {
		try {
			sem3.acquire();
			System.out.println(Thread.currentThread().getName() + " entro al P2");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sem1.release();
	}
	
}
