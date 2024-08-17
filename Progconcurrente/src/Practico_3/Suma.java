package Practico_3;

public class Suma {
	private int sumaTotal=0;
	
	public Suma() {
		
	}
	
	public int getSuma() {
		return this.sumaTotal;
	}
	
	public synchronized void incrementar(int valor) {
		this.sumaTotal=this.sumaTotal+valor;
	}
	
}
