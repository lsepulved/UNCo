package Practico_2;

public class ThreadEjemploRunnable implements Runnable{

//	public 
	public void run() {
		for (int i = 0; i < 10 ; i++)
		System.out.println(i + " " + Thread.currentThread().getName());
		
		System.out.println("Termina thread " + Thread.currentThread().getName());
	}
	
	public static void main (String [] args) {
		
		ThreadEjemploRunnable ejemploRunnableUno=new ThreadEjemploRunnable();
		ThreadEjemploRunnable ejemploRunnableDos=new ThreadEjemploRunnable();

		
		new Thread(ejemploRunnableUno,"Maria Jose").start();
		new Thread(ejemploRunnableDos,"Jose Maria").start();
		
		System.out.println("Termina thread main");
		
	}
	
}
