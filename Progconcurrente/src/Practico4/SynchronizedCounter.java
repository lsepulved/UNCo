package Practico4;

public class SynchronizedCounter {
	private int c = 0;
	
	public synchronized void increment() {
		c++;
		System.out.println(Thread.currentThread().getName()+" incremento, valor: "+this.c);
	}
	
	public synchronized void decrement() {
		c--;
		System.out.println(Thread.currentThread().getName()+" decremento, valor: "+this.c);		
	}
	
	public synchronized int value() {
		System.out.println(Thread.currentThread().getName()+" valor "+ this.c);
		return c;
	}
}