package Practico4;

import java.util.Random;

public class Sumador implements Runnable{

	SynchronizedCounter contador;
	
	public Sumador (SynchronizedCounter unContador) {
		this.contador=unContador;
	}
	
	public void run() {
		int numero;
		Random random = new Random();
		
		for (int i=1;i<=5;i++) {
			numero=(random.nextInt(2)+1);
			
			switch (numero) {
			case 1:
				this.contador.increment();	
				break;
			case 2:
				this.contador.decrement();
				break;
			default:
				break;
			}
			
		}
	}
}

