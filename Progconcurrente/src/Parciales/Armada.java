package Parciales;

public class Armada {
	
	int numero=0;
	
	public Armada(int unNumero) {
		this.numero=unNumero;
		
	}
	
	public void imprimirOracion() {
		System.out.println(Thread.currentThread().getName()+" Oracion: "+this.numero);
	}
	
	public void imprimirOracion2() {
		System.out.println(Thread.currentThread().getName()+" Oracion: "+((5*2+1)-this.numero));
	}
	
	
	public int getDivisiones() {
		return this.numero;
	}
}
