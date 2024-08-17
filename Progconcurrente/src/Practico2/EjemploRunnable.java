package Practico2;

public class EjemploRunnable implements Runnable {

	public void run() {
		for (int i = 0; i < 10 ; i++)
			System.out.println(i + " " + Thread.currentThread().getName());
		
		System.out.println("Termina thread " + Thread.currentThread().getName());
	}

	
}

