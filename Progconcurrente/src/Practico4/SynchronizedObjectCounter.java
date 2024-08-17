package Practico4;

public class SynchronizedObjectCounter {
	private int c = 0;
	
	public void increment(){
		synchronized (this) {
			c++;
			System.out.println(Thread.currentThread().getName()+" incremento, valor: "+this.c);			
		} // Este elemento debe ser casteado a Integer
	}
	
	public void decrement() {
		synchronized (this) {
			c--;
			System.out.println(Thread.currentThread().getName()+" decremento, valor: "+this.c);			
		}
	}
	
	public int value() {
		System.out.println(Thread.currentThread().getName()+" valor "+ this.c);
		return c;
	}
}